package com.shop.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class WebOrder {

    private Integer id;

    private String orderId;//订单编号
    private Integer userId;//用户ID

    @NotEmpty
    private String username;//用户名字
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime orderTime;//创建时间
    @NotEmpty
    private String shipmentMode;//运输方式

    private Integer totalCost;//总成本
    private Integer totalWeight;//总重量
    private Integer instrumentId;//乐器ID

    @NotEmpty
    private String itemName;//乐器名
    private Integer quantity;//数量
}
