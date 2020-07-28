package cn.swjtu.demo06.TryCatch;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/*
JDK7的新特性：
在try后边可以增加一个()，在括号中可以定义流对象。那么这个流对象的作用域就在try中有效。
try中的代码执行完毕，就自动把流对象释放，不用写finally了。
格式：
try(定义流对象；定义流对象；......){
    可能会产生异常的代码
}catch(异常类变量 变量名){
    异常处理逻辑
}


 */
public class Demo02JDK7 {
    public static void main(String[] args) {
        try ( //1、创建一个FileInputStream对象。构造方法中绑定要读取的数据源。
              FileInputStream fis = new FileInputStream("F:\\1.png");
              //2、创建一个FileOutputStream对象，构造方法中绑定要写入的目的地。
              FileOutputStream fos = new FileOutputStream("D:\\1.png");) {
            //3、使用字节输入流对象的方法read读取文件；
            //一次读取一个字节的方式（速度慢）
        int len = 0;
            while ((len = fis.read()) != -1) {
                //4、使用字节输出流对象的方法write写入目的地文件中；
                fos.write(len);
            }
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
