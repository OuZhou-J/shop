package com.shop;

import com.shop.mapper.CommentMapper;
import com.shop.mapper.UserMapper;
import com.shop.pojo.ProductReview;
import com.shop.utils.Md5Util;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
class StudyProjectBackendApplicationTests {
    @Autowired
    private CommentMapper commentMapper;

    @Test
    void contextLoads() throws SQLException {


        try {
            String asda="AAAAAAAAA";
            System.out.println("sadasd");
            // 连接数据库
            List<ProductReview> reviews = commentMapper.findCommentsByInstrument_id(1);

// 遍历结果并打印
            for (ProductReview review : reviews) {
                System.out.println(review.getOrder_id());

                  }
            System.out.println("sadasd");
        } catch (Exception e) {
        }
    }
}