package com.hspedu.entity;

import java.util.Date;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class Monk {
    private Integer id;
    private String nickname;
    private String skill;
    private Integer grade;
    private double salary;
    private Date birthday;
    private Date entry;

    public Monk() {
    }

    public Monk(Integer id, String nickname, String skill, Integer grade, double salary, Date birthday, Date entry) {
        this.id = id;
        this.nickname = nickname;
        this.skill = skill;
        this.grade = grade;
        this.salary = salary;
        this.birthday = birthday;
        this.entry = entry;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getEntry() {
        return entry;
    }

    public void setEntry(Date entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Monk{" +
                "id=" + id +
                ", nickname='" + nickname + '\'' +
                ", skill='" + skill + '\'' +
                ", grade=" + grade +
                ", salary=" + salary +
                ", birthday=" + birthday +
                ", entry=" + entry +
                '}';
    }
}
