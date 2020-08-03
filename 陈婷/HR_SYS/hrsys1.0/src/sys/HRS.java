package sys;

import bean.Resume;
import bean.ResumeList;

import java.util.ArrayList;
import java.util.Scanner;

public class HRS {
    // 简历数的最大值
    private int MAXSIZE = 100;
    int resumeCount = 0;
    // 数组的长度不可以发生改变，但是ArrayList的长度是可以随意变化的。
    ArrayList<Resume> resumeArrayList = new ArrayList();
    ResumeList resumes = new ResumeList();

    // 获取标准输入流用于输入简历信息
    private Scanner input = new Scanner(System.in);

    // 简历遍历
    void showResume(){
        // 给编译器一条指令,告诉它对被批注的代码元素内部的某些警告保持静默
        @SuppressWarnings("resoure")
        Scanner input = new Scanner(System.in);
        System.out.println("是否需要打印所有简历信息，是请输入Y，不用打印则输入任意键");
        String choice = input.nextLine();
        String Y = "Y";
        if(choice.equals(Y)){
            System.out.println("简历管理系统共有" + resumeCount + "份简历");
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if(resumeArrayList.get(i).getDeleteStatus()==1) {
                    System.out.println("姓名：" + resumeArrayList.get(i).getName() + "，身份证号：" + resumeArrayList.get(i).getId() + "，学校：" + resumeArrayList.get(i).getSchool());
                }
            }
        }
    }
    // 1.添加简历
    void addResume(){
        System.out.println("[欢迎进入添加简历界面]");
        // 添加前判断是否已满
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
            resumeArrayList.add(newResume);
            resumeCount++;
            System.out.println("简历添加成功！");
            // 显示简历信息
            showResume();
        }else{
            System.out.println("简历管理系统已满，无法添加简历！");
        }
    }

    // 2.删除简历
    void deleteResume(){
        @SuppressWarnings("resoure")
        Scanner input = new Scanner(System.in);
        System.out.println("[欢迎进入删除简历界面]");
        System.out.println("请输入需要删除简历的姓名");
        String name = input.nextLine();
        // 删除前判断是否为空
        if(resumeArrayList.size() != 0){
            for (int i = 0; i < resumeArrayList.size(); i++) {
                // 该简历存在，并且逻辑上未被删除
                //equals用于比较字符串内容是否相等，==用于比较地址
                if((resumeArrayList.get(i).getName().equals(name)) && (resumeArrayList.get(i).getDeleteStatus()==1)){
                    // 实现逻辑删除，即显示简历信息时不展示该条记录
                    resumeArrayList.get(i).setDeleteStatus(0);
                    resumeCount--;
                    System.out.println("成功删除该简历信息");
                    break;
                }else if(i == resumeArrayList.size() - 1){
                    System.out.println("未找到该简历记录！");
                }
            }
            showResume();
        }else{
            System.out.println("系统为空，未找到该简历记录！");
        }
    }

    // 3.修改简历
    void updateResume(){
        Scanner input = new Scanner(System.in);
        System.out.println("[欢迎进图修改简历界面]");
        System.out.println("请输入需要修改简历的姓名");
        String name = input.nextLine();
        if(resumeArrayList.size() != 0){
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if((resumeArrayList.get(i).getName().equals(name)) && (resumeArrayList.get(i).getDeleteStatus()==1)){
                    System.out.println("请依次输入需要修改的姓名，身份证号，学校");
                    String newName = input.nextLine();
                    String newId = input.nextLine();
                    String newSchool = input.nextLine();

                    Resume newResume = new Resume(newName, newId, newSchool);
                    //
                    resumeArrayList.set(i, newResume);
                    System.out.println("已成功修改简历！");
                    break;
                }else if(i == resumeArrayList.size() - 1){
                    System.out.println("未找到该简历记录！");
                }
            }
            // 显示简历信息
            showResume();
        }else{
            System.out.println("系统为空，未找到该简历记录！");
        }
    }
    // 4.查询简历
    void searchResume(){
        @SuppressWarnings("resource")
        Scanner input = new Scanner(System.in);
        System.out.println("[欢迎进入查询简历界面]");
        System.out.println("请输入需要查询简历的姓名");
        String name = input.nextLine();
        if(resumeArrayList.size() != 0) {
            for (int i = 0; i < resumeArrayList.size(); i++) {
                if ((resumeArrayList.get(i).getName().equals(name)) && (resumeArrayList.get(i).getDeleteStatus() == 1)) {
                    System.out.println("所查找的简历信息为 姓名：" + resumeArrayList.get(i).getName() + ", 身份证号：" + resumeArrayList.get(i).getId() + ", 学校：" + resumeArrayList.get(i).getSchool());
                    break;
                } else if(i == resumeArrayList.size() - 1 ) {
                    System.out.println("未找到该简历记录！");
                }
            }
            showResume();
        }else{
            System.out.println("系统为空，未找到该简历记录！");
        }
    }
    // 5.退出

    HRS(){
        // 控制循环
        int flag = 1;
        do{
            // 打印提示信息
            System.out.println("-----欢迎使用简历管理系统-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按----5");

            // 获取键盘指令
            int choice = input.nextInt();
            // 使用 switch 分支语句实现
            switch (choice){
                case 1:
                    addResume();
                    break;
                case 2:
                    deleteResume();
                    break;
                case 3:
                    updateResume();
                    break;
                case 4:
                    searchResume();
                    break;
                case 5:
                    flag = 0;
                    break;
                default:
                    System.out.println("输入有误，请重新输入：");
                    break;
            }

        }while(flag == 1);
        System.out.println("已成功退出简历管理系统！");
    }

    public static void main(String[] args) {
        new HRS();
    }
}
