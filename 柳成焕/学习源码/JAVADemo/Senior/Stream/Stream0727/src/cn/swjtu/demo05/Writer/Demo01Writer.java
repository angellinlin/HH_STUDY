package cn.swjtu.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
java.io.Writer字符输出流：是所有字符输出流最顶层的父类，是一个抽象类。
共性成员方法：
    abstract  void close() 关闭此流，但要先刷新它。
    void flush() 刷新该流的缓冲。
    void write(char[] cbuf) 写入字符数组。
    void write(char[] cbuf, int off, int len) 写入字符数组的某一部分。
    void write(int c) 写入单个字符。
    void write(String str) 写入字符串。
    void write(String str, int off, int len) 写入字符串的某一部分。

java.io.FileWriter extends OutputStreamWriter extends Writer
FileWriter文件字节输出流：把内存中的字符数据写入到文件中。
构造方法：
    FileWriter(File file)
    FileWriter(String fileName)
    参数：写入数据的目的地
    String fileName文件的路径，File file文件
构造方法的作用：
    1、创建一个FileWriter对象
    2、会根据构造方法中传递的文件/文件的路径，创建文件
    3、会把FileWriter对象指向创建好的文件。

字符输出流的使用步骤【重点】
    1、创建一个  FileWriter对象，构造方法中绑定要写入数据的目的地；
    2、使用FileWriter对象中的方法write，把数据写入到内存缓冲区中（字符转换为字节的过程）；
    3、使用FileWriter对象中的flush方法，把内存缓冲区中的数据刷新到文件中；
    4、释放资源（会先把内存缓冲区中的数据刷新到文件中）。
 */
public class Demo01Writer {
    public static void main(String[] args) throws IOException {
        // 1、创建一个  FileWriter对象，构造方法中绑定要写入数据的目的地；
        FileWriter fw=new FileWriter("Stream0727\\c.txt");
        //2、使用FileWriter对象中的方法write，把数据写入到内存缓冲区中（字符转换为字节的过程）；
        fw.write(97);
        // 3、使用FileWriter对象中的flush方法，把内存缓冲区中的数据刷新到文件中；
        fw.flush();
        // 4、释放资源（会先把内存缓冲区中的数据刷新到文件中）。
       fw.close();
    }
}
