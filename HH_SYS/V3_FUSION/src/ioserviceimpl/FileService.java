package ioserviceimpl;

import bean.Resume;
import ioservice.IOService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * @program: HR_SYS
 * @description: Files IO
 * @author: 朱戈
 * @create: 2020-07-09
 **/

public class FileService implements IOService{
    private static String filePath="D:\\File.txt";
    Path fpath= Paths.get(filePath);

    public void save(ArrayList<Resume> entityList) {
        //Create File
        if(!Files.exists(fpath)) {
            try {
                Files.createFile(fpath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //Create BufferedWriter
        try {
            BufferedWriter bfw=Files.newBufferedWriter(fpath);
            for(Resume x:entityList){
                bfw.write(x.getId()+","+x.getName()+","+x.getSchool()+","+x.getProcess());
                bfw.newLine();
            }
            bfw.flush();
            bfw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void load(ArrayList<Resume> entityList){
        //Create ufferedReader
        if(!Files.exists(fpath)) {
            return ;
        }
        try {
            BufferedReader bfr=Files.newBufferedReader(fpath);
            String eachline=bfr.readLine();
            while(eachline!=null) {
                String[] str = eachline.split(",");
                entityList.add(new Resume(str[0], str[1], str[2], Integer.parseInt(str[3])));
                eachline = bfr.readLine();
            }
            bfr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
