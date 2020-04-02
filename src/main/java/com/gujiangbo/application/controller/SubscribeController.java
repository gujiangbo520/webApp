package com.gujiangbo.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gujiangbo.application.enums.CommonConstants;
import com.gujiangbo.application.manage.service.HttpNorthManageService;
import com.gujiangbo.application.request.SubscribeRequest;
import com.gujiangbo.application.response.SubscribeResponse;
import com.gujiangbo.application.utils.BeanTools;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 订单订购接口流程
 * 1.订单前置系统调用本系统下单接口
 * 2.本系统会调用订购系统进行下单
 * 3.订购系统下单成功后会返回本系统响应码并调用交付系统进行物资交付
 * 4.交付系统出货
 * 5.交付系统出货后通知本系统 rabbitMQ
 * 6.本系统邮件通知用户
 */
@RestController
public class SubscribeController {

    private Log debugLog = LogFactory.getLog(SubscribeController.class);

    @Autowired
    private HttpNorthManageService httpNorthManageService;

    private ObjectMapper objectMapper = new ObjectMapper();

    @RequestMapping(value = "subscribe", method = {RequestMethod.POST})
    public String subscribe(@RequestBody String requestBody, HttpServletRequest httpServletRequest) {
        debugLog.info(" 请求信息:" + requestBody);
        SubscribeRequest request = new SubscribeRequest();
        SubscribeResponse response = new SubscribeResponse();
        try {
            request =  objectMapper.readValue(requestBody,SubscribeRequest.class);
            response = httpNorthManageService.subscribe(request,httpServletRequest);

        } catch (Exception e) {
            response.setReturnCode(CommonConstants.EXCEPTION_FAIL_CODE);
            response.setReturnMsg(CommonConstants.EXCEPTION_FAIL_DESC + ":" + e.getMessage());
        }
        String responseMsg = JSONObject.toJSONString(response);
        debugLog.info("响应结果:" + responseMsg);
        return responseMsg;
    }


}
