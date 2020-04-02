package com.gujiangbo.application.request;

import com.gujiangbo.application.base.BaseInfo;
import com.gujiangbo.application.base.BaseRequest;
import com.gujiangbo.application.info.SubAccount;

import java.util.Date;

/**
 * @description 产品订购字段请求信息
 * @author gujiangbo
 * @version 1.0.0
 * @updateTime 2020/4/1
 */
public class SubscribeRequest extends BaseRequest {

    /**
     * 订单ID，流水号ID ，唯一 建议使用 yyyyMMddHHmmssSSS+random(15) 组成，共计32位
     */
    private String orderId;
    /**
     * 订单名称
     */
    private String orderName;
    /**
     * 订单数量
     */
    private Integer orderNum;

    /**
     * 订单单价
     */
    private Double orderPrice;
    /**
     * 订单产地
     */
    private String orderFactory;

    /**
     * 下单时间
     */
    private Date orderTime;
    /**
     * 订单备注信息
     */
    private String orderDesc;

    /**
     * 订购者信息
     * 对应关系 一条下单信息对应一位收件信息
     */
    private SubAccount subAccount;


    public Double getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Double orderPrice) {
        this.orderPrice = orderPrice;
    }

    public String getOrderFactory() {
        return orderFactory;
    }

    public void setOrderFactory(String orderFactory) {
        this.orderFactory = orderFactory;
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

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getOrderDesc() {
        return orderDesc;
    }

    public void setOrderDesc(String orderDesc) {
        this.orderDesc = orderDesc;
    }

    public SubAccount getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(SubAccount subAccount) {
        this.subAccount = subAccount;
    }
}
