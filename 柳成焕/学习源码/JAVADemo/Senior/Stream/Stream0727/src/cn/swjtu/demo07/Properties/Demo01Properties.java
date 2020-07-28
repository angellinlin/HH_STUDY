package cn.swjtu.demo07.Properties;

import java.io.*;
import java.util.Properties;
import java.util.Set;

/*
java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>
Properties类表示了一个持久的属性集。Properties 可保存在流中或从流中加载。
Properties是唯一一个和IO流相结合的集合。
可以使用Properties集合中的方法store把集合中的临时数据，持久化写入到硬盘中存储。
可以使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用。

属性列表中每个键及其对应值都是一个字符串。
Properties集合是一个双列集合，key和value都默认是字符串。
Object setProperty(String key, String value) 调用 Hashtable 的方法 put。
String getProperty(String key, String defaultValue) 通过key找到value值，此方法相当于Map集合中的get(key)方法
Set<String> stringPropertyNames() 返回此属性列表中的键集，其中该键及其对应值是字符串。此方法相当于Map集合中的keySet方法。

可以使用Properties集合中的方法store把集合中的临时数据，持久化写入到硬盘中存储。
 void store(OutputStream out, String comments)
 void store(Writer writer, String comments)
 参数：OutputStream out字节输出流，不能写入中文
      Writer writer字符输出流，可以写中文
      String comments注释，用来解释说明保存的文件是做什么用的。（不能使用中文，会产生乱码，默认是Unicode，一般使用""空字符串）

使用步骤：
    1、创建Properties集合对象，添加数据
    2、创建字符/字节输出流对象，构造方法中绑定要输出的目的地
    3、使用集合Properties中的方法store把集合中的临时数据，持久化写入到硬盘中存储。


可以使用Properties集合中的方法load，把硬盘中保存的文件（键值对），读取到集合中使用。
 void load(InputStream inStream)
 void load(Reader reader)
    参数：Reader reader字符输入流，能读取含有中文的键值对
         InputStream inStream字节输入流，不能读取含有中文的键值对。
 使用步骤：
 1、创建一个Properties集合对象；
 2、使用Properties集合对象中的方法load读取保存键值对的文件；
 3、遍历Properties集合；

 注意事项：
 1、存储键值对的文件中，键与值得默认连接符号可以使用=，空格（其他符号）；
 2、存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取；
 3、存储键值对的文件中，键与值默认都是字符串，不用再加引号。
 */
public class Demo01Properties {
    public static void main(String[] args) throws IOException {
        //show01();
        //show02();
        show03();
    }

    private static void show03() throws IOException {
        //1、创建一个Properties集合对象；
        Properties prop = new Properties();
        //2、使用Properties集合对象中的方法load读取保存键值对的文件；
        prop.load(new FileReader("Stream0727\\prop.txt"));
        //3、遍历Properties集合；
        Set<String> set = prop.stringPropertyNames();
        //遍历set集合
        for (String key : set) {
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }

    private static void show02() throws IOException {
        //1、创建Properties集合对象，添加数据
        Properties prop = new Properties();
        //使用setProperty往集合中添加数据
        prop.setProperty("孙尚香", "100");
        prop.setProperty("芈月", "85");
        prop.setProperty("王昭君", "90");
        // 2、创建字符/字节输出流对象，构造方法中绑定要输出的目的地
        /*FileWriter fw=new FileWriter("Stream0727\\prop.txt"); //字符流
        //3、使用集合Properties中的方法store把集合中的临时数据，持久化写入到硬盘中存储。
        prop.store(fw,"store data");
        //4、释放资源
        fw.close();*/
        //创建字节流的匿名对象，由于不能写入中文，所以显示乱码，并且匿名对象会自动释放资源。
        prop.store(new FileOutputStream("Stream0727\\prop2.txt"), "store data by FileOutputStream");

    }

    /*使用Properties集合存储数据，遍历取出Properties集合中的数据*/
    private static void show01() {
        //创建Properties集合对象
        Properties prop = new Properties();
        //使用setProperty往集合中添加数据
        prop.setProperty("孙尚香", "100");
        prop.setProperty("芈月", "85");
        prop.setProperty("王昭君", "90");
        //使用stringPropertyNames方法把Properties集合中的键取出，存储到一个Set集合中
        Set<String> set = prop.stringPropertyNames();
        //遍历set集合，取出Properties集合的每一个键
        for (String key : set) {
            //使用getProperty方法通过key获取value
            String value = prop.getProperty(key);
            System.out.println(key + "=" + value);
        }
    }
}
