package com.weihongyu.controller;

import com.weihongyu.entity.Resume;
import com.weihongyu.service.ResumeService;
import com.weihongyu.service.impl.ResumeServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 17:05
 * @Description:
 */
public class ResumeController {

    ResumeService resumeService = new ResumeServiceImpl();

    public void run() throws SQLException {


        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

        out:while (true) {
            System.out.println("-----欢迎进入HR系统控制台+JDBC版本-----");
            System.out.println("增加简历信息----1");
            System.out.println("查询简历信息----2");
            System.out.println("修改简历信息----3");
            System.out.println("删除简历信息----4");
            System.out.println("显示所有简历信息----5");
            System.out.println("退出系统--------6");
            int choice = input.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("请输入姓名，身份证号，学校名称，以‘#’分割");
                    resumeService.addResume(sc.nextLine());break;
                case 2:

                    System.out.println("请输入要查询简历对应的姓名");
                    resumeService.searchResumeByName(sc.nextLine());
                    break;
                case 3:

                    System.out.println("请输入需要修改简历的姓名");
                    String name = sc.nextLine();
                    System.out.println("请输入姓名，身份证号，学校名称，以‘#’分割");
                    String resumeStr = sc.nextLine();

                    resumeService.updateResumeByName(name, resumeStr);
                    break;
                case 4:
                    System.out.println("请输入需要删除简历的姓名");
                    resumeService.delResumeByName(sc.nextLine());
                    break;
                case 5:
                    resumeService.getAll();
                    break;
                case 6:
                    input.close();sc.close();break out;
            }
        }

    }

}
