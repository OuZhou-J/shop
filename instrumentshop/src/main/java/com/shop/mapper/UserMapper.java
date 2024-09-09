package com.shop.mapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.shop.pojo.User;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username, password, Create_time, Update_time) values (#{username}, #{password}, now(), now())")
    public void addUser(String username, String password);
    @Select("select * from user where username = #{username}")
    public User findUserByUsername(String username);
}


