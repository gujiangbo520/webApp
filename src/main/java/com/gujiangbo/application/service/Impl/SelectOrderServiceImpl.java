package com.gujiangbo.application.service.Impl;

import com.gujiangbo.application.controller.SelectOrderController;
import com.gujiangbo.application.database.service.OperateDataBaseService;
import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.service.SelectOrderService;
import com.gujiangbo.application.utils.CommonConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SelectOrderServiceImpl implements SelectOrderService {

    private Log debugLog = LogFactory.getLog(SelectOrderServiceImpl.class);
    @Autowired
    private OperateDataBaseService operateDataBaseService;

    @Override
    public SelectOrderResponse selectOrder(SelectOrderRequest request) {

        debugLog.info("开始执行数据查询......");
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
        debugLog.info("数据查询结束......");
        return response;
    }
}
