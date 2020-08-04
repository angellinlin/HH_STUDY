package cn.swjtu.demo04.Supplier;

import java.util.function.Supplier;

/*
练习：求int数组元素最大值。使用Supplier接口作为方法参数，通过lambda表达式楸树int数组中的最大值。


 */
public class Demo02Test {
    //定义一个方法，用于获取数组的最大值，方法参数传递Supplier接口，泛型使用Integer
    public static int getMax(Supplier<Integer> sup) {
        return sup.get();
    }
    public static void main(String[] args) {
        int[] arr = {3, 5, 3, 7, 2, 7, 10, 1, 3, 4};
        //调用getMax方法，参数为函数式接口，可以传递lambda表达式
        int num = getMax(() -> {
            //获取数组的最大值，并返回
            //定义一个变量，将数组第一个元素赋值给该变量，记录元素中的最大值
            int max = arr[0];
            //遍历数组。获取数组中其他元素
            for (int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            return max;
        });
        System.out.println("最大值为：" + num);
    }
}
