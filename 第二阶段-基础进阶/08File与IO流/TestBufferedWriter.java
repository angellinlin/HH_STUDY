package cn.com.spdb.testidea11;

import java.io.*;

public class TestBufferedWriter {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter("baobaojiu.txt",true));
        for (int i = 0; i <10 ; i++) {
            bw.write("heihei");
            bw.newLine();//分行
        }
        BufferedReader br = new BufferedReader(new FileReader("baobaojiu.txt"));
        char[] chars = new char[1024];
        int len = 0;
        while ((len = br.read(chars))!=-1){
            System.out.println(new String(chars,0,len));
        }

        String line;
        while ((line = br.readLine())!=null){
            System.out.println(line);
        }
        bw.close();
        br.close();
    }
}

