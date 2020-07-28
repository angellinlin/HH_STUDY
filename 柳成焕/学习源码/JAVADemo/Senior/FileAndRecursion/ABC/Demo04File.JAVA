package cn.swjtu.demo01.File;

import java.io.File;

/*
public boolean exists():由File表示的文件或目录是否实际存在。存在：true，不存在：false
public boolean isDirectory():由File表示的是否为目录。用于判断构造方法中的路径是否以文件夹结尾。
public boolean isFile():由File表示的是否为文件用于判断构造方法中的路径是否为文件。
注意：电脑硬盘中只有文件和文件夹，两个方法是互斥的。
     使用前提：路径必须存在，否则都返回false。
 */
public class Demo04File {
    public static void main(String[] args) {
        show01();
        System.out.println("-------");
        show02();
    }

    private static void show02() {
        File file1=new File("F:\\JAVADemo\\Senior\\FileAndRecursionAAA");
        //不存在就没有必要获取
        if(file1.exists()){     }
        File file2=new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\a\\1.png");
        System.out.println(file2.isFile());  //文件，true
        System.out.println(file2.isDirectory()); //false

    }

    public static void show01(){
        File file1=new File("F:\\JAVADemo\\Senior\\FileAndRecursion");
        System.out.println(file1.exists());  //路径存在，true

        File file2=new File("F:\\JAVADemo\\Senior\\FileAndRecursionAAA");
        System.out.println(file2.exists());  //路径不存在，false

        File file3=new File("FileAndRecursion0724");//其实是"F:\\JAVADemo\\Senior\\FileAndRecursion\\FileAndRecursion0724"
        System.out.println(file1.exists());  //相对路径，存在，true
    }
}
