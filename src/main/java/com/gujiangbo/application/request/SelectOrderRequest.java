package com.gujiangbo.application.request;

import com.gujiangbo.application.base.BaseRequest;

public class SelectOrderRequest  extends BaseRequest {

    private String orderId;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }
}
