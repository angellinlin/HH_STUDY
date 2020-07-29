package cn.swjtu.demo07.ObjectStream;

import java.io.*;
import java.util.ArrayList;

/*
练习：当我们想在按文件中保存多个对象的时候，可以把多个对象存储到一个集合中面对集合进行序列化和反序列化。
分析：
1、定义一个存储Person对象的ArrayList集合，add多个对象
2、定义一个序列化流对象，
3、定义一个反序列化流对象
4、使用序列化对象的writeObject()将集合写入
5、使用反序列化的readObject（）将集合取出
6、将Object转为ArrayList集合,遍历
7、释放资源
 */
public class Demo03Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Person> list = new ArrayList<>();
        list.add(new Person("芈月", 17));
        list.add(new Person("王昭君", 18));
        list.add(new Person("孙尚香", 19));

        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("IO0728\\list.txt"));
        //序列化集合
        oos.writeObject(list);
        //反序列化
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("IO0728\\list.txt"));
        Object obj = ois.readObject();
        //将OBJ转为ArrayList集合
        ArrayList<Person>list02=(ArrayList<Person>)obj;
        for (Person person : list02) {
            System.out.println(person);
        }
        //释放资源
        ois.close();
        oos.close();
    }
}
