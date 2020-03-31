package com.gujiangbo.application.database.service;

import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OperateDataBaseService {

    /**
     * 查询单条数据记录，orderID唯一
     * @param request
     * @return
     * @throws Exception
     */
    OrderInfo selectOrder(SelectOrderRequest request) throws Exception;
}
