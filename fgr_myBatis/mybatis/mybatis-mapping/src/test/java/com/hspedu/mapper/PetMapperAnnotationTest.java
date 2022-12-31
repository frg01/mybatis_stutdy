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
public class PetMapperAnnotationTest {

    private SqlSession sqlSession;
    private PetMapperAnnotation petMapperAnnotation;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        petMapperAnnotation= sqlSession.getMapper(PetMapperAnnotation.class);
        System.out.println("petMapperAnnotation= " + petMapperAnnotation);
    }


    @Test
    public void getPetByUserId(){
        List<Pet> pets = petMapperAnnotation.getPetByUserId(1);
        for (Pet pet : pets) {
            System.out.println("pet= " + pet.getNickname() + "user +" + pet.getUser().getName());

        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }


    @Test
    public void getPetById(){
        Pet pet = petMapperAnnotation.getPetById(1);

        System.out.println("pet= " + pet.getId() + " " + pet.getNickname());
        System.out.println("user= " + pet.getUser().getName());

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
