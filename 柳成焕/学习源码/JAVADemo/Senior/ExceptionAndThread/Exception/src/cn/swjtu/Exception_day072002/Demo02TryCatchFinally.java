package cn.swjtu.Exception_day072002;

import java.io.IOException;

/*
格式：
try{
    //可能会产生异常的代码
}catch(定义一个异常的变量，用来接收try中抛出的异常对象){
    //异常的处理逻辑，产生异常对象后，怎么处理异常对象
    //一般在工作中，会把异常的信息记录到一个日志中
}
...
 catch(异常类名 变量名){

 }finally{
    无论是否异常都会执行的代码
 }
注意：
1、finally不能单独使用，必须和try一起使用
2、finally一般用于资源释放（回收），无论程序是否出现异常，最后都要资源释放（IO）
 */
public class Demo02TryCatchFinally {
    public static void main(String[] args) {
        try {
            readFile("c:\\a.exe");
        } catch (IOException e) {
            e.printStackTrace();

        }finally {
            System.out.println("资源释放！");
        }
        System.out.println("后续代码");
    }

    public static void readFile(String fileName) throws IOException {
        /*
        如果传递的路径不是.txt结尾
        那我们就抛出IO异常对象，告知方法调用者，文件的后缀名不对
         */
        if (!fileName.endsWith(".txt")) {
            throw new IOException("文件的后缀名不对");
        }
        System.out.println("后缀正确，继续执行！");
    }
}
