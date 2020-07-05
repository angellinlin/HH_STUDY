import Operation.Operation;
import Resume.Resume;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<Resume> applicants = new ArrayList<>();
        boolean flag=true;
        while (flag) {
            System.out.println("-----欢迎进入HR管理系统v1.0-----");
            System.out.println("添加简历请按----1");
            System.out.println("查询简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("删除简历请按----4");
            System.out.println("退出系统请按----5");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    Operation.addResume(applicants);
                    break;
                case 2:
                    Operation.searchResume(applicants);
                    break;
                case 3:
                    Operation.modifyResume(applicants);
                    break;
                case 4:
                    Operation.deletResume(applicants);
                    break;
                case 5:
                    flag=false;
                    break;
                default:
                    System.out.println("Error!\n请重新输入你的选择！");
            }
        }
        System.out.println("你已退出HR管理系统V1.0！");
    }


}
