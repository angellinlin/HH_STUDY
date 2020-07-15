package cn.swjtu.Object.day071401;

import java.util.ArrayList;

/*

Person类默认继承了Object类，因此可以用Object类的equals方法。
public boolean equals(Object obj);指示其他某个对象是否与此对象“相等”。
equals方法源码：public boolean equals(Object obj) {
                  return (this == obj);
               }
               参数：Object obj可以传递任意对象
               ==比较运算符，返回的是一个boolean值，true/false
               基本数据类型：比较的是值
               引用数据类型：比较的是两个对象的地址值
               this：哪个对象调用的方法，方法中this就是那个对象。
               obj：传递过来的参数

 */
public class Demo02Equals {
    public static void main(String[] args) {
        Person person1=new Person("啊柳",18);
        Person person2=new Person("啊柳",18);
        System.out.println(person1);  //cn.swjtu.Object.day071401.Person@75412c2f
        System.out.println(person2);  // cn.swjtu.Object.day071401.Person@282ba1e
        System.out.println(person1.equals(person2));  //false

        //person1=person2;
        //System.out.println(person1.equals(person2)); //true

        System.out.println("===========");

        //重写后
        System.out.println(person1.equals(person2));

        ArrayList<String>list=new ArrayList<>();
        System.out.println(list.equals(person1));

        System.out.println(person1.equals(null));

        System.out.println(person1.equals(person1));
    }
}
