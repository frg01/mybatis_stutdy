package com.hspedu.mapper;

import com.hspedu.entity.Person;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface PersonMapper {

    //通过Person的id获取到Person 包括级联的IdenCard
    public Person getPersonById(Integer id);

    //方式二 通过Person的id获取到Person 包括级联的IdenCard
    public Person getPersonById2(Integer id);
}
