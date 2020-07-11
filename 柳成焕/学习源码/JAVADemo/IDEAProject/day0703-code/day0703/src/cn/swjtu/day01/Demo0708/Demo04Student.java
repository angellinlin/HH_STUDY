package cn.swjtu.day01.Demo0708;

public class Demo04Student {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.setName("郭彦宏");
        stu.setAge(25);
        stu.setMale(true);

        System.out.println("姓名"+stu.getName());
        System.out.println("年龄"+stu.getAge());
        System.out.println("性别"+stu.isMale());


    }
}
