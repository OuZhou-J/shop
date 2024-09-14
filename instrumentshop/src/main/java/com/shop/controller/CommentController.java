package com.shop.controller;

import com.shop.pojo.Result;
import com.shop.pojo.ProductReview;
import com.shop.pojo.User;
import com.shop.service.CommentService;
import com.shop.service.UserService;
import com.shop.utils.JwtUtil;
import com.shop.utils.Md5Util;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/comment")

public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/postcomment")
    // 注册
    public Result comment(int order_id,int user_id,int instrument_id,String item_name,int rating,String review_text,String image_url) {
        List<ProductReview> reviews =  commentService.findifcomment(instrument_id,user_id);
        if (reviews.isEmpty()) {
            commentService.addComment(order_id,user_id,instrument_id,item_name,rating,review_text,image_url);
            return Result.success();
        }
        return Result.error("您已经评论过该商品了");

    }

    @GetMapping("/readcomments")
    public Result readcomments(int instrument_id) {

        List<ProductReview> reviews = commentService.findCommentsByInstrument_id(instrument_id);
        if (reviews == null) {
            return Result.error("评论不存在");
        }
        else {
            return Result.success(reviews);
        }
    }

}
