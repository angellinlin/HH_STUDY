package cn.swjtu.demo01.File;

import java.io.File;
import java.io.IOException;

/*
public boolean creatNewFile():当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。
创建文件的路径和名称在构造方法中给出（构造方法参数）
返回值：
    true:文件不存在，创建文件，返回true
    false:文件存在，不会创建，返回false
注意事项：
1、此方法只能创建文件，不能创建文件夹。
2、创建文件的路径必须存在，否则会抛出异常。
createNewFile声明抛出了异常IOException，我们调用此方法时，要么try/catch,要么throws

public boolean mkdir():创建由此File表示的目录。创建单级空文件夹。
public boolean mkdirs():创建由此File表示的目录,包括任何必需但不存在的父目录。即可创建单级空文件夹，也可创建多级空文件夹。
创建文件夹的路径和名称在构造方法中给出（构造方法参数）
返回值：
    true:文件夹不存在，创建文件夹，返回true
    false:文件夹存在，不会创建，返回false，构造方法中给出的路径不存在也返回false
注意事项：此方法只能创建文件夹，不能创建文件。

public boolean delete():删除由此File表示的文件或目录。此方法可删除构造方法中给出的文件/文件夹。
返回值：
    true 文件/文件夹删除成功
    false：文件夹中有内容，不会删除，返回false
            构造方法中路径不存在，返回false
注意：delete方法是直接在硬盘删除文件/文件夹，不走回收站，删除要谨慎

 */
public class Demo05File {
    public static void main(String[] args) throws IOException {
        show01();
        System.out.println("---------");
        show02();
        System.out.println("---------");
        show03();
    }

    private static void show03() {
        File file1= new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\新建文件夹");
        System.out.println(file1.delete());

        File file2=new File("abc.txt");
        System.out.println(file2.delete());
    }

    private static void show02() {
        File file1=new File("AAA");
        boolean b1=file1.mkdir();
        System.out.println(b1);

        File file2=new File("111\\222\\333");
        System.out.println(file2.mkdirs());

        File file3=new File("abc.txt");
        System.out.println(file3.mkdir());  //创建的是名叫abc.txt的文件夹

        File file4=new File("08\\abc.txt");
        System.out.println(file4.mkdir());  //路径不存在，返回false
    }

    public static void show01() throws IOException {
        File file1 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\1.txt");
        boolean b1 = file1.createNewFile();
        System.out.println(b1);

        File file2 = new File("2.txt");
        boolean b2 = file2.createNewFile();
        System.out.println(b2);

        File file3 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\新建文件夹");
        System.out.println(file3.createNewFile());  //这也是创建一个文件，不要看名称，要看类型

       /* File file4 = new File("FileAndRecursion\\3.txt");
        System.out.println(file4.createNewFile());  //路径不存在，抛出异常*/
    }
}
