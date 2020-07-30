package cn.swjtu.demo08.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
java.io.PrintStream extends OutputStream:打印流，为其他输出流添加了功能，使他们能够方便地打印格式各种数据值的表示形式。
特点：
1、是负责数据的输出，不负责数据的读取；
2、与其他输出流不同，PrintStream永远不会抛出IOException；
3、特有的方法：print/println可以输出任意类型的值

构造方法：
PrintStream(File file)输出的目的地是一个文件
PrintStream(OutputStream out)输出目的地是一个字节输出流
PrintStream(String fileName)输出目的地是一个文件路径

继承自父类OutputStream的共性方法：
void close() 关闭此输出流并释放与此流有关的所有系统资源。
void flush() 刷新此输出流并强制写出所有缓冲的输出字节。
void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
abstract  void write(int b) 将指定的字节写入此输出流。
注意：
如果使用继承自父类的write方法写数据，那么查看数据的时候会查看编码表：97  --> a
如果使用自己特有的方法print/println写数据，那么会原样输出：97 -->  97

 */
public class Demo01PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        //System.out.println("97");
        PrintStream ps = new PrintStream("IO0728\\print,txt");
        ps.write(97); //a
        ps.println(97); //97
        ps.println(3.145);//3.145
        ps.println('a');//a
        ps.close();
    }
}
