package sys;

import bean.DataOperate;
import bean.Resume;
import bean.Service;

import java.util.LinkedList;
import java.util.Scanner;

/*
 1.采用文本来实现招聘系统
 2.修改第一版中查找与删除、修改中的bug（结束查找的判断语句没写，导致每次只能判断链表中的一个元素就break了）
 3.这里如果还是采用原来的逻辑删除模式，在系统操作删除的时候可以在链表中实现。但是文本当中的简历信息并不会删除，下一次查找还有。
 4.要想用逻辑删就得把逻辑控制符写入到文本中，读取的时候也读取。
 */

public class HRS02 {
    public static void main(String[] args) {
        /*
        修改运用linkedlist来创建集合，相较于动态数组模式增删更快
        */
        LinkedList<Resume> resumeLinkedList = new LinkedList<Resume>();

        //获取标准输入流用于输入简历信息
        Scanner resumeInfor = new Scanner(System.in);
        DataOperate.loadData(resumeLinkedList);//写一个类，每次做操作之前应该读入所有的简历信息，同时操作完需要保存
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
                    Service.addResumeInfo(resumeLinkedList);//没有创建对象直接调用静态方法
                    break;//没有break的话会被穿透，不可省略
                case 2:
                    Service.delResumeInfo(resumeLinkedList);
                    break;
                case 3:
                    Service.updateResumeInfo(resumeLinkedList);
                    break;
                case 4:
                    Service.researchResumeInfo(resumeLinkedList);
                    break;
                case 5:
                    Service.showResumeInfo(resumeLinkedList);
                    break;
                case 6:
                    DataOperate.saveData(resumeLinkedList);//所有操作结束之后，将信息存入到文件中
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