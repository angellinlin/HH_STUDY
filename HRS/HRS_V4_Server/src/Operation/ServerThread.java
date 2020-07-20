package Operation;

import Resume.Resume;
import util.Parser;
import util.ParserResult;
import util.Protocol;
import util.ReturnResult;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerThread extends Thread {
    Socket socket;
    static BufferedReader in;
    static PrintWriter out;
    static String str;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
                str = in.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //
            if (str.equals("bye")) {
                System.out.println("Bye!");
                try {
                    in.close();
                    out.close();
                    socket.close();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else {
                Parser parser = new Parser();
                ParserResult pr = parser.parser(str);
                ReturnResult rr = new ReturnResult();
                //添加简历操作
                if (pr.head.equals("add")) {
                    Action action = new Action();
                    Resume resume = (Resume) pr.resultData;
                    rr = action.addResume(resume);
                    System.out.println(rr);
                    Protocol protocol = new Protocol();
                    String message = protocol.addResumeMessage(rr);
                    System.out.println("向客户端返回：" + message);
                    out.println(message);
                } else if (pr.head.equals("delete")) {
                    Action action = new Action();
                    Resume resume = (Resume) pr.resultData;
                    rr = action.deleteResume(resume);
                    Protocol protocol = new Protocol();
                    String message = protocol.deleteResumeMessage(rr);
                    System.out.println("向客户端返回：" + message);
                    out.println(message);
                } else if (pr.head.equals("modify")) {
                    Action action = new Action();
                    List<Resume> applicants = (ArrayList<Resume>) pr.resultData;
                    rr = action.modifyResume(applicants.get(0), applicants.get(1));
                    Protocol protocol = new Protocol();
                    String message = protocol.modifyResumeMessage(rr);
                    System.out.println("向客户端返回：" + message);
                    out.println(message);
                } else if (pr.head.equals("search")) {
                    Action action = new Action();
                    String resumeId = (String) pr.resultData;
                    rr = action.searchResume(resumeId);
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(rr);
                    System.out.println("向客户端返回：" + message);
                    out.println(message);
                } else if (pr.head.equals("searchAll")) {
                    Action action = new Action();
                    rr = action.searchAllResume();
                    Protocol protocol = new Protocol();
                    String message = protocol.searchAllResumeMessage(rr);
                    System.out.println("向客户端返回：" + message);
                    out.println(message);
                }
            }
        }
    }
}
