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
public class PetMapperTest {
    private SqlSession sqlSession;
    private PetMapper petMapper;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        petMapper= sqlSession.getMapper(PetMapper.class);
        System.out.println("petMapper= " + petMapper);
    }


    @Test
    public void getUserById(){
        List<Pet> pets = petMapper.getPetByUserId(2);
        for (Pet pet : pets) {
            System.out.println("pet= " + pet.getId() + pet.getNickname());
            User user = pet.getUser();
            System.out.println("user= " +user.getName());
        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void getPetById(){
        Pet pet = petMapper.getPetById(2);

        System.out.println("pet= " + pet  + "  user= " + pet.getUser().getName());


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
