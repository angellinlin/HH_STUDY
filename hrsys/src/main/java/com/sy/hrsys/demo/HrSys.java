package com.sy.hrsys.demo;

import bean.Jhunter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author sy
 * @date 2020/7/17 14:40
 */
public class HrSys {
    //最大求职者数量
    private static int MAX_SIZE = 500;
    //求职者列表
    private List<Jhunter> jhunterList = new ArrayList<>();
    //输入
    private Scanner scanner = new Scanner(System.in);

    /**
     * 添加求职者信息
     * @return
     */
    public boolean add(){
        System.out.println("基于内存和控制台的hr系统1.0");
        if (jhunterList.size()<MAX_SIZE){
            Scanner input = new Scanner(System.in);
            System.out.println("请依次输入姓名，身份证号，学校，专业，和状态...");
            String name = input.nextLine();
            String identity = input.nextLine();
            String school = input.nextLine();
            String specialty = input.nextLine() ;
            int tag = input.nextInt();
            Jhunter jhunter = new Jhunter();
            jhunter.setName(name);
            jhunter.setIdentity(identity);
            jhunter.setSchool(school);
            jhunter.setSpecialty(specialty);
            jhunter.setTag(tag);
            jhunterList.add(jhunter);
            System.out.println("添加成功"+"---jhunter:"+jhunter.toString());

        }else {
            System.out.println("内存已满，无法添加");
        }
        return true;
    }

    /**
     * 删除求职者信息
     * @return
     */
    public boolean delete(){
        System.out.println("基于内存和控制台的hr系统1.0");
        Scanner input = new Scanner(System.in);
        System.out.println("输入要删除者的名字");
        //先查询在删除 重名则输入身份证号
        String name = input.nextLine();
        List<Jhunter> search = search(name);
        switch (search.size()){
            case 0:
                System.out.println("没有该求职者，请重新输入！");
                break;
            case 1:
                System.out.println("是否进行该操作 Y/N");
                Scanner choose = new Scanner(System.in);
                String check = choose.nextLine();
                while (!check.equals("Y")||!check.equals("N")){
                    System.out.println("是否进行该操作 Y/N");
                    choose = new Scanner(System.in);
                }
                if (check.equals("Y")){
                    jhunterList.remove(search.get(0));
                    System.out.println("删除成功");
                }else if (check.equals("N")){
                    System.out.println("操作取消");
                    break;
                }
               break;
            default:
                System.out.println("发现重名，请输入身份证号删除");
                Scanner in = new Scanner(System.in);
                String identity = in.nextLine();
                boolean delete = false;
                for (Jhunter jhunter:search
                     ) {
                    String identity1 = jhunter.getIdentity();
                    if (identity == identity1){
                        jhunterList.remove(jhunter);
                        System.out.println("删除成功");
                    }
                }
                    System.out.println("不存在或者删除失败");
        }
        return true;
    }

    /**
     * 更新求职者信息
     * @return
     */
    public boolean update(){
        System.out.println("基于内存和控制台的hr系统1.0");
        Scanner input = new Scanner(System.in);
        System.out.println("输入要更新者的名字");
        //先查询
        String name = input.nextLine();
        List<Jhunter> search = search(name);
        switch (search.size()){
            case 0:
                System.out.println("没有该求职者，请重新输入！");
                break;
            case 1:
                System.out.println("请输入更新项");
                System.out.println("更新名字输入---1");
                System.out.println("更新状态输入---2");
                Scanner choose = new Scanner(System.in);
                String check = choose.nextLine();
                while (!check.equals("1")||!check.equals("2")){
                    System.out.println("请输入1或者2");
                    choose = new Scanner(System.in);
                }
                if (check.equals("1")){
                    System.out.println("请输入新名字");
                    Scanner scannerName = new Scanner(System.in);
                    String nName = scannerName.nextLine();
                    for (Jhunter j:jhunterList
                         ) {
                        if (j.getName().equals(search.get(0).getName())) {
                            j.setName(nName);
                            System.out.println("更新成功");
                        }else {
                            System.out.println("更新失败");
                        }
                    }
                }else if (check.equals("2")){
                    System.out.println("请输入新状态");
                    Scanner scannerTag = new Scanner(System.in);
                    int nTag = scannerTag.nextInt();
                    for (Jhunter j:jhunterList
                    ) {
                        if (j.getName().equals(search.get(0).getName())) {
                            j.setTag(nTag);
                            System.out.println("更新成功");
                        }else {
                            System.out.println("更新失败");
                        }
                    }
                }
                break;
                //超过一个
            default:
                System.out.println("发现重名，请输入身份证号更新");
                Scanner in = new Scanner(System.in);
                String identity = in.nextLine();
                boolean delete = false;
                for (Jhunter jhunter:search
                ) {
                    String identity1 = jhunter.getIdentity();
                    if (identity == identity1){
                        System.out.println("请输入更新项");
                        System.out.println("更新名字输入---1");
                        System.out.println("更新状态输入---2");
                        Scanner update = new Scanner(System.in);
                        String item = update.nextLine();
                        while (!item.equals("1")||!item.equals("2")){
                            System.out.println("请输入1或者2");
                            choose = new Scanner(System.in);
                        }
                        if (item.equals("1")){
                            System.out.println("请输入新名字");
                            Scanner scannerName = new Scanner(System.in);
                            String nName = scannerName.nextLine();
                            for (Jhunter j:jhunterList
                            ) {
                                if (j.getName().equals(search.get(0).getName())) {
                                    j.setName(nName);
                                    System.out.println("更新成功");
                                }else {
                                    System.out.println("更新失败");
                                }
                            }
                        }else if (item.equals("2")){
                            System.out.println("请输入新状态");
                            Scanner scannerTag = new Scanner(System.in);
                            int nTag = scannerTag.nextInt();
                            for (Jhunter j:jhunterList
                            ) {
                                if (j.getName().equals(search.get(0).getName())) {
                                    j.setTag(nTag);
                                    System.out.println("更新成功");
                                }else {
                                    System.out.println("更新失败");
                                }
                            }
                        }
                        System.out.println("更新成功");
                    }
                }
                System.out.println("不存在或者更新失败");
        }
        return true;
    }

    /**
     * 根据名字查询求职者信息
     */
    public List<Jhunter> search(String name){
        List<Jhunter> list = new ArrayList<>();
        for (Jhunter j :
        jhunterList) {
            String name1 = j.getName();
            if (name1.equals(name)){
                list.add(j);
            }
        }
        return list;
    }

    /**
     * 搜索
     */
    public void search(){
        System.out.println("基于内存和控制台的hr系统1.0");
        Scanner input = new Scanner(System.in);
        System.out.println("输入要搜索的名字");
        String name = input.nextLine();
        for (Jhunter j:jhunterList
             ) {
            String name1 = j.getName();
            if (name1.equals(name)){
                System.out.println("搜索结果："+j.toString());
            }
        }
    }

    public HrSys() {
        while (true){
            System.out.println("基于内存和控制台的hr系统");
            System.out.println("添加求职信息请按---1");
            System.out.println("删除求职信息请按---2");
            System.out.println("更新求职信息请按---3");
            System.out.println("查询求职信息请按---4");
            System.out.println("退出请按-------5");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    add();
                    break;
                case 2:
                    delete();
                    break;
                case 3:
                    update();
                    break;
                case 4:
                    search();
                    break;
                case 5:
                    System.out.println("你已退出系统");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
