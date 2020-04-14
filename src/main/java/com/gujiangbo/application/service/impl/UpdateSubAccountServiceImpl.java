package com.gujiangbo.application.service.impl;

import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.info.SubAccount;
import com.gujiangbo.application.manage.service.HttpSouthManageService;
import com.gujiangbo.application.service.UpdateSubAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UpdateSubAccountServiceImpl implements UpdateSubAccountService {

    @Autowired
    private HttpSouthManageService httpSouthManageService;
    @Override
    public BaseResponse updateSubAccount(SubAccount account) {
        return httpSouthManageService.updateSubAccount(account);
    }
}
