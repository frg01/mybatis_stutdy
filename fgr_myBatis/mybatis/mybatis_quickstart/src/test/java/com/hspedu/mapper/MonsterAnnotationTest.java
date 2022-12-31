package com.hspedu.mapper;

import com.hspedu.entity.Monster;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class MonsterAnnotationTest {

    private SqlSession sqlSession;
    private MonsterAnnotation monsterAnnotation;

    //编写方法 完成初始化  @Before表示执行目标测试方法前会执行该方法
    @Before
    public void init(){
        //获取sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        //获取monsterAnnotation代理对象 底层使用动态代理机制
        monsterAnnotation = sqlSession.getMapper(MonsterAnnotation.class);
        System.out.println("monsterMapper =" + monsterAnnotation.getClass());
    }

    @Test
    public void addMonster(){
        Monster monster = new Monster();
        monster.setAge(21);
        monster.setBirthday(new Date());
        monster.setEmail("ate@qq.com");
        monster.setGender(1);
        monster.setName("大象--");
        monster.setSalary(1003);
        monsterAnnotation.addMonster(monster);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findAllMonster(){
        List<Monster> allMonster = monsterAnnotation.findAllMonster();
        for (Monster monster : allMonster) {
            System.out.println("mosnter= " + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
