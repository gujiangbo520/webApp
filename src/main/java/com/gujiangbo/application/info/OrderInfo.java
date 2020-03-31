package com.gujiangbo.application.info;

import com.gujiangbo.application.base.BaseInfo;

public class OrderInfo extends BaseInfo {

    private String orderId;
    private String orderName;
    private double orderPrice;
    private String orderFactory;

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderFactory() {
        return orderFactory;
    }

    public void setOrderFactory(String orderFactory) {
        this.orderFactory = orderFactory;
    }
}
