package cn.swjtu.demo03.FileUploadPlus;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

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
        /*让服务器一直处于监听状态（死循环accept方法）
        有一个客户端上传文件，就保存一个文件 */
        while (true) {
            Socket socket = server.accept();
            /*使用多线程提高程序效率
            有一个客户端上传文件，就开启一个线程，完成文件的上传   */
            new Thread(new Runnable() {
                @Override
                public void run() {
                    //完成文件的上传
                    try {
                        InputStream is = socket.getInputStream();
                        //判断f盘是否有upload文件夹，没有则创建
                        File file = new File("F:\\upload");
                        if (!file.exists()) {
                            file.mkdir();  //不存在就创建
                        }
                         /*
                         自定义一个文件命名规则，防止被覆盖
                         规则：域名+毫秒值+随机数
                          */
                        String fileName = "LCH" + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
                        //创建本地字节输出流
                        FileOutputStream fos = new FileOutputStream(file + "\\" + fileName);
                        //接收客户端端发送的文件
                        byte[] bytes = new byte[1024];
                        int len = 0;  //读取文件
                        while ((len = is.read(bytes)) != -1) {
                            fos.write(bytes, 0, len);
                        }
                        //5、服务器使用网络字节输出流给客户端回写一个“上传成功！”；
                        //创建服务器字节输出流
                        OutputStream os = socket.getOutputStream();
                        //向服务器端发送此文件
                        os.write("上传成功！".getBytes());
                        //释放资源
                        fos.close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }).start();
        }
        //服务器一直启动，就不用关闭了
        //server.close();
    }
}
