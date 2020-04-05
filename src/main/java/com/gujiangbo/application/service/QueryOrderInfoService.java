package com.gujiangbo.application.service;

import com.gujiangbo.application.response.SelectOrderResponse;
import org.springframework.stereotype.Service;

/**
 * @author gujiangbo
 */
@Service
public interface QueryOrderInfoService {

    /**
     * @param subAccount
     * @return SelectOrderResponse
     * @description 根据subAccount 查询订单信息
     */
    public SelectOrderResponse queryOrderInfo(String subAccount);
}
