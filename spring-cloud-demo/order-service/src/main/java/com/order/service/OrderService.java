package com.order.service;

import com.common.response.ResponseResult;

public interface OrderService {
    ResponseResult order(String userId, String productId);
}
