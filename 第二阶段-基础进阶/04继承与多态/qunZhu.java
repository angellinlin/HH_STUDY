package cn.com.spdb.testidea07;

import java.util.ArrayList;

public class qunZhu extends Person {

    public qunZhu(String name, int num) {
        super(name, num);
    }
    @Override
    void method() {
        System.out.println("子类qunzhu的方法");
    }
    public ArrayList<Integer> caozuo(int total,int n){
        ArrayList<Integer>  list1= new ArrayList<>();
        if(super.getNum()<total){
            System.out.println("余额不够");
        }else {
            super.setNum(super.getNum() - total);//余额重设
            int avg = total/n;
            int mod = total%n;
            for (int i = 0; i < n-1; i++) {
                list1.add(i,avg);
            }
            list1.add(avg+mod);
        }
        return list1;
    }

}
