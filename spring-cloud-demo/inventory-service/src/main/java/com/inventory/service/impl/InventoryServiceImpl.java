package com.inventory.service.impl;

import com.inventory.entity.InventoryInfo;
import com.inventory.mapper.InventoryMapper;
import com.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    public void reduce(String enterpriseId, String productId) {
        InventoryInfo inventoryInfo = inventoryMapper.find(enterpriseId, productId);
        int count = inventoryInfo.getCount();
        if (count >= 1) {
            inventoryInfo.setProductId(productId);
            inventoryInfo.setEnterpriseId(enterpriseId);
            inventoryInfo.setCount(count - 1);
            int row = inventoryMapper.update(inventoryInfo);
            if (row > 0) {
                System.out.println("库存扣减成功");
                return;
            }
            System.out.println("库存扣减失败");
            return;
        }
        System.out.println("库存扣减不足");
    }

    @Override
    public int update(InventoryInfo inventoryInfo) {
        return inventoryMapper.update(inventoryInfo);
    }

    @Override
    public InventoryInfo find(String enterpriseId, String productId) {
        return inventoryMapper.find(enterpriseId, productId);
    }
}
