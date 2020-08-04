package Client;

import java.util.Scanner;

public class ClientTranProtocol {

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
        try {
            System.out.println("请输入删除人员ID!");
            String head = "delete" + "/n";
            Scanner input = new Scanner(System.in);
            String toServerMsg = input.nextLine();
            deleteMsg = head + toServerMsg;
        } catch (Exception e) {
            deleteMsgToServer();
        }


        return deleteMsg;
    }
    public String changeMsgToServer() {
        System.out.println("请按格式输入修改信息：name,id,school!");
        String head = "change" + "/n";
        Scanner input = new Scanner(System.in);
        String toServerMsg = input.nextLine();
        changeMsg = head + toServerMsg;

        return changeMsg;
    }
    public String searchMsgToServer() {
        System.out.println("查询所有人员请输入 Y " + "," + "或直接输入人员 ID");
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
