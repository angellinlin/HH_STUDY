package bean;

import sun.management.FileSystem;

import java.util.LinkedList;
import java.util.Scanner;

public class OperateInTxt {
    /**
     * 构造成一个linkedlist,其与arraylist的区别在于:
     * 效率不同 arraylist:动态数组,get,set效率更高,而linkedlist,是链表结构,线性存储,指针移动所以效率第
     * 但linkedlist的add与remove效率更高,原因arraylist删除和增加数据index会变化,数据会移动
     * arraylist容量低,需手动设置容量,而linkedlist动态扩容
     */

    /*将people类构建为一个数组,每个数组包含其具体信息,存入链表*/
    LinkedList<People> peopleLinkedList = new LinkedList<People>();


    // 待修改
    public void add() {
        System.out.println("进入人员添加界面");
        /**
         * 主 利用FileOutStream类 和 BufferReader类
         */


        try {
            System.out.println("请按照格式依次输入:姓名,ID,学校");
            Scanner scanner = new Scanner(System.in);
            String strs = scanner.nextLine();
            String[] tempinfos = strs.split(",");
            String tempName = tempinfos[0];
            int tempID = Integer.parseInt(tempinfos[1]);
            String tempSchool = tempinfos[2];
            People people = new People(tempName, tempID, tempSchool);
            peopleLinkedList.add(people);

            System.out.println("信息录入成功");
            System.out.println(peopleLinkedList.getLast().getPeopleName() + peopleLinkedList.getLast().getId() + peopleLinkedList.getLast().getSchool());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("格式输入错误,请重新输入");
            add();
        }

    }

    // 待修改
    public void delete() {
        System.out.println("进入信息删除界面");

        try {
            System.out.println("请输入删除人员ID");
            Scanner scanner = new Scanner(System.in);
            int deleteID = scanner.nextInt();

            // 假设ID不变
            for (int i = 0; i < peopleLinkedList.size(); i++) {
                if (peopleLinkedList.get(i).getId() == deleteID) {
                    peopleLinkedList.remove(i);
                    break;
                }
            }
            System.out.println("信息删除完成");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("格式输入错误,请重新输入");
            delete();
        }

    }

    // 待修改
    public void change() {
        System.out.println("进入信息修改界面");
        int changeIndex = -1;
        try {
            System.out.println("请按照格式依次输入修改项:姓名,ID(原则不变),学校");
            Scanner scanner = new Scanner(System.in);
            String strs = scanner.nextLine();
            String[] newInfos = strs.split(",");
            String newName = newInfos[0];
            int newID = Integer.parseInt(newInfos[1]);
            String newSchool = newInfos[2];
            People newpeopleinfo = new People(newName, newID, newSchool);
            // 假设ID不变
            for (int i = 0; i < peopleLinkedList.size(); i++) {
                if (peopleLinkedList.get(i).getId() == newID) {
                    changeIndex = i;
                    peopleLinkedList.set(changeIndex, newpeopleinfo);
                    break;
                }
            }
            System.out.println("信息修改完成!!!");
            System.out.println("修改信息为：" + peopleLinkedList.get(changeIndex).getPeopleName() + "," + peopleLinkedList.get(changeIndex).getId() + "," + peopleLinkedList.get(changeIndex).getSchool());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("格式输入错误,请重新输入!!!");
            change();
        }

    }

    // 待修改
    public void search() {
        System.out.println("查询所有人员请输入 Y " + "," + "或直接输入人员 ID");
        Scanner input = new Scanner(System.in);
        if (input.nextLine().equals("Y")) {
            readInfo();
        } else if (Integer.valueOf(input.nextLine()) > 0) {
            readInfo(Integer.valueOf(input.nextLine()));
        } else {
            System.out.println("查询输入错误,请重新输入");
        }
    }

    // 待修改
    // 重载两个不同参数方法,实现两种类型的查询
    // 所有数据遍历
    public void readInfo() {
        System.out.println("当前共有" + peopleLinkedList.size() + "人员注册入库");
        for (int i = 0; i < peopleLinkedList.size(); i++) {
            System.out.println("姓名：" + peopleLinkedList.get(i).getPeopleName() + "ID:" + peopleLinkedList.get(i).getId() + "学校：" + peopleLinkedList.get(i).getSchool());
        }
    }

    // 指定类型查询
    public void readInfo(int peopleID) {
        System.out.println("第" + peopleID + "人员注册入库");
        for (int i = 0; i < peopleLinkedList.size(); i++) {
            if (peopleLinkedList.get(i).getId() == peopleID) {
                System.out.println("姓名：" + peopleLinkedList.get(i).getPeopleName() + "ID:" + peopleLinkedList.get(i).getId() + "学校：" + peopleLinkedList.get(i).getSchool());
            } else {
                System.out.println("无该人员或重新输入！！！");
            }
        }
    }
}
