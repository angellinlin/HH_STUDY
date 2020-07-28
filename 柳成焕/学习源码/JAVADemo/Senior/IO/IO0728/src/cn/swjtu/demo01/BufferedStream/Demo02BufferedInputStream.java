package cn.swjtu.demo01.BufferedStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;

/*
java.io.BufferedInputStream extends InputStream
BufferedInputStream字节缓冲输入流
1、继承父类的共性成员方法
int read() 从输入流中读取数据的下一个字节。
int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
void close() 关闭此输入流并释放与该流关联的所有系统资源。

2、构造方法
BufferedInputStream(InputStream in)
BufferedInputStream(InputStream in, int size)
参数：
InputStream in字节输入流，我们可以传递FileInputStream,缓冲流会给FileInputStream增加一个缓冲区，提高FileInputStream的读取效率。
int size指定缓冲流内部缓冲区的大小，不指定就是默认大小。

3、使用步骤
（1）创建一个InputStream对象，构造方法中绑定要读取的数据源；
（2）创建BufferedInputStream对象，构造方法中传递InputStream对象，提高其读取效率；
（3）使用BufferedInputStream对象中的read方法，读取文件；
（4）释放资源。

 */
public class Demo02BufferedInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("IO0728\\a.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        /*int len=0;//记录每次读取到的字节,一次读一个字节
        while ((len=bis.read())!=-1){
            System.out.println(len);
        }*/
        int len = 0; //记录每次读取的有效字节数
        byte[] bytes = new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            System.out.println(new String(bytes));
        }

        bis.close();

    }
}
