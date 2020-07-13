package bean;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

public class PersistenceStorageInTxt {
    /**
     * 构造成一个linkedlist,其与arraylist的区别在于:
     * 效率不同 arraylist:动态数组,get,set效率更高,而linkedlist,是链表结构,线性存储,指针移动所以效率第
     * 但linkedlist的add与remove效率更高,原因arraylist删除和增加数据index会变化,数据会移动
     * arraylist容量低,需手动设置容量,而linkedlist动态扩容
     */

    /*将people类构建为一个数组,每个数组包含其具体信息,存入链表*/
    LinkedList<People> peopleLinkedList = new LinkedList<People>();

    public static final String path = "C:\\Users\\fanlei\\IdeaProjects\\lowsystem2.0\\src\\main\\java\\DBTxT\\peopleDB.txt";

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

            // 开启防覆盖模式   文件写入模块
            FileWriter fileWriter = new FileWriter(path, true);
            BufferedWriter writerIn = new BufferedWriter(fileWriter);
            String peopleInfo = people.getPeopleName() + "," + people.getId() + "," + people.getSchool();
            writerIn.write(peopleInfo);
            writerIn.write("\n");
            writerIn.flush();
            System.out.println("信息录入成功");
            writerIn.close();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("格式输入错误,请重新输入");
            add();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 待修改
    public void delete() {
        System.out.println("进入信息删除界面");

        String newInfo = "";
        try {
            System.out.println("请输入删除人员ID");
            Scanner scanner = new Scanner(System.in);
            int deleteID = scanner.nextInt();

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String deleteInfo = "";
            while ((deleteInfo = bufferedReader.readLine()) != null) {

                String[] strings = deleteInfo.split(",");
                if (Integer.valueOf(strings[1]) == deleteID) {
                    newInfo += "";
                } else {
                    newInfo += deleteInfo + "\n";
                }
            }
            System.out.println("人员信息已删除！当前信息：" + newInfo);

            // 开启防覆盖模式   文件写入模块
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter writerIn = new BufferedWriter(fileWriter);
            writerIn.write(newInfo);
            writerIn.write("\n");
            writerIn.flush();
            System.out.println("修改信息录入成功");
            writerIn.close();

            System.out.println("信息删除完成");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("格式输入错误,请重新输入");
            delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 待修改
    public void change() {
        System.out.println("进入信息修改界面");

        String newInfo = "";
        try {
            System.out.println("请输入修改信息");
            Scanner scanner = new Scanner(System.in);
            String strs = scanner.nextLine();
            String[] tempinfos = strs.split(",");
            String tempName = tempinfos[0];
            int tempID = Integer.parseInt(tempinfos[1]);
            String tempSchool = tempinfos[2];
            People people = new People(tempName, tempID, tempSchool);
            String peopleInfo = people.getPeopleName() + "," + people.getId() + "," + people.getSchool();

            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String tempInfo = "";
            while ((tempInfo = bufferedReader.readLine()) != null) {
                String[] strings = tempInfo.split(",");
                if (Integer.valueOf(strings[1]) == tempID) {
                    newInfo += peopleInfo+ "\n";
                } else {
                    newInfo += tempInfo + "\n";
                }
            }
            System.out.println("人员信息已修改！当前信息：" + newInfo);

            // 开启防覆盖模式   文件写入模块
            FileWriter fileWriter = new FileWriter(path);
            BufferedWriter writerIn = new BufferedWriter(fileWriter);
            writerIn.write(newInfo);
            writerIn.write("\n");
            writerIn.flush();
            System.out.println("修改信息录入成功");
            writerIn.close();

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("格式输入错误,请重新输入");
            delete();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void search() {
        System.out.println("查询所有人员请输入 Y " + "," + "或直接输入人员 ID");
        Scanner input = new Scanner(System.in);
        String key = input.nextLine();
        if (key.equals("Y")) {
            readInfo();
        } else if (Integer.valueOf(key) > 0) {
            System.out.println("指定人员查询");
            readInfo(Integer.valueOf(key));
        } else {
            System.out.println("查询输入错误,请重新输入");
        }
    }

    // 重载两个不同参数方法,实现两种类型的查询
    // 所有数据遍历
    public void readInfo() {
        String outInfo = "";
        int totalNum = 0;
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String strs = "";
            while ((strs = bufferedReader.readLine()) != null) {
                outInfo += strs + "\n";
                totalNum++;
            }
            System.out.println("当前共有" + totalNum + "人员注册入库");
            System.out.println(outInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    // 指定类型查询
    public void readInfo(int peopleID) {
        String outInfo = "";
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String strs = "";
            while ((strs = bufferedReader.readLine()) != null) {
                String[] strings = strs.split(",");
                if (Integer.valueOf(strings[1]) == peopleID) {
                    outInfo += strs + "\n";
                    break;
                }
            }
            System.out.println("查询信息为：" + outInfo);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
