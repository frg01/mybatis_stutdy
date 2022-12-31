package com.hspedu.fgrmybatis2.sqlsession2;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrSessionFactory {
    public static com.hspedu.fgrmybatis2.sqlsession2.FgrSqlSession openSession(){
        return new FgrSqlSession();
    }
}
