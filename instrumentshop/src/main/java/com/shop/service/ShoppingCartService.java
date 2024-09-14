package com.shop.service;
import com.shop.pojo.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {
    void addShoppingCart(String username, int instrument_id, int quantity);
    boolean deleteShoppingCart(int id);
    boolean updateShoppingCart(int id, int instrument_id, int quantity);
    public void logoutShoppingCart();
    List<ShoppingCart> findShoppingCartByUsername(String username);
}
