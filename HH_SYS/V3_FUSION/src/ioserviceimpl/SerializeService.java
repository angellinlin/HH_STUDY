package ioserviceimpl;

import bean.Resume;
import ioservice.IOService;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * @program: HR_SYS
 * @description: Java Object Serialization
 * @author: 朱戈
 * @create: 2020-07-09
 **/
public class SerializeService implements IOService {
    private static String filePath="D:\\Serialize.txt";
    Path fpath= Paths.get(filePath);

    public void save(ArrayList<Resume> entityList){
        if(!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectOutputStream oo = null;
        try {
            oo = new ObjectOutputStream(new FileOutputStream(
                    new File(filePath)));
            oo.writeObject(entityList);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("简历数据对象序列化成功！");
    }
    public void load(ArrayList<Resume> entityList){
        if(!Files.exists(fpath)) {
            return ;
        }
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                    new File(filePath)));
            ArrayList<Resume> oisList = (ArrayList<Resume>) ois.readObject();
            oisList.forEach(x->entityList.add(x));
            System.out.println("简历数据对象反序列化成功！");
        }catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
    }
}
