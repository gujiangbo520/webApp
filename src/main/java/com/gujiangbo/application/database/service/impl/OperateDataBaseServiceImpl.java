package com.gujiangbo.application.database.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gujiangbo.application.database.service.OperateDataBaseService;
import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.info.SubAccount;
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
    public OrderInfo selectOrder(SelectOrderRequest request) {
        debugLog.info("selectOrder start!");
        OrderInfo info = new OrderInfo();
        Map<String, String> map = new HashMap<>(16);
        map.put("orderId", request.getOrderId());
        debugLog.info("数据查询请求参数:" + JSONObject.toJSONString(map));
        try {
            info = dataBaseMapper.selectOrder(map);
        } catch (Exception e) {
            debugLog.error("selectOrder is error:", e);
        }


        return info;
    }

    @Override
    public boolean insertSubAccount(SubAccount account) {
        debugLog.info("insertSubAccount start!");
        boolean flag = false;
        try {
            this.dataBaseMapper.insertSubAccount(account);
            flag = true;
        } catch (Exception e) {
            debugLog.error("insertSubAccount is error:", e);
        }
        return flag;
    }

    @Override
    public boolean updateSubAccount(SubAccount account) {
        debugLog.info("updateSubAccount start!");
        boolean flag = false;
        try {
            this.dataBaseMapper.updateSubAccount(account);
            flag = true;
        } catch (Exception e) {
            debugLog.error("updateSubAccount is error:", e);
        }
        return flag;
    }

    @Override
    public boolean saveOrderInfo(OrderInfo info) {
        debugLog.info("saveOrderInfo start!");
        boolean flag = false;
        try {
            this.dataBaseMapper.saveOrderInfo(info);
            flag = true;
        } catch (Exception e) {
            debugLog.error("saveOrderInfo is error:", e);
        }
        return flag;
    }

    @Override
    public SubAccount selectSubAccount(SubAccount account) {
        debugLog.info("开始查询账号信息:");
        SubAccount sub = new SubAccount();
        Map<String,String> map = new HashMap<String,String>(16);
        map.put("accountId",account.getAccountId());
        map.put("subAccount",account.getSubAccount());
        try{
            sub = this.dataBaseMapper.selectSubAccount(map);
        }catch (Exception e){
            debugLog.info("账号查询失败!",e);
        }
        return sub;
    }
}
