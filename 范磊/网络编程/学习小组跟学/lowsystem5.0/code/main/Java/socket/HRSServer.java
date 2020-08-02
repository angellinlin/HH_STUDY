package socket;

import JDBC.MySQLConnect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

public class HRSServer {

    static ServerSocket server = null;  // 设置监控端口
    static Socket socketConnect = null; // 构建与Clinet 通信得socket返回对象
    int threadPoolSzie = 5;


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
                // 开启线程
                ServerThread serverThread = new ServerThread(socketConnect);
                /*serverThread.start();*/

                // 补充一个线程池方法 ThreadPool
                ExecutorService executorService = newFixedThreadPool(threadPoolSzie);
                executorService.submit(serverThread);

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
