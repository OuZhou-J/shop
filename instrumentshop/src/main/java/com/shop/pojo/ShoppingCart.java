package com.shop.pojo;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShoppingCart {
    private int id;                  // 购物车ID
    private String username;         // 用户名
    private int instrumentId;        // 乐器ID
    private int quantity;            // 数量
    private LocalDateTime addedAt;   // 创建时间
    private int shippingMode;       // 运输方式
    private BigDecimal money;          // 金额
    private BigDecimal weight;         // 重量
}
