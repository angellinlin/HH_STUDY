package TCPClient;

import java.io.*;
import java.net.Socket;

public class TCPClient {
    public static void main(String[] args) {
        new TCPClient();
    }

    Socket socket;
    PrintWriter out;
    BufferedReader in;
    public TCPClient() {

        try {
            socket = new Socket("127.0.0.1", 8888);
            System.out.println("连接服务器成功！");
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向服务器发送字符串
    public String sendMessageToServer(String message) {
        String str = "";
        try {
            out.println(message);
            System.out.println("向服务器发送：" + message);
            str=in.readLine();//
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    //关闭服务器连接
    public void closeTCPClient() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
