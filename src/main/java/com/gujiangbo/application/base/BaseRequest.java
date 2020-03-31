package com.gujiangbo.application.base;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BaseRequest {
    /**
     * 请求来源 必填项
     */
    private String sourceId;

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }
}
