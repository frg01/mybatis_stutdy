package com.hspedu.mapper;

import com.hspedu.entity.User;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface UserMapperAnnotation {

    //注解配置通过id获取User对象
    @Select("SELECT * FROM `mybatis_user` WHERE `id` = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "name" ,column = "name"),
            //pets属性对应集合
            @Result(property = "pets" ,column = "id", many = @Many(select = "com.hspedu.mapper.PetMapperAnnotation.getPetByUserId"))
    })
    public User getUserById(Integer id);
}
