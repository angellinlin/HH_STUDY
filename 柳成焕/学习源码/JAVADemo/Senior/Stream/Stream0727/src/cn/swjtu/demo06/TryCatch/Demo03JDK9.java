package cn.swjtu.demo06.TryCatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
JDK9的新特性：
try的前边可以定义流对象，try后边的括号中可以直接引入流对象的名称（变量名），
在try代码块执行完毕后，流对象也可以释放掉，不用写finally了
格式：
A a=new A();
B b=new B();
try(a;b){
    可能会产生异常的代码
}catch(异常类变量 变量名){
    异常处理逻辑
}
 */
public class Demo03JDK9 {
    public static void main(String[] args) throws IOException {
        //1、创建一个FileInputStream对象。构造方法中绑定要读取的数据源。
        FileInputStream fis=new FileInputStream("F:\\1.png");
        //2、创建一个FileOutputStream对象，构造方法中绑定要写入的目的地。
        FileOutputStream fos=new FileOutputStream("D:\\1.png");
        try(fis;fos){
            //3、使用字节输入流对象的方法read读取文件；
            //一次读取一个字节的方式（速度慢）2526
            int len=0;
            while ((len=fis.read())!=-1){
                //4、使用字节输出流对象的方法write写入目的地文件中；
                fos.write(len);
            }
        }catch(IOException e){
            System.out.println(e);
        }
       // fos.write(1); //IOException: Stream Closed  流已经关闭了，不能再使用了
    }
}
