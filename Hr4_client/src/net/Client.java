package net;

import main.mainClass;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;


public class Client {

    BufferedReader in;
    PrintWriter out;
    Socket tcpConnection;

    public Client() {
        try {
            tcpConnection = new Socket("127.0.0.1", 1235);
            System.out.println("连接上服务器了");
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);


        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static class clientContainer {
        private static Client client = new Client();
    }

    public static Client getClient() {
        return clientContainer.client;
    }

    public String sendMessageToSever(String message)//�����ַ���ȥ�ͷ���
    {
        String str = "";
        try {
            out.println(message);
			System.out.println("向服务器发送  "+message);
            str = in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str;
    }

    public void closeClient()//�رտͻ��˲��ر�����
    {
        try {
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        new Client();
        new mainClass();
    }

}
