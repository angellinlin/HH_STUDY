package cn.swjtu.demo01.BufferedStream;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
java.io.BufferedOutputStream extends OutputStream
BufferedOutputStream字节缓冲输出流
继承父类的共性成员方法：
void close() 关闭此输出流并释放与此流有关的所有系统资源。
 void flush() 刷新此输出流并强制写出所有缓冲的输出字节。
 void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
 void write(byte[] b, int off, int len) 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此输出流。
 abstract  void write(int b) 将指定的字节写入此输出流。
构造方法：
BufferedOutputStream(OutputStream out)
BufferedOutputStream(OutputStream out, int size)
参数： OutputStream out字节输出流
我们可以传递FileOutputStream，缓冲流会给FileOutputStream增加一个缓冲区，提高FileOutputStream的写入效率。
       int size指定缓冲流内部缓冲区的大小，不指定就是默认大小。

使用步骤【重点】：
    1、创建FileOutputStream对象，构造方法中绑定要输出的目的地；
    2、创建BufferedOutputStream对象，构造方法中传递FileOutputStream对象，提高FileOutputStream对象效率；
    3、使用BufferedOutputStream对象中的write将数据写入内部缓冲区中；
    4、使用BufferedOutputStream对象中的flush方法把内部缓冲区的数据，刷新到文件中；
    5、释放资源（会先调用flush方法刷新数据，第四步可以省略）关闭缓冲流会一起将基本流关闭。
 */
public class Demo01BufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("IO0728\\a.txt");
        BufferedOutputStream bos=new BufferedOutputStream(fos);
        bos.write("我把数据写入到内部缓冲区中".getBytes());
        bos.flush();
        bos.close();
    }
}
