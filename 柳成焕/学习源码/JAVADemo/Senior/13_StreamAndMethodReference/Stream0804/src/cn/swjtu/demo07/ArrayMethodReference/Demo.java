package cn.swjtu.demo07.ArrayMethodReference;

import java.util.Arrays;

/*
数组的构造器引用
 */
public class Demo {
    /*定义一个方法，参数传递要创建数组的长度和ArrayBuilder接口
    方法内部根据传递的长度使用ArrayBuilder中的arrayBuilder方法创建数组并返回 */
    public static int[] creatArray(int length, ArrayBuilder ab) {
        return ab.arrayBuilder(length);
    }
    public static void main(String[] args) {
        //调用creatArray方法，传递数组长度和lambda表达式
        int[] arr1 = creatArray(10, (len) -> {
            //根据数组长度创建数组并返回
            return new int[len];
        });
        System.out.println(arr1.length); //10
        /*使用方法引用优化lambda表达式
        已知创建的就是int类型的数组，数组的长度也是已知的
        就可以使用方法引用（数组的构造器引用）
        int[]引用new，根据参数传递的长度来创建数组 */
        int[] arr2 = creatArray(5, int[]::new);
        System.out.println(Arrays.toString(arr2)); //[0, 0, 0, 0, 0]
    }
}
