package cn.swjtu.Student;

import java.io.Serializable;

/*
创建一个学生类，存储：
    编号String id
    姓名String name
    性别String male;
    年龄int age;
 */
public class Student implements Serializable {
    private String id;
    private String name;
    private String male;
    private int age;
    private static final long serializeNumber=100L;

    public Student() {

    }

    public Student(String id, String name, String male, int age) {
        this.id = id;
        this.name = name;
        this.male = male;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String isMale() {
        if(male.equals("男")){
            return "男";
        }else{
            return "女";
        }
    }

    public void setMale(String male) {
        this.male = male;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", male=" + male +
                ", age=" + age +
                '}';
    }
}

