package Server;

import model.Student;

import java.util.LinkedList;
import java.util.Scanner;

public class hrServer {

    public static void addStudent(LinkedList<Student> studentList) {

        System.out.println("录入信息");

        Scanner input = new Scanner(System.in);

        System.out.println("请依次输入需要学生姓名，身份证号，毕业学校");

        String studentName = input.nextLine();

        String studentId = input.nextLine();

        String school = input.nextLine();

        Student s = new Student(studentName, studentId, school);

        studentList.add(s);

        System.out.println("您已成功录入信息");

    }
/*
根据身份证号查找学生并删除
 */
    public static void deleteStudent(LinkedList<Student> studentList) {

        Scanner input = new Scanner(System.in);

        System.out.println("删除信息");

        System.out.println("请输入需要删除的学生身份证号");

        String studentId = input.nextLine();

        int scount = studentList.size();

        for (int i = 0; i < scount; i++) {

            if (studentList.get(i).studentId.equals(studentId)) {

                studentList.remove(i);

                System.out.println("您已成功删除该学生");

                break;

            } else if (i == scount - 1) {

                System.out.println("没有查找到该学生");
            }
        }

    }

    public static void updateStudent(LinkedList<Student> studentList) {

        Scanner input = new Scanner(System.in);

        System.out.println("修改信息");

        System.out.println("请输入需要修改的学生姓名");

        String studentName = input.nextLine();

        int scount = studentList.size();

        for (int i = 0; i < scount; i++) {

            if (studentList.get(i).studentName.equals(studentName)) {

                System.out.println("请依次输入学生姓名，身份证号，毕业院校");

                String sName = input.nextLine();

                String sId = input.nextLine();

                String newschool = input.nextLine();

                Student student = new Student(sName, sId, newschool);

                studentList.set(i, student);

                System.out.println("您已成功修改成功");

            } else if (i == scount - 1 || scount == 0) {

                System.out.println("没有查找到该学生");

            }
        }

    }

    public static void showStudent(LinkedList<Student> studentList) {

        System.out.println("共有" + studentList.size() + "名学生");

        int scount = studentList.size();

        for (int i = 0; i < scount; i++) {

            System.out.println((i + 1) + "姓名：" + studentList.get(i).studentName + "  身份证号："

                    + studentList.get(i).studentId + "  毕业院校：" + studentList.get(i).school);

            System.out.println();
        }

    }
}

