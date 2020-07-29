package cn.swjtu.demo06.ReverseStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

/*
java.io.OutputStreamWriter extends Writer
OutputStreamWriter：是字符通向字节的桥梁；可食用指定的charset将要写入流中的字符编码成字节。（编码：把能看懂的变成看不懂的）

（一）继承自父类的共性成员方法：
  abstract  void close() 关闭此流，但要先刷新它。
    void flush() 刷新该流的缓冲。
    void write(char[] cbuf) 写入字符数组。
    void write(char[] cbuf, int off, int len) 写入字符数组的某一部分。
    void write(int c) 写入单个字符。
    void write(String str) 写入字符串。
    void write(String str, int off, int len) 写入字符串的某一部分。

（二）构造方法
OutputStreamWriter(OutputStream out) 创建使用默认字符编码的 OutputStreamWriter
OutputStreamWriter(OutputStream out, String charsetName)创建使用指定字符集的 OutputStreamWriter。
参数：OutputStream out字节输出流，可以用来写转换之后的字节到文件中。
String charsetName指定的编码表名称，不区分大小写，可以是UTF-8/utf-8，gbk/GBK.....不指定默认使用UTF-8

(三)使用步骤
1、创建OutputStreamWriter对象，构造方法中传递字节输出流和指定的编码表名称；
2、使用OutputStreamWriter对象的方法write把字符转换为字节，存储到缓冲区中；
3、使用OutputStreamWriter对象的方法flush把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）
4、释放资源



 */
public class Demo02OutputStreamWriter {
    public static void main(String[] args) throws IOException {
        write_utf_8();
        write_gbk();
    }

    private static void write_gbk() throws IOException {
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("IO0728\\gbk.txt"),"GBK");
        osw.write("你好"); //4字节
        osw.flush();
        osw.close();
    }

    private static void write_utf_8() throws IOException {
        //OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("IO0728\\utf-8.txt"),"utf-8");
        //不指定默认为utf-8
        OutputStreamWriter osw=new OutputStreamWriter(new FileOutputStream("IO0728\\utf-8.txt"));
        osw.write("你好");//6字节
        osw.flush();
        osw.close();
    }
}
