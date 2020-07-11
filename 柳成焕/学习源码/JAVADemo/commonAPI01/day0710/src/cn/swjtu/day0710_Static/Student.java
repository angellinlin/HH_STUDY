package cn.swjtu.day0710_Static;

public class Student {
    private int id;  //学号
    private String name; //姓名
    private int age;   //年龄
    static String room;  //教室
    static int idCounter=0;  //计数器，每当创建一个对象，就++，用于给自动生成学号
    public Student() {
        this.id=++idCounter;  //创建新对象，计数器加一，再赋值给学号
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(String name, int age) {
        this.id=++idCounter;

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
