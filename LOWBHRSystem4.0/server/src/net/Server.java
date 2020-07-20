package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

public class Server {
    static ServerSocket ss;
    static Socket s;
    static BufferedReader socIn;
    static PrintWriter socOut;

    /*
    客户端——服务器连接成功后以字节流交互
    服务器没有IO流的，使用客户端Socket提供的IO流与客户端交互
     */

    public Server(){
        try{
            int port = 22333;
            ss = new ServerSocket(port);
            System.out.println("服务器已启动，等待客户端的连接！");
            s = ss.accept();
            System.out.println("有客户端连接上!");
            socIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            socOut = new PrintWriter(s.getOutputStream());
        }
        catch(IOException e){
            e.printStackTrace();
            System.out.println("服务器启动失败！");
        }
    }

    //从客户端读取报文信息
    public static String readMessage(){

        String res;
        try {
            res = socIn.readLine();
            System.out.println("从客户端接收信息：" + res);
        }
        catch(IOException e){
            System.out.println("从客户端读取信息失败！");
            res = null;
            e.printStackTrace();
        }

        return res;
    }

    public static void sendMessage(String str){

        socOut.println(str);
        socOut.flush();
        System.out.println("向客户端发送信息：" + str);

    }

    /*
    关闭服务器，并向客户端返回“Bye”信息
     */
    public static void closeServer(){

        try {
            socOut.println("Bye");
            socOut.flush();
            socIn.close();
            socOut.close();
            s.close();
            ss.close();
        }
        catch(IOException e){
            System.out.println("关闭服务器失败！");
            e.printStackTrace();
        }
    }
}


