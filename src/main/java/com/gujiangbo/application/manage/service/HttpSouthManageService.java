package com.gujiangbo.application.manage.service;

import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.info.SubAccount;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.request.SubscribeRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import com.gujiangbo.application.response.SubscribeResponse;
import org.springframework.stereotype.Service;

/**
 * @author gujiangbo
 * @description 南向服务接口
 */
@Service
public interface HttpSouthManageService {

    public abstract SelectOrderResponse selectOrder(SelectOrderRequest request);

    public abstract SubscribeResponse subscribe(SubscribeRequest request);

    public BaseResponse updateSubAccount(SubAccount account);

    public SelectOrderResponse queryOrderInfo(String subAccount);
}
