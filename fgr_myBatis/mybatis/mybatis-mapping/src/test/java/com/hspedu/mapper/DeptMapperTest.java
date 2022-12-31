package com.hspedu.mapper;

import com.hspedu.entity.Dept;
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
public class DeptMapperTest {
    private SqlSession sqlSession;
    private DeptMapper deptMapper;

    @Before
    public void init(){
        sqlSession = MyBatisUtils.getSqlSession();
        deptMapper= sqlSession.getMapper(DeptMapper.class);
        System.out.println("deptMapper= " + deptMapper);
    }


    @Test
    public void getDeptByDeptId(){
        Dept dept = deptMapper.getDeptByDeptId(1);
        System.out.println("dept=" + dept.getId() + " " + dept.getName() );
        List<Emp> emps = dept.getEmps();
        for (Emp emp : emps) {
            System.out.println("emp= " +emp.getName());
        }


        if (sqlSession != null){
            sqlSession.commit();
            sqlSession.close();
        }
    }
}
