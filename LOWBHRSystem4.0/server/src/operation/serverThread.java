package operation;

import java.net.*;
import java.io.*;

import database.dataBaseConnection;
import net.Server;
import pojo.*;
import util.parser;
import service.PersonService;

public class serverThread extends Thread{
    static connector con;

    public serverThread(connector con){
        this.con = con;
    }

    @Override
    public void run(){

        while(true) {
            String str = Server.readMessage();

            if (str.equalsIgnoreCase("Bye")) {
                Server.closeServer();
                dataBaseConnection.closeConnection(con);
                break;
            }
            else{
                parserResult pr = parser.parser(str);
                returnResult rr = new returnResult();
                String res = null;

                if(pr == null){
                    res = "Failure@" + "报文头不符合规范，无法解析！";
                    Server.sendMessage(res);
                }
                else if(pr.head.equals("add")){
                    rr = PersonService.addPerson(con, pr.resume);
                    res = protocol.Message(rr);
                    Server.sendMessage(res);
                }
                else if(pr.head.equals("delete")){
                    rr = PersonService.deletePerson(con, pr.resume);
                    res = protocol.Message(rr);
                    Server.sendMessage(res);
                }
                else if(pr.head.equals("update")){
                    rr = PersonService.updatePerson(con, pr.oldResume, pr.resume);
                    res = protocol.Message(rr);
                    Server.sendMessage(res);
                }
                else if(pr.head.equals("search")){
                    rr = PersonService.showPerson(con, pr.resume);
                    res = protocol.Message(rr);
                    Server.sendMessage(res);
                }
            }
        }
    }
}
