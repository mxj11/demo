package com.order.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface OrderStateMapper {
    @Insert("INSERT INTO t_order_state (userId,productId,orderNum,orderState) VALUES (#{userId}, #{productId},#{orderNum},#{orderState});")
    int insertOrderState(@Param("userId") String userId, @Param("productId")String productId,@Param("orderNum")String orderNum, @Param("orderState")int orderState);
}
