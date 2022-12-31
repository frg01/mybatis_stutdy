package com.hspedu.mapper;

import com.hspedu.entity.Monster;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class MonsterMapperTest {
    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        System.out.println("monsterMapper =" + monsterMapper.getClass());
    }

    @Test
    public void findMonsterByAge() {
        List<Monster> monsters = monsterMapper.findMonsterByAge(-1);
        for (Monster monster : monsters) {
            System.out.println("monster= " + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdAndName(){
        Monster monster = new Monster();
        monster.setId(-1);
//        monster.setName("大象--");
        List<Monster> monsters = monsterMapper.findMonsterByIdAndName(monster);

        for (Monster m : monsters) {
            System.out.println("monster =" + m);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

    }


    @Test
    public void findMonsterByIdAndName_choose(){
        Map map = new HashMap();
//        map.put("name","大象--");
        map.put("id",-1);

        List monsters = monsterMapper.findMonsterByIdAndName_choose(map);
        for (Object monster : monsters) {
            System.out.println("monster=" + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterById_forEach(){
        Map<String, Object> map = new HashMap<>();
        map.put("ids", Arrays.asList(10,12,14));

        List<Monster> monsters = monsterMapper.findMonsterById_forEach(map);
        for (Monster monster : monsters) {
            System.out.println("monster= " + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByName_Trim(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","牛魔王100");
        map.put("age",10);

        List<Monster> monsters = monsterMapper.findMonsterByName_Trim(map);
        for (Monster monster : monsters) {
            System.out.println("monster= "  + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

    }

    @Test
    public void updateMonster_set(){
        Map<String, Object> map = new HashMap<>();
        map.put("name","牛魔王100");
        map.put("age",10);
        map.put("email","1233ss@qq.com");
        map.put("id",5);

        monsterMapper.updateMonster_set(map);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

    }
}
