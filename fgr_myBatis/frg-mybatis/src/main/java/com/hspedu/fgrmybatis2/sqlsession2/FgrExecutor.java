package com.hspedu.fgrmybatis2.sqlsession2;

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
    private FgrConfiguration fgrConfiguration = new FgrConfiguration();

    @Override
    public <T> T query(String sql, Object parameter) {
        //通过FgrConfiguration获取connection
        Connection connection = fgrConfiguration.build("fgr_mybatis.xml");

        ResultSet set = null;
        PreparedStatement pre = null ;

        try {
            pre = connection.prepareStatement(sql);
            pre.setString(1,parameter.toString());
            set = pre.executeQuery();

            Monster monster = new Monster();
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
}
