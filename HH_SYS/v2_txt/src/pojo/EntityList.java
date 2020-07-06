package pojo;

import bean.Entity;
import bean.Resume;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;

/**
 * @program: HR_SYS
 * @description: Resume Bean的容器
 * @author: 朱戈
 * @create: 2020-07-03 11:00
 * @update: 2020-07-06
 * @result：失败的尝试（放弃）
 **/
public class EntityList{
//    public ArrayList<? extends Entity> list; /*当ArrayList含有万用字符时，无法添加元素到集合中！*/
//    EntityList(String type){
//        if("Resume".equals(type)){
//            list=new ArrayList<Resume>();
//        }
//    }
//
//    @Override
//    public String toString() {
//        String str="";
//        for (Entity e:list) {
//            str+=e.toString()+"\n"; /*解耦：具体打印格式由实体类内部实现*/
//        }
//        return str;
//    }
//    public String printInfo() {
//        if(list.size()==0)return "未能找到简历";
//        String str="";
//        int idx=0;
//        for (Entity e:list) {
//            str+=e.printInfo()+"\n"+"位于第" + idx++ + "位置"+'\n'; /*解耦：具体打印格式由实体类内部实现*/
//        }
//        return str;
//    }
//    public void createEntity(String entityName, String entityId, String entitySchool, int entityStatus){
//        if(true){
//            System.out.println("666");
//            list.add(new Resume(entityName, entityId, entitySchool, entityStatus));
//        }
//
//    }
}
