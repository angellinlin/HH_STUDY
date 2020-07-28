package cn.swjtu.demo03.Filter;

import java.io.File;

/*
使用递归打印多级目录，只打印以.java结束的文件。
思路：定义一个方法，参数传递File类型的目录。
     方法中对目录进行遍历,只要.java结尾的文件

我们可以使用过滤器来实现。
在File类中有两个和ListFiles重载的方法，方法的参数传递的就是过滤器。
1、File[] listFiles(FileFilter filter)返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
java.io.FileFilter接口：用于抽象路径名（File对象）的过滤器。
    作用：用来过滤文件的。
    抽象方法：过滤文件的方法。boolean accept(File pathname)
    参数：使用ListFiles方法遍历目录，得到的每一个文件对象。
2、File[] listFiles(FilenameFilter filter)返回抽象路径名数组，这些路径名表示此抽象路径名表示的目录中满足指定过滤器的文件和目录。
java.io.FilenameFilter接口：实现此接口的类实例可用于过滤器文件名
    作用：用来过滤文件名称。
    抽象方法：用来过滤文件的方法。boolean accept(File dir, String name)
    参数：File dir构造方法中传递的被遍历的目录，String name使用ListFiles方法遍历目录，获取的每一个文件/文件夹名称

注意：
    两个过滤器接口是没有实现类的。需要我们自己写实现类，重写过滤的方法accept,在方法中自己定义过滤的规则。

    1.过滤器中的accept方法是谁调用的？
    2.accept方法的参数pathname是什么？
 */
public class Demo01Filter {

    public static void main(String[] args) {
        File file = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\ABC");
        getAllFiles(file);
    }

    public static void getAllFiles(File dir) {
        /*
        listFiles一共做了三件事情：
        1、listFiles方法会对构造方法中传递的目录进行遍历，获取目录中的每一个文件/文件夹-->封装为File对象；
        2、listFiles方法会调用参数传递的过滤器中的方法accept；
        3、listFiles会把遍历得到的每一个file对象，传递给accept方法的参数pathname。

        accept方法返回值是一个boolean值：
        true：就会把传递过去的File对象保存到File数组中
        false：就不会把传递过去的File对象保存到File数组中
         */
        File[] files = dir.listFiles(new FileFilterImpl());  //传递过滤器对象

        for (File file : files) {
            if (file.isDirectory()) {  //如果是文件夹，则继续遍历
                getAllFiles(file);
            } else {
                System.out.println(file); //否则直接打印文件
            }

        }
    }
}
