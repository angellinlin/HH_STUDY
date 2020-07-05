package dataPersistence;

import pojo.Resume;

import java.io.*;
import java.util.ArrayList;

public class DataOperate {
    public static void saveData(ArrayList<Resume> resumeArrayList) {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("d:/PuFaStudy/resumeArrayList.txt", false)));
            for (Resume re : resumeArrayList) {
                printWriter.println(re.getName()+","+re.getId()+","+re.getSchool()+","+re.getStatus()+","+re.getDeleteStatus());
            }
            printWriter.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            printWriter.close();
        }
    }

    public static void loadData(ArrayList<Resume> resumeArrayList){
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("d:/PuFaStudy/resumeArrayList.txt"));
            String data = bufferedReader.readLine();
            while (data != null){
                String[] str = data.split(",");
                String name = str[0];
                String id =str[1];
                String school = str[2];
                int status = Integer.parseInt(str[3]);
                int deleteStatus =Integer.parseInt(str[4]);
                Resume resume = new Resume(name,id,school,status,deleteStatus);
                resumeArrayList.add(resume);
                data = bufferedReader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
