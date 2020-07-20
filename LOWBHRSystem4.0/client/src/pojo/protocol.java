package pojo;

import java.util.Scanner;

public class protocol {

    /*
    按照协议构建报文样式,并发送到服务器端
     */
    public static String addPerson(){

        System.out.println("欢迎来到人员信息增添界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入人员姓名，性别，民族，电话和邮箱地址，每输入一项请按回车键确定");
        String name = in.nextLine();
        String sex = in.nextLine();
        String nation = in.nextLine();
        String phone = in.nextLine();
        String email = in.nextLine();

        String str = "add:" + name + "," + sex + "," + nation + "," + phone + "," + email;
        return str;
    }

    public static String deletePerson(){
        System.out.println("欢迎来到人员信息删除界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要删除的人员姓名和手机号，每输入一项请按回车键确定");

        String dName = in.nextLine();
        String dPhone = in.nextLine();

        String str = "delete:" + dName + "," + dPhone;
        return str;
    }

    public static String updatePerson(){
        System.out.println("欢迎来到人员信息更新界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要更新的人员姓名和手机号，每输入一项请按回车键确定");
        String uName = in.nextLine();
        String uPhone = in.nextLine();

        System.out.println("请输入更新后的人员姓名，性别，民族，电话和邮箱地址，每输入一项请按回车键确定");
        String name = in.nextLine();
        String sex = in.nextLine();
        String nation = in.nextLine();
        String phone = in.nextLine();
        String email = in.nextLine();

        String str = "update:" + uName + "," + uPhone + "," + name + "," + sex + "," +
                nation + "," + phone + "," + email;
        return str;
    }

    public static String showPerson(){
        System.out.println("欢迎来到人员信息查找界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要查找的人员姓名和手机号，每输入一项请按回车键确定");
        String lName = in.nextLine();
        String lPhone = in.nextLine();

        String str = "search:" + lName + "," + lPhone;
        return str;
    }
}
