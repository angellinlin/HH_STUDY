package cn.swjtu.demo02.CopyFile;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
文件复制练习：一读一写
明确：
    数据源：f:\\1.png
    数据目的地：d:\\1.jpg
文件复制的步骤：
    1、创建一个FileInputStream对象。构造方法中绑定要读取的数据源。
    2、创建一个FileOutputStream对象，构造方法中绑定要写入的目的地。
    3、使用字节输入流对象的方法read读取文件；
    4、使用字节输出流对象的方法write写入目的地文件中；
    5、释放资源。先关闭写的，再关闭读的。（如果写完了，肯定读完了）

    一次读取一个字节：2526毫秒
    一次读取多个字节：94毫秒
 */
public class Demo01CopyFile {
    public static void main(String[] args) throws IOException {
        long start=System.currentTimeMillis();
        //1、创建一个FileInputStream对象。构造方法中绑定要读取的数据源。
        FileInputStream fis=new FileInputStream("F:\\1.png");
        //2、创建一个FileOutputStream对象，构造方法中绑定要写入的目的地。
        FileOutputStream fos=new FileOutputStream("D:\\1.png");
        //3、使用字节输入流对象的方法read读取文件；

        //一次读取一个字节的方式（速度慢）2526
        /*int len=0;
        while ((len=fis.read())!=-1){
            //4、使用字节输出流对象的方法write写入目的地文件中；
            fos.write(len);
        }*/

        //一次读取多个字节
        int len=0;
        byte[] bytes=new byte[1024];
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);  //写有效个数,速度快 7
        }
        //释放，
        fos.close();
        fis.close();
        long end=System.currentTimeMillis();
        System.out.println("复制文件耗时："+(end-start));
    }
}

