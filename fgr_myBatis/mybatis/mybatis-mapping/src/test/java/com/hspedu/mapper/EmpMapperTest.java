package com.hspedu.mapper;

import com.hspedu.entity.Emp;
import com.hspedu.entity.Pet;
import com.hspedu.entity.User;
import com.hspedu.util.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class EmpMapperTest {
    private SqlSession sqlSession;
    private EmpMapper empMapper;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        empMapper= sqlSession.getMapper(EmpMapper.class);
        System.out.println("empMapper= " + empMapper);
    }


    @Test
    public void getEmpsByDeptId(){
        List<Emp> emps = empMapper.getEmpsByDeptId(1);
        for (Emp emp : emps) {
            System.out.println("emp= " + emp);
            System.out.println("Dept= " + emp.getDept().getName());
        }

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }

    @Test
    public void getEmpById(){
        Emp emp = empMapper.getEmpById(2);
        System.out.println("emp= " + emp + " dept= "  + emp.getDept().getName());

        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
