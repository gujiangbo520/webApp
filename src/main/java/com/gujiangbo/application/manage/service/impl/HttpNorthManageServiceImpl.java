package com.gujiangbo.application.manage.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.manage.service.HttpNorthManageService;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.service.SelectOrderService;
import com.gujiangbo.application.utils.CommonConstants;
import com.gujiangbo.application.utils.SafeCheckUtils;
import com.gujiangbo.application.utils.ValidateParamTool;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.List;

/**
 * 北向接口具体实现
 */
@Repository
public class HttpNorthManageServiceImpl implements HttpNorthManageService {

    private Log debugLog = LogFactory.getLog(HttpNorthManageServiceImpl.class);


    @Autowired
    private SelectOrderService selectOrderService;

    @Override
    public SelectOrderResponse selectOrder(SelectOrderRequest request, HttpServletRequest httpServletRequest) {
        debugLog.info("北向接口请求参数校验开始......");
        SelectOrderResponse response = new SelectOrderResponse();
        //数据头部校验
        BaseResponse baseResponse = SafeCheckUtils.getInstance().checkHeader(httpServletRequest);
        debugLog.info("头部字段校验结果:"+JSONObject.toJSONString(baseResponse));
        response.setReturnCode(baseResponse.getReturnCode());
        response.setReturnMsg(baseResponse.getReturnMsg());
        List<String> errList = ValidateParamTool.validateProperty(request, "orderId", "sourceId");
        debugLog.info("参数校验结果:"+JSONObject.toJSONString(errList));
        //头部校验成功 必传参数校验成功
        if (CommonConstants.SUCCESS_CODE.equals(baseResponse.getReturnCode()) && errList.isEmpty()) {
            response = selectOrderService.selectOrder(request);
        } else if (errList.size() > 0) {
            response.setReturnCode(CommonConstants.VALIDATE_PARAM_FAIL_CODE);
            response.setReturnMsg(CommonConstants.VALIDATE_PARAM_FAIL_DESC + ":" + JSONObject.toJSONString(errList));
        }
        return response;
    }
}
