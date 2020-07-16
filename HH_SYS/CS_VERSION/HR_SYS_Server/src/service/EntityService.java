package service;

import model.MessageResult;
import model.Resume;
import util.ResumeParser;
import util.ResumeProtocol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;

public class EntityService {
    DBCRUDService crudService=null;
    Socket conn=null;
    ResumeParser parser=null;
    ResumeProtocol protocol=null;
    public EntityService(Socket tcpConn){
        crudService=new DBCRUDImpl();
        parser=new ResumeParser();
        protocol=new ResumeProtocol();
        conn=tcpConn;
    }

    public void addEntity(BufferedReader in, PrintWriter out) {
        writeToClient(out,"Server：请依次输入【简历】的姓名，身份证号，学校，简历状态,并以逗号隔开,分号结束");
        MessageResult pr= parser.parse(readFromClient(in));

        /**/
        if(pr.entityList!=null)
            writeToClient(out,crudService.addEntity(pr.entityList.get(0))==true?"Inf：添加简历成功":"Inf：添加简历失败");
        else
            writeToClient(out,"Err：解析错误,输入格式有误");
    }

    public void deleteEntity(BufferedReader in, PrintWriter out) {
        writeToClient(out,"Server：请输入需要【删除】简历的身份证号");
        writeToClient(out,crudService.deleteEntity(readFromClient(in))==true?"Inf：删除简历成功":"Inf：删除简历失败");
    }

    public void updateEntity(BufferedReader in, PrintWriter out) {
        writeToClient(out,"Server：请输入需要【修改】简历的身份证号");
        MessageResult pr= parser.parse(readFromClient(in));
        if(pr.entityList!=null)
            writeToClient(out,crudService.updateEntity(pr.entityList.get(0))==true?"Inf：添加简历成功":"Inf：添加简历失败");
        else
            writeToClient(out,"Err：解析错误,输入格式有误");
    }

    public void getEntityList(BufferedReader in, PrintWriter out) {
        String str="Server：这里是查询简历系统："+"[查询所有请按----------0]"+"[按身份证号查找请按----------1]"+
                "[按姓名查找请按----------2]"+"[按学校查找请按----------3]"+"[按简历进度查找请按------------4]"+
                "[模糊查找请按------------5]"+"[退出请按----------------6]";
        writeToClient(out,str);
        int choice=Integer.parseInt(readFromClient(in));
        String matchStr="";
        if(choice!=0){
            writeToClient(out,"Server：请输入查找关键字");
            matchStr=readFromClient(in);
        }

        ArrayList<Resume> list=crudService.getEntityListByKey(choice,matchStr);

        writeToClient(out,protocol.encode(list).str_entity);
    }

    public void exit(BufferedReader in, PrintWriter out){
        writeToClient(out,"Bye：您已经退出图书管理系统");
        try {
            in.close();
            out.close();
            crudService.close();
            conn.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String readFromClient(BufferedReader in){
        String res=null;
        try {
            res=in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }

    public void writeToClient(PrintWriter out,String str){
        out.println(str);
    }
}
