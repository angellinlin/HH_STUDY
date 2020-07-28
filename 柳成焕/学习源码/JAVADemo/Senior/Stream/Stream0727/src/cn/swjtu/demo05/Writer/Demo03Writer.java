package cn.swjtu.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
字符输出流写数据的其他方法：
    void write(char[] cbuf) 写入字符数组。
    abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分。
    void write(String str) 写入字符串。
    void write(String str, int off, int len) 写入字符串的某一部分。
 */
public class Demo03Writer {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("Stream0727\\d.txt");
        //void write(char[] cbuf) 写入字符数组
        char[] chars1 = {'a', 'b', 'c', 'd'};
        fw.write(chars1);

        //abstract void write(char[] cbuf, int off, int len) 写入字符数组的某一部分。
        fw.write(chars1,0,2);

        //void write(String str) 写入字符串。
        fw.write("你好呀");

        //void write(String str, int off, int len) 写入字符串的某一部分。
        fw.write("上海浦东发展银行",4,4);  //发展银行
        fw.close();


    }
}
