package com.gujiangbo.application.utils;

import java.beans.PropertyDescriptor;
import java.util.List;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import com.gujiangbo.application.manage.service.impl.HttpNorthManageServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.FatalBeanException;

public class ValidateParamTool {

    private static Log debugLog = LogFactory.getLog(HttpNorthManageServiceImpl.class);

    //整个类都校验
    public static List<String> validateProperty(Object validateObj) {
        debugLog.info("参数校验开始");
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(validateObj.getClass());
        String[] checkProperties = new String[targetPds.length];
        for (int i = 0; i <= targetPds.length; i++) {
            checkProperties[i] = targetPds[i].getName();
        }
        return validateProperty(validateObj, checkProperties);
    }

    //类中的某些字段校验
    public static List<String> validateProperty(Object validateObj, String... checkProperties) {
        debugLog.info("参数校验开始");
        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(validateObj.getClass());
        List<String> checkList = (checkProperties != null ? Arrays.asList(checkProperties) : null);
        List<String> errList = new ArrayList<>();
        for (PropertyDescriptor targetPd : targetPds) {
            Method readMethod = targetPd.getReadMethod();
            if (readMethod != null && (checkList != null && checkList.contains(targetPd.getName()))) {
                try {
                    if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                        readMethod.setAccessible(true);
                    }
                    Object value = readMethod.invoke(validateObj);
                    if (value instanceof String) {
                        if (StringUtils.isEmpty((String) value)) {
                            errList.add(validateObj.getClass().getSimpleName() + "中的" + targetPd.getName() + "不能为空");
                            continue;
                        }
                    }
                    if (value == null) {
                        errList.add(validateObj.getClass().getSimpleName() + "中的" + targetPd.getName() + "不能为空");
                    }
                } catch (Throwable ex) {
                    throw new FatalBeanException(
                            "Could not copy property '" + targetPd.getName() + "' from source to target", ex);
                }
            }
        }
        debugLog.info("参数校验结束");
        return errList;
    }
}
