package com.shop.mapper;

import com.shop.pojo.ProductReview;
import com.shop.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.ResultSet;
import java.util.List;

@Mapper
public interface CommentMapper {

    @Insert("insert into ProductReview (order_id,user_id,instrument_id,item_name,rating,review_text,image_url,review_date) values (#{order_id},#{user_id},#{instrument_id},#{item_name},#{rating}, #{review_text},#{image_url}, now())")
    public void addComment(int order_id,int user_id,int instrument_id,String item_name,int rating,String review_text,String image_url);
    @Select("select * from ProductReview where instrument_id = #{instrument_id}")
    public List<ProductReview> findCommentsByInstrument_id(int instrument_id);
    @Select("select * from ProductReview where order_id = #{instrument_id} and user_id = #{user_id}")
    public List<ProductReview> findifcomment(int instrument_id,int user_id);
}


