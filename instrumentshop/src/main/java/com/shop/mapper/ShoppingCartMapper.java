package com.shop.mapper;

import com.shop.pojo.ShoppingCart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ShoppingCartMapper {
    @Insert("insert into ShoppingCart (username,instrument_id,quantity,added_at) values (#{username}, #{instrument_id}, #{quantity}, now())")
    public void addShoppingCart(String username, int instrument_id,int quantity);

    @Delete("DELETE FROM ShoppingCart WHERE id = #{id}")
    public void deleteShoppingCart(int id);

    @Update("UPDATE ShoppingCart SET instrument_id = #{instrument_id}, quantity = #{quantity},added_at = now() WHERE id = #{id}")
    public void updateShoppingCart(int id,int instrument_id, int quantity);

    @Select("SELECT * FROM ShoppingCart WHERE username = #{username}")
    public List<ShoppingCart> findShoppingCartByUsername(String username);

    @Select("SELECT * FROM ShoppingCart WHERE id = #{id}")
    public  ShoppingCart findShoppingCartById(int id);

    @Select("SELECT * FROM ShoppingCart WHERE instrument_id = #{instrument_id}")
    public ShoppingCart findShoppingCartByInstrument_id(int instrument_id);

    @Delete("DELETE FROM ShoppingCart WHERE username = #{username}")
    public void logoutShoppingCart(String username);
}
