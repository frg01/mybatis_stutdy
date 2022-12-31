package com.hspedu.mapper;

import com.hspedu.entity.Person;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class PersonMapperAnnotationTest {

    private SqlSession sqlSession;
    private PersonMapperAnnotation personMapperAnnotation;

    //编写方法 完成初始化  @Before表示执行目标测试方法前会执行该方法
    @Before
    public void init(){
        //获取sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        //获取MonsterMapper代理对象 底层使用动态代理机制
        personMapperAnnotation = sqlSession.getMapper(PersonMapperAnnotation.class);
        System.out.println("personMapperAnnotation =" + personMapperAnnotation.getClass());
    }

    @Test
    public void getPersonById(){
        Person person = personMapperAnnotation.getPersonById(1);
        System.out.println("person= " + person);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
