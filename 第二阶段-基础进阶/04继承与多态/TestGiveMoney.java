package cn.com.spdb.testidea07;

import java.util.ArrayList;

public class TestGiveMoney {
    public static void main(String[] args) {
        qunZhu person1 = new qunZhu("大头",250);
        Member person2 = new Member("jiu",10);
        Member person3 = new Member("siu",20);
        Member person4 = new Member("diu",30);
        person1.show();
        person2.show();
        person3.show();
        person4.show();

        ArrayList<Integer>list  = person1.caozuo(50,3);
        System.out.println(person1.getNum());
        person2.caozuo(list);
        person3.caozuo(list);
        person4.caozuo(list);

        person1.show();
        person2.show();
        person3.show();
        person4.show();
    }
}
