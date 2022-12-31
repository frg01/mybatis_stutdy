package com.hspedu.fgrmybatis.config;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * 记录对应的Mapper方法的信息 -
 */
public class Function {
    //属性
    private String sqlType;//如：insert update
    private String funcName;//方法名
    private String sql;//sql语句
    private Object resultType; //返回类型
    private String parameterType; //参数类型

    public Function() {
    }

    public Function(String sqlType, String funcName, String sql, Object resultType, String parameterType) {
        this.sqlType = sqlType;
        this.funcName = funcName;
        this.sql = sql;
        this.resultType = resultType;
        this.parameterType = parameterType;
    }

    public String getSqlType() {
        return sqlType;
    }

    public void setSqlType(String sqlType) {
        this.sqlType = sqlType;
    }

    public String getFuncName() {
        return funcName;
    }

    public void setFuncName(String funcName) {
        this.funcName = funcName;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object getResultType() {
        return resultType;
    }

    public void setResultType(Object resultType) {
        this.resultType = resultType;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public String toString() {
        return "Function{" +
                "sqlType='" + sqlType + '\'' +
                ", funcName='" + funcName + '\'' +
                ", sql='" + sql + '\'' +
                ", resultType=" + resultType +
                ", parameterType='" + parameterType + '\'' +
                '}';
    }
}
