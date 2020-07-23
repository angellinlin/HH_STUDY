package Client;

import bean.TranProtocol;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class HRSClient {

    BufferedReader bufferedReader;
    PrintWriter printWriter;
    Socket socketConnect;


    public HRSClient() {
        try {
            socketConnect = new Socket("127.0.0.1", 9191);
            System.out.println("Server连接成功！");
            bufferedReader = new BufferedReader(new InputStreamReader(socketConnect.getInputStream())); //读取服务器发回数据
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketConnect.getOutputStream())), true); // 读取发给Server的数据

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 单例模式 构建一个私有类来专门实例化HRSclient

    private static class ClientContainer {
        private static HRSClient hrsClient = new HRSClient();
    }
    public HRSClient getClientContainer() {
        return ClientContainer.hrsClient;
    }


    // 此处用于融入传输的数据帧  根据不同数据帧进行添加
    public void sendMsgToServer(String message) {
        String rebackMsg = "";

        try {
            printWriter.println(message);   // 输入给Server的数据
            System.out.println("ClinetToServer:" + message);
            rebackMsg = bufferedReader.readLine();// 读取发回的数据
            System.out.println("Server返回信息：" + rebackMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deleteMsgToServer(String message) {
        String rebackMsg = "";
        try {
            printWriter.println(message);   // 输入给Server的数据
            System.out.println("ClinetToServer:" + message);
            rebackMsg = bufferedReader.readLine();// 读取发回的数据
            System.out.println("Server返回信息：" + rebackMsg);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    public void changeMsgToServer(String message) {
        String rebackMsg = "";
        try {
            printWriter.println(message);   // 输入给Server的数据
            System.out.println("ClinetToServer:" + message);
            rebackMsg = bufferedReader.readLine();// 读取发回的数据
            System.out.println("Server返回信息：" + rebackMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void searchMsgToServer(String message) {
        String rebackMsg = "";
        try {
            printWriter.println(message);   // 输入给Server的数据
            System.out.println("ClinetToServer:" + message);
            rebackMsg = bufferedReader.readLine();// 读取发回的数据
            System.out.println("Server返回信息：" + rebackMsg);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeClient() {
        try {
            bufferedReader.close();
            printWriter.close();
            socketConnect.close();
            System.out.println("系统退出！");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        HRSClient hrsClient = new HRSClient();
        Scanner input = new Scanner(System.in);
        TranProtocol tranProtocol = new TranProtocol();

        while (true) {
            base:
            try {
                System.out.println("-------欢迎进入人力资源管理系统------");
                System.out.println("人员添加请按----------1");
                System.out.println("人员删除请按----------2");
                System.out.println("人员修改请按----------3");
                System.out.println("人员查询请按----------4");
                System.out.println("退出系统请按----------5");
                int chioce = input.nextInt();

                // protocol传输协议函数
                switch (chioce) {
                    case 1:
                        hrsClient.sendMsgToServer(tranProtocol.addMsgToServer());
                        break;
                    case 2:
                        hrsClient.deleteMsgToServer(tranProtocol.deleteMsgToServer());
                        break;
                    case 3:
                        hrsClient.changeMsgToServer(tranProtocol.changeMsgToServer());
                        break;
                    case 4:
                        hrsClient.searchMsgToServer(tranProtocol.searchMsgToServer());
                        break;
                    case 5:
                        hrsClient.sendMsgToServer(tranProtocol.exitMsg());
                        hrsClient.closeClient();
                        input.close();
                        System.exit(0);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("输入错误,请重新输入");



            }

        }
    }
}
