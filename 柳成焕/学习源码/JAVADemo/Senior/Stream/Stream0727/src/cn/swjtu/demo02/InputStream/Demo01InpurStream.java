package cn.swjtu.demo02.InputStream;

import java.io.FileInputStream;
import java.io.IOException;

/*
java.io.InputStream：字节输入流
此抽象类是表示字节输入流的所有类的超类。

int read() 从输入流中读取数据的下一个字节。
int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
void close() 关闭此输入流并释放与该流关联的所有系统资源。

java.io.FileInputStream extends InputStream：文件字节输入流
作用：把硬盘文件中的数据读取到内存中使用。
构造方法：
FileInputStream(String name)
FileInputStream(File file)
参数：读取文件的数据源
    String name：文件的路径，File file：文件
构造方法的作用：
    1、创建一个FileInputStream对象；
    2、把FileInputStream对象指向构造方法中要读取的文件。

读取数据的原理（硬盘-->内存）
java程序-->JVM-->OS-->OS读取数据的方法-->读取文件

字节输入流的使用步骤【重点】：
1、创建一个FileInputStream对象，构造方法中绑定要读取的数据源；
2、使用FileInputStream对象中的方法read读取文件；
3、释放资源
 */
public class Demo01InpurStream {
    public static void main(String[] args) throws IOException {
        //1、创建一个FileInputStream对象，构造方法中绑定要读取的数据源；
        FileInputStream fis = new FileInputStream("Stream0727\\a.txt");
        //2、使用FileInputStream对象中的方法read读取文件；
        //int read()读取文件中的一个字节并返回，读取到文件的末尾返回-1
        /*int len = fis.read();
        System.out.println(len); //97 a

        len = fis.read();
        System.out.println(len);//98 b

        len = fis.read();
        System.out.println(len);//99 c

        len = fis.read();
        System.out.println(len);//-1

        len = fis.read();
        System.out.println(len);//-1*/

        /*
        我们发现以上读取文件是一个重复过程，所以可以使用循环优化
        不知道文件中有多少个字节，使用while循环
        while循环的结束条件:(len=fis.read() ) != -1
        1、fis.read()：读取一个字节
        2、len=fis.read()：把读取到的字节赋值给变量len
        3、(len=fis.read() ) != -1判断变量len是否不等于-1
         */
        int len = 0;//记录读取到的字节
        while ((len = fis.read()) != -1) {
            System.out.println((char) len);
        }
        /*必须用一个变量来接收read方法，否则：
        第一步fis.read()得到97！=-1，则进入循环体
        fis.read()读取到98，输出98
        再进行判断fis.read()得到99！-1
        进入循环体，打印输出fis.read此时为-1
        这样就只会输出98  -1两个值
        while (( fis.read()) != -1) {
            System.out.println(fis.read());
        }*/


        //3、释放资源
        fis.close();
    }
}
