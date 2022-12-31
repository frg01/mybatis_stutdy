package com.hspedu.mapper;

import com.hspedu.entity.Person;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.junit.Test;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface PersonMapperAnnotation {

    //通过Person的id获取到Person 包括级联的IdenCard
    @Select("SELECT id AS fgr_id,name,card_id FROM `person` WHERE `id` = #{id}")
    @Results({
            @Result(id = true,property = "id",column = "fgr_id"),
            @Result(property = "name",column = "name"),
            @Result(property = "card",column = "card_id",one = @One(select = "com.hspedu.mapper.IdenCardMapper.getIdenCardById"))
    })
    public Person getPersonById(Integer id);
}
