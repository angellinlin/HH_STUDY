package cn.swjtu.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/*
斗地主的四个步骤：
    1.准备54张牌，存储到一个集合中
    2.洗牌
    3、发牌
    4.看牌

 */
public class DouDiZhu {
    public static void main(String[] args) {
        //1.定义一个存储54张牌的集合
        ArrayList<String> puke = new ArrayList<>();
        //定义两个数组，一个存储牌的花色，一个存储牌的序号
        String[] colors = {"♠", "♥", "♣", "♦"};
        String[] numbers = {"2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3"};
        //先把大王和小王添加到集合中
        puke.add("大王");
        puke.add("小王");
        //循环嵌套遍历两个数组，组装52张牌
        //增强for
        for (String number : numbers) {
            for (String color : colors) {
                //System.out.println(color+number);
                //把组装好的牌存储到puke集合中
                puke.add(color + number);
            }

        }
        //System.out.println(puke);

        //2.洗牌
        //用Collections中的方法
        //static void shuffle(List<?> list)
        Collections.shuffle(puke);  //顺序不同了

        //3.发牌
        //定义四个集合，存储三个玩家的牌，和底牌
        ArrayList<String> play01=new ArrayList<>();
        ArrayList<String> play02=new ArrayList<>();
        ArrayList<String> play03=new ArrayList<>();
        ArrayList<String> diPai=new ArrayList<>();

        //遍历puke，获取每一张牌
        //索引%3 轮流给三个玩家发牌
        //最后剩余三张给底牌集合 i>=51
        for (int i = 0; i < puke.size(); i++) {
            //获取每一张牌
            String pai=puke.get(i);
            //轮流发牌
            if(i>=51){
                //发给底牌
                diPai.add(pai);
            }else if(i%3==0) { //给玩家1发牌
                play01.add(pai);
            }else if(i%3==1){ //给玩家2发牌
                play02.add(pai);
            }else if(i%3==2){  //给玩家3发牌
                play03.add(pai);
            }
        }

        //4.看牌
        System.out.println("刘德华："+play01);
        System.out.println("周润发："+play02);
        System.out.println("周星驰："+play03);
        System.out.println("底牌："+diPai);
    }
}
