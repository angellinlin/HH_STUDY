package cn.swjtu.Operator;

import cn.swjtu.DataTxt.DataOperatorTXT;
import cn.swjtu.Student.Student;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

//import static cn.swjtu.HRSystem.HRMain.students;

public class SystemOperator {
    static Scanner sc = new Scanner(System.in);

    /*
   创建一个添加函数，用于分隔字符串，并将其存至students集合中
   返回值：void
   参数名称：addStudent
   参数列表：str
    */
    public static ArrayList<Student> addStudent(ArrayList<Student> stus) {
        //提示用户输入学生信息
        System.out.println("请输入学生信息(以空格分隔)：id 姓名 性别 年龄");
        //使用Scanner类从控制台输入多个学生对象
        /*输入学生信息：*/
        //Scanner sc = new Scanner(System.in);

        String str = "";
        while (true) {
            str = sc.nextLine();
            if (str.equals("")) {
                //如果输入空行，则结束
                break;
            }
            //处理输入的学生数据
            // stus = DataOperatorTXT.resolveData(str);
            stus = studentData(stus,str);
        }

        for (Student student : stus) {
            System.out.println(student);
        }

        return stus;
    }


    /*
   2、从内存中学生信息删除
   返回值：void
   方法名称：deleteStudent
   参数列表：无
    */
    public static ArrayList<Student> deleteStudent(ArrayList<Student> stus) {
        while (true) {
            System.out.println("请输入要删除的学生id：");
            String id = sc.nextLine();
            if (id.equals("")) {
                //空行停止
                break;
            }
            Iterator<Student> it = stus.iterator();
            while (it.hasNext()) {
                if (id.equals(it.next().getId())) {
                    it.remove();
                }
            }

            System.out.println("删除后的学生列表为：");
            for (Student student : stus) {
                System.out.println("id：" + student.getId() + "，姓名：" + student.getName() +
                        "，性别：" + student.isMale() + "，年龄：" + student.getAge());
            }
        }

        return stus;
    }

    /*
     3、从内存中学生信息修改
     三要素：
     返回值：void
     方法名称：alterStudent
     参数列表：
     */
    public static ArrayList<Student> alterStudent(ArrayList<Student> stus) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("请输入您要修改的学生id号：");
            String id = sc.nextLine();

            for (Student student : stus) {
                if (student.getId().equals(id)) {
                    System.out.println("姓名：" + student.getName() + ",性别：" + student.isMale() + ",年龄：" + student.getAge());
                    break;
                }
            }
            System.out.println("请输入您要修改的信息：1-姓名，2-性别，3-年龄");
            String in = sc.next();
            //修改id的对应信息
            switch (Integer.valueOf(in)) {
                case 1: {//修改姓名
                    System.out.println("姓名要修改为：");
                    String name = sc.next();
                    alterStudentName(stus, id, name);
                    break;
                }
                case 2: {//修改性别
                    System.out.println("性别要修改为：");
                    String male = sc.next();
                    alterStudentMale(stus, id, male);
                    break;
                }
                case 3: {//修改年龄
                    System.out.println("年龄要修改为：");
                    int age = sc.nextInt();
                    alterStudentAge(stus, id, age);
                    break;
                }
                default:
                    return stus;
            }
            if (id.equals("")) {
                //如果输入空行，则结束
                return stus;
            }
        }

    }

    /*
    修改姓名
    返回值：void
    方法名称：alterStudentName
    参数列表：int id,String name
     */
    public static ArrayList<Student> alterStudentName(ArrayList<Student> stus, String id, String name) {
        for (Student student : stus) {
            if (id.equals(student.getId())) {
                student.setName(name);
                System.out.println("姓名修改成功！");
                break;
            }
        }
        for (Student student : stus) {
            System.out.println(student);
        }
        System.out.println("\r\n");
        return stus;
    }

    /*
   修改性别
   返回值：void
   方法名称：alterStudentMale
   参数列表：int id,boolean male
    */
    public static ArrayList<Student> alterStudentMale(ArrayList<Student> stus, String id, String male) {
        for (Student student : stus) {
            if (id.equals(student.getId())) {
                student.setMale(male);
                break;
            }
            System.out.println("性别修改成功！");
        }

        for (Student stu : stus) {
            System.out.println(stu);
        }
        System.out.println("\r\n");
        return stus;
    }

    /*
  修改年龄
  返回值：void
  方法名称：alterStudentAge
  参数列表：int id,int age
   */
    public static ArrayList<Student> alterStudentAge(ArrayList<Student> stus, String id, int age) {
        for (Student student : stus) {
            if (id.equals(student.getId())) {
                student.setAge(age);
                System.out.println("年龄修改成功！");
                break;
            }
        }

        for (Student stu : stus) {
            System.out.println(stu);
        }
        System.out.println("\r\n");
        return stus;
    }


    /*
    处理输入的每行数据
     */
    public static ArrayList<Student> studentData(ArrayList<Student> stus, String str) {
        String[] arrStr = str.split(" ");
        //创建一个学生对象，用于存储每行的数据
        Student stu = new Student();
        stu.setId(arrStr[0]);
        stu.setName(arrStr[1]);
        stu.setMale(arrStr[2]);
        stu.setAge(Integer.valueOf(arrStr[3]));
        //将学生对象添加至ArrayList数组
        stus.add(stu);
        return stus;
    }

    /*
    4、从内存中学生信息查询
    使用id查询,直接打印输出
    三要素：
    返回值：void
    方法名称：foreachStudent
    参数列表：int id
     */
    public static ArrayList<Student> foreachStudent(ArrayList<Student> stus) {
        //提示用户输入id查询
        while (true) {
            System.out.println("请输入要查询的学生id：");
            String id = sc.nextLine();
            if (id.equals("")) {
                //如果输入空行，则结束
                break;
            }


            for (Student student : stus) {
                if (student.getId().equals(id)) {
                    System.out.println("姓名：" + student.getName() + ",性别：" + student.isMale() + ",年龄：" + student.getAge());
                    return stus;
                }

            }
            System.out.println("输入的id不存在！");
        }
        return stus;
    }
}
