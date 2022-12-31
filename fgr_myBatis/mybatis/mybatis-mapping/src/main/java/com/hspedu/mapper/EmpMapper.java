package com.hspedu.mapper;

import com.hspedu.entity.Emp;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface EmpMapper {

    //通过dept_id查询对应emps
    public List<Emp> getEmpsByDeptId(Integer dept_id);

    //通过id查询员工
    public Emp getEmpById(Integer id);
}
