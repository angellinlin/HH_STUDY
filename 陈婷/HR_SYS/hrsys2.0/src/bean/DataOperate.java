package bean;

import java.io.*;
import java.util.LinkedList;

@SuppressWarnings("all")
// 从文本中读入数据、将数据输出到文本中
public class DataOperate {

    public static void loadData(LinkedList<Resume> resumeLinkedList){
        // BufferedReader类：从字符输入流中读取文本，缓冲各个字符，从而实现字符、数组和行的高效读取。
        BufferedReader br = null;
        try{
            br = new BufferedReader(new FileReader("E:\\QQPCmgr\\Desktop\\HH_STUDY\\陈婷\\HR_SYS\\hrsys2.0\\src\\bean\\resume.txt"));
            // 一行一行地读并处理存储到列表中
            String data = br.readLine();
            while(data != null){
                // 每一行的数据按照逗号来分隔
                String[] str = data.split(",");
                String name = str[0];
                String id = str[1];
                String school = str[2];
                Resume resume = new Resume(name, id, school);
                resumeLinkedList.add(resume);
                data = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try{
                br.close();
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }

    public static void saveData(LinkedList<Resume> resumeLinkedList){
        PrintWriter printWriter = null;
        try{
            // 覆盖写入
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("resume.txt",false)));
            int resumeCount = resumeLinkedList.size();
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                // 每次存放以逗号分开，便于读取的时候按照逗号取出元素
                printWriter.println(resumeLinkedList.get(i).getName()+","+resumeLinkedList.get(i).getId()+","+resumeLinkedList.get(i).getSchool());
            }
            printWriter.flush();
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }finally{
            printWriter.close();
        }
    }
}
