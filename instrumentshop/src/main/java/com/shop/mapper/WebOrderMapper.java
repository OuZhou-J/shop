package com.shop.mapper;

import com.shop.pojo.WebOrder;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WebOrderMapper {

    //查询用户所有订单
    @Select("select * from weborder where user_id = #{userId}")
    List<WebOrder> list(Integer userId);

    //添加
    @Insert("insert into weborder(order_id,user_id, username, order_time, shipment_mode, total_cost, total_weight, instrument_id, item_name, quantity)" +
            "values(#{orderId},#{userId},#{username},#{orderTime},#{shipmentMode},#{totalCost},#{totalWeight},#{instrumentId},#{itemName},#{quantity}) ")
    void add(WebOrder webOrder);
}
