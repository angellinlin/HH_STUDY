package system;


import service.HRService;

import java.util.Scanner;

public class HRS {

    private static HRService service = new HRService();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        loop:
        while(true) {
            System.out.println("---欢迎进入HR系统---");
            System.out.println("---增加简历请按1---");
            System.out.println("---查询简历请按2---");
            System.out.println("---修改简历请按3---");
            System.out.println("---删除简历请按4---");
            System.out.println("---退出系统请按5---");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    service.addResume();
                    break;
                case 2:
                    service.queryResume();
                    break;
                case 3:
                    service.updateResume();
                    break;
                case 4:
                    service.deleteResume();
                    break;
                case 5:
                    service.closeService("end");
                    System.out.println("您已经退出HR简历管理系统");
                    break loop;
                default:
                    System.out.println("输入有误，请重新输入");
                    break;
            }
        }
        input.close();
    }
}
