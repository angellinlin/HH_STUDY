package cn.swjtu.demo04.BSTCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
创建BS版本的TCP服务器
 */
public class TCPServer {
    public static void main(String[] args) throws IOException {
        //创建一个服务器ServerSocket，指定端口号
        ServerSocket server = new ServerSocket(8080);

        /*
        浏览器解析服务回写的html页面，页面中如果有图片，那么浏览器会单独开启一个线程，读取服务器的图片
        我们就让服务器一直处于监听状态，客户端请求一次，服务器就回写一次。
         */
        while (true) {
            //使用accept方法获取到请求的客户端对象
            Socket socket = server.accept();
            //开启线程
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        //使用socket中的方法获取到网络字节输入流
                        InputStream is = socket.getInputStream();
                        //使用网络字节输入流对象的方法read读取客户端的请求信息的第一行
                        //把网络字节输入流对象转为字符缓冲输入流
                        BufferedReader br = new BufferedReader(new InputStreamReader(is));  //InputStreamReader转换流
                        //把客户端请求信息的第一行读取出来  Get /Net0731/web/index.html HTP/1.1
                        String line = br.readLine();
                        //把读取的信息进行切割，只要中间的部分  /Net0731/web/index.html
                        String[] arr = line.split(" ");
                        //把路径前边的/去掉，进行截取
                        String htmlPath = arr[1].substring(1);

                        //创建一个本地字节输入流，构造方法中绑定要读取的html路径
                        FileInputStream fis = new FileInputStream(htmlPath);
                        //使用socket中的方法getOutputSteam获取网络字节输出流对象
                        OutputStream os = socket.getOutputStream();
                        //写入HTTP协议头，固定写法
                        os.write("HTTP/1.1 200 OK\r\n".getBytes());
                        os.write("Content-Type:text/html\r\n".getBytes());
                        //你需要写入空行，否则浏览器不解析
                        os.write("\r\n".getBytes());

                        //一读一写复制文件，把服务器读取的html文件回写到客户端
                        int len = 0;
                        byte[] bytes = new byte[1024];
                        while ((len = fis.read(bytes)) != -1) {
                            os.write(bytes, 0, len);
                        }
                        //释放资源
                        fis.close();
                        socket.close();
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                }
            }).start();
        }
    }
        //-server.close();
}

