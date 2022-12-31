package com.hspedu.fgrmybatis.sqlsession;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * FgrSessionFactory 会话工厂 返回SqlSession
 */
public class FgrSessionFactory {

    public static FgrSqlSession openSession(){
        return new FgrSqlSession();
    }
}
