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
        //密码加密,得到MD5字符串
        String md5String = Md5Util.getMD5String(password);
        //将用户信息存入数据库(用户名,密码md5字符串)
        userMapper.addUser(username, md5String);
    }

    @Override
    public User findUserByUsername(String username) {
        //查找用户
        User user = userMapper.findUserByUsername(username);
        //返回用户
        return user;
    }
}
