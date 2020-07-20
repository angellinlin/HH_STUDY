package net;

import java.io.IOException;
import java.net.Socket;
import java.io.*;

public class client {
    static Socket s;
    static BufferedReader socIn;
    static PrintWriter socOut;

    public client(){

        try {
            s = new Socket("127.0.0.1", 22333);
            System.out.println("连接上服务器了");
            socIn = new BufferedReader(new InputStreamReader(s.getInputStream()));
            socOut = new PrintWriter(s.getOutputStream());
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    //向服务器端发送了报文后，等待服务器返回处理结果
    public static String sendAndReadMessage(String str){

        String res;
        try{
            socOut.println(str);
            socOut.flush();
            System.out.println("向服务器发送： " + str);
            res = socIn.readLine();
            System.out.println("从服务器接收：" + res);
        }
        catch(IOException e){
            e.printStackTrace();
            res = null;
        }
        return res;
    }

    public static void closeClient(){

        try{
            socIn.close();
            socOut.close();
            s.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
