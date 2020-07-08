/**
 * A program for JAVA-LOWBHRSystem
 * @version 1.0 2020-07-07
 * @author Kan Wang
 */

package operation;

import pojo.Resume;
import java.io.*;
import java.util.*;

public class dataOperate {
    public static LinkedList<Resume> loadResume(String filePath) {

        //判断读取路径是否为空
        if (filePath.isEmpty()) {
            System.out.println("请输入正确的文件路径名！");
            return null;
        }

        BufferedReader br = null;
        LinkedList<Resume> person = new LinkedList<>();

        try {
            br = new BufferedReader(new FileReader(filePath));
            String data = br.readLine();
            while (data != null && data.length() != 0) {
                String[] str = data.split(",");
                String name = str[0];
                String sex = str[1];
                String nation = str[2];
                String phone = str[3];
                String email = str[4];
                Resume resume = new Resume(name, sex, nation, phone, email);
                person.add(resume);
                data = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return person;
    }

    public static void saveResume(LinkedList<Resume> person, String filePath)  {

        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filePath));
            for (Resume i : person) {
                bw.write(i.name + "," + i.sex + "," + i.nation + "," + i.phone + "," + i.email);
                bw.newLine();
            }
            bw.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                bw.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
