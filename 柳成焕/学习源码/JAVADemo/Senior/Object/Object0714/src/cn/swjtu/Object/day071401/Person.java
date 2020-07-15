package cn.swjtu.Object.day071401;

import java.util.Objects;

/*
  Object类中的equals方法默认比较两个对象的地址值，没有意义，需要重写。
   比较两个对象的属性。(name,age)
   问题：隐含着一个多态
           多态的弊端：无法使用子类的特有方法
           解决：向下转型Object --> Person

  */
public class Person /*extends Object*/ {
    public String name;
    public int age;


    /*@Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }*/

   /* @Override
    public boolean equals(Object obj) {
        //增加一个判断，传递的额参数如果是this本身，直接返回true提高效率
        if(obj==this){
            return true;
        }

        //增加一个判断，传递的参数是Null直接返回false，提高程序效率
        if(obj==null){
            return false;
        }

        //向下转型
        //增加一个判断
        if (obj instanceof Person) {
            Person person = (Person) obj;
            //一个对象是this（person1），另一个对象是obj(person2)
            boolean b = (this.age == person.age) && (this.name == person.name);
            return b;
        }
        return false;  //不是Person直接返回false

    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //getClass() != o.getClass() 使用反射技术，判断obj是否是Person类型 等效于 obj instanceof Person
        if (o == null || getClass() != o.getClass())
            return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
