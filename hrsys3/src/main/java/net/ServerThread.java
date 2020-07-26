package net;

import bean.ConvertResult;
import bean.Jhunter;
import bean.OperaResult;
import com.sy.hrsys3.Driver;
import utils.DataConvert;
import utils.Protocol;

import java.io.*;
import java.net.Socket;

/**
 * @author sy
 * @date 2020/7/26 16:41
 */
public class ServerThread extends Thread{

    Socket socket;
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    public ServerThread(Socket socket){
        this.socket = socket;
    }


    @Override
    public void run() {
       while (true){
           try {
               in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
               out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
               str = in.readLine();
           } catch (IOException e) {
               e.printStackTrace();
           }
            if (str.equals("exit")){
                out.println("退出");
                try {
                    in.close();
                    out.close();
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                DataConvert dataConvert = new DataConvert();
                ConvertResult convertResult = dataConvert.convert(str);
                OperaResult operaResult = new OperaResult();
                //添加
                if (convertResult.getHead().equals("add")){
                    Driver driver = new Driver();
                    Jhunter jhunter = (Jhunter) convertResult.getConvertData();
                    operaResult = driver.add(jhunter);
                    Protocol protocol = new Protocol();
                    String message = protocol.AddMessage(operaResult);
                    System.out.println("返回客户端信息："+message);
                    out.println(message);
                }
                //删除
                if (convertResult.getHead().equals("delete")){
                    Driver driver = new Driver();
                    Jhunter jhunter = (Jhunter) convertResult.getConvertData();
                    operaResult = driver.delete(jhunter.getName());
                    Protocol protocol = new Protocol();
                    String message = protocol.AddMessage(operaResult);
                    System.out.println("返回客户端信息："+message);
                    out.println(message);
                }
                //更新
                if (convertResult.getHead().equals("update")){
                    Driver driver = new Driver();
                    Jhunter jhunter = (Jhunter) convertResult.getConvertData();
                    operaResult = driver.update(jhunter);
                    Protocol protocol = new Protocol();
                    String message = protocol.AddMessage(operaResult);
                    System.out.println("返回客户端信息："+message);
                    out.println(message);

                }
                //搜索
                if (convertResult.getHead().equals("searchByName")){
                    Driver driver = new Driver();
                    Jhunter jhunter = (Jhunter) convertResult.getConvertData();
                    operaResult = driver.searchByName(jhunter.getName());
                    Protocol protocol = new Protocol();
                    String message = protocol.AddMessage(operaResult);
                    System.out.println("返回客户端信息："+message);
                    out.println(message);
                }
            }
       }
    }
}
