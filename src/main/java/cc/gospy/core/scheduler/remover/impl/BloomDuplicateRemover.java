/*
 * Copyright 2017 ZhangJiupeng
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cc.gospy.core.scheduler.remover.impl;

import cc.gospy.core.entity.Task;
import cc.gospy.core.scheduler.Recoverable;
import cc.gospy.core.scheduler.remover.DuplicateRemover;
import cc.gospy.core.util.Experimental;
import cc.gospy.core.util.bloomfilter.ScalableBloomFilter;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Experimental
public class BloomDuplicateRemover implements DuplicateRemover, Recoverable {
    private ScalableBloomFilter bloomFilter = new ScalableBloomFilter();
    private Set<Task> taskWhiteList = Collections.synchronizedSet(new HashSet<>());
    private long counter;

    @Override
    public void record(Task task) {
        if (taskWhiteList.contains(task)) {
            taskWhiteList.remove(task);
        } else {
            bloomFilter.put(task);
        }
        counter++;
    }

    @Override
    public void delete(Task task) {
        if (taskWhiteList.contains(task)) {
            return;
        }
        taskWhiteList.add(task);
        counter--;
    }

    @Override
    public boolean exists(Task task) {
        return !taskWhiteList.contains(task) && bloomFilter.mightContain(task);
    }

    @Override
    public long size() {
        return counter;
    }

    @Override
    public void pause(String dir) throws Throwable {
        bloomFilter.saveToFile(dir);
    }

    @Override
    public void resume(String dir) throws Throwable {
        bloomFilter.readFromFile(dir);
    }
}
