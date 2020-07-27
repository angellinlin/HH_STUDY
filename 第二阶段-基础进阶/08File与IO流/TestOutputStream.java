package cn.com.spdb.testidea11;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestOutputStream {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("baobaojiu.txt",true);//在项目下创建的
        byte[] bytes = new byte[]{65,67,68,69,70};
        fos.write(bytes);
        for (int i = 0; i <10 ; i++) {
            String name = "goudan";
            byte[] bytes1 = name.getBytes();
            fos.write(bytes1);
            fos.write("\r\n".getBytes());
        }

        fos.close();
    }
}
