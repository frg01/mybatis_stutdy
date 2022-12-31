package com.hspedu;

import com.hspedu.entity.Monster;
import com.hspedu.mapper.MonsterMapper;
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
    public void level1CacheTest(){
        Monster monster = monsterMapper.getMonsterById(4);
        System.out.println("id=4monster1= " + monster);

        System.out.println("====一级缓存默认打开 重复查询不会在打出sql语句");
        Monster monster2 = monsterMapper.getMonsterById(4);
        System.out.println("id=4monster2= " + monster2);

        Monster monster3 = monsterMapper.getMonsterById(4);
        System.out.println("id=4monster3= " + monster3);

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

//    测试二级缓存
    @Test
    public void level2CacheTest(){
        Monster monster = monsterMapper.getMonsterById(4);
        System.out.println("monster=" + monster);

        //关闭sqlSession
        if (sqlSession != null){
            sqlSession.close();
        }

        //重新获取
        sqlSession = MyBatisUtils.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);

        System.out.println("虽然关闭了sqlSession 但配置了二级缓存 查询相同id时 不会发出sql 从二级缓存获取数据");
        Monster monster2 = this.monsterMapper.getMonsterById(4);
        System.out.println("monster2" + monster2);
    }

    @Test
    public void ehCacheTest(){
        Monster monster = monsterMapper.getMonsterById(4);
        System.out.println("monster=" + monster);

        //关闭sqlSession
        if (sqlSession != null){
            sqlSession.close();
        }

        //重新获取
        sqlSession = MyBatisUtils.getSqlSession();
        monsterMapper = sqlSession.getMapper(MonsterMapper.class);

        System.out.println("虽然关闭了sqlSession 但配置了二级缓存 查询相同id时 不会发出sql 从二级缓存获取数据");
        Monster monster2 = this.monsterMapper.getMonsterById(4);
        System.out.println("monster2" + monster2);

        if (sqlSession != null){
            sqlSession.close();
        }
    }
}
