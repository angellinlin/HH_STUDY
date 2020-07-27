package cn.com.spdb.testidea11;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestReader {
    public static void main(String[] args) {
        FileReader fr = null;
        FileWriter fw = null;
        try {
           fr = new FileReader("baobaojiu.txt");
            char[] chars = new char[1024];
            int len = 0;//放读取的有效个数
            while ((len=fr.read(chars))!=-1){
                System.out.println(new String(chars,0,len));
            }
           fw = new FileWriter("baobaojiu.txt",true);
            for (int i = 0; i <10 ; i++) {
                String name = "ergouzi";
                char[] chars1 = name.toCharArray();
                fw.write(chars1);
                String nihaoma = "nihaoma";
                fw.write("\r\n");
                fw.write(nihaoma);
                fw.write("\r\n");
            }
        }
        catch (IOException e){
            System.out.println(e);
        }finally {
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }





    }
}
