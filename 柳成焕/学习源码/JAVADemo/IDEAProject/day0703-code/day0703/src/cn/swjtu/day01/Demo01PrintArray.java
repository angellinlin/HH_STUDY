package cn.swjtu.day01;

import java.util.Arrays;

/*
面向过程：当需要实现一个功能的时候，每一个具体步骤都要亲力亲为，详细处理每一个细节。
面向过程：当需要实现一个功能的时候，不关心具体步骤，而是找一个已经具有该功能的人。（偷懒）
 */
public class Demo01PrintArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};

        //打印格式为[1,2,3,4,5,6,7]
        //使用面向过程
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {  //若是最后一个元素，没有逗号，加]
                System.out.println(array[i] + "]");
            } else {  //否则
                System.out.print(array[i] + ",");
            }
        }

        System.out.println("===========================");

        //使用面向对象
        //找一个JDK给我们提供好的类Arrays
        //其中有一个toString，直接把数组变成想要的格式字符串
        System.out.println(Arrays.toString(array));

    }
}
