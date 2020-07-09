package service;

import bean.Entity;
import bean.Resume;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class IOCRUDImpl implements CRUDService{
    public void addEntity(ArrayList<Resume> entityList,Resume resume) {
        entityList.add(resume);
        System.out.println("您已经成功添加简历");
    }

    public void deleteEntity(ArrayList<Resume> entityList,String deleteId) {
        if (entityList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        int previousSize = entityList.size();
        Vector<Entity> v = new Vector<Entity>();
        entityList.forEach(x -> {
            if (x.getId().equals(deleteId)) v.add(x);
        });
        entityList.removeAll(v);
        System.out.println(previousSize != entityList.size() ? "您已经成功删除简历" : "未能找到该简历");
        getEntityListByKey(entityList,0);
    }

    public void updateEntity(ArrayList<Resume> entityList,String updateId) {
        Vector<Entity> v = new Vector<Entity>();
        boolean[] hasUpdated = {false};
        entityList.forEach(x -> {
            if (x.getId().equals(updateId)) {
                v.add(x);
                hasUpdated[0] = true;
            }
        });
        entityList.removeAll(v);
        System.out.println("请依次输入【简历】的姓名，身份证号，学校，简历状态");
        Scanner input = new Scanner(System.in);
        String entityName = input.nextLine();
        String entityId = input.nextLine();

        String entitySchool = input.nextLine();
        int entityStatus = input.nextInt();
        entityList.add(new Resume(entityId,entityName,entitySchool,entityStatus));
        System.out.println(hasUpdated[0] ? "已找到该简历" : "未能找到该简历");
    }

    public ArrayList<Resume> getEntityListByKey(ArrayList<Resume> entityList,int cond){
        if(cond==5){
            System.out.println("2.0版本暂不支持模糊查找，将返回所有简历信息");
            return entityList;
        }
        if (entityList.size() == 0 || cond == 0) {
            return entityList;
        }
        System.out.println("请输入查找关键字");
        Scanner input = new Scanner(System.in);
        String key = input.nextLine();
        ArrayList<Resume> rlist=new ArrayList<Resume>();
        int idx[] = {0};
        Resume[] r={null};
        entityList.forEach(x -> {
            String matchStr="";
            matchStr= cond==1? x.getId():cond==2?x.getName():cond==3?x.getSchool():cond==4?""+x.getProcess():key;
            if (matchStr.equals(key)) {
                rlist.add(x);
            }
            ++idx[0];
        });
        return rlist;
    }
    public void close(){

    }
}
