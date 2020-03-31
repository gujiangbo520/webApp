package com.gujiangbo.application.mapper;

import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface DataBaseMapper {

    OrderInfo selectOrder(Map<String,String> map);
}
