package com.hspedu.mapper;

import com.hspedu.entity.Pet;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface PetMapperAnnotation {

    //    通过userId返回宠物
    @Select("SELECT * FROM `mybatis_pet` WHERE `user_id` = #{userId}")
    @Results(id = "PetResultMap", value = {
            @Result(id = true, property = "id",column = "id"),
            @Result(property = "nickname",column = "nickname"),
            @Result(property = "user",column = "user_id", one = @One(select = "com.hspedu.mapper.UserMapperAnnotation.getUserById"))
    })
    public List<Pet> getPetByUserId(Integer userId);

    //通过宠物id查找宠物
    @Select("SELECT * FROM `mybatis_pet` WHERE `id` = #{id}")
    @ResultMap(value = "PetResultMap")
    public Pet getPetById(Integer id);
}
