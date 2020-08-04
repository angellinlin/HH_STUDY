package cn.swjtu.demo03.FileUploadPlus;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/*
1、客户端使用本地的字节输入流读取要上传的文件；
2、客户端使用网络字节输出流把读取到的文件上传到服务器；
6、客户端使用网络字节输入流速去服务器回写的数据；
7、释放资源

 void shutdownOutput() 禁用此套接字的输出流。
 对于 TCP 套接字，任何以前写入的数据都将被发送，并且后跟 TCP 的正常连接终止序列。
 */
public class TCPClient {
    public static void main(String[] args) throws IOException {
        //创建本地字节输入流
        FileInputStream fis = new FileInputStream("D:\\1.jpg");
        //创建客户端对象
        Socket socket = new Socket("127.0.0.1", 8888);
        //创建客户端字节输出流
        OutputStream os = socket.getOutputStream();
        //使用read方法读取本地文件
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len=fis.read(bytes)) != -1) {
            //向服务器端发送此文件
            os.write(bytes, 0, len);
        }
        //增加一个结束标记
        socket.shutdownOutput();
        //接收服务器端发送的消息
        InputStream is = socket.getInputStream();
        while ((len=is.read(bytes)) != -1) {
            //打印服务器发送过来的消息
            System.out.println(new String(bytes, 0, len));
        }
        //释放资源
        fis.close();
        socket.close();
    }
}
