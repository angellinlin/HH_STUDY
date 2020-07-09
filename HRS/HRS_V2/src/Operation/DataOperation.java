package Operation;

import Resume.Resume;

import java.io.*;
import java.util.List;


//从txt文件中读取数据、将数据写入txt文件中。
public class DataOperation {
    public static void readData(List<Resume> applicants) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("D:/IdeaProjects/HH_STUDY/HRS/HRS_V2/ResumeData.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] temp = line.split(",");
                String resumeName = temp[0];
                String resumeSchool = temp[1];
                String resumeId = temp[2];
                String resumeEmail = temp[3];
                applicants.add(new Resume(resumeName, resumeId, resumeSchool, resumeEmail));
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeData(List<Resume> applicants) {
        try {
            PrintWriter writer = new PrintWriter(new FileWriter("D:/IdeaProjects/HH_STUDY/HRS/HRS_V2/ResumeData.txt"));
            for (Resume applicant : applicants) {
                writer.println(applicant.getName() + "," + applicant.getSchool() + ","
                        + applicant.getId() + "," + applicant.getEmail());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

