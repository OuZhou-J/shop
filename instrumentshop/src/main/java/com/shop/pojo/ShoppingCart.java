package com.shop.pojo;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ShoppingCart {
    private int id;                  // 购物车ID
    private String username;         // 用户名
    private int instrumentId;        // 乐器ID
    private int quantity;            // 数量
    private LocalDateTime addedAt;            // 创建时间
}
