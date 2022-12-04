package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.entity.Todolist;
import com.example.demo.service.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


/**
 *与前端进行交互，接受前端传入的数据并作出回应
 */
@CrossOrigin
@Controller
@RequestMapping("/todolist")
public class Listcontroller {

    @Autowired
    ListService listService;

    /**
     * 通过GetMapping获取前端页面
     */
    @GetMapping("/add")
    public String gotoadd(){
        return "todolist-jquery.html";
    }


    @PostMapping("/add")
    @ResponseBody
    public Result add(@RequestBody Todolist things){
        return listService.add(things);
    }

    @GetMapping("/show")
    @ResponseBody
    public Result show(){
        List<Todolist> things = listService.show();
        return Result.success(things);
    }


    @PostMapping("/delete")
    @ResponseBody
    public Result delete(@RequestBody Todolist things){
        listService.delete(things);
        return Result.success();
    }

}
