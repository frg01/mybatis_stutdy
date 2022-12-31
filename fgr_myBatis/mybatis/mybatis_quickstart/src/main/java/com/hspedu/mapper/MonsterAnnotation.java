package com.hspedu.mapper;

import com.hspedu.entity.Monster;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 使用注解方式配置接口方法
 */
public interface MonsterAnnotation {

    //添加monster
    /*
    使用注解方式配置接口方法
    useGeneratedKeys可以返回自增值
    keyProperty = "id" 自增值对应的对象属性
    keyColumn = "id" 自增值对应表的字段
     */
    @Insert("INSERT INTO `monster` (`age`,`birthday`,`email`,`gender`,`name`,`salary`) " +
            "VALUES (#{age},#{birthday},#{email},#{gender},#{name},#{salary})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "id")
    public void addMonster(Monster monster);

    //根据id删除Monster
    @Delete("DELETE FROM `monster` WHERE id = #{id}")
    public void deleteMonster(Integer id);

    //修改Monster
    @Update("UPDATE `monster` SET `age` = #{age},`birthday`= #{birthday},`email`= #{email}, " +
            "`gender`= #{gender},`name` = #{name},`salary` = #{salary} WHERE id = #{id}")
    public void updateMonster(Monster monster);

    //查询Monster 根据id
    @Select("SELECT * FROM `monster` WHERE id = #{id}")
    public Monster getMonsterById(Integer id);

    //查询所有的Monster
    @Select("SELECT * FROM `monster`")
    public List<Monster> findAllMonster();
}
