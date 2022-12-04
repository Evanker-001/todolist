package com.example.demo.controller;


import com.example.demo.common.Result;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 *与前端进行交互，接受前端传入的数据并作出回应
 */

@CrossOrigin  //解决跨域问题
@Controller
@RequestMapping("/user")
public class Usercontroller {

    @Autowired
    private UserService userService;

    /**
     * 登录
     */
    @GetMapping("/login")
    public String tologin(){
        return "mylogin.html";
    }

    @ResponseBody
    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }


    /**
     * 注册
     */
    @GetMapping("/register")
    public String toregister(){
        return "registration.html";
    }

    @ResponseBody
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.register(user);
    }

}