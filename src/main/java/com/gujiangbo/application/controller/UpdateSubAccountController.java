package com.gujiangbo.application.controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.info.SubAccount;
import com.gujiangbo.application.manage.service.HttpNorthManageService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author gujiangbo
 * @descreption 更新收件账户信息
 * @updateTime 2020/4/3
 */
@RestController
public class UpdateSubAccountController {

    private Log debugLog = LogFactory.getLog(UpdateSubAccountController.class);

    @Autowired
    private HttpNorthManageService httpNorthManageService;

    private ObjectMapper mapper = new ObjectMapper();

    @ResponseBody
    @RequestMapping("updateSubAccount")
    public String updateSubAccount(@RequestBody String requestBody, HttpServletRequest httpServletRequest) {
        debugLog.info("修改收件人信息请求:" + requestBody);
        BaseResponse response = new BaseResponse();
        SubAccount subAccount = null;
        try {
            subAccount = mapper.readValue(requestBody, SubAccount.class);
            response = httpNorthManageService.updateSubAccount(subAccount, httpServletRequest);
        } catch (Exception e) {
            debugLog.error("收件人信息读取异常!", e);
        }
        debugLog.info("响应信息:" + JSONObject.toJSONString(response));
        return JSONObject.toJSONString(response);
    }
}
