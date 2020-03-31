package com.gujiangbo.application.response;

import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.info.OrderInfo;

import java.io.Serializable;
import java.util.List;


public class SelectOrderResponse extends BaseResponse {


    List<OrderInfo> list ;

    public List<OrderInfo> getList() {
        return list;
    }

    public void setList(List<OrderInfo> list) {
        this.list = list;
    }
}
