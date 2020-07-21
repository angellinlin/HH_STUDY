package socket;

import JDBC.MySQLConnect;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class HRSServer {

    ServerSocket server = null;  // 设置监控端口
    Socket socketConnect = null; // 构建与Clinet 通信得socket返回对象

    public HRSServer() {
        try {
            server = new ServerSocket(9191);
            System.out.println("Server启动，等待客户端连接！");

        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true) {
            try {
                socketConnect = server.accept();
                System.out.println("客户端连接成功！");
                ServerThread serverThread = new ServerThread(socketConnect);
                serverThread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }



    public static void main(String[] args) {
        new MySQLConnect();
        new HRSServer();


    }
}
