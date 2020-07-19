package cn.com.spdb.testidea07;

public class Person {
    private String name;
    private int num;

    public Person(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void show(){
        System.out.println("我叫"+name+"我有"+num+"钱");
    }
    void method(){
        System.out.println("父类方法");
    }

}
