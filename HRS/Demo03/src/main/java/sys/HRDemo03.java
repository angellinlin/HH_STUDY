package sys;

import bean.Student;
import org.junit.Test;
import service.StudentService;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/9 18:25
 * @modified By：
 */
public class HRDemo03 {

    public static void main(String[] args) {
        while (true){
            show();
            int choice = getSc().nextInt();
            int f = 1;
            switch (choice){
                case 1:
                    add();
                    break;
                case 2:
                    del();
                    break;
                case 3:
                    modify();
                    break;
                case 4:
                    search();
                    break;
                case 5:

                    f = 0;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
            if (f == 0){
                getSc().close();
                break;
            }
        }
    }


    //给逻辑方法提供一个Scanner对象，然后该对象在被close之前，在全局生效
    private static Scanner getSc(){
        return new Scanner(System.in);
    }
    //给逻辑方法提供一个StudentService对象
    private static StudentService getService(){
        return new StudentService();
    }
    //菜单
    private static void show(){
        System.out.println("****浦发银行校园招聘系统****");
        System.out.println("添加招聘学生信息请按----1");
        System.out.println("删除招聘学生信息请按----2");
        System.out.println("修改招聘学生信息请按----3");
        System.out.println("查询招聘学生信息请按----4");
        System.out.println("退出请按--------------5");
        System.out.println("****浦发银行校园招聘系统****");
        System.out.print("请输入你的选择：");
    }

    //增
    private static void add() {
        System.out.print("请输入姓名：");
        String name = getSc().next();
        System.out.print("请输入身份证：");
        String id = getSc().next();
        System.out.print("请输入应聘职位：");
        String position = getSc().next();
        Student student = new Student(name,id,position);
        getService().add(student);
    }


//    打印发现同一个方法内部使用的getSc对象是同一个，所以只需要关闭一次就行了
//    @Test
//    public void te(){
//        System.out.println(getSc() + "1");
//        System.out.println(getSc() + "2");
//        getSc().close();
//    }

    //删
    private static void del() {
        System.out.print("请输入要删除的学生身份证：");
        String id = getSc().next();
        getService().delete(id);
    }

    //改
    private static void modify() {
        System.out.print("请输入要修改的学生身份证：");
        String id = getSc().next();
        System.out.print("请输入需要修改的姓名：");
        String name = getSc().next();
        System.out.print("请输入需要修改的应聘职位：");
        String position = getSc().next();
        Student student = new Student(name,id,position);
        getService().modify(student);
    }


    //查
    private static void search() {
        ArrayList<Student> students = new ArrayList<>();
        students = getService().search();
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println("查询完成");
    }

}
