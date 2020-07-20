/**
 * A program for JAVA-LOWBHRSystem
 * @version 4.0 2020-07-17
 * @author Kan Wang
 */

package com.spdb;
import net.client;
import java.util.*;
import pojo.*;
import util.parser;


/*
客户端干了那几件事：
1. 根据需求结合客户端协议生成相应的报文信息发送给服务器，并等待接收服务器端的处理结果；
2. 利用解析器解析服务器端返回的报文信息，并打印出来；
 */
public class Main {
    public static void main(String [] args) {

        new client();
        Scanner in = new Scanner(System.in);
        String str, res;

        while (true) {
            System.out.println("************Welcome to LOWBHRSystem 4.0************");
            System.out.println("新增人员信息请按--------1");
            System.out.println("删除人员信息请按--------2");
            System.out.println("更新人员信息请按--------3");
            System.out.println("打印人员信息请按--------4");
            System.out.println("退出HR系统请按--------5");

            int c = in.nextInt();

            //switch-case分支
            if (c == 1) {
                str = protocol.addPerson();
                res = client.sendAndReadMessage(str);
                parser.parser(res);
            }
            else if (c == 2) {
                str = protocol.deletePerson();
                res = client.sendAndReadMessage(str);
                parser.parser(res);
            }
            else if (c == 3) {
                str = protocol.updatePerson();
                res = client.sendAndReadMessage(str);
                parser.parser(res);
            }
            else if (c == 4) {
                str = protocol.showPerson();
                res = client.sendAndReadMessage(str);
                parser.parser(res);
            }
            else if (c == 5) {
                str = client.sendAndReadMessage("Bye");
                client.closeClient();
                System.out.println("您已退出HR系统！");
                break;
            }
            else {
                System.out.println("功能尚未完善，请按指示操作！");
            }
        }
    }
}
