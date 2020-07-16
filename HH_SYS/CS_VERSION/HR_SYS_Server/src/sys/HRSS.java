package sys;

import thread.MyRejectedExecutionHandler;
import thread.MyTask;
import thread.MyThreadFactory;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @program: HR_SYS
 * @description: Entrance
 * @author: 朱戈
 * @create: 2020-7-16 15:00
 * @version: C/S version
 * @Structure:[ ■Package  ○Interface  ●Class  ->Impl  --->extends]
 * ★HR_SYS_Server
 *     ■DBConnection
 *         ●DBConnection
 *     ■model
 *         ●Entity
 *         ●Resume ---> ●Entity [Bean]
 *         ●MessageResult [保存简历数组对象、以及字符串编码后的简历数组对象]
 *     ■service
 *         ●EntityService [get inputs & get CRUD results,by ○CRUDService]
 *         ○DBCRUDService <common ops for CRUD>
 *         ●DBCRUDImpl -> ○CRUDService [impl:CRUD based on JDBC]
 *     ■sys
 *         ●HRSS [Program Entrance]
 *     ■thread
 *         ●MyTask -> ○Runnable
 *         ●MyThreadFactory -> ○ThreadFactory
 *         ●MyRejectedExecutionHandler -> ○RejectedExecutionHandler
 *     ■util
 *         ●ResumeParser [String -> ResumeList]
 *         ●ResumeProtocol [ResumeList -> String]
 **/
public class HRSS {
    static ThreadPoolExecutor executor;
    static ServerSocket ss;
    Socket tcpConnection;
    int threadCode=0;
    HRSS(){
        executor=new ThreadPoolExecutor(6,10,10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(20),
                new MyThreadFactory(),
                new MyRejectedExecutionHandler());
        try {
            ss=new ServerSocket(1200);
            System.out.println("服务器启动，等待客户端连接...");
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(true){
            try {
                tcpConnection=ss.accept();
                System.out.println("检测到客户端连接");
                executor.execute(new MyTask(""+threadCode,tcpConnection));
            } catch (IOException e) {
                e.printStackTrace();
            }
            ++threadCode;
        }
    }

    public static void main(String[] args){
        new HRSS();
    }
}
