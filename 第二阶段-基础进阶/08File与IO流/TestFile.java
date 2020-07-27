package cn.com.spdb.testidea11;

import java.io.File;
import java.io.IOException;

//把文件和文件夹封装为了一个file类
public class TestFile {
    public static void main(String[] args) throws IOException {
        File file = new File("C:"+File.separator+"Users"+File.separator+"BBJ"+File.separator+"Desktop"+File.separator+"xumafei.txt");
        System.out.println(file);//C:\Users\BBJ\Desktop\jiujiu.txt
        System.out.println(file.getName());//jiujiu.txt
        System.out.println(file.length());//0
        System.out.println(file.getAbsolutePath());//C:\Users\BBJ\Desktop\jiujiu.txt
        System.out.println(file.getPath());//C:\Users\BBJ\Desktop\jiujiu.txt
        System.out.println(file.exists());//判断这个目录存不存在
        System.out.println(file.isDirectory());//判断这是不是目录
        System.out.println(file.isFile());//判断这是不是文件

        File file1 = new File("C:"+File.separator+"Users"+
                File.separator+"BBJ"+File.separator+"Desktop"+
                File.separator+"嘿嘿.txt");
        //只能创建文件不能创建文件夹，路径必须存在否则会抛出异常
        boolean b = file1.createNewFile();//处理异常,抛出IO异常
        System.out.println(b);
        boolean delete = file1.delete();//删除
        System.out.println(delete);

        File file2 = new File("C:"+File.separator+"Users"+
                File.separator+"BBJ"+File.separator+"Desktop"+
                File.separator+"aaa");
        file2.mkdirs();
        File file3 = new File("aaa");
        boolean aaa = file3.mkdir();
        System.out.println(aaa);
        file3.delete();

    }
}
