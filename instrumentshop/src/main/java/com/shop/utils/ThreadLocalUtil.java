package com.shop.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * ThreadLocal 工具类
 */
@SuppressWarnings("all")
public class ThreadLocalUtil {
    //提供ThreadLocal对象,
    private static final ThreadLocal THREAD_LOCAL = new ThreadLocal();

    //根据键获取值
    public static <T> T get(){
        return (T) THREAD_LOCAL.get();
    }
	
    //存储键值对
    public static void set(Object value){
        THREAD_LOCAL.set(value);
    }


    //清除ThreadLocal 防止内存泄漏
    public static void remove(){
        THREAD_LOCAL.remove();
    }


    //get id
    public static Integer getUserId(){
        //获取用户id
        Map<String, Object> claims = get();
        return (Integer) claims.get("id");
    }

    //get username
    public static String getUsername(){
        //获取用户名
        Map<String, Object> claims = get();
        return (String) claims.get("username");
    }
}
