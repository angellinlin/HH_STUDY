package cn.swjtu.day01.Demo0708_02;

public class Demo02Student {
    public static void main(String[] args) {
        Student stu=new Student("啊柳",18);
        Student stu1=new Student();
        System.out.println("姓名："+stu.getName()+"，年龄："+stu.getAge());
        //如果需要改变对象中成员变量中数据内容，仍然还需要使用set方法
        stu.setAge(19);
    }
}
