package Web.Model.code.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;
import java.io.FileInputStream;
import java.io.File;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

public class Test {

    private static List<String> bookList = Arrays.asList("Java Toturial", "HTML Toturial", "CSS Toturial",
            "JavaScript Toturial");  // 添加的元素

    public static void main(String[] args) throws Exception {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);
        server.createContext("/test", new MyHandler());
        server.createContext("/", new RawHtmlHandler());
        server.createContext("/htmlElem", new HtmlElementHandler());
        server.createContext("/serveHtml", new ServeHtmlHander());

        server.setExecutor(null); // creates a default executor
        server.start();

        HttpServer server1 = HttpServer.create(new InetSocketAddress(8001), 0);
        server1.createContext("/serveHtml", new ServeHtmlHander());
        server1.setExecutor(null); // creates a default executor
        server1.start();
    }

    static class MyHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            String response = "This is the response";
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class RawHtmlHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            StringBuilder htmlBuilder = new StringBuilder();
            htmlBuilder.append("<!DOCTYPE HTML><html>"); // html 初始状态属性设置方法
            htmlBuilder.append(
                    "<head><title>Hello World</title><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/></head><body>");  // 首


            // 内容
            for (String x : bookList) {
                if ("Java Toturial".equals(x)) {
                    htmlBuilder.append("<p style=\"color:red\">" + x + "</p>");
                } else {
                    htmlBuilder.append("<p>" + x + "</p>");
                }
            }

            htmlBuilder.append("</body></html>");  // 尾
            String response = htmlBuilder.toString();
            t.sendResponseHeaders(200, response.length());
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class HtmlElementHandler implements HttpHandler {
        @Override
        public void handle(HttpExchange t) throws IOException {
            StringBuilder htmlBuilder = new StringBuilder();  // 构建html各节点元素
            for (String x : bookList) {
                if ("Java Toturial".equals(x)) {
                    htmlBuilder.append("<p style=\"color:red\">" + x + "</p>");
                } else {
                    htmlBuilder.append("<p>" + x + "</p>");
                }
            }
            // t.getResponseHeaders().add("Access-Control-Allow-Origin", "*");

            // if (t.getRequestMethod().equalsIgnoreCase("OPTIONS")) {
            //     t.getResponseHeaders().add("Access-Control-Allow-Methods", "GET, OPTIONS");
            //     t.getResponseHeaders().add("Access-Control-Allow-Headers", "Content-Type,Authorization");
            //     t.sendResponseHeaders(204, -1);
            //     return;
            // }
            String response = htmlBuilder.toString();
            t.sendResponseHeaders(200, 0);
            OutputStream os = t.getResponseBody();
            os.write(response.getBytes());
            os.close();
        }
    }

    static class ServeHtmlHander implements HttpHandler {

        @Override
        public void handle(HttpExchange t) throws IOException {
            t.sendResponseHeaders(200, 0);
            OutputStream output = t.getResponseBody();
            File file = new File("./example.html");
            FileInputStream fs = new FileInputStream(file);
            final byte[] buffer = new byte[0x10000];
            int count = 0;
            while ((count = fs.read(buffer)) >= 0) {
                output.write(buffer, 0, count);
            }
            output.flush();
            output.close();
            fs.close();
        }

    }
}