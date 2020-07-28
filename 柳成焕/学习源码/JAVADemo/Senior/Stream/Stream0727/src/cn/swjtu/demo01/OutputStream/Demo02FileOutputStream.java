package cn.swjtu.demo01.OutputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

/*
一次写入多个自己的方法：
void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
  一次写入多个字节：
      如果第一个字节是整数（0-127），那么显示时会查询ASCII表。
      如果第一个字节是负数，那第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表（GBK）
 void write(byte[] b, int off, int len) 把字节数组的一部分写入到文件中
    int off：数组的开始索引，int len写几个字节

 */
public class Demo02FileOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("Stream0727\\a.txt");
        //文件中想要显示100，则需要写入3个字节
        fos.write(49);
        fos.write(48);
        fos.write(48);  //100
     /*
     void write(byte[] b) 将 b.length 个字节从指定的 byte 数组写入此输出流。
     一次写入多个字节：
     如果第一个字节是整数（0-127），那么显示时会查询ASCII表。
     如果第一个字节是负数，那第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表（GBK）
     */
        //byte[] bytes = {65, 66, 67, 68, 69};//ABCDE
        byte[] bytes = {-65, -66, -67, -68};//烤郊
        fos.write(bytes);

    /*
    void write(byte[] b, int off, int len) 把字节数组的一部分写入到文件中
    int off：数组的开始索引，int len写几个字节
    */
        byte[] bytes1 = {97, 98, 99, 100, 101};
        fos.write(bytes1,1, 2);  //98, 99  bc


    /*
    写入字符的方法：可以使用String类的方法把字符串转换为字节数组。
    byte[] getBytes()把字符串转为字节数组
     */
        FileOutputStream fos1 = new FileOutputStream("Stream0727\\b.txt");
        byte[] bytes2 = "你好".getBytes();
        System.out.println(Arrays.toString(bytes2));
        fos1.write(bytes2);



        fos.close();
        fos1.close();
    }
    /*

     */

}
