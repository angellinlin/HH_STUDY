package cn.com.spdb.testidea05;

import java.util.ArrayList;
import java.util.Random;

public class TestArrayList {
    public static void main(String[] args) {

        //不可变长度的数组
        Hero[] array1 = new Hero[3];
        array1[0] = new Hero("酒1", 12);
        array1[1] = new Hero("酒2", 24);
        array1[2] = new Hero("酒3", 32);
        System.out.println(array1[0].getName());

        //arraylist
        ArrayList<Hero> list = new ArrayList<>();
        System.out.println(list);//对于ArrayList来说直接打印不是打印地址值，是打印内容
        list.add(new Hero("嘟嘟", 23));
        list.add(new Hero("一一", 12));
        System.out.println(list.get(1).getName());//获取第2个对象的name属性
        System.out.println(list.size());
        list.remove(1);
        System.out.println(list.size());

        //放基本数据类型
        ArrayList<Integer> listInt = new ArrayList<>();
        listInt.add(10);
        int num = listInt.get(0);
        System.out.println(num);

        //生成6个1-33之间的随机数，添加到集合中，并且遍历集合
        //新建集合
        ArrayList<Integer> list2 = new ArrayList<>();
        //创建随机数对象
        Random random = new Random();
        //循环生成6个随机数并放进去
        for (int i = 0; i < 6; i++) {
            list2.add(i, random.nextInt(33) + 1);
        }
//        //遍历集合
//        for (int i = 0; i < list2.size(); i++) {
//            System.out.println(list2.get(i));
//        }
//        //增强for
//        for( Integer li:list2){
//            System.out.println(li);
//
//        }

        //用一个大集合存放20个数字，删选其中的偶数放到小集合当中
        //创建大集合和小集合
        ArrayList<Integer> list3 = new ArrayList<>();

        //创建随机数对象
        Random random1 = new Random();
        //循环生成6个随机数并放进去
        for (int i = 0; i < 20; i++) {
            list3.add(i, random1.nextInt(100) + 1);
        }
        ArrayList<Integer> list4 = shaixuan(list3);
        System.out.println(list4+"个数是"+list4.size());
    }

    public static ArrayList<Integer> shaixuan(ArrayList<Integer> list) {
        ArrayList<Integer> temp = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                temp.add(list.get(i));
            }
        }
        return temp;
    }

}
