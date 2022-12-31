package com.hspedu.mapper;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */

import com.hspedu.entity.Monster;

import java.util.List;

/**
 * 只是一个接口
 * 该接口用于定义声明操作monster表的方法
 * 这些方法可以通过注解或者xml文件来实现
 */
public interface MonsterMapper {

    //添加monster
    public void addMonster(Monster monster);

    //根据id删除Monster
    public void deleteMonster(Integer id);

    //修改Monster
    public void updateMonster(Monster monster);

    //查询Monster 根据id
    public Monster getMonsterById(Integer id);

    //查询所有的Monster
    public List<Monster> findAllMonster();
}
