package com.gujiangbo.application.info;

import com.gujiangbo.application.base.BaseInfo;

/**
 * @author gujiangbo
 * @version 1.0.0
 * @description 收件人信息
 * @updateTime 2020/4/1
 */
public class SubAccount extends BaseInfo {

    /**
     * 订购者id 唯一，表唯一ID
     */
    private String accountId;
    /**
     * 订购者账号
     */
    private String subAccount;
    /**
     * 收件人姓名
     */
    private String subName;
    /**
     * 收件人性别
     */
    private String subGender;
    /**
     * 收件地址
     */
    private String subAddress;
    /**
     * 收件人联系方式
     */
    private String subPhone;
    /**
     * 收件人邮编信息
     */
    private String subPostCode;


    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getSubAccount() {
        return subAccount;
    }

    public void setSubAccount(String subAccount) {
        this.subAccount = subAccount;
    }

    public String getSubName() {
        return subName;
    }

    public void setSubName(String subName) {
        this.subName = subName;
    }

    public String getSubGender() {
        return subGender;
    }

    public void setSubGender(String subGender) {
        this.subGender = subGender;
    }

    public String getSubAddress() {
        return subAddress;
    }

    public void setSubAddress(String subAddress) {
        this.subAddress = subAddress;
    }

    public String getSubPhone() {
        return subPhone;
    }

    public void setSubPhone(String subPhone) {
        this.subPhone = subPhone;
    }

    public String getSubPostCode() {
        return subPostCode;
    }

    public void setSubPostCode(String subPostCode) {
        this.subPostCode = subPostCode;
    }

}
