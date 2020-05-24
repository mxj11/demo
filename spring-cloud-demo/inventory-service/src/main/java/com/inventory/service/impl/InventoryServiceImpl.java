package com.inventory.service.impl;

import com.common.response.ResponseResult;
import com.inventory.entity.InventoryInfo;
import com.inventory.mapper.InventoryMapper;
import com.inventory.service.InventoryService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@RequestMapping("/inventory")
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @RequestMapping(value = "/v1/reduce", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseResult reduce(String enterpriseId, String productId) {
        ResponseResult responseResult = new ResponseResult(200, "success");
        InventoryInfo inventoryInfo = inventoryMapper.find(enterpriseId, productId);
        inventoryInfo.setEnterpriseId(enterpriseId);
        inventoryInfo.setProductId(productId);
        responseResult.setData(inventoryInfo);
        return responseResult;
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
