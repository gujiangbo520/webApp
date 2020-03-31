package com.gujiangbo.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gujiangbo.application.manage.service.HttpNorthManageService;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.utils.CommonConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class SelectOrderController {
    private Log debugLog = LogFactory.getLog(SelectOrderController.class);

    @Autowired
    private HttpNorthManageService httpNorthManageService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping("/selectOrder")
    public String selectOrder(@RequestBody String requestBody, HttpServletRequest httpServletRequest) {
        debugLog.info("请求参数:" + requestBody);
        SelectOrderRequest request = null;
        SelectOrderResponse response = new SelectOrderResponse();
        try {
            request = objectMapper.readValue(requestBody, SelectOrderRequest.class);
            response = httpNorthManageService.selectOrder(request, httpServletRequest);
        } catch (Exception e) {
            response.setReturnCode(CommonConstants.EXCEPTION_FAIL_CODE);
            response.setReturnMsg(CommonConstants.EXCEPTION_FAIL_DESC + ":" + e.getMessage());
        }
        String responseMsg = JSONObject.toJSONString(response);
        debugLog.info("查询结果:" + responseMsg);
        return responseMsg;
    }

}
