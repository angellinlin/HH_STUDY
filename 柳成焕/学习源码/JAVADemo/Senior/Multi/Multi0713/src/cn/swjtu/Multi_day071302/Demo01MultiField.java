package cn.swjtu.Multi_day071302;
/*
访问成员变量的两种方式：
1.直接通过对象名称访问成员变量：看等号左边是谁，优先用谁，没有则向上找。
 Fu obj=new Zi();  等号左边是Fu,则在Fu中找。
2.间接通过成员方法访问成员变量。看该方法属于谁，则优先用谁，没有则向上找。

 */

public class Demo01MultiField {
    public static void main(String[] args) {
        //使用多态创建对象
        Fu obj=new Zi();

        //1.直接通过对象名称访问成员变量
        //看等号左边是谁Fu obj
        System.out.println(obj.num);   //10

        //2.通过成员方法访问成员变量
        //子类没有覆盖重写，就直接找到父类中的方法
       // obj.showNum();   //10

        //子类如果覆盖重写，就在子类中找到方法，20
        obj.showNum();  //20
    }
}
