package com.shop.pojo;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class MusicalInstruments {
    private int id;                  // 乐器ID
    private String name;             // 乐器名称
    private BigDecimal pricePerUnit; // 单价
    private BigDecimal shippingWeight; // 重量
    private String description;      // 描述
    private BigDecimal airCost;      // 空运费用
    private BigDecimal landCost;     // 陆运费用
    private String imageUrl;         // 图片地址
}
