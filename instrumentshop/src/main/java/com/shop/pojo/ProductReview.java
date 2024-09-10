package com.shop.pojo;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ProductReview {
    private int review_id;            // 评价ID
    private int order_id;             // 订单ID
    private int user_id;              // 用户ID
    private int instrument_id;        // 乐器ID
    private String item_name;         // 乐器名称
    private int rating;              // 评分
    private String review_text;       // 评价内容
    private String image_url;         // 图片地址
    private LocalDateTime review_date;         // 创建时间

}

