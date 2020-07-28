package cn.swjtu.demo01.File;

import java.io.File;

/*
java.io.File类：文件和目录路径名的抽象表示形式。
    java把电脑中的文件和文件夹（目录）封装为File类，我们可以使用File类对文件和文件夹进行操作。
    我们可以使用File类的方法：创建一个文件/文件夹、删除文件/文件夹、获取文件/文件夹、判断文件/文件夹是否存在、对文件夹进行遍历、获取文件的大小。
File是一个与系统无关的类，任何的操作系统都可以使用这个类中的方法。
重点记住三个单词：
    file 文件
    directory：文件夹/目录
    path：路径


static String pathSeparator 系统有关的路径分隔符，为了方便，它被表示为一个字符串。
static char pathSeparatorChar 与系统有关的路径分隔符。（路径分隔符windows分号； linux冒号：）
static String separator 系统有关的默认名称分隔符，为了方便，它被表示为一个字符串。
static char separatorChar 与系统有关的默认名称分隔符。（文件名称分隔符 windows反斜杠\ ,linux正斜杠/）

操作路径：路径不能写死了。
C:\develop\a\a.txt  windows
C:/develop/a/a.txt   linux
"C:"+File.separator+"develop"+File.separator+"a"+File.separator+"a.txt"
 */
public class Demo01File {
    public static void main(String[] args) {
        String str1=File.pathSeparator;
        System.out.println(str1);  //路径分隔符windows分号； linux冒号：

        System.out.println(File.pathSeparatorChar);   //;

        String str2=File.separator;
        System.out.println(str2);  //文件名称分隔符 windows反斜杠\ ,linux正斜杠/
    }
}
