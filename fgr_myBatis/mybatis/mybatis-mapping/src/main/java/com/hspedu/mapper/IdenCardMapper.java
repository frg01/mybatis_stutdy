package com.hspedu.mapper;

import com.hspedu.entity.IdenCard;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface IdenCardMapper {

    //根据id获取到身份证序列号
    public IdenCard getIdenCardById(Integer id);
}
