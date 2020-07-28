package cn.swjtu.demo06.TryCatch;

import java.io.FileWriter;
import java.io.IOException;

/*
在JDK1.7之前使用try...catch finally处理流中的异常
格式：
try{
    可能会产生异常的代码
}catch(异常类变量 变量名){
    异常处理逻辑
}finally{
    一定会执行的代码
    资源释放
}
 */
public class Demo01TryCatch {
    public static void main(String[] args) {
        /*提高变量fw的作用域，让finally可以使用
        变量在定义时可以没有值，但在使用时必须有值
         fw = new FileWriter("Stream0727\\d.txt", true);如果执行失败，则  fw.close();中的fw没有值，就会报错。*/
        FileWriter fw = null;
        try {
            fw = new FileWriter("w:\\Stream0727\\d.txt", true);
            for (int i = 0; i < 10; i++) {
                fw.write("hello" + i + "\r\n");
            }
        } catch (IOException e) {
            System.out.println(e);//FileNotFoundException: w:\Stream0727\d.txt (系统找不到指定的路径。)
        } finally {
            //一定会执行的代码
            /*创建对象如果失败了，fw默认值就是null。
            null是不能直接调用方法的，会抛出NullPointerException异常
            需要增加一个判断，不是null就把资源释放*/
            if (fw != null) {
                try {
                    //fw.close();声明抛出了异常，所以我们必须处理
                    fw.close();
                } catch (IOException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
