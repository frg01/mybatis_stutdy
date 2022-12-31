package com.hspedu.mapper;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */

import com.hspedu.entity.Monster;

import javax.swing.*;
import java.util.List;
import java.util.Map;

/**
 * 只是一个接口
 * 该接口用于定义声明操作monster表的方法
 * 这些方法可以通过注解或者xml文件来实现
 */
public interface MonsterMapper {

    //通过id或名字查询
    public List<Monster> findMonsterByNameOrId(Monster monster);

    //查询名字中含有牛魔王
    public List<Monster> findMonsterByName(String name);

    //查询id>10 并且salary>40  要求传入参数是HashMap
    public List<Monster> findMonsterByIdAndSalary_ParameterHashMap(Map<String,Object> map);

    //查询id>10 并且salary>40  要求传入参数是HashMap
    public List<Map<String,Object>> findMonsterByIdAndSalary_ReturnHashMap(Map<String,Object> map);


}
