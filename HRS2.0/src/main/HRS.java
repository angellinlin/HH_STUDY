package main;

import dataPersistence.DataOperate;
import pojo.Resume;
import service.HRService;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Resume> resumeArrayList = new ArrayList<>();
        DataOperate.loadData(resumeArrayList);
        loop:
        while (true) {
            System.out.println("---欢迎进入HR系统---");
            System.out.println("---增加简历请按1---");
            System.out.println("---查询简历请按2---");
            System.out.println("---修改简历请按3---");
            System.out.println("---删除简历请按4---");
            System.out.println("---打印简历请按5---");
            System.out.println("---退出系统请按6---");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    HRService.addResume(resumeArrayList);
                    break;
                case 2:
                    HRService.queryResume(resumeArrayList);
                    break;
                case 3:
                    HRService.updateResume(resumeArrayList);
                    break;
                case 4:
                    HRService.deleteResume(resumeArrayList);
                    break;
                case 5:
                    HRService.showResume(resumeArrayList);
                    break;
                case 6:
                    System.out.println("退出系统");
                    DataOperate.saveData(resumeArrayList);
                    break loop;
                default:
                    System.out.println("输入有误，请重新输入");
            }
        }
        input.close();
    }

}
