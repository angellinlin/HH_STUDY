package cn.swjtu.day0711_04;

import java.util.ArrayList;
import java.util.Random;

/*
群成员
 */
public class Member extends User {
    public Member() {

    }

    public Member(String name, int money) {
        super(name, money);
    }

    //收红包的方法
    //三要素
    //返回值void
    //方法名称recive
    //参数列表（ArrayList<Integer>）
    public void recive(ArrayList<Integer> list) {
        //当前成员本来有多少钱
        int money = super.getMoney();
        //从多个红包中，随机获取一哥
        //随机获取一个集合中的索引编号
        Random r = new Random();
        int index = r.nextInt(list.size());  //[0,size)

        //根据索引，从集合中删除元素，并获取红包值
        int delta = list.remove(index);
        //加金额，并设置回去
        super.setMoney(money+delta);
    }
}
