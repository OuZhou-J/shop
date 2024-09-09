package com.shop.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class WebOrder {
    private int orderId;             // 订单ID
    private int userId;              // 用户ID
    private String username;         // 用户名
    private LocalDateTime orderDate;          // 订单时间
    private String shipmentMode;     // 运输方式
    private BigDecimal totalCost;    // 总费用
    private BigDecimal totalWeight;  // 总重量
    private int instrumentId;        // 乐器ID
    private String itemName;         // 乐器名称
    private int quantity;            // 数量
}
