package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 进行注册登录业务处理
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    /**
     * 用户登录
     */
    public Result login(User user){
        User dbuser = userMapper.selectAllByUsernameAndPassword(user);

        if (dbuser == null){
            return Result.error("-1","账号或密码错误");
        }else
            return Result.success();
    }

    /**
     * 用户注册
     */
    public Result register(User user) {
            userMapper.insert(user);
            return Result.success();

    }


}
