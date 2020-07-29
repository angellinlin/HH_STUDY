package cn.swjtu.demo07.ObjectStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/*
java.io.ObjectOutputStream extends OutputStream
ObjectOutputStream对象的序列化流，把对象以流的方式写入到文件中保存。

（一）构造方法
ObjectOutputStream(OutputStream out) 创建写入指定字节输出流 OutputStream 的 ObjectOutputStream。

（二）特有的成员方法
void writeObject(Object obj) 将指定的对象写入 ObjectOutputStream。

（三）使用步骤
1、创建ObjectOutputStream对象，构造方法中传递字节输出流；
2、使用ObjectOutputStream对象的writeObject方法把对象写入到文件中；
3、资源释放。


 */
public class Demo01ObjectOutputStream {
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IO0728\\person.txt"));
        oos.writeObject(new Person("芈月",18));
        oos.close();
    }
}
