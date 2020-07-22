package main;


import model.Resume;
import service.HrService;

import java.util.ArrayList;
import java.util.Scanner;

public class mainClass {
    public mainClass(){
        Scanner input = new Scanner(System.in);
        HrService hrService=new HrService();
        while(true)
        {

            System.out.println("-----欢迎进入HR招聘系统-----");
            System.out.println("添加简历信息请按----1");
            System.out.println("删除简历信息请按----2");
            System.out.println("修改简历信息请按----3");
            System.out.println("查询简历信息请按----4");
            System.out.println("退出请按--------5");


            int choice=input.nextInt();
            boolean flag=false;
            switch (choice){
                case 1:
                    hrService.addResume();
                    break;
                case 2:
                    hrService.deleteResume();
                    break;
                case 3:
                    hrService.updateResume();
                    break;
                case 4:
                    hrService. searchResume();
                    break;
                case 5:
                    flag=true;
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
            if(flag){
                hrService.byeResume();
                break;
            }

        }
    }
    public static void main(String[] args) {
        new mainClass();
    }
}
