package cn.swjtu.demo02.CopyFile;

import java.io.*;

/*
文件复制练习：一读一写
明确：
    数据源：f:\\1.png
    数据目的地：d:\\1.jpg
文件复制的步骤：
1、创建字节缓冲输入流，构造方法中传递字节输入流；
2、创建字节缓冲输出流，构造方法中传递字节输出流；
3、使用字节缓冲输入流对象的read方法，读取文件；
4、使用字节缓冲输出流对象的write方法，把写出到内存缓冲区；
5、释放资源

 */
public class Demo02CopyFile {
    public static void main(String[] args) throws IOException {
        //获取开始毫秒值
        long start = System.currentTimeMillis();
        //1、创建字节缓冲输入流，构造方法中传递字节输入流；
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("f:\\1.png"));
        //2、创建字节缓冲输出流，构造方法中传递字节输出流；
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("d:\\1.png"));
        //3、使用字节缓冲输入流对象的read方法，读取文件；

        /*一次读取一个字节  20毫秒*/
        int len = 0;
        while ((len = bis.read()) != 0) {
            bos.write(len);
        }

        /*一次读取多个字节  4毫秒*/
       /* int len = 0;
        byte[] bytes = new byte[1024];
        while ((len=bis.read(bytes))!=-1){
            bos.write(bytes,0,len);
        }*/
        bis.close();
        bos.close();
        //获取结束毫秒值
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
