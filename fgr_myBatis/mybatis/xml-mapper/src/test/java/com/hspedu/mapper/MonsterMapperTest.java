package com.hspedu.mapper;

import com.hspedu.entity.Monster;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public void t1(){
        Monster monster = new Monster();
        monster.setId(1);
        monster.setName("松鼠++-");
        List<Monster> monsters
                = monsterMapper.findMonsterByNameOrId(monster);
        for (Monster m : monsters) {
            System.out.println("m-" + m);

        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("t1..");
    }

    @Test
    public void findMonsterByName(){
        List<Monster> monster = monsterMapper.findMonsterByName("牛魔王");

        for (Monster m : monster) {
            System.out.println("m = " + m);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdAndSalary_ParameterHashMap(){
//        pom.xml文件中指定编译器版本
        Map<String, Object> map = new HashMap<>();
        map.put("id",6);
        map.put("salary",90);
        List<Monster> monsters = monsterMapper.findMonsterByIdAndSalary_ParameterHashMap(map);

        for (Monster monster : monsters) {
            System.out.println("monster= " + monster);
        };

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void findMonsterByIdAndSalary_ReturnHashMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("id",6);
        map.put("salary",90);
        List<Map<String, Object>> list = monsterMapper.findMonsterByIdAndSalary_ReturnHashMap(map);
        for (Map<String, Object> monsterMap : list) {
//            System.out.println("monsterMap=" + monsterMap);/
//            Set<String> keys = monsterMap.keySet();
//            for (String key : keys) {
//                System.out.print(key + "=>" + monsterMap.get(key));
//            }
            for (Map.Entry<String,Object> entry :monsterMap.entrySet()){
                System.out.println(entry.getKey() + "=" + entry.getValue());
            }
            System.out.println("=================");
        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }

    }
}
