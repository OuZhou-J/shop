package com.shop.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductReview {
    private int reviewId;            // 评价ID
    private int orderId;             // 订单ID
    private int userId;              // 用户ID
    private int instrumentId;        // 乐器ID
    private String itemName;         // 乐器名称
    private int rating;              // 评分
    private String reviewText;       // 评价内容
    private String imageUrl;         // 图片地址
    private LocalDateTime reviewDate;         // 创建时间

}

