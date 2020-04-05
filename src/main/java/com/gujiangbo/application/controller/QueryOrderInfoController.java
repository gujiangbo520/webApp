package com.gujiangbo.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.gujiangbo.application.enums.CommonEnums;
import com.gujiangbo.application.manage.service.HttpNorthManageService;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 根据订购者的Id 查询订单信息
 *
 * @author gujiangbo
 */
@RestController
public class QueryOrderInfoController {

    private Log debugLog = LogFactory.getLog(QueryOrderInfoController.class);

    @Autowired
    private HttpNorthManageService httpNorthManageService;

    @ResponseBody
    @RequestMapping("/queryOrderInfo")
    public String queryOrderInfos(@RequestBody String requestBody, HttpServletRequest httpServletRequest) {
        debugLog.info("请求查询信息:" + requestBody);
        SelectOrderResponse response = new SelectOrderResponse();
        try {
            JSONObject obj = JSONObject.parseObject(requestBody);
            response = httpNorthManageService.queryOrderInfo(requestBody, httpServletRequest);
        } catch (Exception e) {
            debugLog.error("数据查询失败，失败原因：", e);
            response.setReturnCode(CommonEnums.SELECT_DATA_FAIL_CODE);
            response.setReturnMsg(CommonEnums.SELECT_DATA_FAIL_MSG);
        }
        return JSONObject.toJSONString(response);
    }
}
