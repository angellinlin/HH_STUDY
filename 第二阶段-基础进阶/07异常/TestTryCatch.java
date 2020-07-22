package cn.com.spdb.testidea10;

import java.io.FileNotFoundException;

public class TestTryCatch {
    public static void main(String[] args)  {
        try {
            method("xxx");
        } catch (FileNotFoundException e) {
//            System.out.println("传递的文件后缀名不是.txt");
//            String message = e.getMessage();
//            String s = e.toString();
//            System.out.println(s);
            e.printStackTrace();
        }
        System.out.println("后续代码");
    }

    public static void method(String Filename) throws FileNotFoundException {
        if(!Filename.equals("c:/a.txt")) {
            throw new FileNotFoundException("传递的文件路径不正确");
        }
//        Objects.requireNonNull(obj,"空");
    }
}
