package service;

import dao.HrDao;
import model.Resume;

import java.util.ArrayList;
import java.util.Scanner;

public class HrService {
    HrDao hrDao=new HrDao();

    //添加
    public  void addResume()
    {
        System.out.println("欢迎进入添加简历界面");

        Scanner input=new Scanner(System.in);
        System.out.println("请依次输入需要添加的名称，身份证号，学校");
        String Name=input.nextLine();
        String id=input.nextLine();
        String school=input.nextLine();

        //get/SET
        Resume resume=new Resume(Name,id,school);

        int line=  hrDao.addResume(resume);
        if(line==0){
            System.out.println("添加失败");
        }else{
            System.out.println("您已经成功添加简历");
        }

    }

    //删除
    public  void deleteResume()
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入删除简历界面");
        System.out.println("请输入需要删除的学生姓名");
        String studentName=input.nextLine();

        Resume resume=new Resume(studentName,null,null);
        int line=hrDao.deleteResumeByName(resume);
        if(line!=0)
        {
            System.out.println("删除学生成功");
        }
        else
        {
            System.out.println("没有找到该学生，无法删除");
        }


//		input.close();
    }

    //修改图书
    public  void updateResume()
    {
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入修改简历界面");
        System.out.println("请输入需要修改的学生姓名");
        String studentName=input.nextLine();
        Resume resume1=new Resume(studentName,null,null);
        System.out.println("请依次输入新的姓名，身份证号，学校");
        String name=input.nextLine();
        String id=input.nextLine();
        String school=input.nextLine();
        Resume resume2=new Resume(name,id,school);
        int line=hrDao.updateByName(resume1,resume2);
        if(line!=0)
        {
            System.out.println("修改学生成功");
        }
        else
        {
            System.out.println("没有找到该学生，无法修改");
        }



    }

    //查询图书
    public   void searchResume(ArrayList<Resume> resumeList)
    {
        @SuppressWarnings("resource")
        Scanner input=new Scanner(System.in);
        System.out.println("欢迎进入查询简历界面");
        while(true)
        {
            System.out.println("************欢迎来到查询简历界面************");
            System.out.println("按姓名查找请按----------1");
            System.out.println("按身份证查找请按----------2");
            System.out.println("按学校查找请按----------3");
            System.out.println("模糊查找请按------------4");
            System.out.println("退出请按----------------5");
            int choice =input.nextInt();
            if(choice==1)
            {
                searchResumeByName();
            }
            else if(choice==2)
            {
                searchResumeById();
            }
            else if(choice==3)
            {
               searchResumeBySchool();
            }
            else if(choice==4)
            {
                searchResumeByPointword();
            }
            else if(choice==5)
            {
                break;
            }
            else{
                System.out.println("输入错误");
            }
        }
    }

    private void searchResumeByPointword() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的学生姓名关键字");
        String Name =input.nextLine();
        Resume student=new Resume(Name,null,null);
        ArrayList<Resume> studentList=hrDao.searchBookByKeyword(student);
        int studentCount = studentList.size();
        if(studentCount>0)
        {
            for(int i=0;i<studentCount;i++) {
                System.out.println("学生姓名："+studentList.get(i).getName()+"  "
                        +"学生身份证："+"："+studentList.get(i).getId()+"  "
                        +"学生学校"+"："+studentList.get(i).getSchool()+"  ");
            }
        }
        else {
            System.out.println("没有找到姓名与"+Name+"有关的学生");
        }
    }

    private void searchResumeBySchool() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的学生学校");
        String school =input.nextLine();
        Resume student=new Resume(null,null,school);
        ArrayList<Resume> studentList=hrDao.searchBookBySchool(student);
        int studentCount = studentList.size();
        if(studentCount>0)
        {
            for(int i=0;i<studentCount;i++) {
                System.out.println("学生姓名："+studentList.get(i).getName()+"  "
                        +"学生身份证："+"："+studentList.get(i).getId()+"  "
                        +"学生学校"+"："+studentList.get(i).getSchool()+"  ");
            }
        }
        else {
            System.out.println("没有找到学校为"+school+"的学生");
        }
    }

    private void searchResumeById() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的学生身份证号");
        String id =input.nextLine();
        Resume student=new Resume(null,id,null);
        ArrayList<Resume> studentList=hrDao.searchBookById(student);
        int studentCount = studentList.size();
        if(studentCount>0)
        {
            for(int i=0;i<studentCount;i++) {
                System.out.println("学生姓名："+studentList.get(i).getName()+"  "
                        +"学生身份证："+"："+studentList.get(i).getId()+"  "
                        +"学生学校"+"："+studentList.get(i).getSchool()+"  ");
            }
        }
        else {
            System.out.println("没有找到身份证号为"+id+"的学生");
        }
    }

    private void searchResumeByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的学生姓名");
        String Name =input.nextLine();
        Resume student=new Resume(Name,null,null);
        ArrayList<Resume> studentList=hrDao.searchBookByName(student);
        int studentCount = studentList.size();
        if(studentCount>0)
        {
            for(int i=0;i<studentCount;i++) {
                System.out.println("学生姓名："+studentList.get(i).getName()+"  "
                        +"学生身份证："+"："+studentList.get(i).getId()+"  "
                        +"学生学校"+"："+studentList.get(i).getSchool()+"  ");
            }
        }
        else {
            System.out.println("没有找到姓名为"+Name+"的学生");
        }
    }
}
