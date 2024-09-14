package com.shop.service;

import com.shop.pojo.WebOrder;

import java.util.List;

public interface WebOrderService {

    //订单查询
    List<WebOrder> list();

    //订单添加
    void add(WebOrder webOrder,String orderID);
}
