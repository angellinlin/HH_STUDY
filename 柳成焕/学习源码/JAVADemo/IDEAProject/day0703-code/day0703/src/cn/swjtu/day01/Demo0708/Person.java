package cn.swjtu.day01.Demo0708;

/*
定义Person年龄时，无法阻止不合理的数值被设置进来。
解决方案：用private将需要保护的成员变量进行修饰。

一旦使用private进行修饰，本类中依然可以随意使用.
但是！超出了本类范围就不能直接访问了。

间接访问private成员变量，就定义一对get/set方法。
 */
public class Person {
    String name;  //姓名
    private int age;      //年龄

    //用于向成员变量age设置数据
    public void setAge(int num) {
        if (num >= 0 && num <= 100) {
            age = num;
        } else {
            System.out.println("数据不合理");
        }

    }

    //用于获取age数据
    public int getAge() {
        return age;
    }

    public void show() {
        System.out.println("姓名:" + name + ",年龄:" + age);
    }
}
