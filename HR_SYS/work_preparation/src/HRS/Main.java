package HRS;

import work.HROperation;
import database.DBConnection;
import bean.Resume;
import bean.ResumeList;

import java.util.Scanner;

public class Main {
    public static void HRS() {
        while(true) {
            System.out.println("欢迎进入hr系统！");
            System.out.println("0：插入；1：查询；2：修改；3：删除;-1：退出");
            System.out.print("请输入想要进行的操作：");
            Scanner sc = new Scanner(System.in);
            int operation = sc.nextInt();
//            ResumeList listM = new ResumeList();
            switch (operation) {
                case 0:
                    addResume();
                    break;
                case 1:
                    searchResume();
                    break;
                case 2:
                    updateResume();
                    break;
                case 3:
                    deleteResume();
                    break;
                case -1:
                    System.out.println("退出HR系统！");
                    return;
                default:
                    System.out.println("输入错误！");
            }
        }
    }
    /*
     * 名字
     * 身份证号
     * 学校
     * */
    // 此处只添加操作输入信息，具体操作另外打包，
    private static void addResume(){
        System.out.println("请依次输入需要添加的信息：名字；身份证号；学校");
        Scanner input = new Scanner(System.in);
        String name = input.next();
        String id = input.next();
        String school = input.next();
        HROperation hrO = new HROperation();
        int temp = hrO.insertPerson(new Resume(name,id,school));
        if(temp>0){
            System.out.println("添加成功！");
        }else{
            System.out.println("添加失败！");
        }
    }
    private static void deleteResume(){
        while(true){
            System.out.println("************欢迎来到简历删除界面************");
            System.out.println("按名字删除请按----------1");
            System.out.println("按身份证号删除请按----------2");
            System.out.println("退出请按--------------3");
            Scanner input = new Scanner(System.in);
            int choice =input.nextInt();
            if(choice==1) {
                deleteByName();
            }else if(choice==2) {
                deleteById();
            } else if(choice==3) {
                System.out.println("退出！");
                break;
            } else{
                System.out.println("输入错误！");
            }
        }
    }
    private static void deleteById() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的id");
        String id = input.nextLine();
        Resume resume = new Resume(null,id,null);
        HROperation hrO = new HROperation();
        int line = hrO.deleteById(resume);
        if(line>0) {
            System.out.println("按名字删除成功");
        }else {
            System.out.println("没有找到该名字，无法删除");
        }
    }
    private static void deleteByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要删除的名字");
        String name = input.nextLine();
        Resume resume = new Resume(name,null,null);
        HROperation hrO = new HROperation();
        int line = hrO.deleteByName(resume);
        if(line>0) {
            System.out.println("按名字删除成功");
        }else {
            System.out.println("没有找到该名字，无法删除");
        }
    }
    private static void searchResume(){
        while(true)
        {
            System.out.println("************欢迎来到查询图书界面************");
            System.out.println("按姓名查找请按----------1");
            System.out.println("退出请按----------------5");
            Scanner input = new Scanner(System.in);
            int choice =input.nextInt();
            if(choice==1) {
                searchByName();
            } else if(choice==5) {
                System.out.println("退出查询！");
                break;
            } else{
                System.out.println("输入错误！");
            }
        }
    }
    private static void searchByName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入需要查询的姓名");
        String name =input.nextLine();
        Resume resume=new Resume(name,null,null);
        HROperation hrO = new HROperation();
        ResumeList resumeList = hrO.searchByName(resume);
        int bookCount = resumeList.size();
        if(bookCount>0) {
            for(int i = 0; i < bookCount; i ++) {
                Resume re = resumeList.get(i);
                System.out.println(name + "  " + re.getId() + "  " + re.getSchool());
            }
        } else {
            System.out.println("没有找到!");
        }
    }
    private static void updateResume(){
        while(true){
            System.out.println("************欢迎来到简历更新界面************");
            System.out.println("更新建立基本信息按----------1");
            System.out.println("更新简历状态请按----------2");
            System.out.println("退出请按--------------3");
            Scanner input = new Scanner(System.in);
            int choice =input.nextInt();
            if(choice==1) {
                updateResumName();
            }else if(choice==2) {
                updateResumeProcess();
            } else if(choice==3) {
                System.out.println("退出！");
                break;
            } else{
                System.out.println("输入错误！");
            }
        }
    }
    private static void updateResumName() {
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入修改前信息（原始）：名字，身份证号，学校 ");
        String nameOld = input.next();
        String idOld = input.next();
        String schoolOld = input.next();
        Resume resumeOld = new Resume(nameOld,idOld,schoolOld);
        System.out.println("请依次输入要修改信息（更新）：名字，身份证号，学校 ");
        String nameNew = input.next();
        String idNew = input.next();
        String schoolNew = input.next();
        Resume resumeNew = new Resume(nameNew,idNew,schoolNew);
        HROperation hrO = new HROperation();
        int temp = hrO.updateResumName(resumeOld, resumeNew);
        if(temp>0) {
            System.out.println("名字修改成功！");
        }else {
            System.out.println("名字修改失败！");
        }
    }
    private static void updateResumeProcess() {
        Scanner input = new Scanner(System.in);
        System.out.println("请依次输入要修改的简历信息以及最新的简历状态：名字，身份证号，学校，简历状态 ");
        String name = input.next();
        String id = input.next();
        String school = input.next();
        Resume resumeOld = new Resume(name,id,school);
        int process = input.nextInt();
        HROperation hrO = new HROperation();
        int temp = hrO.updateResumeProcess(resumeOld, process);
        if(temp>0) {
            System.out.println("简历状态修改成功！");
        }else {
            System.out.println("简历状态修改失败！");
        }
    }
    public static void main(String[] args) {
        HRS();
    }
}
