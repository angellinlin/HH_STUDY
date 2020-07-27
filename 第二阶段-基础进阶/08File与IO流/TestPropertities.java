package cn.com.spdb.testidea11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

public class TestPropertities {
    public static void main(String[] args) throws IOException {
        FileWriter fw = new FileWriter("baobaojiu.txt",true);
        FileReader fr = new FileReader("baobaojiu.txt");

        Properties pp = new Properties();
        //都必须是字符串
        pp.setProperty("我是","金吒");
        pp.setProperty("你是","木吒");
        pp.setProperty("他是","哪吒");

        //把键值取出存到set集合中进行遍历
        Set<String> strings = pp.stringPropertyNames();
        for (String i:strings) {
            System.out.println(pp.getProperty(i));
        }

        pp.store(fw,"");//注释不能使用中文，一般使用空字符串
        pp.load(fr);
        Set<String> strings1 = pp.stringPropertyNames();
        for (String i:strings1) {
            System.out.println(pp.getProperty(i));
        }

        fw.close();
        fr.close();

    }
}
