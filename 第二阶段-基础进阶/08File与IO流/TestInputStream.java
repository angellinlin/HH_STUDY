package cn.com.spdb.testidea11;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class TestInputStream {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("baobaojiu.txt");
//        int len = fis.read();
//        System.out.println(len);
//        int len1 = fis.read();
//        System.out.println(len1);
//        int len2 = fis.read();
//        System.out.println(len2);

//        int le = 0;//记录读取的字节
//        while ((le = fis.read())!=-1){
//            System.out.println(le);
//        }
        byte[] b = new byte[2];
        int read = fis.read(b);
        System.out.println(Arrays.toString(b));
        System.out.println(new String(b));


        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = (fis.read(bytes)))!=-1){
            System.out.println(new String(bytes,0,len));//只转有效的
        }
        fis.close();
    }
}
