package cn.swjtu.day01.Demo0709_01;

import java.sql.SQLOutput;

/*
题目：定义一个数组，用于存放3个Person对象。

数组有一个缺点，一旦创建，程序运行期间，长度不可改变。
 */
public class Demo01Array {
    public static void main(String[] args) {
        Person[] array=new Person[3];
        System.out.println(array[0]);  //null

        Person one=new Person("迪丽热巴",18);
        Person two=new Person("古力娜扎",20);
        Person three=new Person("玛尔扎哈",38);

        array[0]=one;
        array[1]=two;
        array[2]=three;

        System.out.println(array[0]);  //地址值
        System.out.println(array[1]);
        System.out.println(array[2]);

        System.out.println(array[0].getName()); //迪丽热巴
    }
}
