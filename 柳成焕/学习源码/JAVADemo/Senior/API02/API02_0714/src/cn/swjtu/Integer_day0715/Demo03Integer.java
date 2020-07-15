package cn.swjtu.Integer_day0715;

import java.util.ArrayList;

/*
自动装箱与自动拆箱
 */
public class Demo03Integer {
    public static void main(String[] args) {
        //自动装箱
        Integer in=1;   //相当于Integer in=new Integer(1);

        //自动拆箱
        //Integer类无法直接进行运算
        //in+2相当于：in.intvalue()+2=3  --> int
        //in=3     又是一个自动装箱操作
        in=in+2;

        ArrayList<Integer>list=new ArrayList<>();
        list.add(100);  //隐含了一个自动装箱操作
        int num=list.get(0);  //隐含了一个自动拆箱操作
    }
}
