package com.gujiangbo.application.manage.service;

import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.request.SubscribeRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.response.SubscribeResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * @description 北向服务接口
 */
@Service
public interface HttpNorthManageService {

    public SelectOrderResponse selectOrder(SelectOrderRequest request, HttpServletRequest httpServletRequest);

    public SubscribeResponse subscribe(SubscribeRequest request, HttpServletRequest httpServletRequest);
}
