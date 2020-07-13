package com.weihongyu.util;

import com.weihongyu.entity.Resume;

import java.io.*;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/10 23:41
 * @Description:
 */
public class FileUtil {

    private static FileWriter fw = null;
    private static PrintWriter pw = null;
    private static FileReader fr = null;
    private static BufferedReader br = null;
    private static BufferedWriter bw = null;


//    /**
//     * @function 将对象存储到文本中
//     */
//    public static void objinsertToFile(Object object, String path) throws IOException, IllegalAccessException {
//        File file = new File(path);
//        if (!file.exists() || file.isDirectory()) {
//            System.out.println("file is not exist,I will create a new file");
//            File parentFile = new File(file.getParent());
//            if (!parentFile.exists()) {
//                parentFile.mkdirs();
//            }
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//        fw = new FileWriter(file, true);
//        pw = new PrintWriter(fw, true);
//        pw.println(objToString(object));
//        fw.close();
//        pw.close();
//
//    }

    /**
     * @function 从文本中查找数据，并封装成对象
     */
    public static <T> T getObjectByName(Class<T> t, String name, String path) throws IllegalAccessException, InstantiationException, IOException {
        T instance = t.newInstance();
        Class clazz = instance.getClass();
        Field[] fields = clazz.getDeclaredFields();
        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("文件名不存在");
            return null;
        }
        fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while ((line = br.readLine()) != null) {
            if (line.contains(name)) {
                String[] values = line.split("#");
                for (int i = 0; i < values.length; i++) {
                    Type type = fields[i].getType();
                    if (type == Integer.class) {
                        fields[i].setAccessible(true);
                        fields[i].set(instance, Integer.parseInt(values[i]));
                    } else {
                        fields[i].setAccessible(true);
                        fields[i].set(instance, values[i]);
                    }
                }
            }
        }
        fr.close();
        br.close();
        return instance;
    }

    /**
     * 通过名字删除文本中的数据
     */
    public static void deleteByname(String name, String path) throws IOException {
        if (!check(path)) {
            return;
        }
        File file = new File(path);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line = null;
        List<String> lines = new ArrayList<>();

        while ((line=br.readLine())!=null){
            if (line.contains(name)){
                continue;
            }
            //不包含名字的添加到一个list，然后重新覆盖整个文本
            lines.add(line);
        }

        fr.close();
        br.close();
        clearFile(path);
        fw = new FileWriter(file,true);
        pw = new PrintWriter(fw,true);
        for (String newline :lines){
            pw.println(newline);
        }
    }

    /**
     * 通过名字更新文本数据
     * 首先删除原来的数据，然后再添加更新的数据
     */
    public static void updateOneLine(String name,Object obj, String path) throws IOException, IllegalAccessException {
        if (!check(path)){
            return;
        }
        deleteByname(name,path);
        File file = new File(path);
        fw = new FileWriter(file,true);
        pw = new PrintWriter(fw,true);


        pw.println(objToString(obj));
        fw.close();
        pw.close();
    }
    public static void clearFile(String path) throws IOException {

        File file = new File(path);
        fw = new FileWriter(file);
        fw.write("");
        fw.flush();
        fw.close();
    }


    /**
     * 获得全部对象的字符串格式
     * @param path
     * @return
     */
    public static  List<String> getAll(String path) throws IOException {
        List<String> list = new ArrayList<>();
        File file = new File(path);
        fr = new FileReader(file);
        br = new BufferedReader(fr);
        String line = null;


        while ((line=br.readLine())!=null){
            list.add(line);
        }

        return list;
    }


    /**
     * @function 对象转字符串，以#分割
     */
    public static String objToString(Object obj) throws IllegalAccessException {
        Class clazz = obj.getClass();
        Field[] filelds = clazz.getDeclaredFields();
        StringBuffer newLine = new StringBuffer();
        for (Field field : filelds) {
            if (field.get(obj)==null){
                continue;
            }
            field.setAccessible(true);//禁止访问控制检查
            newLine.append(field.get(obj).toString() + "#");
        }
        return newLine.toString();
    }

    public static Boolean check(String path) {
        File file = new File(path);
        if (file.isDirectory() || !file.exists()) {
            System.out.println("文件不存在");
            return false;
        }
        return true;
    }

    public static void addResume(String resume, String path) throws IOException {

        File file = new File(path);
        if (!file.exists() || file.isDirectory()) {
            System.out.println("file is not exist,I will create a new file");
            File parentFile = new File(file.getParent());
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        fw = new FileWriter(file, true);
        pw = new PrintWriter(fw, true);
        pw.println();
        pw.println(resume);
        fw.close();
        pw.close();
    }
}
