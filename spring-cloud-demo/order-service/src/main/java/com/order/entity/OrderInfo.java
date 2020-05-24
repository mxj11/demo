package com.order.entity;

import lombok.Data;

@Data
public class OrderInfo {
    private String userId;

    private String productId;

    private String orderNum;

    private String enterpriseId;

    private long updateTime;

    private long createTime;
}
