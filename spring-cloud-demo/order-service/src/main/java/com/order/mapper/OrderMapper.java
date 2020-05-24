package com.order.mapper;

import com.order.entity.OrderInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO t_order (userId,productId,orderNum,enterpriseId,createTime,updateTime) VALUES (#{userId}, #{productId},#{orderNum},#{enterpriseId},#{createTime},#{updateTime});")
    int order(OrderInfo orderInfo);
}
