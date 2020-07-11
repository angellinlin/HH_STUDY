package cn.swjtu.day01.Demo0708_02;
/*
构造方法：专门用于创建对象的方法，当我们通过new创建对象时，其实就是在调用构造方法。
格式：
public 类名称(参数类型 参数名称，......){
   方法体
}

注意事项：
1.构造方法的名称必须和所在类名称完全一样，就连大小写都要一样；
2.构造方法不要写返回值类型，廉void都不要写;
3.构造方法不能return一个具体的返回值；
4.如果没有编写任何构造方法，那么编译器将会默认赠送一个构造方法，没有参数，方法体什么事情都不做;
5.一旦编写了至少一个构造方法，编译器将不再赠送;
6.构造方法也可以进行重载（方法名称相同，参数类型不同）
public Student() {}


如果需要改变对象中成员变量中数据内容，仍然还需要使用set方法.
 */
public class Student {
    //成员变量
    private String name;
    private int age;

    //无参构造函数
    public Student(){
        System.out.println("我是无参构造函数！");
       //  return 0; 构造方法不能return一个具体的返回值；
    }

    //全参构造函数
    public Student(String name,int age){
        System.out.println("我是全参构造函数！");
        this.name=name;
        this.age=age;
    }
    //set/get方法
    public void setName(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
    public void setAge(int name){
        this.age=age;
    }

    public int getAge(){
        return age;
    }


}
