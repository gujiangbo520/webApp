package com.gujiangbo.application.service;

import com.gujiangbo.application.base.BaseResponse;
import com.gujiangbo.application.info.SubAccount;
import org.springframework.stereotype.Service;

@Service
public interface UpdateSubAccountService {

    public BaseResponse updateSubAccount(SubAccount account);
}
