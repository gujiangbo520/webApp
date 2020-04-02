package com.gujiangbo.application.database.service;

import com.gujiangbo.application.info.OrderInfo;
import com.gujiangbo.application.info.SubAccount;
import com.gujiangbo.application.request.SelectOrderRequest;
import com.gujiangbo.application.response.SelectOrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface OperateDataBaseService {

    /**
     * 查询单条数据记录，orderID唯一
     *
     * @param request
     * @return
     * @throws Exception
     */
    OrderInfo selectOrder(SelectOrderRequest request);

    /**
     * 新增收件人账号信息
     *
     * @param account
     * @throws Exception
     */
    boolean insertSubAccount(SubAccount account);

    /**
     * 更新收件人账号信息
     *
     * @param account
     * @throws Exception
     */
    boolean updateSubAccount(SubAccount account);


    /**
     * 保存订单信息
     *
     * @param info
     * @throws Exception
     */
    boolean saveOrderInfo(OrderInfo info);

    /**
     * 查询收件人信息
     * @param account
     * @return
     */
    SubAccount selectSubAccount(SubAccount account);
}
