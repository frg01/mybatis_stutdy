package com.hspedu.test;

import com.hspedu.entity.Monster;
import com.hspedu.fgrmybatis.config.MapperBean;
import com.hspedu.fgrmybatis.sqlsession.*;
import com.hspedu.mapper.MonsterMapper;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.Test;

import javax.management.Query;
import java.sql.Connection;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrMybatisTest {

    @Test
    public void build(){
//        FgrConfiguration fgrConfiguration = new FgrConfiguration();
//        Connection connection = fgrConfiguration.build("fgr_mybatis.xml");
//        System.out.println("connection=" + connection);
        com.hspedu.fgrmybatis2.sqlsession2.FgrConfiguration fgrConfiguration = new com.hspedu.fgrmybatis2.sqlsession2.FgrConfiguration();
        Connection connection = fgrConfiguration.build("fgr_mybatis.xml");
        System.out.println("connection=" + connection);
    }

    @Test
    public void query(){
//        Executor executor = new FgrExecutor();
//        Monster monster =
//                executor.query("select * from monster where id=?", 1);
//        System.out.println("monster--" + monster);
        com.hspedu.fgrmybatis2.sqlsession2.FgrExecutor fgrExecutor = new com.hspedu.fgrmybatis2.sqlsession2.FgrExecutor();
        Monster monster = fgrExecutor.query("select * from monster where id=?", 1);
        System.out.println("monster--" + monster);
    }

    //完成测试
    @Test
    public void selectOne(){
//        FgrSqlSession fgrSqlSession = new FgrSqlSession();
//        Monster monster = fgrSqlSession.selectOne("select * from monster where id = ?", 1);
//        System.out.println("monster = " + monster);
        com.hspedu.fgrmybatis2.sqlsession2.FgrSqlSession fgrSqlSession = new com.hspedu.fgrmybatis2.sqlsession2.FgrSqlSession();
        Monster monster = fgrSqlSession.selectOne("select * from monster where id=?", 1);
        System.out.println("monster= " + monster);
    }

    @Test
    public void readMapper(){
        FgrConfiguration fgrConfiguration = new FgrConfiguration();
        MapperBean mapperBean =
                fgrConfiguration.readMapper("MonsterMapper.xml");
        System.out.println("mapperBean = " + mapperBean);
    }

    @Test
    public void getMapper(){
//        FgrSqlSession fgrSqlSession = new FgrSqlSession();
//        MonsterMapper mapper = fgrSqlSession.getMapper(MonsterMapper.class);
//        Monster monster = mapper.getMonsterById(1);
//        System.out.println("monster=" + monster);
//        System.out.println("mapper = " +mapper.getClass());

    }


    @Test
    public void openSession(){
//        FgrSqlSession fgrSqlSession = FgrSessionFactory.openSession();
//        MonsterMapper mapper = fgrSqlSession.getMapper(MonsterMapper.class);
//        Monster monster = mapper.getMonsterById(1);
//        System.out.println("monster===" + monster);
        com.hspedu.fgrmybatis2.sqlsession2.FgrSqlSession fgrSqlSession = com.hspedu.fgrmybatis2.sqlsession2.FgrSessionFactory.openSession();
        MonsterMapper mapper = fgrSqlSession.getMapper(MonsterMapper.class);
        Monster monster = mapper.getMonsterById(1);
        System.out.println("monster=" + monster);
    }
}
