package com.shop.service.impl;


import com.shop.mapper.WebOrderMapper;
import com.shop.pojo.WebOrder;
import com.shop.service.WebOrderService;
import com.shop.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class WebOrderServiceImpl implements WebOrderService {

    @Autowired
    private WebOrderMapper webOrderMapper;


    @Override
    public List<WebOrder> list() {
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        return webOrderMapper.list(userId);
    }

    @Override
    public void add(WebOrder webOrder,String orderId) {
        //补充属性值
        webOrder.setOrderTime(LocalDateTime.now());

        //获取ID
        Map<String,Object> map = ThreadLocalUtil.get();
        Integer userId = (Integer) map.get("id");

        webOrder.setUserId(userId);

        webOrder.setOrderId(orderId);

        webOrderMapper.add(webOrder);
    }
}
