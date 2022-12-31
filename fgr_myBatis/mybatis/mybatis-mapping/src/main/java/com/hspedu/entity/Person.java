package com.hspedu.entity;

/**
 * @author: guorui fu
 * @versiion: 1.0
 */
public class Person {

    private Integer id;
    private String name;
    //一个人对应一个身份证 直接定义一个IdenCard对象属性
    private IdenCard card;

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

    public IdenCard getCard() {
        return card;
    }

    public void setCard(IdenCard card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", card=" + card +
                '}';
    }
}
