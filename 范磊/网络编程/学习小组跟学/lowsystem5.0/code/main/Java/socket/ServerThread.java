package socket;

import bean.DataParser;
import bean.PersistenceStorageInMySql;
import transmissionProtocol.ResponseMsg;
import transmissionProtocol.TranProtocol;

import java.io.*;
import java.net.Socket;

// 构建一个线程来处理多个客户端的接入
public class ServerThread extends Thread {

    Socket socketConnect = null;
    static BufferedReader bufferedReader;
    static PrintWriter printWriter;

    public static String getReadClientMsg() {
        return readClientMsg;
    }

    static String readClientMsg;
    PersistenceStorageInMySql persistenceStorageInMySql = new PersistenceStorageInMySql();
    TranProtocol tranProtocol = new TranProtocol();

    public ServerThread() {

    }

    public ServerThread(Socket socketConnect) {
        this.socketConnect = socketConnect;

    }

    @Override
    public void run() {
        while (true) {
            try {

                bufferedReader = new BufferedReader(new InputStreamReader(socketConnect.getInputStream()));  // 读取Client数据流中发给Server的数据
                printWriter = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socketConnect.getOutputStream())), true); // 打印(或写入)Server发送给Client的数据流
                /**
                 * 数据写入可以采用 printWriter类，属于输出流，针对文本（字符流）以及字节流，并可以按行自动刷新
                 */
                readClientMsg = bufferedReader.readLine();  // 针对读取的信息利用parser进行解析，并将解析结果传输给执行层



            } catch (IOException e) {
                e.printStackTrace();
            }

            if (readClientMsg.equals("exit")) {
                try {
                    printWriter.println("bye bye!");
                    bufferedReader.close();
                    printWriter.close();
                    socketConnect.close();
                    break;

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {
                // 启动对数据帧的解析函数
                DataParser dataParser = new DataParser();
                // 解析Client返回的数据帧信息
                if (readClientMsg != null) {
                    System.out.println("接收ClientMsg："+ readClientMsg);
                }
                ResponseMsg responseMsg= dataParser.parser(readClientMsg);  // 解析后返回消息体

                // 调用持久化层
                if (responseMsg.getHead().equals("add")) {
                    persistenceStorageInMySql.add(dataParser.parserAdd(responseMsg.getResponseMsg()));
                    printWriter.println(tranProtocol.addMessage());

                } else if (responseMsg.getHead().equals("delete")) {
                    persistenceStorageInMySql.delete(dataParser.parserDelete(Integer.parseInt(responseMsg.getResponseMsg())));
                    printWriter.println(tranProtocol.deleteMessage());

                } else if (responseMsg.getHead().equals("change")) {
                    persistenceStorageInMySql.change(dataParser.parserChange(responseMsg.getResponseMsg()));
                    printWriter.println(tranProtocol.changeMessage());

                } else if (responseMsg.getHead().equals("search")) {
                    persistenceStorageInMySql.search(dataParser.parserSearch(responseMsg.getResponseMsg()));

                    printWriter.println(tranProtocol.searchMessage()+persistenceStorageInMySql.getRebackMsgToserver());
                }
                /**
                 * 此过程需要构建信息发送和返回的数据帧解析协议
                 */

                // 判断Client返回的结果信息，并回复Cleint



            }

        }

    }
}
