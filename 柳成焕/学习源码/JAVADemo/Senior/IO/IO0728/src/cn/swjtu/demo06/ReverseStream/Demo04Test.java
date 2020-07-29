package cn.swjtu.demo06.ReverseStream;

import java.io.*;

/*
要求:将gbk编码的文件，转换为utf-8的文本文件。
分析：
1、创建一个读的转换流，InputStreamReader，读取GBK格式的文件；
2、创建一个写的转换流，OutputStreamWriter，将读取到的文本以UTF-8格式写入到文件中。

 */
public class Demo04Test {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(new FileInputStream("IO0728\\我是GBK格式的文本.txt"), "GBK");
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("IO0728\\我是UTF-8格式的文本.txt"), "UTF-8");
        int len = 0;
        char[] chars = new char[1024];
        while ((len = isr.read(chars)) != -1) {
            String str = new String(chars, 0, len);
            System.out.println(str);
            osw.write(str);
        }
        osw.flush();
        osw.close();
        isr.close();
    }

}
