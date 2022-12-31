package com.hspedu.fgrmybatis2.sqlsession2;

import java.lang.reflect.Proxy;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrSqlSession {
    //配置
    private FgrConfiguration fgrConfiguration = new FgrConfiguration();
    //执行
    private Executor executor = new FgrExecutor();

    public <T> T selectOne(String statement,Object parameter){
        return executor.query(statement,parameter);
    }

    public <T> T getMapper(Class<T> clazz){
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new FgrMapperProxy(fgrConfiguration,clazz,this));
    }
}
