package main.java.com.study.tomcat;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * @Author: A wei
 * @Date: 2020/7/18 14:27
 * @Last Modified by:
 * @last Modified date:
 * @Description:
 */
public class WebServerStarter {

    //处理请求的线程池


    public static void start(){
        ServerSocket serverSocket = null;
        try{
            //绑定监听端口
            serverSocket = new ServerSocket(9999);
            while(true){
                //不同操作系统由不同实现--接受新请求
                Socket connection = serverSocket.accept();//BIO写法 --当没有新请求时，阻塞

            }

        }catch (Exception e){

        }
    }
}
