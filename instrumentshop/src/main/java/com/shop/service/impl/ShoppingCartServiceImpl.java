package com.shop.service.impl;

import com.shop.mapper.ShoppingCartMapper;
import com.shop.pojo.ShoppingCart;
import com.shop.utils.ThreadLocalUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ShoppingCartServiceImpl implements com.shop.service.ShoppingCartService {

    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Override
    public void addShoppingCart(String username, int instrument_id, int quantity) {
        ShoppingCart check_ShoppingCart=shoppingCartMapper.findShoppingCartByInstrument_id(instrument_id);
        if(check_ShoppingCart!=null){
            int update_qutity=quantity+check_ShoppingCart.getQuantity();
            shoppingCartMapper.updateShoppingCart(check_ShoppingCart.getId(),instrument_id,update_qutity);
        }
        else{
            shoppingCartMapper.addShoppingCart(username, instrument_id, quantity);
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
    public boolean updateShoppingCart(int id,int instrument_id, int quantity) {
        ShoppingCart Update_ShoppingCart = shoppingCartMapper.findShoppingCartById(id);
        Map<String, Object> claims = ThreadLocalUtil.get();
        String name = (String) claims.get("username");
        if(name.equals(Update_ShoppingCart.getUsername())){
            shoppingCartMapper.updateShoppingCart(id,instrument_id, quantity);
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
}
