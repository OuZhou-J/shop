package com.shop.controller;

import com.shop.interceptors.LoginInterceptor;
import com.shop.pojo.MusicalInstruments;
import com.shop.pojo.Result;
import com.shop.pojo.ShoppingCart;
import com.shop.service.MusicalInstrumentsService;
import com.shop.service.ShoppingCartService;
import com.shop.utils.ThreadLocalUtil;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.instrument.Instrumentation;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;



    @PostMapping("/add")

    public Result addShoppingCart(@RequestParam int instrument_id, @RequestParam int quantity, @RequestParam int shipping_mode) {
        // 添加购物车项
        Map<String, Object> claims = ThreadLocalUtil.get();
        String name = (String) claims.get("username");

        //System.out.println("instrument_id: " + instrument_id);

        BigDecimal money = shoppingCartService.getMoney(instrument_id, quantity, shipping_mode);
        BigDecimal weight = shoppingCartService.getWeight(instrument_id, quantity);

//
//        System.out.println("money: " + money);
//        System.out.println("weight: " + weight);

        shoppingCartService.addShoppingCart(name, instrument_id, quantity, shipping_mode, money, weight);
        return Result.success("购物车项添加成功");
    }

    @PostMapping("/delete")
    public Result deleteShoppingCart(@RequestParam int id) {
        // 删除购物车项
        if(shoppingCartService.deleteShoppingCart(id)){
            return Result.success("购物车项删除成功");
        }
        else{
            return Result.success("删除失败，购物车项不存在或您无权删除此购物车记录");
        }
    }

    @PostMapping("/update")
    public Result updateShoppingCart(@RequestParam int id, @RequestParam int instrument_id, @RequestParam int quantity, @RequestParam int shipping_mode) {
        // 更新购物车项
        BigDecimal money = shoppingCartService.getMoney(instrument_id, quantity, shipping_mode);
        BigDecimal weight = shoppingCartService.getWeight(instrument_id, quantity);

        if(shoppingCartService.updateShoppingCart(id,instrument_id, quantity, shipping_mode, money, weight)){
            return Result.success("购物车项更新成功");
        }
        else{
            return Result.success("记录修改失败，购物车项不存在或您无权修改此购物车记录");
        }
    }

    @GetMapping("/find")
    public Result findShoppingCartByUsername() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String name = (String) claims.get("username");
        List<ShoppingCart> cart = shoppingCartService.findShoppingCartByUsername(name);
        if (cart != null) {
            return Result.success(cart);
        }
        else {
            return Result.error("购物车项不存在");
        }
    }
    @PostMapping("/logout")
    public Result logoutShoppingCart() {
        shoppingCartService.logoutShoppingCart();
        return Result.success("购物车删除成功");
    }
}
