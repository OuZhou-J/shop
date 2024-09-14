package com.shop.service.impl;

import com.shop.mapper.ShoppingCartMapper;
import com.shop.pojo.MusicalInstruments;
import com.shop.pojo.ShoppingCart;
import com.shop.service.MusicalInstrumentsService;
import com.shop.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements com.shop.service.ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private MusicalInstrumentsService musicalInstrumentsService;

    @Override
    public void addShoppingCart(String username, int instrument_id, int quantity, int shipping_mode, BigDecimal money, BigDecimal weight) {
        //debug mode money weight
        System.out.println("shipping_mode: " + shipping_mode);
        System.out.println("money: " + money);
        System.out.println("weight: " + weight);

        ShoppingCart check_ShoppingCart = shoppingCartMapper.findShoppingCartByInstrument_id(instrument_id);
        if(check_ShoppingCart != null){
            System.out.println("updateShoppingCart");

            int update_qutity = quantity + check_ShoppingCart.getQuantity();
            BigDecimal update_money = money.add(check_ShoppingCart.getMoney());
            BigDecimal update_weight = weight.add(check_ShoppingCart.getWeight());

            //debug
            System.out.println("id: " + check_ShoppingCart.getId());
            System.out.println("instrument_id: " + instrument_id);
            System.out.println("update_qutity: " + update_qutity);
            System.out.println("shipping_mode: " + shipping_mode);
            System.out.println("update_money: " + update_money);
            System.out.println("update_weight: " + update_weight);

            shoppingCartMapper.updateShoppingCart(check_ShoppingCart.getId(),instrument_id,update_qutity,shipping_mode,update_money,update_weight);
        }
        else{
            System.out.println("addShoppingCart");
            shoppingCartMapper.addShoppingCart(username, instrument_id, quantity, shipping_mode, money, weight);
        }
    }


    @Override
    public boolean deleteShoppingCart(int id) {
        ShoppingCart Update_ShoppingCart = shoppingCartMapper.findShoppingCartById(id);

        // 判断id是否存在
        if(Update_ShoppingCart == null){
            return false;
        }

        // 从ThreadLocal中获取当前用户
        Map<String, Object> claims = ThreadLocalUtil.get();
        String name = (String) claims.get("username");


        // 判断当前用户是否为购物车项的所有者
        if(name.equals(Update_ShoppingCart.getUsername())){
            shoppingCartMapper.deleteShoppingCart(id);
            return true;
        }
        else{
            return false;
        }
    }

    @Override
    public boolean updateShoppingCart(int id,int instrument_id, int quantity, int shipping_mode, BigDecimal money, BigDecimal weight) {
        ShoppingCart Update_ShoppingCart = shoppingCartMapper.findShoppingCartById(id);
        if (Update_ShoppingCart == null) {
            return false;
        }
        Map<String, Object> claims = ThreadLocalUtil.get();
        String name = (String) claims.get("username");
        if(name.equals(Update_ShoppingCart.getUsername())){

            // debug
            System.out.println("id: " + id);
            System.out.println("instrument_id: " + instrument_id);
            System.out.println("quantity: " + quantity);
            System.out.println("shipping_mode: " + shipping_mode);
            System.out.println("money: " + money);
            System.out.println("weight: " + weight);


            shoppingCartMapper.updateShoppingCart(id,instrument_id, quantity, shipping_mode, money, weight);
            return true;
        }
        else {
            return false;
        }
    }


    @Override
    public List<ShoppingCart> findShoppingCartByUsername(String username) {
        return shoppingCartMapper.findShoppingCartByUsername(username);
    }

    public void logoutShoppingCart() {
        Map<String, Object> claims = ThreadLocalUtil.get();
        String name = (String) claims.get("username");
        shoppingCartMapper.logoutShoppingCart(name);
    }


    @Override
    public BigDecimal getMoney(int id, int quantity, int shipping_mode) {
        MusicalInstruments musicalInstruments = musicalInstrumentsService.getMusicalInstrumentsById(id);
        if(musicalInstruments == null){
            return null;
        }
        BigDecimal money = musicalInstruments.getPricePerUnit().multiply(new BigDecimal(quantity));
        BigDecimal shippingCost;
        if (shipping_mode == 1) {
            shippingCost = new BigDecimal(10);
        } else if (shipping_mode == 2) {
            shippingCost = new BigDecimal(5);
        } else {
            return null;
        }
        money = money.add(shippingCost);
        return money;
    }

    @Override
    public BigDecimal getWeight(int id, int quantity) {
        MusicalInstruments musicalInstruments = musicalInstrumentsService.getMusicalInstrumentsById(id);
        if(musicalInstruments == null){
            return null;
        }
        BigDecimal weight = musicalInstruments.getShippingWeight();
        weight = weight.multiply(new BigDecimal(quantity));
        return weight;
    }
}
