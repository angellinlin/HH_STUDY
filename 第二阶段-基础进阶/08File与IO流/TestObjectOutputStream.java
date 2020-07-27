package cn.com.spdb.testidea11;

import java.io.*;

public class TestObjectOutputStream {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Object p1 = new Person("迪丽热巴",18);
        ObjectOutputStream oos;
        oos = new ObjectOutputStream(new FileOutputStream("baobaojiu.txt"));
        oos.writeObject(p1);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("baobaojiu.txt"));
        Object o = ois.readObject();
        ois.close();
        System.out.println(o);
        oos.close();

    }
}
