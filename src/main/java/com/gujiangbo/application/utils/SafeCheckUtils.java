package com.gujiangbo.application.utils;

import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.enums.CommonConstants;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *  安全检查工具
 */
public class SafeCheckUtils {

    private static Log debugLog = LogFactory.getLog(SafeCheckUtils.class);

    private static SafeCheckUtils instance = null;

    public static SafeCheckUtils getInstance() {
        synchronized (SafeCheckUtils.class) {
            if (instance == null) {
                synchronized (Object.class) {
                    instance = new SafeCheckUtils();
                }
            }
        }
        return instance;
    }

    public static Map<String, String> getMap(HttpServletRequest request) {
        Map<String, String> maps = new HashMap<>(16);
        String client_id = request.getHeader("client_id");
        String app_id = request.getHeader("app_id");
        String source_id = request.getHeader("source_id");
        maps.put("client_id", client_id);
        maps.put("app_id", app_id);
        maps.put("source_id", source_id);
        return maps;
    }

    /*请求头部校验*/
    public static BaseResponse checkHeader(HttpServletRequest request) {
        debugLog.info("请求头部参数校验...");
        BaseResponse baseResponse = new BaseResponse();
        if (StringUtils.isNotEmpty(getMap(request).get("client_id"))) {
            baseResponse.setReturnCode(CommonConstants.HEAD_CHECK_SUCCESS_CODE);
            baseResponse.setReturnMsg(CommonConstants.HEAD_CHECK_SUCCESS_DESC);
        } else {
            baseResponse.setReturnCode(CommonConstants.HEAD_CHECK_FAIL_CODE);
            baseResponse.setReturnMsg(CommonConstants.HEAD_CHECK_FAIL_DESC + ",缺少参数:client_id");
        }
        return baseResponse;
    }
}
