package bean;

import Client.HRSClient;

import java.*;
import java.util.Scanner;

public class TranProtocol {

    public static String addMsg;
    public static String deleteMsg;
    public static String changeMsg;
    public static String searchMsg;
    public static String exitMsg;

    public String addMsgToServer() {
        System.out.println("请按格式输入添加信息：name,id,school!");

        String head = "add" + "/n";
        Scanner input = new Scanner(System.in);
        String toServerMsg = input.nextLine();
        addMsg = head + toServerMsg;
        return addMsg;
    }



    public String deleteMsgToServer() {
        String head = "delete" + "/n";
        Scanner input = new Scanner(System.in);
        String toServerMsg = input.nextLine();
        deleteMsg = head + toServerMsg;

        return deleteMsg;
    }
    public String changeMsgToServer() {
        String head = "change" + "/n";
        Scanner input = new Scanner(System.in);
        String toServerMsg = input.nextLine();
        changeMsg = head + toServerMsg;

        return changeMsg;
    }
    public String searchMsgToServer() {
        String head = "search" + "/n";
        Scanner input = new Scanner(System.in);
        String toServerMsg = input.nextLine();
        searchMsg = head + toServerMsg;

        return searchMsg;
    }

    public String exitMsg() {
        Scanner input = new Scanner(System.in);
        String toServerMsg = input.nextLine();
        exitMsg = toServerMsg;

        return exitMsg;
    }
}
