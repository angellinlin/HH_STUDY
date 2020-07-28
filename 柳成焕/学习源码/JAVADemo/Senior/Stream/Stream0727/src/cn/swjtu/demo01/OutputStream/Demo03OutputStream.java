package cn.swjtu.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;

/*
追加写/续写：使用两个参数的构造方法
FileOutputStream(File file, boolean append)创建一个向指定 File 对象表示的文件中写入数据的文件输出流。
FileOutputStream(String name, boolean append) 创建一个向具有指定 name 的文件中写入数据的输出文件流。
参数：File file、String name：写入数据的目的地
      boolean append：追加写开关
        true:创建对象不会覆盖原文件，继续在文件末尾追加写数据
        false：创建一个新文件,覆盖原文件

写换行：写换行符号
windows：\r\n
linux：/n
mac：/r

 */
public class Demo03OutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos=new FileOutputStream("Stream0727\\c.txt",true);
        for (int i = 0; i < 10; i++) {
            fos.write("你好\r\n".getBytes());
        }
        fos.close();
    }
}
