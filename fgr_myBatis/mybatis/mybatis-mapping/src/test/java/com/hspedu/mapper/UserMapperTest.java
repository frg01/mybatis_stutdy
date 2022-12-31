package com.hspedu.mapper;

import com.hspedu.entity.Pet;
import com.hspedu.entity.User;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class UserMapperTest {
    private SqlSession sqlSession;
    private UserMapper userMapper;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        userMapper= sqlSession.getMapper(UserMapper.class);
        System.out.println("userMapper= " + userMapper);
    }


    @Test
    public void getUserById(){
        User user = userMapper.getUserById(2);
        System.out.println("user= " + user.getName() + user.getId());
        List<Pet> pets = user.getPets();
        for (Pet pet : pets) {
            System.out.println("pet= " + pet.getId() + pet.getNickname());
        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }


}
