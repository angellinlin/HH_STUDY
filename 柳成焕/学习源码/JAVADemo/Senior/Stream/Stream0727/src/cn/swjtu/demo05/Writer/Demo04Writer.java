package cn.swjtu.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
字符输出流的续写和换行：
续写：使用两个参数的构造函数
FileWriter(String fileName, boolean append)
FileWriter(File file, boolean append)
 参数：boolean append续写开关
       true：不会创建新的文件覆盖，可以续写
       false：会创建新的文件覆盖原文件
 换行：换行符号
 windows:\r\n  linux:\n  mac:\r
 */
public class Demo04Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Stream0727\\d.txt", true);
        for (int i = 0; i < 10; i++) {
            fw.write("hello" + i + "\r\n");
        }
        fw.close();
    }
}
