package com.shop.service;
import com.shop.pojo.User;

public interface UserService {
    public void register(String username, String password);
    public User findUserByUsername(String username);
}
