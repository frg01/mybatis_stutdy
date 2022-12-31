package com.hspedu.mapper;

import com.hspedu.entity.Monster;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * MonsterMapper: 声明对db的crud
 */
public interface MonsterMapper {

    //查询方法
    public Monster getMonsterById(Integer id);
}
