import Operation.Service;

import java.util.Scanner;

public class HRS_V4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Service service=new Service();
        boolean flag = true;
        while (flag) {
            System.out.println("-----欢迎进入HR管理系统v4.0-----");
            System.out.println("添加简历请按----1");
            System.out.println("查询简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("删除简历请按----4");
            System.out.println("退出系统请按----5");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    service.addResume();
                    break;
                case 2:
                    service.searchResume();
                    break;
                case 3:
                    service.modifyResume();
                    break;
                case 4:
                    service.deletResume();
                    break;
                case 5:
                    flag = false;
                    service.closeNet("bye");
                    break;
                default:
                    System.out.println("Error!\n请重新输入你的选择！");
            }
        }
        System.out.println("你已退出HR管理系统V4.0！");
    }
}
