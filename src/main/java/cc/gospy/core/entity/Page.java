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

package cc.gospy.core.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Page implements Serializable {
    private Task task;
    private byte[] content;
    private int statusCode;
    private long responseTime;
    private String contentType;
    private Map<String, Object> extra = new HashMap<>();

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public long getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(long responseTime) {
        this.responseTime = responseTime;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Map<String, Object> getExtra() {
        return extra;
    }

    @Override
    public String toString() {
        return "Page{" +
                "task=" + task +
                ", content-length=" + content.length +
                ", statusCode=" + statusCode +
                ", responseTime=" + responseTime +
                ", contentType='" + contentType + '\'' +
                ", extra=" + extra +
                '}';
    }
}
