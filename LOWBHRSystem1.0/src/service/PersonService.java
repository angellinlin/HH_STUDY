/**
 * A program for JAVA-LOWBHRSystem
 * @version 1.0 2020-07-06
 * @author Kan Wang
 */

package service;
import pojo.Resume;
import operation.dataOperate;
import java.util.*;
import java.io.*;

public class PersonService {

    public static void addPerson(LinkedList<Resume> person){
        System.out.println("欢迎来到人员信息增添界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入人员姓名，性别，民族，电话和邮箱地址，每输入一项请按回车键确定");
        String name = in.nextLine();
        String sex = in.nextLine();
        String nation = in.nextLine();
        String phone = in.nextLine();
        String email = in.nextLine();

        Resume resume = new Resume(name, sex, nation, phone, email);
        person.add(resume);
        showPerson(person);
    }

    public static void deletePerson(LinkedList<Resume> person){

        System.out.println("欢迎来到人员信息删除界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要删除的人员姓名和手机号，每输入一项请按回车键确定");
        String dName = in.nextLine();
        String dPhone = in.nextLine();

        int n = person.size();
        boolean dFlag = false;

        for(int i = 0; i < n; i++){
            if(person.get(i).name.equals(dName) && person.get(i).phone.equals(dPhone)){
                person.remove(i);
                dFlag = true;
                System.out.println("您已删除相应的人员信息!");
                break;
            }
        }

        if(!dFlag){
            System.out.println("未找到相应的人员信息，请重新输入!");
        }

        showPerson(person);
    }

    public static void updatePerson(LinkedList<Resume> person){

        System.out.println("欢迎来到人员信息更新界面");
        Scanner in = new Scanner(System.in);
        System.out.println("请输入要更新的人员姓名和手机号，每输入一项请按回车键确定");
        String uName = in.nextLine();
        String uPhone = in.nextLine();

        int n = person.size();
        boolean uFlag = false;

        for(int i = 0; i < n; i++){
            if(person.get(i).name.equals(uName) && person.get(i).phone.equals(uPhone)){
                System.out.println("请输入更新后的人员姓名，性别，民族，电话和邮箱地址，每输入一项请按回车键确定");
                String name = in.nextLine();
                String sex = in.nextLine();
                String nation = in.nextLine();
                String phone = in.nextLine();
                String email = in.nextLine();
                Resume resume = new Resume(name, sex, nation, phone, email);
                person.set(i, resume);
                uFlag = true;
                System.out.println("您已更新相应的人员信息!");
                break;
            }
        }

        if(!uFlag){
            System.out.println("未找到需要更新的人员信息，请重新输入!");
        }

        showPerson(person);
    }

    public static void showPerson(LinkedList<Resume> person){
        System.out.println("是否打印全部人员信息, Y/N");
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        if(str.equals("Y")){
            int i = 1;
            for(Resume resume : person){
                System.out.println("第" + i + "个人信息：" + resume.name + " " + resume.sex +
                        " " + resume.nation + " " + resume.phone + " " + resume.email);
                i++;
            }
        }
        else{
            System.out.println("不打印任何信息!");
            return;
        }
    }
}
