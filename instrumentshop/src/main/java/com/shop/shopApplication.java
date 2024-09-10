package com.shop;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@MapperScan("com.shop.mapper")
public class shopApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(shopApplication.class, args);
    }
}
