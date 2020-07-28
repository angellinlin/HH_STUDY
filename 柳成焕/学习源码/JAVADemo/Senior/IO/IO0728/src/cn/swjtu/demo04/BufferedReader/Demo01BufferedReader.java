package cn.swjtu.demo04.BufferedReader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
java.io.BufferedReader extends Reader
BufferedReader字符缓冲输入流
1、继承自父类的共性成员方法
int read() 读取单个字符并返回。
int read(char[] cbuf) 一次读取多个字符，存入数组
void close()  释放资源

2、构造方法
BufferedReader(Reader in)传递字符输入流，可以传递FileReader
BufferedReader(Reader in, int sz)

3、特有的成员方法
String readLine() 读取一行数据。行的终止符号：换行 ('\n')、回车 ('\r') 或回车后直接跟着换行（\r\n）。
返回值：包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 null

4、使用步骤
（1）创建一个字符缓冲输入流对象，构造方法传递字符输入流；
（2）使用字符缓冲输入流对象的read/readLine方法读取文本；
（3）释放资源。
 */
public class Demo01BufferedReader {
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new FileReader("IO0728\\b.txt"));
        String line=null;
        while ((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }
}
