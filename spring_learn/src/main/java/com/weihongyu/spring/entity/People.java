package com.weihongyu.spring.entity;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 17:16
 * @Description:实体类-人
 */
public class People {

    private String name;
    private String id;

    public People() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "People{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
