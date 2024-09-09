package com.shop.interceptors;

import com.shop.utils.ThreadLocalUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.shop.utils.JwtUtil;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Map;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");
        try {
            Map<String, Object> claims = JwtUtil.parseToken(token);
            // 将用户信息存入ThreadLocal,使用时直接从ThreadLocal中获取
            ThreadLocalUtil.set(claims);
            // 放行
            return true;
        }
        catch (Exception e) {
            response.setStatus(401);
            // 不放行
            return false;
        }
    }

    @Override
    // 清除ThreadLocal 防止内存泄漏
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        ThreadLocalUtil.remove();
    }

}
