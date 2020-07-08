/**
 * A program for JAVA-LOWBHRSystem
 * @version 1.0 2020-07-06
 * @author Kan Wang
 */

package com.spdb;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

import pojo.Resume;
import operation.dataOperate;
import service.PersonService;

public class Main {
    public static void main(String [] args) {
        LinkedList<Resume> person = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        System.out.println("文件存储是否选用默认路径，Y/N");
        String choice = in.nextLine();
        String filePath = null;

        if(choice.equals("Y")){
            filePath = "C:\\Users\\Kan Wang\\Desktop\\spdb\\Person.txt";
        }
        else{
            System.out.println("请输入您选择的文件路径");
            filePath = in.nextLine();
        }

        person = dataOperate.loadResume(filePath);

        while(true){
            System.out.println("************Welcome to LOWBHRSystem 1.0************");
            System.out.println("新增人员信息请按--------1");
            System.out.println("更新人员信息请按--------2");
            System.out.println("删除人员信息请按--------3");
            System.out.println("打印人员信息请按--------4");
            System.out.println("退出HR系统请按--------5");

            int c = in.nextInt();

            //switch-case分支
            if(c == 1){
                PersonService.addPerson(person);
            }
            else if(c == 2){
                PersonService.updatePerson(person);
            }
            else if(c == 3){
                PersonService.deletePerson(person);
            }
            else if(c == 4){
                PersonService.showPerson(person);
            }
            else if(c == 5){
                dataOperate.saveResume(person, filePath);
                System.out.println("您已退出HR系统！");
                break;
            }
            else{
                System.out.println("功能尚未完善，请按指示操作！");
            }
        }
    }
}
