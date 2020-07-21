package socket;

import bean.DataParser;

import java.io.*;
import java.net.Socket;

// 构建一个线程来处理多个客户端的接入
public class ServerThread extends Thread {

    Socket socketConnect = null;
    static BufferedReader bufferedReader;
    static PrintWriter printWriter;
    static String readClientMsg;


    public ServerThread(Socket socketConnect) {
        this.socketConnect = socketConnect;

    }

    @Override
    public void run() {
        try {

            bufferedReader = new BufferedReader(new InputStreamReader(socketConnect.getInputStream()));  // 读取Client数据流中发给Server的数据
            printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketConnect.getOutputStream())), true); // 打印(或写入)Server发送给Client的数据流
            /**
             * 数据写入可以采用 printWriter类，属于输出流，针对文本（字符流）以及字节流，并可以按行自动刷新
             */

            readClientMsg = bufferedReader.readLine();  // 针对读取的信息利用parser进行解析，并将解析结果传输给执行层
            if (readClientMsg != null) {
                // 加入返回给Client的消息确认信息
                System.out.println("接收ClientMsg："+ readClientMsg);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        if (readClientMsg.equals("exit")) {
            try {
                printWriter.println("bye bye!");
                bufferedReader.close();
                printWriter.close();
                socketConnect.close();
                System.out.println("Server等待连接！");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } else {
            // 启动对数据帧的解析函数
            DataParser dataParser = new DataParser();
            // 解析Client返回的数据帧信息

            /**
             * 此过程需要构建信息发送和返回的数据帧解析协议
             */

            // 判断Client返回的结果信息，并回复Cleint



        }

    }
}
