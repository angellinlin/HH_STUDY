package cn.swjtu.demo01.File;

import java.io.File;

/*
路径：绝对路径和相对路径。
绝对路径：是一个完整地路径。
        以盘符开始的路径C:\\a.txt
        F:\\JAVADemo\\Senior\\FileAndRecursion\\123.txt
相对路径：是一个简化的路径
    相对于当前项目的根目录: F:\\JAVADemo\\Senior\\FileAndRecursion
    如果使用当前项目的根目录，路径可以简化为：F:\\JAVADemo\\Senior\\FileAndRecursion\\123.txt-->简化为：123.txt（可以省略项目的根目录）
注意：
1、路径是不区分大小写的；
2、路径中的文件名称分隔符windows使用反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠。

构造方法：
File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
参数：
    String pathname：字符串的路径名称
    路径可以是以文件结尾，也可以是以文件夹结尾
    路径可以是绝对路径，也可以是相对路径
    路径可以存在，也可以不存在
    创建File类对象只是把字符串路径封装为File类对象，不考虑真假情况

File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
参数：把路径分成了两部分
    String parent父路径，String child子路径
好处：父路径和子路径可单独书写，使用起来非常灵活；父路径和子路径都可以变化。

File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
参数：把路径分成了两部分
    File parent父路径, String child子路径
好处：
    父路径和子路径可单独书写，使用起来非常灵活；父路径和子路径都可以变化。
    父路径是File类型。可以使用File的一些方法对路径进行一些操作，再使用路径创建对象。

 */
public class Demo02File {
    public static void main(String[] args) {
        show01();
        //show02("C:\\","a.txt"); //C:\a.txt
        show02("d:\\", "a.txt"); //d:\a.txt

        show03(); //c:\hello.txt
    }

    /*
    File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
    参数：把路径分成了两部分
        File parent父路径, String child子路径
    好处：
        父路径和子路径可单独书写，使用起来非常灵活；父路径和子路径都可以变化。
        父路径是File类型。可以使用File的一些方法对路径进行一些操作，再使用路径创建对象。
     */
    private static void show03() {
        File parent = new File("c:\\");
        File file = new File(parent, "hello.txt");
        System.out.println(file);
    }

    /*
    File(String parent, String child) 根据 parent 路径名字符串和 child 路径名字符串创建一个新 File 实例。
参数：
    String parent父路径，String child子路径
好处：父路径和子路径可单独书写，使用起来非常灵活；父路径和子路径都可以变化。
     */
    private static void show02(String parent, String child) {
        File file1 = new File(parent, child);
        System.out.println(file1);

    }

    /*
    构造方法：
File(File parent, String child) 根据 parent 抽象路径名和 child 路径名字符串创建一个新 File 实例。
File(String pathname) 通过将给定路径名字符串转换为抽象路径名来创建一个新 File 实例。
参数：
    String pathname：字符串的路径名称
    路径可以是以文件结尾，也可以是以文件夹结尾
    路径可以是绝对路径，也可以是相对路径
    路径可以存在，也可以不存在
    创建File类对象只是把字符串路径封装为File类对象，不考虑真假情况
     */
    public static void show01() {
        //不存在的路径
        File file1 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\a.txt");
        System.out.println(file1);  //重写了toString方法

        //存在，且为文件夹结尾
        File file2 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion");
        System.out.println(file2);

        File file3 = new File("b.txt");
        System.out.println(file3);
    }
}
