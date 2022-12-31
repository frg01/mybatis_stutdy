package com.hspedu.fgrmybatis2.sqlsession2;

import com.hspedu.fgrmybatis2.config.Function;
import com.hspedu.fgrmybatis2.config.MapperBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrMapperProxy implements InvocationHandler {

    private FgrConfiguration fgrConfiguration;
    private String mapperFile;
    private FgrSqlSession fgrSqlSession;

    public FgrMapperProxy(FgrConfiguration fgrConfiguration, Class clazz, FgrSqlSession fgrSqlSession) {
        this.fgrConfiguration = fgrConfiguration;
        this.mapperFile = clazz.getSimpleName() + ".xml";
        this.fgrSqlSession = fgrSqlSession;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MapperBean mapperBean = fgrConfiguration.readMapper(this.mapperFile);
        if (!method.getDeclaringClass().getName().equals(mapperBean.getInterfaceName())){
            return null;
        }
        List<Function> functions = mapperBean.getFunctions();
        if (functions != null && functions.size() != 0){
            for (Function function : functions) {
                if ("select".equals(function.getSqlType())){
                    if (function.getFuncName().equals(method.getName())){
                        return fgrSqlSession.selectOne(function.getSql(),String.valueOf(args[0]));
                    }
                }

            }
        }
        return null;
    }
}
