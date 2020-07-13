package cn.swjtu.day0711_04;

import java.util.ArrayList;
/*
群主类
 */
public class Manager extends User {
    public Manager() {

    }

    public Manager(String name, int money) {
        super(name, money);
    }

    //发红包的方法
    //三要素
    //返回值 ArrayList<Integer>
    //方法名称 send
    //参数列表 （int totalMoney,int count）
    public ArrayList<Integer> send(int totalMoney, int count) {
        //首先需要一个集合存放若干个红包的金额
        ArrayList<Integer> list = new ArrayList<>();

        //首先看群主有多少钱
        int leftMoney = super.getMoney();
        if (totalMoney > leftMoney) {
            System.out.println("余额不足！");
            return list;   //返回空集合
        }

        //扣钱，其实就是重新设置金额
        super.setMoney(leftMoney - totalMoney);

        //发红包需要平均分为count份
        int avg = totalMoney / count;
        int mode = totalMoney % count;  //余数，也就是甩下的零头
        //剩下的零头，包在最后一个红包中

        //下面把前n-1个红包放入集合中
        for (int i = 0; i < count - 1; i++) {
            list.add(avg);
        }

        //最后处理最后一个红包
        int last=avg+mode;
        list.add(last);

        return list;
    }
}
