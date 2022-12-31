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
public class MonsterMapperTest {

    private SqlSession sqlSession;
    private MonsterMapper monsterMapper;

    //编写方法 完成初始化  @Before表示执行目标测试方法前会执行该方法
    @Before
    public void init(){
        //获取sqlSession
        sqlSession = MyBatisUtils.getSqlSession();
        //获取MonsterMapper代理对象 底层使用动态代理机制
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);
        System.out.println("monsterMapper =" + monsterMapper.getClass());
    }

    @Test
    public void addMonster(){
        for (int i = 0; i < 2; i++) {
            Monster monster = new Monster();
            monster.setAge(10+i);
            monster.setBirthday(new Date());
            monster.setEmail("kate@qq.com");
            monster.setGender(1);
            monster.setName("大象--" + i);
            monster.setSalary(1000 + i * 10);
            monsterMapper.addMonster(monster);
            System.out.println("添加对象-- " + monster);
            System.out.println("添加到表中后 自增长的id=" + monster.getId());
        }



        //如果时增删改 需要提交事务
        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("保存成功。。。");
    }


    @Test
    public void deleteMonster(){
        monsterMapper.deleteMonster(2);
        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("deleteMonster()... 删除成功");
    }


    @Test
    public void updateMonster(){
        Monster monster = new Monster();
        monster.setAge(50);
        monster.setBirthday(new Date());
        monster.setEmail("king@qq.com");
        monster.setGender(0);
        monster.setName("松鼠++-");
        monster.setSalary(1000);
        monster.setId(3);
        monsterMapper.updateMonster(monster);

        if (sqlSession != null) {
            sqlSession.commit();
            sqlSession.close();
        }

        System.out.println("修改完成");
    }

    @Test
    public void getMonsterById(){
        Monster monster = monsterMapper.getMonsterById(4);
        System.out.println("monster=" + monster);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("查询成功~~");
    }

    @Test
    public void findAllMonster(){
        List<Monster> monsters = monsterMapper.findAllMonster();
        for (Monster monster : monsters) {
            System.out.println("monster - " + monster);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("查询成功~~");
    }
}
