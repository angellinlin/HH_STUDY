package cn.swjtu.demo07.ObjectStream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
ObjectInputStream对象的反序列化流，把文件中保存的额对象，以流的形式读取出来使用

（一）构造方法
ObjectInputStream(InputStream in) 创建从指定 字节输入流InputStream 读取的 ObjectInputStream。

（二）特有的成员方法
Object readObject() 从 ObjectInputStream 读取对象

（三）使用步骤
1、创建ObjectInputStream对象，构造方法中传递字节输入流；
2、使用ObjectInputStream对象的方法readObject读取保存对象的文件；
3、释放资源。
4、使用读取出来的对象（打印）。

readObject方法声明抛出了ClassNotFoundException（class文件找不到异常）
当不存在对象的class文件时，抛出此异常
反序列化的前提：
1、类必须实现Serializable接口；
2、必须存在类对象的class文件。




 */
public class Demo02ObjectInputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IO0728\\person.txt"));
        Object obj = ois.readObject();
        ois.close();
        System.out.println(obj);//Person{name='芈月', age=0}
        //转换为Person类型
        Person p = (Person) obj;
        System.out.println(p);
    }
}
