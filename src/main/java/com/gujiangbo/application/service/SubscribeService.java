package com.gujiangbo.application.service;

import com.gujiangbo.application.request.SubscribeRequest;
import com.gujiangbo.application.response.SubscribeResponse;
import org.springframework.stereotype.Service;

@Service
public interface SubscribeService {
    public SubscribeResponse subscribe(SubscribeRequest request);
}
