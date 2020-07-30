/*
需要实现以下功能：
    1、从内存中学生信息录入
    2、从内存中学生信息删除
    3、从内存中学生信息修改
    4、从内存中学生信息查询
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HRMain {
    //创建一个集合用于存储学生对象
    public static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("欢迎进入HR_Syetem1.0系统，请输入你要进行的操作：");
            System.out.println("1--增加学生信息");
            System.out.println("2--查询学生信息");
            System.out.println("3--修改学生信息");
            System.out.println("4--删除学生信息");
            String in = sc.nextLine();
            switch (Integer.valueOf(in)) {
                case 1: {//增加学生信息
                    addStudent();
                    break;
                }
                case 2: {//2--查询学生信息
                    /*提示用户输入id查询*/
                    while (true) {
                        System.out.println("请输入要查询的学生id：");
                        String str = sc.nextLine();
                        if (str.equals("")) {
                            //如果输入空行，则结束
                            break;
                        }
                        foreachStudent(Integer.valueOf(str));
                    }
                    break;
                }
                case 3: {//3--修改学生信息
                    alterStudent();
                    break;
                }
                case 4: {//4--删除学生信息
                    deleteStudent();
                    break;
                }
                default:
                    break;

            }
            if (in.equals("")) {
                break;
            }
        }

    }

    /*
    2、从内存中学生信息删除
    返回值：void
    方法名称：deleteStudent
    参数列表：无
     */
    public static void deleteStudent() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入要删除的学生id：");
            String str = sc.nextLine();
            if (str.equals("")) {
                //空行停止
                break;
            }
            int id = Integer.valueOf(str);
            Iterator<Student> it = students.iterator();
            while (it.hasNext()) {
                if (id == it.next().getId()) {
                    it.remove();
                }
            }
        }

            System.out.println("删除后的学生列表为：");
            for (Student student : students) {
                System.out.println("id：" + student.getId() + "，姓名：" + student.getName() +
                        "，性别：" + student.isMale() + "，年龄：" + student.getAge());
            }
        }

    /*
     3、从内存中学生信息修改
     三要素：
     返回值：void
     方法名称：alterStudent
     参数列表：
     */
    public static void alterStudent() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入您要修改的学生id号：");
            String str = sc.nextLine();
            if (str.equals("")) {
                //如果输入空行，则结束
                break;
            }
            foreachStudent(Integer.valueOf(str));

            System.out.println("请输入您要修改的信息：1-姓名，2-性别，3-年龄");
            String in = sc.next();

            //修改id为Integer.valueOf(str)的对应信息
            switch (Integer.valueOf(in)) {
                case 1: {//修改姓名
                    System.out.println("姓名要修改为：");
                    String name = sc.next();
                    alterStudentName(Integer.valueOf(str), name);
                    break;
                }
                case 2: {//修改性别
                    System.out.println("性别要修改为：");
                    String male = sc.next();
                    alterStudentMale(Integer.valueOf(str), male);
                    break;
                }
                case 3: {//修改年龄
                    System.out.println("年龄要修改为：");
                    int age = sc.nextInt();
                    alterStudentAge(Integer.valueOf(str), age);
                    break;
                }
                default:
                    break;
            }

            for (Student student : students) {
                if (Integer.valueOf(str) == student.getId())
                    System.out.println("id：" + Integer.valueOf(str) + "，姓名：" + student.getName() +
                            "，性别：" + student.isMale() + "，年龄：" + student.getAge());
                break;
            }
        }

    }

    /*
    修改姓名
    返回值：void
    方法名称：alterStudentName
    参数列表：int id,String name
     */
    public static void alterStudentName(int id, String name) {
        for (Student student : students) {
            if (id == student.getId()) {
                student.setName(name);
            }
        }
    }

    /*
   修改性别
   返回值：void
   方法名称：alterStudentMale
   参数列表：int id,boolean male
    */
    public static void alterStudentMale(int id, String male) {
        for (Student student : students) {
            if (id == student.getId()) {
                if (male == "男") {
                    student.setMale(true);
                } else if (male == "女") {
                    student.setMale(false);
                }

            }
        }
    }

    /*
  修改年龄
  返回值：void
  方法名称：alterStudentAge
  参数列表：int id,int age
   */
    public static void alterStudentAge(int id, int age) {
        for (Student student : students) {
            if (id == student.getId()) {
                student.setAge(age);
            }
        }
    }

    /*
    创建一个添加函数，用于分隔字符串，并将其存至students集合中
    返回值：void
    参数名称：addStudent
    参数列表：str
     */
    public static void addStudent() {
        //提示用户输入学生信息
        System.out.println("请输入学生信息(以空格分隔)： 姓名 性别 年龄");
        //使用Scanner类从控制台输入多个学生对象
        /*输入学生信息：*/
        Scanner sc = new Scanner(System.in);
        int id = 0;  //用于添加学生id
        String str = "";
        while (true) {
            str = sc.nextLine();
            if (str.equals("")) {
                //如果输入空行，则结束
                break;
            }
            //处理输入的学生数据
            studentData(id, str);
            id++;
        }

        for (Student student : students) {
            System.out.println(student);
        }

    }

    /*
    处理输入的每行数据
     */
    private static void studentData(int id, String str) {
        String[] arrStr = str.split(" ");
        //创建一个学生对象，用于存储每行的数据
        Student stu = new Student();
        stu.setId(id);

        stu.setName(arrStr[0]);
        if (arrStr[1].equals("男")) {
            stu.setMale(true);
        }
        stu.setAge(Integer.valueOf(arrStr[2]));
        //将学生对象添加至ArrayList数组
        students.add(stu);
    }

    /*
    4、从内存中学生信息查询
    使用id查询,直接打印输出
    三要素：
    返回值：void
    方法名称：foreachStudent
    参数列表：int id
     */
    public static void foreachStudent(int id) {
        if (id > students.size() || id < 0) {
            System.out.println("输入的id不存在！");
            return;
        }

        for (Student student : students) {
            if (student.getId() == id) {
                System.out.println("姓名：" + student.getName() + ",性别：" + student.isMale() + ",年龄：" + student.getAge());
                return;
            }

        }
        System.out.println("输入的id不存在！");
    }
}
