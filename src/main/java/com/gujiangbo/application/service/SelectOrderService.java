package com.gujiangbo.application.service;

import com.gujiangbo.application.controller.SelectOrderController;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface SelectOrderService {

    public SelectOrderResponse selectOrder(SelectOrderRequest request);
}
