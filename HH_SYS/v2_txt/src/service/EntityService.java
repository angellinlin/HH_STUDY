package service;


import bean.Entity;
import bean.Resume;
import pojo.EntityList;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
/**
 * @program: HR_SYS
 * @description: 将逻辑处理封装
 * @author: 朱戈
 * @create: 2020-07-06
 **/
public class EntityService {
    public void addEntity(ArrayList<Resume> entityList) {
        System.out.println("请依次输入【简历】的姓名，身份证号，学校，简历状态");
        Scanner input = new Scanner(System.in);//新建/初始化流

        String entityName = input.nextLine();

        String entityId = input.nextLine();
        String entitySchool = input.nextLine();
        int entityStatus = input.nextInt();

        entityList.add(new Resume(entityName, entityId, entitySchool, entityStatus));
        System.out.println("您已经成功添加简历");
    }

    /**/
    public void deleteEntity(ArrayList<Resume> entityList) {
        if (entityList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("请输入需要【删除】简历的身份证号");
        Scanner input = new Scanner(System.in);

        String entityId = input.nextLine();
        int previousSize = entityList.size();
        Vector<Entity> v = new Vector<Entity>();
        entityList.forEach(x -> {
            if (x.getId().equals(entityId)) v.add(x);//无法用三元运算符，三元运算符的表达式必须有值，比如不能是Syso
        });
        entityList.removeAll(v);
        System.out.println(previousSize != entityList.size() ? "您已经成功删除简历" : "未能找到该简历");
        getEntityList(entityList);
    }

    /**/
    public void updateEntity(ArrayList<Resume> entityList) {
        if (entityList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("请输入需要【修改】简历的身份证号");
        Scanner input = new Scanner(System.in);
        Vector<Entity> v = new Vector<Entity>();
        String entityId = input.nextLine();
        boolean[] hasUpdated = {false}; /*判断是否成功修改*/
        /* Java lambda表达式的参数只能是传值方式，无法支持引用传递（C++可），因此只能用数组来实现修改外部变量的效果*/
        /* ArrayList在遍历时，无法添加/删除元素（会修改modCount），否则将抛出异常：
        if (modCount != expectedModCount)
            throw new ConcurrentModificationException();
        */
        /*foreach 不能break*/
        /*Vector是线程安全，速度慢；ArrayList则不是，速度快；它们都是基于数组实现的*/
        entityList.forEach(x -> {
            if (x.getId().equals(entityId)) {//String的判等要用equals函数，不能直接用==
                //entityList.remove(x); 抛出异常
                v.add(x);
                hasUpdated[0] = true;
            }
        });
        entityList.removeAll(v);//由于不支持遍历时修改，只能在遍历后统一删除
        addEntity(entityList);
        System.out.println(hasUpdated[0] ? "您已经成功修改简历" : "未能找到该简历");
    }

    /**/
    public void getEntity(ArrayList<Resume> entityList) {
        System.out.println("请输入需要查询简历的身份证号");
        Scanner input = new Scanner(System.in);

        String resumeId = input.nextLine();
        String printInfo[] = {"未能找到该简历"};
        int idx[] = {0};
        entityList.forEach(x -> {
            if (x.getId().equals(resumeId)) {
                printInfo[0] = x.printInfo()
                        + "位于第" + idx[0] + "位置";
            }
            ++idx[0];
        });
        System.out.println(printInfo[0]);
    }

    /**/
    public void getEntityList(ArrayList<Resume> entityList) {
        if (entityList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("是否需要打印所有简历，是请输入Y，不用打印则输入任意");
        Scanner input = new Scanner(System.in);

        String choice = input.nextLine();
        if (!choice.equals("Y")) return;
        int idx[] = {0};
        entityList.forEach(x -> {
            System.out.println("第" + (idx[0] + 1) + "份简历：\n"
                    + x.printInfo());
            ++idx[0];
        });

    }

    /**/
    public void exit() {
        //input.close(); 已经关闭
        System.out.println("您已经退出图书管理系统");

    }
}
