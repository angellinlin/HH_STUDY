package cn.swjtu.demo06.ReverseStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/*
InputStreamReader 是字节流通向字符流的桥梁：它使用指定的 charset 读取字节并将其解码为字符。
解码：把看不懂的变为看懂的。

（一）继承自父类的方法
 int read() 读取单个字符并返回。
 int read(char[] cbuf) 一次读取多个字符，存入数组
 void close()  释放资源

（二）构造方法
InputStreamReader(InputStream in) 创建一个使用默认字符集的 InputStreamReader。
InputStreamReader(InputStream in, String charsetName) 创建一个使用指定字符集的 InputStreamReader。
参数：InputStream in字节输入流，用来读取文件中保存的字节。
     String charsetName指定的编码表名称，不区分大小写，可以是UTF-8/utf-8，gbk/GBK.....不指定默认使用UTF-8

（三）使用步骤
 1、 创建InputStreamReader 对象，构造方法中传递字节输入流和指定的编码表名称；
 2、使用InputStreamReader对象的方法read读取文件；
 3、释放资源。

 （四）注意事项
 构造方法中指定的编码表名称要和文件的编码相同，否则会发生乱码。
 */
public class Demo03InputStreamReader {
    public static void main(String[] args) throws IOException {
        //read_utf_8();
        read_gbk();
    }

    private static void read_gbk() throws IOException {
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("IO0728\\gbk.txt"), "utf-8");编码表名称要和文件编码一致
       InputStreamReader isr = new InputStreamReader(new FileInputStream("IO0728\\gbk.txt"), "GBK");
        int len = 0;
        char[] chars = new char[1024];
        while ((len=isr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        isr.close();
    }
    private static void read_utf_8() throws IOException {
        //InputStreamReader isr = new InputStreamReader(new FileInputStream("IO0728\\utf-8.txt"), "utf-8");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("IO0728\\utf-8.txt"));
        int len = 0;
        char[] chars = new char[1024];
        while ((len=isr.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }
        isr.close();

    }
}
