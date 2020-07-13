import Operation.Service;


import java.util.Scanner;

public class HRS_V3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("-----欢迎进入HR管理系统v3.0-----");
            System.out.println("添加简历请按----1");
            System.out.println("查询简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("删除简历请按----4");
            System.out.println("退出系统请按----5");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    Service.addResume();
                    break;
                case 2:
                    Service.searchResume();
                    break;
                case 3:
                    Service.modifyResume();
                    break;
                case 4:
                    Service.deletResume();
                    break;
                case 5:
                    flag = false;

                    break;
                default:
                    System.out.println("Error!\n请重新输入你的选择！");
            }
        }
        System.out.println("你已退出HR管理系统V3.0！");
    }
}
