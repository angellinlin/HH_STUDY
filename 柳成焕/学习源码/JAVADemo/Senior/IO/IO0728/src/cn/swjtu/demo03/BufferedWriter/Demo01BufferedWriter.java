package cn.swjtu.demo03.BufferedWriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/*
java.io.BufferedWriter extends Writer
BufferedWriter字符缓冲输出流
1、继承自父类的共性成员方法
abstract  void close() 关闭此流，但要先刷新它。
void flush() 刷新该流的缓冲。
void write(char[] cbuf) 写入字符数组。
void write(char[] cbuf, int off, int len) 写入字符数组的某一部分。
void write(int c) 写入单个字符。
void write(String str) 写入字符串。
void write(String str, int off, int len) 写入字符串的某一部分。

2、构造方法
BufferedWriter(Writer out)
BufferedWriter(Writer out, int sz)
参数：Writer out字符输出流，我们可以传递FileWriter，缓冲流会给FileWriter增加一个缓冲区，提高FileWriter的写入效率
     int sz定缓冲流内部缓冲区的大小，不指定就是默认大小。

3、特有的成员方法
void newLine() 写入一个行分隔符。 会根据不同的操作系统，获取不同的行分隔符。

4、使用步骤
（1）创建一个字符缓冲输出流对象，构造方法传递字符输出流对象；
（2）调用字符缓冲输出流对象的write方法将数据写到缓冲区中；
（3）调用字符缓冲输出流对象的flush方法,把内存缓冲区中的数据刷新到内存；
（4）释放资源。
 */
public class Demo01BufferedWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw=new BufferedWriter(new FileWriter("IO0728\\b.txt"));
        for (int i = 0; i < 10; i++) {
            bw.write("你好呀"+i);
            //bw.write("\r\n");
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}
