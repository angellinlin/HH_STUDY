package sys;

import model.MessageResult;
import model.Resume;
import util.ResumeParser;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class HRSC {
    BufferedReader in;
    PrintWriter out;
    Socket tcpConnection;
    ResumeParser parser=new ResumeParser();

    public HRSC() {
        try {
            tcpConnection = new Socket("127.0.0.1", 1200);
            System.out.println("Inf：连接上服务器了");
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);
            while(true){
                String inputline=null;
                inputline=in.readLine();
                /*将服务器返回的字符串解析成对象，再依次遍历打印*/
                MessageResult mr=parser.parse(inputline);
                if(mr.entityList!=null){
                    int i=1;
                    for(Resume r:mr.entityList){
                        System.out.println("第"+i+++"份简历：");
                        System.out.println(r.printInfo());
                    }
                }else{
                    /*从服务器返回的字符串判断，是否需要额外读新的行（客户端每次循环只能读一行）*/
                    String subStr=inputline.substring(0,3);
                    if("Err".equals(subStr)||"Inf".equals(subStr)){
                        System.out.println(in.readLine());
                    }else if("Bye".equals(subStr)){/*检测到Bye字段，则关闭连接，结束程序*/
                        tcpConnection.close();
                        in.close();
                        out.close();
                        return;
                    }
                    /*提示用户输入*/
                    System.out.print("Type:");
                    Scanner input = new Scanner(System.in);
                    String userStr = input.nextLine();
                    out.println(userStr);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new HRSC();
    }
}
