package com.gujiangbo.application.utils;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class BeanTools {

    private static Log debugLog = LogFactory.getLog(BeanTools.class);

    /**
     * Bean 对象转换成 JsonString
     *
     * @param obj
     * @return
     */
    public static String beanToString(Object obj) {
        return JSONObject.toJSONString(obj);
    }

    /**
     * JsonString 转换成 Bean对象
     * @param jsonStr
     * @param object
     * @return
     */
    public static Object jsonStringToBean(String jsonStr, Object object) {
        ObjectMapper mapper = new ObjectMapper();
        Object obj = new Object();
        try {
            obj = mapper.readValue(jsonStr, object.getClass());
        } catch (Exception e) {
            debugLog.error("对象转换失败，失败原因:"+e.getMessage());
        }
        return obj;
    }
}
