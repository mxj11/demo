package com.order.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class OrderInfo implements Serializable {
    private String userId;

    private String productId;

    private String orderNum;

    private String enterpriseId;

    private long updateTime;

    private long createTime;
}
