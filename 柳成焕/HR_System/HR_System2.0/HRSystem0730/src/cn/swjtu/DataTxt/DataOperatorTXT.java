package cn.swjtu.DataTxt;

import cn.swjtu.Operator.SystemOperator;
import cn.swjtu.Student.Student;
import java.io.*;
import java.util.ArrayList;

import cn.swjtu.Operator.SystemOperator;

/*
处理与txt有关的方法
    1、从txt中学生信息录入
    2、从txt中学生信息删除
    3、从txt中学生信息修改
    4、从txt中学生信息查询
 */
public class DataOperatorTXT {
    //加载文本资源
    public static ArrayList<Student> loadData() {
        String line = null;
        ArrayList<Student> stus = new ArrayList<>();
        try {
            //创建字符缓冲输入流，指定文本路径
            BufferedReader br = new BufferedReader(new FileReader("F:\\JAVADemo\\HR_System\\HR_System2.0\\HRSystem0730\\student.txt"));
            //使用BufferedReader的read方法进行数据的读取
            //开始读取
            while ((line = br.readLine()) != null) {//不确定文本有多少行，用while循环
                stus = SystemOperator.studentData(stus, line);
            }
            System.out.println("加载数据成功！");
            //释放资源；
            br.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        for (Student student : stus) {
            System.out.println(student.getId() + " " + student.getName() +
                    " " + student.isMale() + " " + student.getAge());
        }
        return stus;
    }

    //不能使用序列化，那我们还是使用缓冲字符输出流将内存中的数据写到文件中去
    public static ArrayList<Student> saveData(ArrayList<Student> stus) {
        try{
            BufferedWriter bw = new BufferedWriter(new FileWriter("F:\\JAVADemo\\HR_System\\HR_System2.0\\HRSystem0730\\student.txt"));
            //遍历集合，将每个对象转为字符串
            for (Student student : stus) {
                //将对象转为字符串
                String line = student.getId() + " " + student.getName() + " " + student.isMale() + " " + student.getAge();
                //将其写入到文件中
                bw.write(line);
                //换行
                bw.newLine();
            }
            //释放资源
            bw.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return stus;
    }


    //不能使用序列化，txt中查看是乱码，需要和反序列化一起使用。
   /* //将数据保存到txt中，用序列化集合的方式
    public static ArrayList<Student> saveData(ArrayList<Student> stus) {
        ObjectOutputStream oos=null;
        try {
            //将集合保存到文件中，可以使用序列化
             oos = new ObjectOutputStream(new FileOutputStream("F:\\JAVADemo\\HR_System\\HR_System2.0\\HRSystem0730\\student.txt"));
            oos.writeObject(stus);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //资源释放
            try {
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stus;
    }*/


}
