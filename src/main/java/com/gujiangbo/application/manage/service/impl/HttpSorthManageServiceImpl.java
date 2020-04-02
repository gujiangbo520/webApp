package com.gujiangbo.application.manage.service.impl;

import cn.hutool.core.date.DateUtil;
import com.gujiangbo.application.database.service.OperateDataBaseService;
import com.gujiangbo.application.enums.CommonConstants;
import com.gujiangbo.application.enums.CommonEnums;
import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.info.SubAccount;
import com.gujiangbo.application.manage.service.HttpSorthManageService;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.request.SubscribeRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.response.SubscribeResponse;
import com.gujiangbo.application.service.Impl.SelectOrderServiceImpl;
import com.gujiangbo.application.utils.IDTools;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Repository
public class HttpSorthManageServiceImpl implements HttpSorthManageService {

    private Log debugLog = LogFactory.getLog(HttpSorthManageServiceImpl.class);
    @Autowired
    private OperateDataBaseService operateDataBaseService;

    @Override
    public SelectOrderResponse selectOrder(SelectOrderRequest request) {
        debugLog.info("南向接口开始执行数据查询......");
        SelectOrderResponse response = new SelectOrderResponse();
        List<OrderInfo> infoLists = new ArrayList<>(16);
        OrderInfo info = null;
        try {
            info = operateDataBaseService.selectOrder(request);
            if (info != null) {
                infoLists.add(info);
            }
            response.setList(infoLists);
            response.setReturnCode(CommonConstants.SUCCESS_CODE);
            response.setReturnMsg(CommonConstants.SUCCESS_DESC);
        } catch (Exception e) {
            debugLog.error("数据查询失败，失败原因:" + e.getMessage());
            response.setReturnCode(CommonConstants.EXCEPTION_FAIL_CODE);
            response.setReturnMsg(CommonConstants.EXCEPTION_FAIL_DESC + ":" + e.getMessage());
        }
        debugLog.info("南向接口数据查询结束......");
        return response;
    }


    /**
     * 本次下单接口仅仅往数据库插入一条记录，因订购系统未上线，暂不做调用
     *
     * @param request
     * @return
     */
    @Override
    public SubscribeResponse subscribe(SubscribeRequest request) {
        debugLog.info("南向接口开始执行......");
        SubscribeResponse response = new SubscribeResponse();
        response.setReturnCode(CommonConstants.SUCCESS_CODE);
        response.setReturnMsg(CommonConstants.SUCCESS_DESC);
        SubAccount account = request.getSubAccount();
        OrderInfo info = new OrderInfo();
        /**
         * 先查询是否有收件人账号信息
         */
        SubAccount dbAccount = operateDataBaseService.selectSubAccount(account);
        if (dbAccount == null) {
            debugLog.info("开始对收件人账号信息保存!");
            if (operateDataBaseService.insertSubAccount(account)) {
                debugLog.info("收件人账号信息保存成功!");
            } else {
                response.setReturnCode(CommonEnums.OPERATE_DB_SAVE_FAIL_CODE);
                response.setReturnMsg(CommonEnums.OPERATE_DB_SAVE_FAIL_MSG);
                return response;
            }
        } else {
            debugLog.info("开始更新收件人账号信息!");
            if (operateDataBaseService.updateSubAccount(account)) {
                debugLog.info("收件人账号信息更新成功!");
            } else {
                response.setReturnCode(CommonEnums.OPERATE_DB_SAVE_FAIL_CODE);
                response.setReturnMsg(CommonEnums.OPERATE_DB_SAVE_FAIL_MSG);
                return response;
            }
        }
        info.setOrderId(request.getOrderId());
        info.setOrderFactory(request.getOrderFactory());
        info.setOrderName(request.getOrderName());
        info.setOrderNum(request.getOrderNum());
        info.setOrderPrice(request.getOrderPrice());
        info.setCreateUser(request.getOrderName());
        info.setUpdateUser(request.getOrderName());
        info.setInfo(request.getOrderDesc());
        info.setSubAccount(request.getSubAccount().getSubAccount());
        debugLog.info("开始保存订单信息!");
        if (operateDataBaseService.saveOrderInfo(info)) {
            debugLog.info("订单信息数据保存成功！");
        } else {
            response.setReturnCode(CommonEnums.OPERATE_DB_SAVE_FAIL_CODE);
            response.setReturnMsg(CommonEnums.OPERATE_DB_SAVE_FAIL_MSG);
            return response;
        }


        return response;
    }
}
