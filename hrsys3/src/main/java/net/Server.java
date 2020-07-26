package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sy
 * @date 2020/7/26 16:38
 */
public class Server {
    static ServerSocket serverSocket;
    Socket socket;

    public Server() {
        try {
            serverSocket = new ServerSocket(1680);
        } catch (IOException e) {
            e.printStackTrace();
        }
        while (true){
            try {
                socket = serverSocket.accept();
                System.out.println("客户端接入");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
