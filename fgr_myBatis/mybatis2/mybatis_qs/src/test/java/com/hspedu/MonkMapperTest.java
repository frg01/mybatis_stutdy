package com.hspedu;

import com.hspedu.entity.Monk;
import com.hspedu.mapper.MonkMapper;
import com.hspedu.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class MonkMapperTest {

    private SqlSession sqlSession;
    private MonkMapper monkMapper;


    @Before
    public void init(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        monkMapper = sqlSession.getMapper(MonkMapper.class);
        System.out.println(monkMapper.getClass());
    }


    @Test
    public void addMonk() throws ParseException {
        for (int i = 0; i < 1; i++) {
            Monk monk = new Monk();
            monk.setNickname("小法--" + i);
            monk.setSkill("扫地" + i);
            monk.setBirthday(new Date());
            //将DATE类型进行处理转换为TimeStamp
//            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            String dateStr = sdf.format(new Date());
//            Timestamp ts = (Timestamp)sdf.parse(dateStr);
//            Timestamp ts = new Timestamp(new Date().getTime());
            monk.setEntry(new Date());
            monk.setGrade(1);
            monk.setSalary(1002 + i * 3);
            monkMapper.addMonk(monk);
            System.out.println("monk=" + monk);
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
        System.out.println("保存成功");
    }
}
