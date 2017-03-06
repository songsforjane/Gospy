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

package cc.gospy.core.scheduler.filter.impl;

import cc.gospy.core.scheduler.Task;
import cc.gospy.core.scheduler.filter.DuplicateRemover;

public class BloomDuplicateRemover implements DuplicateRemover {
    @Override
    public void sign(Task task) {
        // TODO
    }

    @Override
    public boolean exists(Task task) {
        // TODO
        return false;
    }
}
