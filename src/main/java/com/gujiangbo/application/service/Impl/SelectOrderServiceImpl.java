package com.gujiangbo.application.service.Impl;

import com.gujiangbo.application.database.service.OperateDataBaseService;
import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.manage.service.HttpSorthManageService;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.service.SelectOrderService;
import com.gujiangbo.application.enums.CommonConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SelectOrderServiceImpl implements SelectOrderService {

    @Autowired
    private HttpSorthManageService httpSorthManageService;

    @Override
    public SelectOrderResponse selectOrder(SelectOrderRequest request) {

        return httpSorthManageService.selectOrder(request);

    }
}
