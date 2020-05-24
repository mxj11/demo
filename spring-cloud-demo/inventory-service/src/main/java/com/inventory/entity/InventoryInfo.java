package com.inventory.entity;

import lombok.Data;

@Data
public class InventoryInfo {
    private String enterpriseId;

    private String productId;

    private int count;
}
