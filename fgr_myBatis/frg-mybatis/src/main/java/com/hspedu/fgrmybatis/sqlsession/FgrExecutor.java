package com.hspedu.fgrmybatis.sqlsession;

import com.hspedu.entity.Monster;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class FgrExecutor implements Executor{

    //属性
    private FgrConfiguration fgrConfiguration = new FgrConfiguration();

    /**
     * sql查询结果
     * @param sql
     * @param parameter
     * @param <T>
     * @return
     */
    @Override
    public <T> T query(String sql, Object parameter) {
        //得到连接
        Connection connection = getConnection();
        //查询返回的结果集
        ResultSet set = null;
        PreparedStatement pre = null;

        try {
            pre = connection.prepareStatement(sql);
            //设置参数  参数多可以使用数组封装
            pre.setString(1,parameter.toString());
            set = pre.executeQuery();
            //把set结果集封装到monster 简化处理
            Monster monster = new Monster();
            //遍历结果集 封装到monster
            while(set.next()){
                monster.setId(set.getInt("id"));
                monster.setName(set.getString("name"));
                monster.setEmail(set.getString("email"));
                monster.setAge(set.getInt("age"));
                monster.setGender(set.getInt("gender"));
                monster.setBirthday(set.getDate("birthday"));
                monster.setSalary(set.getDouble("salary"));
            }

            return (T) monster;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                if (set != null){
                    set.close();
                }
                if (pre != null){
                    pre.close();
                }
                if (connection != null){
                    connection.close();
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return null;
    }


    //通过FgrConfiguration对象返回连接
    private Connection getConnection(){
        Connection connection = fgrConfiguration.build("fgr_mybatis.xml");
        return connection;
    }
}
