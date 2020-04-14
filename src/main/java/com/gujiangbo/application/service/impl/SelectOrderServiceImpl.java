package com.gujiangbo.application.service.impl;

import com.gujiangbo.application.manage.service.HttpSouthManageService;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.service.SelectOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SelectOrderServiceImpl implements SelectOrderService {

    @Autowired
    private HttpSouthManageService httpSouthManageService;

    @Override
    public SelectOrderResponse selectOrder(SelectOrderRequest request) {

        return httpSouthManageService.selectOrder(request);

    }
}
