package com.sy.driver;

import com.sy.service.HrSysService;

import java.util.Scanner;

/**
 * @author sy
 * @date 2020/7/20 11:07
 */
public class HrSys1 {

    //输入
    private Scanner scanner = new Scanner(System.in);

    private static HrSysService service = new HrSysService();

    public HrSys1() {
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
                    service.add();
                    break;
                case 2:
                    service.delete();
                    break;
                case 3:
                    service.update();
                    break;
                case 4:
                    service.search();
                    break;
                case 5:
                   service.exit();
                default:
                    System.out.println("输入错误，请重新输入");
            }
        }
    }
}
