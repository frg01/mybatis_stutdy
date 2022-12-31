package com.hspedu.mapper;

import com.hspedu.entity.Dept;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public interface DeptMapper {

    //通过id查询dept
    public Dept getDeptByDeptId(Integer id);
}
