package cn.swjtu.demo02.FileUpload;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
3、服务器使用网络字节输入流读取客户端上传的文件；
4、服务器使用本地的字节输出流把读取到的文件保存到服务器的硬盘上；
5、服务器使用网络字节输出流给客户端回写一个“上传成功！”；
7、释放资源


 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //3、服务器使用网络字节输入流读取客户端上传的文件；
        ServerSocket server = new ServerSocket(8888);
        Socket socket = server.accept();
        InputStream is = socket.getInputStream();
        //判断f盘是否有upload文件夹，没有则创建
        File file = new File("F:\\upload");
        if (!file.exists()) {
            file.mkdir();  //不存在就创建
        }
        //创建本地字节输出流
        FileOutputStream fos = new FileOutputStream(file+"\\1.jpg");
        //接收客户端端发送的文件
        byte[] bytes = new byte[1024];
        int len = 0;  //读取文件
        System.out.println("111111while循环之前");
        while ((len = is.read(bytes)) != -1) {
            fos.write(bytes, 0, len);
        }
        System.out.println("22222while之后，执行不到");
        //5、服务器使用网络字节输出流给客户端回写一个“上传成功！”；
        //创建服务器字节输出流
        OutputStream os = socket.getOutputStream();
        //向服务器端发送此文件
        os.write("上传成功！".getBytes());
        //释放资源
        fos.close();
        socket.close();
        server.close();
    }
}
