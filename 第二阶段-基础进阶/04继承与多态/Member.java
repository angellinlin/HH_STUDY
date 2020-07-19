package cn.com.spdb.testidea07;

import java.util.ArrayList;
import java.util.Random;

public class Member extends Person{
    public Member(String name, int num) {
        super(name, num);
    }
    public void caozuo(ArrayList<Integer> list1){
        int index = new Random().nextInt(list1.size());
        int delta = list1.remove(index);//把被删除的数返回
        super.setNum(super.getNum()+delta);
    }

    @Override
    void method() {
        System.out.println("子类member的方法");
    }
}
