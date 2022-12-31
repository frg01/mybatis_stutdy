package com.hspedu.fgrmybatis.sqlsession;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * FgrSqlSession 搭建Configuration（连接）和Execution之间的桥梁
 * 操作DB的具体方法
 */
public class FgrSqlSession {

    //配置
    private FgrConfiguration fgrConfiguration = new FgrConfiguration();
    //执行器
    private Executor executor = new FgrExecutor();

    //编写方法 SelectOne 返回记录 原生mybatis中statement不是sql，是要执行的方法
    public <T> T selectOne(String statement,Object parameter){
        return executor.query(statement,parameter);
    }

    //返回Mapper的 动态代理对象
    //返回是MonsterMapper接口代理对象
    //执行接口方法时（通过代理对象调用），根据东爱代理机制，执行到FgrMapperProxy invoke方法
    public <T> T getMapper(Class<T> clazz){
        //返回动态代理对象
//        ClassLoader loader,
//        Class<?>[] interfaces,
//        InvocationHandler h
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),new Class[]{clazz},new FgrMapperProxy(fgrConfiguration,this,clazz));
    }
}
