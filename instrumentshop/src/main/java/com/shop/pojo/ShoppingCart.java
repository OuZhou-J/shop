package com.shop.pojo;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class ShoppingCart {
    private int id;                  // 购物车ID
    private String username;         // 用户名
    private int instrument_id;        // 乐器ID

    private int quantity;            // 数量
    private LocalDateTime added_at;            // 创建时间

    private int shipping_mode;       // 运输方式
    private BigDecimal money;          // 金额
    private BigDecimal weight;         // 重量
}
