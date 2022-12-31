package com.hspedu.mapper;

import com.hspedu.entity.IdenCard;
import org.apache.ibatis.annotations.Select;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 使用注解方式 实现1对1映射
 */
public interface IdenCardMapperAnnotation {

    //根据id获取到身份证序列号
    @Select("SELECT * FROM `idencard` WHERE `id` = #{id}")
    public IdenCard getIdenCardById(Integer id);
}
