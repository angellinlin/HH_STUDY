package operator;

import model.ActionResult;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ServerThread extends Thread{

    private final Socket conn;
    private Action action;

    public ServerThread(Socket conn) {
        this.conn = conn;
        this.action = action = new Action();
    }

    @Override
    public void run(){

        while (true){
            String str;
            DataInputStream in;
            DataOutputStream out;

            try {
                in = new DataInputStream(conn.getInputStream());
                out = new DataOutputStream(conn.getOutputStream());
                str = in.readUTF();
            } catch (SocketTimeoutException s) {
                System.out.println("Socket timed out!");
                break;
            }catch (IOException e) {
                e.printStackTrace();
                break;
            }

            if (str.equals("end")){
                try {
                    out.writeUTF("end");
                    in.close();
                    out.close();
                    conn.close();
                    action.closeConnection();
                    break;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }else {
                Parser parser = new Parser();
                ReturnResult returnResult = parser.Parse(str); // returnResult.head=操作指令，returnResult.data=数据
                ActionResult actionResult;
                if (returnResult.head.equals("add")){
                    Resume resume = (Resume) returnResult.resultData; // 通过客户端的数据建立一个Resume对象
                    actionResult = action.addResume(resume); // 通过客户端的数据建立一个Resume对象
                    Protocol protocol = new Protocol();
                    String message = protocol.processResumeMessage(actionResult); // 格式化（封装）结果数据
                    System.out.println("向客户端返回："+message);
                    try {
                        out.writeUTF(message); // 向客户端发送格式化的结果数据
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (returnResult.head.equals("delete")){
                    Resume resume = (Resume) returnResult.resultData;
                    actionResult = action.deleteResume(resume.getId());
                    Protocol protocol = new Protocol();
                    String message = protocol.processResumeMessage(actionResult);
                    System.out.println("向客户端返回："+message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (returnResult.head.equals("update")){
                    ResumeList resumeList = (ResumeList) returnResult.resultData;
                    actionResult = action.updateResumeById(resumeList);
                    Protocol protocol = new Protocol();
                    String message = protocol.processResumeMessage(actionResult);
                    System.out.println("向客户端返回："+message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }else if (returnResult.head.equals("search")){
                    Resume resume = (Resume) returnResult.resultData;
                    actionResult = action.selectById(resume.getId());
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(actionResult);
                    System.out.println("向客户端返回：" + message);
                    try {
                        out.writeUTF(message);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
