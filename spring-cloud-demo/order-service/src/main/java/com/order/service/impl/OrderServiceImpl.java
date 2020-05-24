package com.order.service.impl;

import com.common.response.ResponseResult;
import com.order.entity.OrderInfo;
import com.order.mapper.OrderMapper;
import com.order.mapper.OrderStateMapper;
import com.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderStateMapper orderStateMapper;

    @Transactional
    @Override
    public ResponseResult order(String userId, String productId, String enterpriseId) {
        ResponseResult responseResult = new ResponseResult(200, "success");
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateTime(System.currentTimeMillis());
        orderInfo.setUpdateTime(System.currentTimeMillis());
        orderInfo.setUserId(userId);
        String orderNum = UUID.randomUUID().toString();
        orderInfo.setOrderNum(orderNum);
        orderInfo.setEnterpriseId(enterpriseId);
        orderInfo.setProductId(productId);
        orderMapper.order(orderInfo);
        orderStateMapper.insertOrderState(userId, productId, orderNum,1);
        return responseResult;
    }
}
