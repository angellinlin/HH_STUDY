package bean;

import bean.Resume;

import java.util.LinkedList;
import java.util.Scanner;

public class ResumeService {

    // 简历遍历
    public static void showResume(LinkedList<Resume> resumeLinkedList){
        // 给编译器一条指令,告诉它对被批注的代码元素内部的某些警告保持静默
        @SuppressWarnings("resoure")
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有简历信息，是请输入Y，不用打印则输入任意键");
        String choice = input.nextLine();
        String Y = "Y";
        int resumeCount = resumeLinkedList.size();
        if(choice.equals(Y)){
            System.out.println("简历管理系统共有" + resumeCount + "份简历");
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                if(resumeLinkedList.get(i).getDeleteStatus()==1) {
                    System.out.println("姓名：" + resumeLinkedList.get(i).getName() + "，身份证号：" + resumeLinkedList.get(i).getId() + "，学校：" + resumeLinkedList.get(i).getSchool());
                }
            }
        }
    }

    // 1.添加简历
    public static void addResume(LinkedList<Resume> resumeLinkedList){
        System.out.println("[欢迎进入添加简历界面]");
        // 添加前判断是否已满
        int MAXSIZE = 100;
        int resumeCount = resumeLinkedList.size();
        if(resumeCount < MAXSIZE){
            // 从键盘输入获取简历信息
            Scanner input = new Scanner(System.in);
            System.out.println("请依次输入需要添加的姓名，身份证号，学校");
            String name = input.nextLine();
            String id = input.nextLine();
            String school = input.nextLine();

            // 使用有参构造赋值
            Resume newResume = new Resume(name, id, school);
            // 添加到简历集合中
            resumeLinkedList.add(newResume);
            resumeCount++;
            System.out.println("简历添加成功！");
            // 显示简历信息
            showResume(resumeLinkedList);
        }else{
            System.out.println("简历管理系统已满，无法添加简历！");
        }
    }

    // 2.删除简历
    public static void deleteResume(LinkedList<Resume> resumeLinkedList){
        @SuppressWarnings("resoure")
        Scanner input = new Scanner(System.in);
        System.out.println("[欢迎进入删除简历界面]");
        System.out.println("请输入需要删除简历的姓名");
        String name = input.nextLine();
        // 删除前判断是否为空
        int resumeCount = resumeLinkedList.size();
        if(resumeLinkedList.size() != 0){
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                // 若该简历存在
                //equals用于比较字符串内容是否相等，==用于比较地址
                if(resumeLinkedList.get(i).getName().equals(name)){
                    // 实现逻辑删除，即显示简历信息时不展示该条记录
//                    resumeLinkedList.get(i).setDeleteStatus(0);
                    // 实现物理删除
                    resumeLinkedList.remove(i);
                    resumeCount--;
                    System.out.println("成功删除该简历信息");
                    // 一旦删除成功即退出
                    break;
                }else if(i == resumeLinkedList.size() - 1){
                    System.out.println("未找到该简历记录！");
                }
            }
            showResume(resumeLinkedList);
        }else{
            System.out.println("系统为空，未找到该简历记录！");
        }
    }

    // 3.修改简历
    public static void updateResume(LinkedList<Resume> resumeLinkedList){
        Scanner input = new Scanner(System.in);
        System.out.println("[欢迎进图修改简历界面]");
        System.out.println("请输入需要修改简历的姓名");
        String name = input.nextLine();
        if(resumeLinkedList.size() != 0){
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                if(resumeLinkedList.get(i).getName().equals(name)){
                    System.out.println("请依次输入需要修改的姓名，身份证号，学校");
                    String newName = input.nextLine();
                    String newId = input.nextLine();
                    String newSchool = input.nextLine();

                    Resume newResume = new Resume(newName, newId, newSchool);
                    //
                    resumeLinkedList.set(i, newResume);
                    System.out.println("已成功修改简历！");
                    break;
                }else if(i == resumeLinkedList.size() - 1){
                    System.out.println("未找到该简历记录！");
                }
            }
            // 显示简历信息
            showResume(resumeLinkedList);
        }else{
            System.out.println("系统为空，未找到该简历记录！");
        }
    }
    // 4.查询简历
    public static void searchResume(LinkedList<Resume> resumeLinkedList){
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("[欢迎进入查询简历界面]");
        System.out.println("请输入需要查询简历的姓名");
        String name = input.nextLine();
        if(resumeLinkedList.size() != 0) {
            for (int i = 0; i < resumeLinkedList.size(); i++) {
                if (resumeLinkedList.get(i).getName().equals(name)) {
                    System.out.println("所查找的简历信息为 姓名：" + resumeLinkedList.get(i).getName() + ", 身份证号：" + resumeLinkedList.get(i).getId() + ", 学校：" + resumeLinkedList.get(i).getSchool());
                    break;
                } else if(i == resumeLinkedList.size() - 1 ) {
                    System.out.println("未找到该简历记录！");
                }
            }
            showResume(resumeLinkedList);
        }else{
            System.out.println("系统为空，未找到该简历记录！");
        }
    }
}
