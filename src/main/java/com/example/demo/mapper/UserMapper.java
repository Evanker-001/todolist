package com.example.demo.mapper;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 进行数据库相关操作
 */
@Mapper
public interface UserMapper {

   /**
    * 查询用户账号密码，供UserService使用
    */
   @Select("select * from user where username = #{username} and password = #{password}")
   User selectAllByUsernameAndPassword(User user);

   /**
    * 新增用户，即用户注册
    */
   @Insert("insert into user(username,password)values (#{username},#{password})")
   void insert(User user);


}