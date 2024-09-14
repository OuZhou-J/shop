package com.shop.controller;
import com.shop.pojo.Result;
import com.shop.pojo.WebOrder;
import com.shop.service.WebOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/webOrder")
public class WebOrderController {

    @Autowired
    private WebOrderService webOrderService;

    //查询订单
    @GetMapping
    public Result<List<WebOrder>> list(){
        List<WebOrder> cs = webOrderService.list();
        if (cs.isEmpty()) {
            return Result.error("历史订单为空");
        }
        return Result.success(cs);
    }

    //添加订单
    @PostMapping
    public Result add (@RequestBody List<WebOrder> list) {
        if (list.isEmpty()) {
            return Result.error("购物篮是空的");
        }
        String orderId = list.get(0).getUsername() +
                LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        for(WebOrder webOrder : list){
            webOrderService.add(webOrder,orderId);
        }
        return Result.success();
    }

}
