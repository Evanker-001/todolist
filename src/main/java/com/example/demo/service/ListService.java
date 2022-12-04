package com.example.demo.service;

import com.example.demo.common.Result;
import com.example.demo.entity.Todolist;
import com.example.demo.mapper.ListMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * 进行业务处理
 */
@Service
public class ListService {
    @Autowired
    ListMapper listMapper;

    /**
     * 添加任务
     */
    public Result add(Todolist things){
        listMapper.add(things);
        return Result.success();
    }

    /**
     * 展示所有任务
     */
    public List<Todolist> show(){
        return listMapper.show();
    }


    /**
     * 删除任务
     */
    public void delete(Todolist things){
        listMapper.delete(things);
    }
}
