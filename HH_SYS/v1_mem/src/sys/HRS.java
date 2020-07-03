package sys;

import bean.Resume;
import pojo.ResumeList;

import java.util.Scanner;
import java.util.Vector;

/**
 * @program: HR_SYS
 * @description: 逻辑处理
 * @author: 朱戈
 * @create: 2020-7-3 11:00
 * @PS: 不用for循环，尝试了数组的lambda遍历，踩了一些坑
 **/
public class HRS {

    private ResumeList resumeList;
    private Scanner input = new Scanner(System.in);

    HRS() {
        resumeList=new ResumeList();//初始化不要忘记
        while (true) {
            System.out.println("-----欢迎进入招聘系统V1-----");

            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按--------5");
            int choice = input.nextInt();
            switch (choice) {
                case 0:getResumeList();break;
                case 1:addResume();break;
                case 2:deleteResume();break;
                case 3:updateResume();break;
                case 4:getResume();break;
                case 5:exit();return;
                default:System.out.println("输入错误，请重新输入");break;
            }
        }
    }

    /**/
    void addResume() {
        System.out.println("请依次输入【简历】的姓名，身份证号，学校，简历状态");
        Scanner input = new Scanner(System.in);//新建/初始化流

        String resumeName = input.nextLine();

        String resumeId = input.nextLine();
        String resumeSchool = input.nextLine();
        int resumeStatus = input.nextInt();
        resumeList.add(new Resume(resumeName, resumeId, resumeSchool, resumeStatus));
        System.out.println("您已经成功添加简历");
    }

    /**/
    void deleteResume() {
        if (resumeList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("请输入需要【删除】简历的身份证号");
        Scanner input = new Scanner(System.in);

        String resumeId = input.nextLine();
        int previousSize = resumeList.size();
        Vector<Resume> v = new Vector<Resume>();
        resumeList.forEach(x -> {
            if (x.getId().equals(resumeId)) v.add(x);//无法用三元运算符，三元运算符的表达式必须有值，比如不能是Syso
        });
        resumeList.removeAll(v);
        System.out.println(previousSize != resumeList.size() ? "您已经成功删除简历" : "未能找到该简历");
        getResumeList();
    }

    /**/
    void updateResume() {
        if (resumeList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("请输入需要【修改】简历的身份证号");
        Scanner input = new Scanner(System.in);
        Vector<Resume> v = new Vector<Resume>();
        String resumeId = input.nextLine();
        boolean[] hasUpdated = {false}; /*判断是否成功修改*/
        /* Java lambda表达式的参数只能是传值方式，无法支持引用传递（C++可），因此只能用数组来实现修改外部变量的效果*/
        /* ArrayList在遍历时，无法添加/删除元素（会修改modCount），否则将抛出异常：
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
        */
        /*foreach 不能break*/
        /*Vector是线程安全，速度慢；ArrayList则不是，速度快；它们都是基于数组实现的*/
        resumeList.forEach(x -> {
            if (x.getId().equals(resumeId)) {//String的判等要用equals函数，不能直接用==
                //resumeList.remove(x); 抛出异常
                v.add(x);
                hasUpdated[0] = true;
            }
        });
        resumeList.removeAll(v);//由于不支持遍历时修改，只能在遍历后统一删除
        addResume();
        System.out.println(hasUpdated[0] ? "您已经成功修改简历" : "未能找到该简历");
    }

    /**/
    void getResume() {
        System.out.println("请输入需要查询简历的身份证号");
        Scanner input = new Scanner(System.in);

        String resumeId = input.nextLine();
        String printInfo[] = {"未能找到该简历"};
        int idx[] = {0};
        resumeList.forEach(x -> {
            if (x.getId().equals(resumeId)) {
                printInfo[0] = "简历姓名：" + x.getName() + "\n"
                        + "身份证号：" + x.getId() + "\n"
                        + "学校：" + x.getSchool() + "\n"
                        + "简历状态：" + x.getProcess() + "\n"
                        + "位于第" + idx[0] + "位置";
            }
            ++idx[0];
        });
        System.out.println(printInfo[0]);
    }

    /**/
    void getResumeList() {
        if (resumeList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        Scanner input = new Scanner(System.in);

        String choice = input.nextLine();
        if (!choice.equals("Y")) return;
        int idx[] = {0};
        resumeList.forEach(x -> {
            System.out.println("第" + (idx[0] + 1) + "份简历：\n"
                    + "    简历姓名：" + x.getName() + "\n"
                    + "    身份证号：" + x.getId() + "\n"
                    + "    学校：" + x.getSchool() + "\n"
                    + "    简历状态：" + x.getProcess() + "\n");
            ++idx[0];
        });

    }

    /**/
    void exit() {
        //input.close(); 已经关闭
        System.out.println("您已经退出图书管理系统");

    }

    public static void main(String[] args) {
        new HRS();
    }
}
