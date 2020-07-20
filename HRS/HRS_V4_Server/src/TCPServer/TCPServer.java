package TCPServer;

import Operation.ServerThread;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {
    public static void main(String[] args) {
        new TCPServer();
    }

    ServerSocket server;
    Socket socket;

    public TCPServer() {
        try {
            server = new ServerSocket(8888);
            System.out.println("服务器已启动，等待客户端连接···");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            socket = server.accept();//该方法阻塞当前线程，直到建立连接为止
            System.out.println("有客户端已连接！");
            ServerThread r = new ServerThread(socket);
            r.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
