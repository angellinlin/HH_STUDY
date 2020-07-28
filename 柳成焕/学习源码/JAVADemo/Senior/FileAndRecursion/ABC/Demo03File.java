package cn.swjtu.demo01.File;

import java.io.File;

/*
public String getAbsolutePath():返回File类的绝对路径字符串，无论路径是相对的还是绝对的，getAbsolutePath方法返回的都是绝对路径。
public String getPath():将此File转换为路径名字符串（toString方法调用的其实就是getPath方法）
public String getName():返回由此File表示的文件或目录名称。获取的就是构造方法传递路径的结尾部分（文件/文件夹）
public long length():返回由此File类表示的文件的长度。获取的是构造方法指定的文件的大小，以字节为单位。
注意：
    1、文件夹是没有大小概念的，所以不能获取文件夹的大小。
    2、如果构造方法中给出的路径不存在，那么length方法返回0.

 */
public class Demo03File {
    public static void main(String[] args) {
        show01();
        System.out.println("=======");
        show02();
        System.out.println("------------");
        show03();
        System.out.println("-------------");
        show04();
    }

    private static void show04() {
        File file1 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\1.png");
        long l1 = file1.length();
        System.out.println(l1);  //182005

        File file2=new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\2.png");
        System.out.println(file2.length());  //路径不存在，返回0

        File file3=new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\a");
        System.out.println(file3.length());  //文件夹没有大小概念，返回0
    }

    //public String getName():返回由此File表示的文件或目录名称。获取的就是构造方法传递路径的结尾部分（文件/文件夹）
    private static void show03() {
        File file1 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\a.txt");
        String name1 = file1.getName();
        System.out.println(name1);//a.txt

        File file2 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion");
        String name2 = file2.getName();
        System.out.println(name2);//FileAndRecursion
    }

    //public String getPath():将此File转换为路径名字符串
    private static void show02() {
        File file1 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\a.txt");
        String path1 = file1.getPath();
        System.out.println(path1);//F:\JAVADemo\Senior\FileAndRecursion\a.txt

        File file2 = new File("b.txt");
        String path2 = file2.getPath();
        System.out.println(path2);//b.txt

        System.out.println(file1);//F:\JAVADemo\Senior\FileAndRecursion\a.txt
        //toString方法调用的其实就是getPath方法
        System.out.println(file1.toString());//F:\JAVADemo\Senior\FileAndRecursion\a.txt
    }

    /*public String getAbsolutePath():返回File类的绝对路径字符串
    获取的构造方法中的路径，无论路径是相对的还是绝对的，getAbsolutePath方法返回的都是绝对路径。
     */
    public static void show01() {
        File file1 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\a.txt");
        String absolutePath1 = file1.getAbsolutePath();
        System.out.println(file1);//F:\JAVADemo\Senior\FileAndRecursion\a.txt

        File file2 = new File("b.txt");
        String absolutePath2 = file2.getAbsolutePath();
        System.out.println(absolutePath2);//F:\JAVADemo\Senior\FileAndRecursion\b.txt
    }
}
