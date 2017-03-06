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

package cc.gospy.core.scheduler.queue.impl;

import cc.gospy.core.scheduler.Task;
import cc.gospy.core.scheduler.queue.TaskQueue;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class FIFOTaskQueue extends TaskQueue {
    private BlockingQueue<Task> taskQueue;

    public FIFOTaskQueue() {
        this.taskQueue = new LinkedBlockingQueue<>();
    }

    @Override
    public Iterator<Task> iterator() {
        return taskQueue.iterator();
    }

    @Override
    public int size() {
        return taskQueue.size();
    }

    @Override
    public boolean offer(Task task) {
        return taskQueue.offer(task);
    }

    @Override
    public Task poll() {
        return taskQueue.poll();
    }

    @Override
    public Task peek() {
        return taskQueue.peek();
    }
}
