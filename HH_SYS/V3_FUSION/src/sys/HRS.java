package sys;

import bean.Resume;
import ioservice.IOService;
import ioserviceimpl.FileService;
import ioserviceimpl.SerializeService;
import service.EntityService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: HR_SYS
 * @description: Entrance
 * @author: 朱戈
 * @create: 2020-7-9 15:00
 * @version: 3.0：Fusion version( TXT + Serialization + Database )
 * @StoragePath: TXT[D:\File.txt],Serialization[D:\Serialize.txt]
 * @Structure:[ ■Package  ○Interface  ●Class  ->Impl  --->extends]
 * ★HR_SYS_v3
 *     ■bean
 *         ●Entity
 *         ●Resume ---> ●Entity [Bean]
 *     ■DBConnection
 *         ●DBConnection
 *     ■ioservice
 *         ○IOService <common ops for IO>
 *     ■ioserviceimpl
 *         ●FileService -> ○IOService
 *         ●SerializeService -> ○IOService
 *     ■service
 *         ●EntityService [get inputs & get CRUD results,by ○CRUDService]
 *         ○CRUDService <common ops for CRUD>
 *         ●IOCRUDImpl -> ○CRUDService [impl:CRUD based on FileIO/Serialization]
 *         ●DBCRUDImpl -> ○CRUDService [impl:CRUD based on JDBC]
 *     ■sys
 *         ●HRS [Program Entrance,by ●EntityService]
 **/
public class HRS {
    ArrayList<Resume> entityList;
    private Scanner input = new Scanner(System.in);
    private EntityService entityService=null;
    HRS(){
        System.out.println("-----选择系统存储方式-----");
        System.out.println("文件IO----1");
        System.out.println("对象序列化----2");
        System.out.println("数据库----3");
        /*Get Storage Mode*/
        while(entityService==null)
            switch (input.nextInt()) {
                case 1:entityService=new EntityService(1);break;/*Mode 1: File IO*/
                case 2:entityService=new EntityService(2);break;/*Mode 2: Serialization*/
                case 3:entityService=new EntityService(3);break;/*Mode 3: JDBC(MySQL)*/
                default:
                    System.out.println("请重新选择");break;
            }
        entityList=new ArrayList<Resume>();
        /*Data loading*/
        entityService.load(entityList);;
        while (true) {
            System.out.println("-----欢迎进入招聘系统V3-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按--------5");
            switch (input.nextInt()) {
                case 1:entityService.addEntity(entityList);break;
                case 2:entityService.deleteEntity(entityList);break;
                case 3:entityService.updateEntity(entityList);break;
                case 4:entityService.getEntityList(entityList);break;
                case 5:
                    /*Data saving when exiting*/
                    entityService.save(entityList);
                    entityService.exit();
                    return;
                default:System.out.println("输入错误，请重新输入");break;
            }
        }
    }

    public static void main(String[] args){
        new HRS();
    }
}
