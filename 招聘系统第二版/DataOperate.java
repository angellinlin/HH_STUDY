package bean;

import java.io.*;
import java.util.LinkedList;

//用于从文件中读入读出信息
public class DataOperate {


    public static void loadData(LinkedList<Resume> linkedList) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("baobaojiu.txt"));
            //一行一行的读并处理存储到列表中
            String line;
            while ((line = br.readLine()) != null) {
                String[] str = line.split(",");//每一行的数据按照逗号来分隔
                /*
                    个人信息属性：
                    姓名：resumeName
                    年龄：resumeAge
                    学校：resumeSchool
                    性别：sex
                    逻辑删除控制：id
                */
                String name = str[0];
                int resumeAge = Integer.parseInt(str[1]);//把字符串解析为整数
                String school = str[2];
                String sex = str[3];
                Resume  resume = new Resume(name,resumeAge,school,sex);
                linkedList.add(resume);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                br.close();
            }catch (IOException exception){
                exception.printStackTrace();
            }
        }
    }
    public static void saveData(LinkedList<Resume> linkedList)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("baobaojiu.txt",false)));//覆盖写入
            int resumeCount = linkedList.size();
            for(int i=0;i<linkedList.size();i++)
            {
                //每一次存用逗号分开，便于后面读取的时候按照逗号来取出元素
                printWriter.println(linkedList.get(i).getResumeName()+","+linkedList.get(i).getResumeAge()+","+linkedList.get(i).getResumeSchool()+","+linkedList.get(i).getSex());
            }
            printWriter.flush();
        }
        catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
        finally
        {
            printWriter.close();
        }
    }
}
