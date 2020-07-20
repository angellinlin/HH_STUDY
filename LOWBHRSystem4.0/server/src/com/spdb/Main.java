/**
 * A program for JAVA-LOWBHRSystem
 * @version 4.0 2020-07-17
 * @author Kan Wang
 */

package com.spdb;
import database.dataBaseConnection;
import net.Server;
import pojo.connector;
import service.PersonService;
import operation.serverThread;

import java.util.Scanner;

/*
服务器端干了那几件事：
1. 连接MySQL数据库；
2. 读取客户端发送的报文信息，并用解析器解析，得到解析结果parserResult，包括报文头（操作）和内容（人员信息）；
3. 使用MySQL语句结合解析结果对数据库进行相应地操作，并返回处理结果returnResult，包括处理状态（Success还是
failure）、处理成功时的记录（record）和失败原因（failReason)；
4. 根据服务器端协议将处理结果封装成报文，并发送到客户端；
 */

public class Main {
    public static void main(String[] args) {

        connector con = new connector();
        con.con = dataBaseConnection.getConnection();

        if(con.con != null) {
            PersonService.createTable(con);
            new Server();    //对服务器初始化，包括ServerSocket、Socket和IO流
            serverThread st = new serverThread(con);    //构建线程处理客户端需求
            st.start();
        }
        else{
            System.out.println("连接MySQL数据库失败，即将退出！");
            return;
        }
    }
}