package cn.swjtu.demo05Test;

import javax.annotation.processing.Filer;
import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Set;

/*
练习：对文本的内容进行排序。按照文本的序号进行段落排序。
分析：
1、创建一个HashMap集合。k存储文本中的序号，value存储段落内容，String类型。
2、创建一个字符缓冲输入流对象，读取文本
3、HashMap会对序号进行自动排序
4、遍历集合，获取键值，拼接值一个字符串。
4、再将排序完的文本，使用字符缓冲输出流存至文件中。
 */
public class Demo01Test {
    public static void main(String[] args) throws IOException {
        HashMap<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new FileReader("IO0728\\a.txt"));
        BufferedWriter bw=new BufferedWriter(new FileWriter("IO0728\\c.txt"));
        String line = null;
        while ((line = br.readLine()) != null) {
            //文本切割
            String[] arr = line.split("、");
            map.put(arr[0], arr[1]);
        }
        //遍历
        Set<String> set = map.keySet();
        for (String key : set) {
            String value = map.get(key);
            //拼接键值
            String text = key +"、"+ value;
            //将其写入到文件中
            bw.write(text);
            bw.newLine();
        }
        br.close();
        bw.close();
    }
}
