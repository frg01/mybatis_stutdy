package com.hspedu.mapper;

import com.hspedu.entity.Pet;
import com.hspedu.entity.User;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface UserMapper {

    //通过id获取User对象
    public User getUserById(Integer id);
}
