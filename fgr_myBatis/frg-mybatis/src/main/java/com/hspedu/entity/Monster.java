package com.hspedu.entity;

import lombok.*;

import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 * Monster 和 monster表有映射关系
 * @Getter 生成对应的getter方法
 * @Setter 给所有属性生成setter方法
 *
 * 如何选择看需求
 */
@Getter
@Setter
@ToString
@NoArgsConstructor//无参构造器
@AllArgsConstructor//全参构造器
//@Data 包含了六种方法
public class Monster {
    private Integer id;
    private Integer age;
    private String name;
    private String email;
    private Date birthday;
    private double salary;
    private Integer gender;
}
