package cn.swjtu.day0710_Static;

public class Demo03Student {
    public static void main(String[] args) {
        Student.room="101教室";

        Student stu1=new Student("万茜",30);
        System.out.println("stu1的姓名："+stu1.getName());
        System.out.println("stu1的年龄："+stu1.getAge());
        System.out.println("stu1的教室："+Student.room);

        Student stu2=new Student("张含韵",31);
        System.out.println("stu2的姓名："+stu2.getName());
        System.out.println("stu2的年龄："+stu2.getAge());
        System.out.println("stu2的教室："+Student.room);
    }
}
