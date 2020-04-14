package com.gujiangbo.application.service.impl;

import com.gujiangbo.application.manage.service.HttpSouthManageService;
import com.gujiangbo.application.request.SubscribeRequest;
import com.gujiangbo.application.response.SubscribeResponse;
import com.gujiangbo.application.service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SubscribeServiceImpl implements SubscribeService {

    @Autowired
    private HttpSouthManageService httpSouthManageService;

    @Override
    public SubscribeResponse subscribe(SubscribeRequest request) {
        return httpSouthManageService.subscribe(request);
    }
}
