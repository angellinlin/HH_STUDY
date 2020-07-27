package cn.com.spdb.testidea11;

import java.io.*;

public class TestBufferedOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("baobaojiu.txt",true);//不续写
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] bytes = new byte[]{65,66,67,68};
        bos.write(bytes);
        bos.write("你是大猪头".getBytes());

        FileInputStream fis = new FileInputStream("baobaojiu.txt");
        BufferedInputStream bis = new BufferedInputStream(fis);
        byte[] b = new byte[1024];
        int len = 0;
        while((len = bis.read(b))!=-1){
            System.out.println(new String(b,0,len));
        }
        bos.close();
        fos.close();
        bis.close();
        fis.close();
    }
}
