package com.hspedu.mapper;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */

import com.hspedu.entity.Monster;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * 只是一个接口
 * 该接口用于定义声明操作monster表的方法
 * 这些方法可以通过注解或者xml文件来实现
 */
public interface MonsterMapper {

    //根据age查询结果
    public List<Monster> findMonsterByAge(@Param(value = "age")Integer age);

    //根据id和名字查询结果
    public List<Monster> findMonsterByIdAndName(Monster monster);

    //测试choose标签的使用
    public List<Monster> findMonsterByIdAndName_choose(Map<String,Object> map);

    //测试foreach的标签使用
    public List<Monster> findMonsterById_forEach(Map<String,Object> map);

    //trim标签的使用
    public List<Monster> findMonsterByName_Trim(Map<String,Object> map);

    //set标签的使用
    public void updateMonster_set(Map<String,Object> map);

}
