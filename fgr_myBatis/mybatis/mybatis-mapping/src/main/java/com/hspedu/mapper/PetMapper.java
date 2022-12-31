package com.hspedu.mapper;

import com.hspedu.entity.Pet;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface PetMapper {

    //    通过userId返回宠物
    public List<Pet> getPetByUserId(Integer userId);

    //    通过宠物id查找宠物
    public Pet getPetById(Integer id);
}
