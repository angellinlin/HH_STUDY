package sys;

import java.util.ArrayList;
import java.util.Scanner;

import bean.Resume;
import bean.Service;

/*
基于控制台的招聘系统，实现增删查改，修改了逻辑删除方式
问题：没有做异常处理，当输入的信息不符合规范的时候程序就直接终止了
* */
public class HRS {

    /*
    运用ArrayList来创建集合，相较于数组来说可以改变长度。后续学习了linkedlist后可考虑修改
    Arrailist与Linkedlist区别：后者是链表结构，前者是动态数组，增删后者占优势。
    */
    ArrayList<Resume> resumeArrayList = new ArrayList<>();

    //获取标准输入流用于输入简历信息
    Scanner resumeInfor = new Scanner(System.in);

    //将系统实现封装为一个类
    public static void main(String[] args) {
        HRS hrSystem = new HRS();//创建对象，因为只用一次可以采用匿名对象
    }

    HRS() {
        int flag = 1;
        do {
            System.out.println("-----欢迎进入xxx公司招聘系统-----");
            System.out.println("添加个人简历请按----1");
            System.out.println("删除个人简历请按----2");
            System.out.println("修改个人简历请按----3");
            System.out.println("查询个人简历请按----4");
            System.out.println("遍历简历信息请按----5");
            System.out.println("退出招聘系统请按--------6");

            int choice = resumeInfor.nextInt();//获取键盘指令
            //switch实现
            switch (choice) {

                case 1:
                    Service.addResumeInfo(resumeArrayList);//没有创建对象直接调用静态方法
                    break;//没有break的话会被穿透，不可省略
                case 2:
                    Service.delResumeInfo(resumeArrayList);
                    break;
                case 3:
                    Service.updateResumeInfo(resumeArrayList);
                    break;
                case 4:
                    Service.researchResumeInfo(resumeArrayList);
                    break;
                case 5:
                    Service.showResumeInfo(resumeArrayList);
                    break;
                case 6:
                    flag = 0;//控制循环结束
                    break;
                default:
                    System.out.println("输入错误，请重新输入");
                    break;
            }
        } while (flag == 1);

        System.out.println("您已退出招聘系统");
    }

}