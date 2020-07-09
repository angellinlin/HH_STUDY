package service;

import bean.Resume;
import ioservice.IOService;
import ioserviceimpl.FileService;
import ioserviceimpl.SerializeService;
import java.util.ArrayList;
import java.util.Scanner;

public class EntityService {
    IOService ioService=null;
    CRUDService crudService=null;
    int mode=3;
    public EntityService(int mode){
        this.mode=mode;
        crudService=new IOCRUDImpl();
        switch (mode){
            case 1:ioService=new FileService();break;
            case 2:ioService=new SerializeService();break;
            case 3:crudService=new DBCRUDImpl();break;
            default:crudService=new DBCRUDImpl();break;
        }
    }

    public void load(ArrayList<Resume> entityList){
        if(ioService!=null)/*only file-io or serial-io needed*/
            ioService.load(entityList);
    }

    public void save(ArrayList<Resume> entityList){
        if(ioService!=null)/*only file-io or serial-io needed*/
            ioService.save(entityList);
    }

    public void addEntity(ArrayList<Resume> entityList) {
        System.out.println("请依次输入【简历】的姓名，身份证号，学校，简历状态");
        Scanner input = new Scanner(System.in);
        String entityName = input.nextLine();
        String entityId = input.nextLine();
        String entitySchool = input.nextLine();
        int entityStatus = input.nextInt();
        /**/
        crudService.addEntity(entityList,new Resume(entityId,entityName,entitySchool,entityStatus));
    }

    public void deleteEntity(ArrayList<Resume> entityList) {
        System.out.println("请输入需要【删除】简历的身份证号");
        Scanner input = new Scanner(System.in);
        String entityId = input.nextLine();

        crudService.deleteEntity(entityList,entityId);
    }

    public void updateEntity(ArrayList<Resume> entityList) {
        if (entityList.size() == 0) {
            System.out.println("系统为空，没有任何简历");
            return;
        }
        System.out.println("请输入需要【修改】简历的身份证号");
        Scanner input = new Scanner(System.in);
        String entityId = input.nextLine();

        crudService.updateEntity(entityList,entityId);
    }

    public void getEntityList(ArrayList<Resume> entityList) {
        System.out.println("这里是查询简历系统：");
        System.out.println("查询所有请按----------0");
        System.out.println("按身份证号查找请按----------1");
        System.out.println("按姓名查找请按----------2");
        System.out.println("按学校查找请按----------3");
        System.out.println("按简历进度查找请按------------4");
        System.out.println("模糊查找请按------------5");
        System.out.println("退出请按----------------6");
        Scanner input = new Scanner(System.in);
        int choice=input.nextInt();
        if(choice==6)return;
        ArrayList<Resume> rlist=crudService.getEntityListByKey(entityList,choice);
        if(rlist.size()==0){
            System.out.println("没有找到该简历");
            return;
        }
        /*print resumes infos*/
        int idx[] = {0};
        rlist.forEach(x -> {
            System.out.println("第" + (idx[0] + 1) + "份简历：\n"
                    + x.printInfo());
            ++idx[0];
        });
    }
    public void exit(){
        crudService.close();
        System.out.println("您已经退出图书管理系统");
    }
}
