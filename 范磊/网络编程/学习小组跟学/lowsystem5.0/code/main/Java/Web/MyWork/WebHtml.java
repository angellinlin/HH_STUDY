package Web.MyWork;


import bean.PersistenceStorageInMySql;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import socket.ServerThread;
import bean.People;


import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.net.InetSocketAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WebHtml {

    HttpServer httpServer;
    static People people = new People();
    String[] peopleList = new String[]{people.getPeopleName(), String.valueOf(people.getId()), people.getSchool()};

    static PersistenceStorageInMySql persistenceStorageInMySql = new PersistenceStorageInMySql();


    public void bulidHtml() {
        try {
            httpServer = HttpServer.create(new InetSocketAddress(8000), 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
        httpServer.createContext("/", new HomeHtml());
        httpServer.createContext("/search", new searchHtml());
        httpServer.setExecutor(null);  // 查看源码可知可以赋给一个可执行命令
        httpServer.start();
    }

    // 查看源码，httphander 分别存在一个抽象类以及一个接口类，均可以使用
    private class HomeHtml implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<!DOCTYPE HTML><html><head><title>LowSyetem5.0</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/></head><body>"); // html 初始状态属性设置方法// 首

            // 内容
            for (String x : peopleList) {
                htmlBuilder.append("<p>" + x + "</p>");
            }
            htmlBuilder.append("</body></html>");  // 尾


            String response = htmlBuilder.toString();
            httpExchange.sendResponseHeaders(200, response.length());
            OutputStream os = httpExchange.getResponseBody();
            os.write(response.getBytes());
            os.close();


        }
    }

    private class searchHtml implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {  // 查看源码抽象方法

        }
    }

    public static void main(String[] args) {
        WebHtml webHtml = new WebHtml();
        webHtml.bulidHtml();

        String reMsg = ServerThread.getReadClientMsg();
        String reback = persistenceStorageInMySql.getRebackMsgToserver();

    }
}
