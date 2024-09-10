package com.shop.service.impl;
import com.shop.mapper.UserMapper;
import com.shop.pojo.User;
import com.shop.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements com.shop.service.UserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public void register(String username, String password) {
        //注册用户
        String md5String = Md5Util.getMD5String(password);
        userMapper.addUser(username, md5String);
    }

    @Override
    public User findUserByUsername(String username) {
        User user = userMapper.findUserByUsername(username);
        return user;
    }
}
