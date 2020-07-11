package cn.swjtu.day01.Demo0708_03;

public class Demo01Student {
    public static void main(String[] args) {
        Student stu1=new Student();
        stu1.setName("alin");
        stu1.setAge(20);
        System.out.println("姓名："+stu1.getName()+"，年龄："+stu1.getAge());
        System.out.println("=====================");

        Student stu2=new Student("阿朵",20);
        System.out.println("姓名："+stu2.getName()+"，年龄："+stu2.getAge());
        stu2.setAge(21);
        System.out.println("姓名："+stu2.getName()+"，年龄："+stu2.getAge());
    }
}
