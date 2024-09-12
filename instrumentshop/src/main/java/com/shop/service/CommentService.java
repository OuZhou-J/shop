package com.shop.service;
import com.shop.pojo.ProductReview;
import com.shop.pojo.User;

import java.sql.ResultSet;
import java.util.List;

public interface CommentService {
    public void addComment(int order_id,int user_id,int instrument_id,String item_name,int rating,String review_text,String image_url);
    public List<ProductReview> findCommentsByInstrument_id(int instrument_id);
    public List<ProductReview> findCommentsByOrder_id(int order_id);
}
