package Server;

import model.Student;


import java.io.*;
import java.util.LinkedList;



public class informationServer
{
    public static void loadData(LinkedList<Student> studentList)
    {
        BufferedReader br = null;
        try
        {
            br = new BufferedReader(new FileReader("C:\\Users\\HC\\Desktop\\information.txt"));
            String data = br.readLine();
            while(data!=null)
            {
                String[] str = data.split(",");
                String studentName =str[0];
                String studentId =str[1];
                String school = str[2];
                Student student = new Student(studentName,studentId,school);
                studentList.add(student);
                data = br.readLine();
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

    public static void saveData(LinkedList<Student> sList)
    {
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new OutputStreamWriter(new FileOutputStream("C:\\Users\\HC\\Desktop\\information.txt",false)));
            int sCount = sList.size();
            for(int i=0;i<sCount;i++)
            {
                printWriter.println(sList.get(i).studentName+","+sList.get(i).studentId+","+sList.get(i).school);
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
