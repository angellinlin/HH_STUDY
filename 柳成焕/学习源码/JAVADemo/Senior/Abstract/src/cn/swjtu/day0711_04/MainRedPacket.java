package cn.swjtu.day0711_04;

import javax.swing.*;
import java.util.ArrayList;

public class MainRedPacket {
    public static void main(String[] args) {
        Manager manager=new Manager("群主",100);
        Member member1=new Member("成员A",0);
        Member member2=new Member("成员B",0);
        Member member3=new Member("成员C",0);
        Member member4=new Member("成员D",0);

        manager.show();  //100
        member1.show(); //0
        member2.show();  //0
        member3.show(); //0
        member4.show();  //0
        System.out.println("======");

        //群主发20块钱，分成6个红包
        ArrayList<Integer> redList=manager.send(20,6);
        //四个普通成员收红包
        member1.recive(redList);
        member2.recive(redList);
        member3.recive(redList);
        member4.recive(redList);

        manager.show();  //100-20=80
        //3 3 3 3 3 5随机分
        member1.show();
        member2.show();
        member3.show();
        member4.show();
        System.out.println("======");
    }
}
