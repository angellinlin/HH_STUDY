package Operation;

import Resume.Resume;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Operation {
    //添加简历信息
    public static void addResume(List<Resume> applicants) {
        System.out.println("欢迎进入添加简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        System.out.println("请依次输入姓名，学校，身份ID，email");
        String resumeName = input.nextLine();
        String resumeId = input.nextLine();
        String resumeSchool = input.nextLine();
        String resumeEmail = input.nextLine();
        //get/SET
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
        applicants.add(resume);
        System.out.println("您的信息已成功录入系统！");
        showResume(resume);
    }

    //删除简历
    public static void deletResume(List<Resume> applicants) {
        System.out.println("欢迎进入删除简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        System.out.println("输入你要删除的简历身份Id:");
        String id = input.nextLine();

        for (int i = 0; i < applicants.size(); i++) {
            if (applicants.get(i).getId().equals(id)) {
                applicants.remove(applicants.get(i));
                System.out.println("你已成功删除该应聘者简历信息。");
            } else if (i == applicants.size()) {
                System.out.println("无该应聘者的简历！");
            }
        }
    }

    //显示简历信息
    public static void showResume(Resume resume) {
        System.out.println("姓名：" + resume.getName() + ", 学校：" + resume.getSchool() + ", 身份ID：" + resume.getId()
                + ", email:" + resume.getEmail());
    }

    //修改简历信息
    public static void modifyResume(List<Resume> applicants) {
        System.out.println("欢迎进入修改简历信息界面！");
        System.out.println("请输入应聘人员的身份证号码：");//因为身份证信息是唯一的。
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        String dId = input.nextLine();
        for (int i = 0; i < applicants.size(); i++) {
            Resume applicant = applicants.get(i);
            System.out.println(applicant.getId());
//        for (Resume applicant : applicants) {
            if (applicant.getId().equals(dId)) {
                System.out.println("该应聘人员的简历信息:");
                showResume(applicant);
                System.out.println("--------开始更新简历信息--------");
                System.out.println("请输入应聘者的名字：");
                String resumeName = input.nextLine();
                applicant.setName(resumeName);
                System.out.println("请输入应聘者的学校：");
                String resumeSchool = input.nextLine();
                applicant.setSchool(resumeSchool);
                System.out.println("请输入应聘者的身份Id：");
                String resumeId = input.nextLine();
                applicant.setId(resumeId);
                System.out.println("请输入应聘者的email：");
                String resumeEmail = input.nextLine();
                applicant.setEmail(resumeEmail);
                Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
                System.out.println("简历修改成功！");
                showResume(resume);
            } else if (i >= applicants.size()) {
                System.out.println("未找到该应聘者的简历！");
            }
        }
    }

    //查看简历
    public static void searchResume(List<Resume> applicants) {
        System.out.println("欢迎进入查询简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        boolean flag = true;
        while (flag) {
            System.out.println("查询全部---1");
            System.out.println("查询单人---2");
            System.out.println("退出查询---3");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    for (int i = 0; i < applicants.size(); i++) {
                        showResume(applicants.get(i));
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入你要查询的应聘者的身份ID：");
                    String tempID = input.next();
                    int temp;
                    System.out.println(applicants.get(0).getId());
                    for (int i = 0; i < applicants.size(); i++) {
                        if (applicants.get(i).getId().equals(tempID)) {
                            temp = i;
                            showResume(applicants.get(temp));
                        } else if (applicants.size() == i) {
                            System.out.println("未查询到该应聘者信息。");
                        }
                    }
                    break;
                }
                case 3:
                    flag = false;
                    break;
                default: {
                    System.out.println("输入错误！请重新输入：");
                }
            }
        }
    }
}
