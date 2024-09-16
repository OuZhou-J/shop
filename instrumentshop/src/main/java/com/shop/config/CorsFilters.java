package com.shop.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
public class CorsFilters implements Filter {



    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        httpServletResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:5173");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "Authorization, Content-Type");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");

        // 处理 OPTIONS 请求，返回 200
        if ("OPTIONS".equalsIgnoreCase(httpServletRequest.getMethod())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        } else {
            filterChain.doFilter(request, response);
        }
    }
}
