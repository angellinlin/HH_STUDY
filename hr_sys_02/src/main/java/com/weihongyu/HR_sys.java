package com.weihongyu;

import com.weihongyu.service.ResumeOperate;
import com.weihongyu.service.ResumeOperateImpl;
import com.weihongyu.util.StringUtil;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/10 23:05
 * @Description:
 */
public class HR_sys {
    public static void main(String[] args) throws IOException, IllegalAccessException, InstantiationException {
        ResumeOperate ro = new ResumeOperateImpl();
        Scanner input = new Scanner(System.in);
        Scanner sc = new Scanner(System.in);

            out:while (true) {
                System.out.println("-----欢迎进入HR系统控制台版本-----");
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
                        ro.addResume(sc.nextLine());break;
                    case 2:

                        System.out.println("请输入要查询简历对应的姓名");
                        ro.getByName(sc.nextLine());
                        break;
                    case 3:

                        System.out.println("请输入需要修改简历的姓名");
                        String name = sc.nextLine();
                        System.out.println("请输入姓名，身份证号，学校名称，以‘#’分割");
                        String resumeStr = sc.nextLine();
                        ro.updateResumeByName(name,StringUtil.strToResume(resumeStr));
                        break;
                    case 4:
                        System.out.println("请输入需要删除简历的姓名");
                        ro.deleResume(sc.nextLine());
                        break;
                    case 5:
                        List<String> all = ro.getAll();
                        for (String s : all) {
                            System.out.println(s);
                        }
                        break;
                    case 6:
                        input.close();sc.close();break out;
                }
            }

    }
}
