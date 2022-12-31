package com.hspedu.entity;

import java.util.List;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class User {

    private Integer id;
    private String name;
    //一个user可以养多个宠物
    private List<Pet> pets;

    public User() {
    }

    public User(Integer id, String name, List<Pet> pets) {
        this.id = id;
        this.name = name;
        this.pets = pets;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }

    //user和pet相互使用toString会导致栈溢出
//    @Override
//    public String toString() {
//        return "User{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", pets=" + pets +
//                '}';
//    }
}
