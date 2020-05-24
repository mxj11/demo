package com.inventory.mapper;

import com.inventory.entity.InventoryInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface InventoryMapper {
    @Update("UPDATE t_store SET count=#{count} WHERE enterpriseId=#{enterpriseId} AND productId=#{productId}")
    int update(InventoryInfo inventoryInfo);

    @Select("SELECT count FROM t_store where enterpriseId=#{enterpriseId} AND productId=#{productId}")
    InventoryInfo find(@Param("enterpriseId") String enterpriseId, @Param("productId")String productId);
}
