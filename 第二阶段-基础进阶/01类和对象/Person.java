package cn.com.spdb.testidea06;

public class Person {
    String name;
    int old;
    //类中的方法
    public void pr() {
        System.out.println("名字是"+name);
    }
    public void Friend(Person h) {
        System.out.println(name+"的朋友是"+h.name);
    }
    public void Friend(Person h1,Person h2) {
        System.out.println(name+"的朋友是"+h1.name+h2.name);
    }
    public Person(){
        System.out.println("无参构造函数");//没创造一个新对象调用一遍构造函数
    }
    public Person(String name){
        this.name = name;
    }
}
