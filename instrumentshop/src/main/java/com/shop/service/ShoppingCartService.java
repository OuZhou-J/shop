package com.shop.service;
import com.shop.pojo.ShoppingCart;

import java.math.BigDecimal;
import java.util.List;

public interface ShoppingCartService {
    void addShoppingCart(String username, int instrument_id, int quantity, int shipping_mode, BigDecimal money, BigDecimal weight);
    boolean deleteShoppingCart(int id);
    boolean updateShoppingCart(int id, int instrument_id, int quantity, int shipping_mode, BigDecimal money, BigDecimal weight);
    public void logoutShoppingCart();

    BigDecimal getMoney(int id, int quantity, int shipping_mode);

    BigDecimal getWeight(int id, int quantity);
    List<ShoppingCart> findShoppingCartByUsername(String username);
}
