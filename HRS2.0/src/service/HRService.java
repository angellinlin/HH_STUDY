package service;

import pojo.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HRService {
    public static void deleteResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请输入要删除的简历id");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (resumeArrayList.size() != 0) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if (resumeArrayList.get(i).getId().equals(id)) {
                    resumeArrayList.get(i).setDeleteStatus(0);
                    System.out.println("删除简历成功");
                    break;
                } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                    System.out.println("未找到对应简历");
                }
            }
        } else {
            System.out.println("系统中还未录入简历");
        }
    }

    public static void showResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("是否打印简历，是选择y");
        Scanner input = new Scanner(System.in);
        String choose = input.nextLine();
        String y = "y";
        if (choose.equals(y)) {
            if (resumeArrayList.size() != 0) {
                for (int i = 0; i < resumeArrayList.size(); i++) {
                    if (resumeArrayList.get(i).getDeleteStatus() == 1) {
                        System.out.println(resumeArrayList.get(i));
                    }
                }
            } else {
                System.out.println("系统中还未录入简历");
            }
        }
    }

    public static void addResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请添加简历");
        Scanner input = new Scanner(System.in);
        String name = input.nextLine();
        String id = input.nextLine();
        String school = input.nextLine();
        int status = input.nextInt();
        //int deleteStatus = input.nextInt();

        Resume newResume = new Resume(name, id, school, status, 1); //deleteStatus默认为1（展示）
        newResume.setName(name);
        newResume.setId(id);
        newResume.setSchool(school);
        newResume.setStatus(status);
        newResume.setDeleteStatus(1);
        resumeArrayList.add(newResume);
        showResume(resumeArrayList);
    }


    public static void queryResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请输入id查询简历");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (resumeArrayList != null) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if (resumeArrayList.get(i).getId().equals(id)) {
                    if (resumeArrayList.get(i).getDeleteStatus() == 1) {
                        System.out.println(resumeArrayList.get(i).getName());
                        break;
                    } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                        System.out.println("未找到对应简历");
                    }
                } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                    System.out.println("未找到对应简历");
                }
            }
        } else {
            System.out.println("系统中还未录入简历");
        }
    }

    public static void updateResume(ArrayList<Resume> resumeArrayList) {
        System.out.println("请输入要修改的简历id");
        Scanner input = new Scanner(System.in);
        String id = input.nextLine();
        if (resumeArrayList.size() != 0) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if (resumeArrayList.get(i).getId().equals(id) && resumeArrayList.get(i).getDeleteStatus() == 1) {
                    System.out.println("请输入新的简历信息");
                    String newName = input.nextLine();
                    String newId = input.nextLine();
                    String newSchool = input.nextLine();
                    int newStatus = input.nextInt();
                   // int newDeleteStatus = input.nextInt();
                    Resume newResume = new Resume(newName, newId, newSchool, newStatus, 1); //deleteStatus默认为1（展示）
                    resumeArrayList.set(i, newResume);
                    showResume(resumeArrayList);
                } else if (i == resumeArrayList.size() - 1) { //遍历完之后还没有，就打印一次未找到
                    System.out.println("未找到对应简历");
                }
            }
        } else {
            System.out.println("系统中还未录入简历");
        }
    }
}
