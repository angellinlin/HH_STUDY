package cn.swjtu.demo01.File;

import java.io.File;

/*
public String[] list():返回一个String数组，表示该File目录下的所有子文件或目录。
遍历构造方法中给出的目录，会获取目录中所有的文件/文件夹的名称，把获取到的多个名称存储到一个String类型数组中。

public File[] listFiles():返回一个File数组，表示该File目录下所有的子文件或目录。
遍历构造方法中给出的目录，会获取目录中所有的文件/文件夹的，把文件/文件夹封装为File对象，多个File对象存储到File数组中。

注意：
1、list方法和listFiles方法遍历的是构造方法给出的目录；
   如果构造方法中给出的目录路径不存在，则会抛出空指针异常
   如果构造方法中给出的路径不是一个目录，也会抛出空指针异常

 */
public class Demo06File {
    public static void main(String[] args) {
        show01();
        System.out.println("----------------");
        show02();
    }

    private static void show02() {
        File file01 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion");
        File[] files=file01.listFiles();
        for (File file : files) {
            System.out.println(file);
        }
    }

    public static void show01() {
        File file01 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion");
        //File file01 = new File("F:\\JAVADemo\\Senior\\FileAndRecursionAAA");
        //File file01 = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\1.txt");
        String[] arr1 = file01.list();
        for (String s : arr1) {
            System.out.println(s);
        }
    }
}
