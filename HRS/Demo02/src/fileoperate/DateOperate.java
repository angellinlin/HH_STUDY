package fileoperate;

import bean.Student;

import java.io.*;
import java.util.ArrayList;

/**
 * @author ：Timber
 * @date ：Created in 2020/7/4 12:43
 * @modified By：
 */
public class DateOperate {
    //把TXT中的数据加载到内存中
    public void loadData(ArrayList<Student> studentList){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("D:\\PFYH\\HH_STUDY\\HRS\\Demo02\\studentList.txt"));
            String studentData = br.readLine();
            while (studentData != null){
                String[] str = studentData.split(",");
                String stuName = str[0];
                String stuID = str[1];
                String stuPosition = str[2];
                Student student = new Student(stuName,stuID,stuPosition);
                //把从txt中读出的内容储存在内存的一个列表中
                studentList.add(student);
                studentData = br.readLine();
            }
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
        finally
        {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    //把内存中的数据写入到TXT中
    public void savaData(ArrayList<Student> studentList){
        PrintWriter pr = null;
        try {
            pr = new PrintWriter(new OutputStreamWriter(new FileOutputStream("D:\\PFYH\\HH_STUDY\\HRS\\Demo02\\studentList.txt",false)));
            for (Student student : studentList) {
                pr.println(student.getStudentName()+ "," +student.getStudentID()+ "," + student.getPosition());
            }
            pr.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            pr.close();
        }
    }
}
