package sys;

import bean.DataOperate;
import bean.Resume;
import bean.ResumeService;

import java.util.LinkedList;
import java.util.Scanner;

public class HRS {
    public static void main(String[] args) {
        // 修改运用linkedlist来创建集合，相较于动态数组模式增删更快
        LinkedList<Resume> resumeLinkedList = new LinkedList<>();

        // 获取标准输入流用于输入简历信息
        Scanner input = new Scanner(System.in);
        // 下载所有图书
        DataOperate.loadData(resumeLinkedList);
        int flag = 1;
        do{
            // 打印提示信息
            System.out.println("-----欢迎使用简历管理系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按----5");

            // 获取键盘指令
            int choice = input.nextInt();
            // 使用 switch 分支语句实现
            switch (choice){
                case 1:
                    ResumeService.addResume(resumeLinkedList);
                    break;
                case 2:
                    ResumeService.deleteResume(resumeLinkedList);
                    break;
                case 3:
                    ResumeService.updateResume(resumeLinkedList);
                    break;
                case 4:
                    ResumeService.searchResume(resumeLinkedList);
                    break;
                case 5:
                    // 所有操作结束后，将信息存入到文件中
                    DataOperate.saveData(resumeLinkedList);
                    // 控制循环结束
                    flag = 0;
                    break;
                default:
                    System.out.println("输入有误，请重新输入：");
                    break;
            }

        }while(flag == 1);
        System.out.println("已成功退出简历管理系统！");
    }
}
