package com.inventory.msg;

import com.inventory.entity.InventoryInfo;
import com.inventory.service.impl.InventoryServiceImpl;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "order", consumerGroup = "orderGroup")
public class OrderMsg implements RocketMQListener<InventoryInfo> {
    @Autowired
    private InventoryServiceImpl inventoryService;

    @Override
    public void onMessage(InventoryInfo inventoryInfo) {
        inventoryService.reduce(inventoryInfo.getEnterpriseId(), inventoryInfo.getProductId());
    }
}
