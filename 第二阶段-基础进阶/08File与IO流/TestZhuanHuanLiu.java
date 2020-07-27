package cn.com.spdb.testidea11;

import java.io.*;

public class TestZhuanHuanLiu {
    public static void main(String[] args) throws IOException {
        OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("baobaojiu.txt",true),"utf-8");
        osw.write("你好");
        InputStreamReader isr = new InputStreamReader(new FileInputStream("baobaojiu.txt"));
        int len = 0;
        while ((len=isr.read())!=-1){
            System.out.println((char)len);
        }
        osw.close();
        isr.close();

    }
}
