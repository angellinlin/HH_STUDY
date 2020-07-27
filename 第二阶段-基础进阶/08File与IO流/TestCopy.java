package cn.com.spdb.testidea11;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TestCopy {
    public static void main(String[] args) throws IOException {
        //读
        FileInputStream fis = new FileInputStream("baobaojiu.txt");
        FileOutputStream fos = new FileOutputStream("ningning.txt");
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=fis.read(bytes))!=-1){
            fos.write(bytes,0,len);
        }
        fos.close();
        fis.close();
    }
}
