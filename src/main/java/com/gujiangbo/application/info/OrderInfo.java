package com.gujiangbo.application.info;

import com.gujiangbo.application.base.BaseInfo;

/**
 * @author gujiangbo
 */
public class OrderInfo extends BaseInfo {

    /*订单ID*/
    private String orderId;
    /*订单名称*/
    private String orderName;
    /*订单价格*/
    private double orderPrice;
    /*订单数量*/
    private Integer orderNum;
    /*订单产地*/
    private String orderFactory;
    /*订购者*/
    private String subAccount;

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

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

	@Override
	public String toString() {
		return "OrderInfo [orderId=" + orderId + ", orderName=" + orderName + ", orderPrice=" + orderPrice
				+ ", orderNum=" + orderNum + ", orderFactory=" + orderFactory + ", subAccount=" + subAccount + "]";
	}
    
    
}
