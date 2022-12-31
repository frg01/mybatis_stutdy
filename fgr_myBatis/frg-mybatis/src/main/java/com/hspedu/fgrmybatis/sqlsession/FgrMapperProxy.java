package com.hspedu.fgrmybatis.sqlsession;

import com.hspedu.fgrmybatis.config.Function;
import com.hspedu.fgrmybatis.config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 动态代理生成Mapper对象  调用FgrExecutor
 */
public class FgrMapperProxy implements InvocationHandler {
    //属性
    private FgrSqlSession fgrSqlSession;
    private String mapperFile;
    private FgrConfiguration fgrConfiguration;

    public FgrMapperProxy(FgrConfiguration fgrConfiguration,
                          FgrSqlSession fgrSqlSession,
                          Class clazz ) {
        this.fgrSqlSession = fgrSqlSession;
        this.mapperFile = clazz.getSimpleName() + ".xml";
        this.fgrConfiguration = fgrConfiguration;
    }

    //动态代理  spring中讲过
    //当执行Mapper接口的代理对象方法时，会执行invoke方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean = fgrConfiguration.readMapper(this.mapperFile);
        //判断是否是xml文件对应的接口
        if (!method.getDeclaringClass().getName().equals(mapperBean.getInterfaceName())){
            return null;
        }

        //取出MapperBean的function
        List<Function> functions = mapperBean.getFunctions();
        //判断mapperBean解析Mapper.xml后 有方法
        if (null != functions && functions.size() != 0){
            for (Function function : functions) {
                //执行方法与function.getFuncName() 则可以取出相应的信息 进行执行方法
                if (method.getName().equals(function.getFuncName())){
                    //如果执行的和function的sqlType一致是Select
                    //原生的FgrSqlSession 应该对应不同方法，根据不同的情况调用不同方法，还要参数解析，比较字符串处理，拼接字符串，处理返回类型
                    if ("select".equalsIgnoreCase(function.getSqlType())){
                        return fgrSqlSession.selectOne(function.getSql(),String.valueOf(args[0]));
                    }
                }
            }
        }

        return null;
    }
}
