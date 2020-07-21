package net;

import operator.ServerThread;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    private static ServerSocket serverSocket;

    public static void main(String[] args) {
        new Server();
    }

    public Server(){
        try {
            //指定监听端口
            serverSocket = new ServerSocket(1017);
            System.out.println("服务器已启动，等待客户端连接...");
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true){
            try {
                Socket socket = serverSocket.accept(); //通过accept（）方法监听客户端请求。
                System.out.println("客户端："+socket.getInetAddress().getHostName()+"已连接到服务器");
                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
