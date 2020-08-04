package Web.MyWork;


import Client.HRSClient;
import bean.PersistenceStorageInMySql;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import socket.ServerThread;
import bean.People;


import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/**
 * 将Server查询结果转接到此界面
 * 仅用于查询结果的显示
 */

public class WebHtml {

    HttpServer httpServer;
    static People people = new People();
    String[] peopleList = new String[]{people.getPeopleName(), String.valueOf(people.getId()), people.getSchool()};

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
            htmlBuilder.append("<!DOCTYPE HTML><html><head><title>LowSyetem5.0</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/><link rel=\"stylesheet\" href=\"https://cdn.staticfile.org/font-awesome/4.7.0/css/font-awesome.css\"></head><body><div>"); // html 初始状态属性设置方法// 首

            // 内容
            htmlBuilder.append("<div><h1 id=\"title1\">人力资源管理</h1>");
            htmlBuilder.append("<p><a class=\"fa fa-arrow-right\" style=\"font-size: 20px\" href=\"\">添加</a></p>");
            htmlBuilder.append("<p><a class=\"fa fa-arrow-right\" style=\"font-size: 20px\" href=\"\">删除</a></p>");
            htmlBuilder.append("<p><a class=\"fa fa-arrow-right\" style=\"font-size: 20px\" href=\"\">修改</a></p>");
            htmlBuilder.append("<p><a class=\"fa fa-arrow-right\" style=\"font-size: 20px\" href=\"http://localhost:8000/search\">查询</a></p></div>");

            htmlBuilder.append("</div></body></html>");  // 尾
            String response = htmlBuilder.toString();
            byte[] bytes = response.getBytes("utf-8");
            httpExchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = httpExchange.getResponseBody(); // 获取发送之后的响应body并通过OUT流写出，显示

            os.write(bytes);
            os.close();

        }
    }

    private class searchHtml implements HttpHandler {
        @Override
        public void handle(HttpExchange httpExchange) throws IOException {  // 查看源码抽象方法
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<!DOCTYPE HTML><html><head><title>LowSyetem5.0</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/></head><body><div>"); // html 初始状态属性设置方法// 首

            // 内容
            htmlBuilder.append("<center><h1 id=\"title1\">查询结果</h1>");

            htmlBuilder.append("<p style=\"font-size: 20px\">姓名：" + peopleList[0] + "</p>");
            htmlBuilder.append("<p style=\"font-size: 20px\">ID：" + peopleList[1] + "</p>");
            htmlBuilder.append("<p style=\"font-size: 20px\">学校：" + peopleList[2] + "</p></center>");
            htmlBuilder.append("<div id=\"area\">" +
                    "<center><button type=\"button\" onclick=\"window.location.reload()\" style=\"font-size:20px\">刷新</button><input type=\"button\" value=\"返回\"  style=\"font-size:20px\" onclick=\"reBack()\"></center><br>\n" +
                    "</div>");
            htmlBuilder.append("<script>function reBack() {window.open(\"http://localhost:8000/\")}</script>");
            htmlBuilder.append("</div></body></html>");  // 尾

            String response = htmlBuilder.toString();
            byte[] bytes = response.getBytes("utf-8");
            httpExchange.sendResponseHeaders(200, bytes.length);
            OutputStream os = httpExchange.getResponseBody(); // 获取发送之后的响应body并通过OUT流写出，显示

            os.write(bytes);
            os.close();
        }
    }

    public static void main(String[] args) {
        WebHtml webHtml = new WebHtml();
        webHtml.bulidHtml();


    }
}
