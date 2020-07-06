package ioserviceimpl;

import bean.Resume;
import ioservice.IOService;
import pojo.EntityList;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
/**
 * @program: HR_SYS
 * @description: 对象序列化
 * @author: 朱戈
 * @create: 2020-07-06
 **/
public class SerializeService implements IOService {
    private static String filePath="D:\\Serialize.txt";
    Path fpath= Paths.get(filePath);

    public void save(ArrayList<Resume> entityList) throws IOException {
        if(!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File(filePath)));
        oo.writeObject(entityList);
        System.out.println("简历数据对象序列化成功！");
    }
    public void load(ArrayList<Resume> entityList) throws IOException, ClassNotFoundException {
        if(!Files.exists(fpath)) {
            return ;
        }
        System.out.println(888);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File(filePath)));
        ArrayList<Resume> oisList = (ArrayList<Resume>) ois.readObject(); /*值传递，无法对HRS中传入的entityList进行修改*/
        oisList.forEach(x->entityList.add(x));
        System.out.println("Person对象反序列化成功！");

    }
}
