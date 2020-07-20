package com.weihongyu.spring;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/20 16:25
 * @Description:
 */
public class Person {
    private String name;
    private Integer id;

    private Person(){
        System.out.println("私有构造");
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
