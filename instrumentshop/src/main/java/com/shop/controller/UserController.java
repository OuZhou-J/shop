package com.shop.controller;

import jakarta.validation.constraints.Pattern;
import com.shop.pojo.Result;
import com.shop.pojo.User;
import com.shop.service.UserService;
import com.shop.utils.JwtUtil;
import com.shop.utils.Md5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/user")

public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    // 注册
    public Result register( String username, String password) {

        //用户名校验,只能包含字母、数字、下划线，长度为6-20
        if (!username.matches("^[a-zA-Z0-9_]{6,20}$")) {
            return Result.error("用户名只能包含字母、数字、下划线，长度为6-20");
        }
        else if (!password.matches("^[a-zA-Z0-9_]{6,20}$")) {
            return Result.error("密码只能包含字母、数字、下划线，长度为6-20");
        }
        //查找用户
        User user = userService.findUserByUsername(username);
        if (user == null) {
            //注册用户
            userService.register(username, password);
            return Result.success();
        }
        else {
            //占用用户名
            return Result.error("用户名已被占用");
        }
    }

    @PostMapping("/login")
    public Result login(String username, String password) {
        User user = userService.findUserByUsername(username);
        if (user == null) {
            return Result.error("用户名不存在");
        }
        else {

            if (user.getPassword().equals(Md5Util.getMD5String(password))) {
                Map<String, Object> claims = new HashMap<>();
                claims.put("id", user.getId());
                claims.put("username", user.getUsername());
                String token = JwtUtil.genToken(claims);
                return Result.success(token);
            }
            else {
                return Result.error("密码错误");
            }
        }
    }

}
