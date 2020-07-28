package cn.swjtu.demo02.InputStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

/*
字节输入流一次读取多个字节的方法
int read(byte[] b) 从输入流中读取一定数量的字节，并将其存储在缓冲区数组 b 中。
明确两件事情：
    1、参数byte[] b的作用？
    起到缓冲作用，存储每个读取到的多个字节。
    数组的长度一般为1024（1kb）或者是1024的整数倍
    2、方法的返回值int是什么？
    每次读取的有效字节个数。
String类构造方法：
String(byte[] bytes)把字节数组转换为字符串
String(byte[] bytes, int offset, int length) 把字节数组的一部分转换为字符串，offset数组的开始索引，length转换的字节个数
 */
public class Demo02InputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("Stream0727\\b.txt");
        //int read(byte[] b)方法
        /*byte[] bytes=new byte[2];
        int len=fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));

        len=fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));

        len=fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));
        len=fis.read(bytes);
        System.out.println(len);
        System.out.println(new String(bytes));*/

        /*
        发现以上读取是一个重复过程，可以使用循环优化
        不知道文件中有多少字节，所以使用whie循环
         */
        int len = 0;
        byte[] bytes = new byte[1024];
        while ( (len = fis.read(bytes)) !=-1){
            System.out.println(len);
            System.out.println(new String(bytes,0,len)); //只转换有效字节数，
        }

        fis.close();
    }
}
