package com.gujiangbo.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujiangbo.application.manage.service.HttpNorthManageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 订单订购接口
 */
@RestController
public class SubscribeController {

    private Log debugLog = LogFactory.getLog(SubscribeController.class);

    @Autowired
    private HttpNorthManageService httpNorthManageService;

    @RequestMapping(value = "subscribe", method = {RequestMethod.POST})
    public String subscribe(@RequestBody String requestBody, HttpServletRequest httpServletRequest) {
        debugLog.info(" 请求信息:" + requestBody);
        try {

        } catch (Exception e) {
        }


        return null;
    }


}
