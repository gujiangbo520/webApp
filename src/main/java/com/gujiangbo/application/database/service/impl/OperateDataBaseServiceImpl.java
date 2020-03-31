package com.gujiangbo.application.database.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gujiangbo.application.database.service.OperateDataBaseService;
import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.mapper.DataBaseMapper;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class OperateDataBaseServiceImpl implements OperateDataBaseService {

    private Log debugLog = LogFactory.getLog(OperateDataBaseServiceImpl.class);

    @Autowired
    private DataBaseMapper dataBaseMapper;
    @Override
    public OrderInfo selectOrder(SelectOrderRequest request) throws Exception {
        Map<String,String> map = new HashMap<>(16);
        map.put("orderId",request.getOrderId());
        map.put("sourceId",request.getSourceId());
        debugLog.info("数据查询请求参数:"+ JSONObject.toJSONString(map));
        return dataBaseMapper.selectOrder(map);
    }
}
