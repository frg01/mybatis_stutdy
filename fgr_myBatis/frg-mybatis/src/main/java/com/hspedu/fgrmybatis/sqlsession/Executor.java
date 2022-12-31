package com.hspedu.fgrmybatis.sqlsession;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface Executor {
    //泛型方法
    public <T> T query(String statement,Object parameter);
}
