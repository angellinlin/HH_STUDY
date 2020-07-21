package net;

import java.io.*;
import java.net.Socket;

public class Client {

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;


    public Client(){
        try {
            socket = new Socket("127.0.0.1",1017);
            System.out.println("客户端连接上服务器！");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client getClient(){
        return ClientContainer.client;
    }

    // 发送字符串到服务器端，并返回服务器的处理结果
    public String sendMessageToSever(String message){
        String result = "";

        try {
            out.writeUTF(message);  //向服务器发送消息
            System.out.println("向服务器发送："+message);
            result = in.readUTF();  //读取服务器返回的结果
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public void closeClient(){
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
