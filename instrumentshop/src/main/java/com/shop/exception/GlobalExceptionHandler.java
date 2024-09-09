package com.shop.exception;

import com.mysql.jdbc.StringUtils;
import com.shop.pojo.Result;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    public Result exceptionHandler(Exception e) {
        e.printStackTrace();
        return Result.error(StringUtils.isNullOrEmpty(e.getMessage()) ? "系统异常" : e.getMessage());
    }
}
