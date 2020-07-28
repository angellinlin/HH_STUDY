package cn.swjtu.demo05.Writer;

import java.io.FileWriter;
import java.io.IOException;

/*
flush方法和close方法的区别：
    flush：刷新缓冲区，流对象可以继续使用。
    close：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。
 */
public class Demo02FlushAndClose {
    public static void main(String[] args) throws IOException {
        // 1、创建一个  FileWriter对象，构造方法中绑定要写入数据的目的地；
        FileWriter fw=new FileWriter("Stream0727\\c.txt");
        //2、使用FileWriter对象中的方法write，把数据写入到内存缓冲区中（字符转换为字节的过程）；
        fw.write(97);//c.txt中变为a
        // 3、使用FileWriter对象中的flush方法，把内存缓冲区中的数据刷新到文件中；
        fw.flush();
        //刷新之后，流可以继续使用
        fw.write(98);  //c.txt中变为ab
        // 4、释放资源（会先把内存缓冲区中的数据刷新到文件中）。
        fw.close();
        // IOException: Stream closed异常，close方法之后，流已经关闭了，已经从内存中消失了，不能再被使用了。
        //fw.write(99);
    }
}
