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
public class UserMapperAnnotationTest {
    private SqlSession sqlSession;
    private UserMapperAnnotation userMapperAnnotation;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        userMapperAnnotation= sqlSession.getMapper(UserMapperAnnotation.class);
        System.out.println("userMapperAnnotation= " + userMapperAnnotation);
    }


    @Test
    public void getUserById(){
        User user = userMapperAnnotation.getUserById(1);

        System.out.println("user= " + user.getName() + " " + user.getId());
        List<Pet> pets = user.getPets();
        for (Pet pet : pets) {
            System.out.println("pet" + pet);
        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
