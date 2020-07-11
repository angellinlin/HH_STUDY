package cn.swjtu.day01.Demo0709_01;

import java.util.ArrayList;

/*
//错误写法！泛型只能是引用类型，不能是基本类型
//ArrayList<int>list=new ArrayList<int>();

如果希望向集合ArrayList集合中存储基本数据类型，必须使用基本类型对应的包装类。
基本类型     包装类（引用类型，包装类都位于java.lang包下）
byte        Byte
short       Short
int         Integer【特殊】
long        Long
float       Float
double      Double
char        Character【特殊】
boolean     Boolean

从JDK 1.5+开始，支持自动装箱，自动拆箱。
自动装箱：基本类型 --> 包装类型
自动拆箱：包装类型 --> 基本类型


 */
public class Demo05ArrayListBasic {
    public static void main(String[] args) {
        ArrayList<String> listA = new ArrayList<>();

        //错误写法！泛型只能是引用类型，不能是基本类型
        //ArrayList<int>list=new ArrayList<int>();

        ArrayList<Integer> listB = new ArrayList<>();
        System.out.println(listB);  //[]
        listB.add(1);
        listB.add(2);
        listB.add(3);
        listB.add(4);
        System.out.println(listB);  //[1, 2, 3, 4]

        int num=listB.get(1);  //2
        System.out.println(num);
    }

}
