package cn.swjtu.demo02.Recursion;

import java.io.File;

/*
使用递归打印多级目录
思路：定义一个方法，参数传递File类型的目录。
     方法中对目录进行遍历

 */
public class Demo04Recursion {
    public static void main(String[] args) {
        File file = new File("F:\\JAVADemo\\Senior\\FileAndRecursion\\ABC");
        getAllFiles(file);
    }

    /*
     发现直接遍历的结果并不完全，只有文件夹下的内容，没有子文件夹下的内容。
     解决：对遍历得到的file对象进行判断是否是文件夹，是则继续调用getAllFiles
    */
    public static void getAllFiles(File dir) {

        System.out.println(dir);
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {  //如果是文件夹，则继续遍历
                getAllFiles(file);
            } else {
                System.out.println(file); //否则直接打印文件
            }

        }
    }
}
