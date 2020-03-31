package com.gujiangbo.application.manage.service;

import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public interface HttpNorthManageService {
    public SelectOrderResponse selectOrder(SelectOrderRequest request, HttpServletRequest httpServletRequest);
}
