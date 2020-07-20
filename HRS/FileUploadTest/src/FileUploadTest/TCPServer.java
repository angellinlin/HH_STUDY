package FileUploadTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        File file = new File("C:/Users/shanshan/Desktop/upload");
        if (!file.exists()) {
            file.mkdirs();
        }
        //自定义命名
        String filename=System.currentTimeMillis()+new Random().nextInt(99999)+".jpg";
        FileOutputStream fos = new FileOutputStream(file + "/"+filename);

        int len = 0;
        byte[] bytes = new byte[1024];
        while ((len = is.read(bytes)) != -1) //wile循环读取不到结束标记，read方法会阻塞
        {
            fos.write(bytes, 0, len);
        }
        socket.getOutputStream().write("上传成功！".getBytes());
        fos.close();
        socket.close();
        server.close();
    }
}
