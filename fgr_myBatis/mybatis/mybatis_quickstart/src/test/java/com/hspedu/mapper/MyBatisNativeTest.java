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
 * 演示MyBatis原生API操作
 */
public class MyBatisNativeTest {
    private SqlSession sqlSession;

    @Before
    public void init(){
        //获取到sqlSession
        sqlSession = MyBatisUtils.getSqlSession();

        System.out.println("sqlSession--" + sqlSession);
    }

    //MyBatis原生API操作
    @Test
    public void myBatisNativeCrud(){
        //添加
//        Monster monster = new Monster();
//        monster.setAge(100);
//        monster.setBirthday(new Date());
//        monster.setEmail("kate@qq.com");
//        monster.setGender(1);
//        monster.setName("大象--100");
//        monster.setSalary(1000);
//
//        int insert = sqlSession.insert("com.hspedu.mapper.MonsterMapper.addMonster", monster);
//        System.out.println("insert= " + insert);

        //删除
//        int delete = sqlSession.delete("com.hspedu.mapper.MonsterMapper.deleteMonster", 20);
//        System.out.println("delete=" + delete);

        //修改
//        Monster monster = new Monster();
//        monster.setAge(20);
//        monster.setBirthday(new Date());
//        monster.setEmail("k3@qq.com");
//        monster.setGender(1);
//        monster.setName("牛魔王--100");
//        monster.setSalary(1000);
//        monster.setId(19);
//        int update = sqlSession.update("com.hspedu.mapper.MonsterMapper.updateMonster", monster);
//        System.out.println("update=" + update);

        //查询
        List<Monster> monsters
                = sqlSession.selectList("com.hspedu.mapper.MonsterMapper.findAllMonster");
        for (Monster monster : monsters) {
            System.out.println("monster= " + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.commit();
        }
        System.out.println("操作成功、、");
    }
}
