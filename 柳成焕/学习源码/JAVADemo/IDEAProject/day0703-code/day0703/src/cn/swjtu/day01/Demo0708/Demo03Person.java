package cn.swjtu.day01.Demo0708;

public class Demo03Person {
    public static void main(String[] args) {
        Person person=new Person();
        person.show();

        System.out.println("================");

        person.name="万茜";
       // person.age=-20;  //直接访问private变量，报错！
        person.setAge(20);

        person.show();
    }
}
