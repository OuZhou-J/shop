package com.shop.config;

import com.shop.interceptors.LoginInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
// 配置类
public class WebConfig implements WebMvcConfigurer{
    @Autowired
    private LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器,括号里面是不拦截的路径
        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/user/register", "/user/login");
    }

}
