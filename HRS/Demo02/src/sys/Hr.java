package sys;

import bean.Student;
import fileoperate.DateOperate;
import service.StudentService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/4 17:16
 * @modified By：
 */
public class Hr {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Student> studentList = new ArrayList<>();
        DateOperate op = new DateOperate();
        StudentService service = new StudentService();
        //加载txt中的数据到内存中
        op.loadData(studentList);
        while (true){
            System.out.println("****浦发银行校园招聘系统****");
            System.out.println("添加招聘学生信息请按----1");
            System.out.println("删除招聘学生信息请按----2");
            System.out.println("修改招聘学生信息请按----3");
            System.out.println("查询招聘学生信息请按----4");
            System.out.println("退出请按--------------5");
            System.out.println("****浦发银行校园招聘系统****");
            int choice = sc.nextInt();
            int f = 1;
            switch (choice){
                case 1:
                    service.addStudent(studentList);
                    break;
                case 2:
                    service.delStudent(studentList);
                    break;
                case 3:
                    service.modifyStudent(studentList);
                    break;
                case 4:
                    service.showStudent(studentList);
                    break;
                case 5:
                    op.savaData(studentList);
                    f = 0;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
            }
            if (f == 0){
                break;
            }
        }
        sc.close();
        service.close();
    }
}
