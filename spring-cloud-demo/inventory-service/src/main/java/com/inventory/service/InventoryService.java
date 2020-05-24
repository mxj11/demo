package com.inventory.service;

import com.inventory.entity.InventoryInfo;

public interface InventoryService {
    int update(InventoryInfo inventoryInfo);

    InventoryInfo find(String enterpriseId, String productId);
}
