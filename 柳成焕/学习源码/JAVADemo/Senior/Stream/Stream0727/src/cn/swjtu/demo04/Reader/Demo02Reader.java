package cn.swjtu.demo04.Reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

/*
java.io.Reader:字符输入流，用于读取字符流的最顶层的父类，定义了一些共性的成员方法，是一个抽象类。
共性的成员方法
 int read() 读取单个字符并返回。
 int read(char[] cbuf) 一次读取多个字符，存入数组
 void close()  释放资源

 java.io.FileReader extends InoutStreamReader extends Reader文件字符输入流
 作用：把硬盘文件中的数据以字符的方式读取到内存中。
 构造方法：
构造方法摘要
FileReader(File file)
FileReader(String fileName)
参数：读取文件的数据源。
    String fileName文件的路径，File file一个文件
作用：
    1、创建一个FileReader对象；
    2、会把FileReader对象指向要读取的文件。

字符输入流的使用步骤【重点】：
    1、创建一个FileReader对象。构造方法中绑定要读取的数据源；
    2、使用FileReader对象中的方法read读取文件；
    3、释放资源。
String(char[] value) 把字符数组转换为字符串。
String(char[] value, int offset, int count) 把字符数组的一部分转换为字符串。


 */
public class Demo02Reader {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("Stream0727\\c.txt");
        //读取单个字符
        /*int len = 0;
        while((len=fr.read())!=-1){
            System.out.print((char)len);
        }*/

        //一次读取多个字符
        int len = 0;
        char[] chars = new char[1024];
        while ((len = fr.read(chars)) != -1) {
            System.out.println(new String(chars,0,len));
        }
        fr.close();
    }
}
