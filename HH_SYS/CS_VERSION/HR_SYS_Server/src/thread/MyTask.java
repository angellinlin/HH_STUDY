package thread;

import service.EntityService;

import java.io.*;
import java.net.Socket;

public class MyTask implements Runnable{
    Socket tcpConnection;
    static BufferedReader in;
    static PrintWriter out;
    EntityService entityService;/*操作数据库的服务对象*/
    private String code;/*线程编号*/
    String strWelcome = "Server：-----欢迎进入招聘系统V3-----[添加简历请按----1][删除简历请按----2][修改简历请按----3][查询简历请按----4][退出请按--------5]";

    public MyTask(String code, Socket ss) {
        this.code = code;
        this.tcpConnection = ss;
        entityService = new EntityService(tcpConnection);
    }

    public MyTask(Socket ss) {
        this("Default Thread", ss);
    }

    @Override
    public void run() {
        try {
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            out.println(strWelcome);/*每次操作结束都会回写欢迎语句*/
            String inputline = null;
            try {
                inputline = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            switch (inputline) {
                case "1":entityService.addEntity(in,out);break;
                case "2":entityService.deleteEntity(in,out);break;
                case "3":entityService.updateEntity(in,out);break;
                case "4":entityService.getEntityList(in,out);break;
                case "5":entityService.exit(in,out);return;
                default:System.out.println("Server：输入错误，请重新输入");break;
            }
        }
    }

}
