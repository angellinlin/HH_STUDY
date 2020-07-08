package service;

import model.Resume;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class HrService {


    //添加
    public  void addResume(ArrayList<Resume> resumeList)
    {
        System.out.println("欢迎进入添加简历界面");

        Scanner input=new Scanner(System.in);
        System.out.println("请依次输入需要添加的名称，身份证号，学校");
        String Name=input.nextLine();
        String id=input.nextLine();
        String school=input.nextLine();

        //get/SET
        Resume resume=new Resume(Name,id,school);

        resumeList.add(resume);
        System.out.println("您已经成功添加简历");
        showResumeList(resumeList);
    }

    //删除
    public  void deleteResume(ArrayList<Resume> resumeList)
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除的学生姓名");
        String studentName=input.nextLine();
        if(resumeList.size()!=0)//图书管理系统不为空
        {
            for(int i=0;i<resumeList.size();i++)
            {
                if(resumeList.get(i).getName().equals(studentName))
                {
                    resumeList.remove(i);
                    System.out.println("您已经成功删除");
                    break;
                }
                else if(i==resumeList.size()-1) {
                    System.out.println("没有找到该学生的简历");
                }
            }
            showResumeList(resumeList);
        }
        else{
            System.out.println("HR招聘系统为空，没有找到该简历");
        }
//		input.close();
    }

    //修改图书
    public  void updateResume(ArrayList<Resume> resumeList)
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改的学生姓名");
        String studentName=input.nextLine();
        if(resumeList.size()!=0)//图书管理系统不为空
        {
            for(int i=0;i<resumeList.size();i++)
            {
                if(resumeList.get(i).getName().equals(studentName))
                {
                    System.out.println("请依次输入新的姓名，身份证号，学校");
                    String name=input.nextLine();
                    String id=input.nextLine();
                    String school=input.nextLine();
                    resumeList.get(i).setName(name);
                    resumeList.get(i).setId(id);
                    resumeList.get(i).setSchool(school);
                    System.out.println("您已经修改成功");
                    showResumeList(resumeList);
                }
                else if(i==resumeList.size()-1) {
                    System.out.println("没有查找到该简历");
                }
            }
        }
        else{
            System.out.println("系统为空，没有查找到该简历");
        }
//		input.close();
    }

    //查询图书
    public   void searchResume(ArrayList<Resume> resumeList)
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询简历界面");
        System.out.println("请输入需要查询的学生姓名");
        String studentName=input.nextLine();
        for(int i=0;i<resumeList.size();i++)
        {
            if(resumeList.get(i).getName().equals(studentName))
            {
                System.out.println("学生"+resumeList.get(i).getName()+"\n"+
                        "身份证"+":"+resumeList.get(i).getId()+"\n"
                        +"学校"+":"+resumeList.get(i).getSchool()+"\n"
                        +"位于第"+(i+1)+"位置");
                break;
            }
            else if(i==resumeList.size()-1) {
                System.out.println("没有查找到该简历，请重新输入");
            }
        }
//		input.close();
    }

    //简历遍历
    public   void showResumeList(ArrayList<Resume> resumeList)
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        String XUANZE=input.nextLine();
        String Y="Y";
        if(XUANZE.equals(Y))
        {
            System.out.println("本HR招聘系统共有"+resumeList.size()+"份简历");
            for(int i=0;i<resumeList.size();i++) {
                System.out.println("第"+(i+1)+"份简历"+"----"+"<<"+resumeList.get(i).getName()+">>");
            }
        }
//		input.close();
    }
}
