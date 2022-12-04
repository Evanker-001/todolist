package com.example.demo.mapper;


import com.example.demo.entity.Todolist;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * todolist接口
 */
@Mapper
public interface ListMapper {
    /**
     * 添加任务
     */
    @Insert("insert into todolist(things) values(#{things})")
    void add(Todolist things);

    /**
     * 查询所有任务
     */
    @Select("select * from todolist")
    List<Todolist> show();

    /**
     * 删除任务
     */
    @Delete("delete from todolist where things = #{things}")
    void delete(Todolist things);
}
