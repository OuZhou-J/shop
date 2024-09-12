package com.shop.service.impl;
import com.shop.mapper.CommentMapper;
import com.shop.pojo.ProductReview;
import com.shop.pojo.User;
import com.shop.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(int order_id, int user_id, int instrument_id, String item_name, int rating, String review_text, String image_url) {
        //注册用户
        commentMapper.addComment(order_id,user_id,instrument_id,item_name,rating,review_text,image_url);
    }

    @Override
    public List<ProductReview>  findCommentsByInstrument_id(int instrument_id){

        List<ProductReview> reviews = commentMapper.findCommentsByInstrument_id(instrument_id);
        return reviews;
    }

    public List<ProductReview> findCommentsByOrder_id(int order_id){

        List<ProductReview> reviews = commentMapper.findCommentsByOrder_id(order_id);
        return reviews;
    }
}
