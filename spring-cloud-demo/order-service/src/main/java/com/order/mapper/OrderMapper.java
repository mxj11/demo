package com.order.mapper;

import com.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO t_order (userId,productId,orderNum,orderState,createTime,updateTime) VALUES (#{userId}, #{productId},#{orderNum},#{orderState},#{createTime},#{updateTime});")
    int order(OrderInfo orderInfo);
}
