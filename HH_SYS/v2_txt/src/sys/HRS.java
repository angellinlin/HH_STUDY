package sys;

import bean.Entity;
import bean.Resume;
import ioservice.IOService;
import ioserviceimpl.FileService;
import ioserviceimpl.SerializeService;
import pojo.EntityList;
import service.EntityService;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @program: HR_SYS
 * @description: 程序入口
 * @author: 朱戈
 * @create: 2020-7-6 11:00
 * @version: 2.0：基于TXT的数据存储版本
 * 1、学习尝试了一下泛型与集合ArrayList的结合使用，以失败告终
 * 2、实现文件、序列化的功能
 **/
public class HRS<E extends Entity> {

   // ArrayList<Entity> entityList=new ArrayList<Resume>(); 错误：无法转换
    ArrayList<Resume> entityList;
    //private EntityList entityList=new EntityList<E>();
    private Scanner input = new Scanner(System.in);

    private EntityService entityService=new EntityService();
    /*方式一：按一定格式直接读写文件方式*/
    //private IOService ioservice=new FileService();
    /*方式二：基于对象序列化*/
    private IOService ioservice=new SerializeService(); //序列化方式
    HRS() throws IOException, ClassNotFoundException {
        entityList=new ArrayList<Resume>();
        ioservice.load(entityList);/*读取文本数据*/
        System.out.println(entityList.size());
        System.out.println(entityList);
        while (true) {
            System.out.println("-----欢迎进入招聘系统V2-----");
            System.out.println("添加简历请按----1");
            System.out.println("删除简历请按----2");
            System.out.println("修改简历请按----3");
            System.out.println("查询简历请按----4");
            System.out.println("退出请按--------5");
            int choice = input.nextInt();
            switch (choice) {
                case 0:entityService.getEntityList(entityList);break; //error:try to cast ArrayList<Entity> -> ArrayList<Resume>
                case 1:entityService.addEntity(entityList);break;
                case 2:entityService.deleteEntity(entityList);break;
                case 3:entityService.updateEntity(entityList);break;
                case 4:entityService.getEntity(entityList);break;
                case 5:
                    ioservice.save(entityList); /*保存内存数据*/
                    entityService.exit();return;
                default:System.out.println("输入错误，请重新输入");break;
            }
        }
    }

    /**/


    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new HRS<Resume>();
    }
}
