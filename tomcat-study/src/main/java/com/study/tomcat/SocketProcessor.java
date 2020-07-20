package main.java.com.study.tomcat;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import java.net.Socket;

/**
 * @Author: A wei
 * @Date: 2020/7/18 14:34
 * @Last Modified by:
 * @last Modified date:
 * @Description: 处理网络i请求
 */
public class SocketProcessor implements Runnable {

   Socket socket;

   public SocketProcessor(Socket socket){
       this.socket = socket;
   }

    @Override
    public void run() {
       //tomcat没有业务逻辑
       //网络客户端->操作系统->jvm/jdk->socket->tomcat->Servlet(只关心request ,response)
        try{
            byte[]  requestBody = new byte[1024];
            socket.getInputStream();
            String requestString = new String(requestBody);
            System.out.println("收到http请求，内容如下: ");
            System.out.println(requestString);

            //容器转换，tomcat -> Servlet
            HttpServletRequest request = ServletFactory.createRequest(requestBody);
            //todo 找到Servlet,调用
            //1.知道有哪些项目
            //2.有哪些servlet
            Servlet servlet = null;
        }catch (Exception e){

        }



    }
}
