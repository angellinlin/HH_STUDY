package cn.swjtu.demo04.Reader;

import java.io.FileInputStream;
import java.io.IOException;

/*
使用字节流读取中文文件
1个中文：
    GBK：占用两个字节
    UTF-8：占用3个字节
 */
public class Demo01InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis=new FileInputStream("Stream0727\\c.txt");  //存储：你好
        int len=0;
        while ((len=fis.read())!=-1){
            System.out.println((char)len); //乱码
        }
        fis.close();
    }
}
