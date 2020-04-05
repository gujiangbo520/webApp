package com.gujiangbo.application.service.Impl;

import com.gujiangbo.application.manage.service.HttpSouthManageService;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.service.QueryOrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author gujiangbo
 */
@Repository
public class QueryOrderInfoServiceImpl implements QueryOrderInfoService {

    @Autowired
    private HttpSouthManageService httpSouthManageService;
    @Override
    public SelectOrderResponse queryOrderInfo(String subAccount) {

        return httpSouthManageService.queryOrderInfo(subAccount);
    }
}
