package cn.swjtu.day0710_Arrays;

import java.util.Arrays;

/*
java.util.Arrays是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。

public static String toString(数组); 将参数数组变成字符串，按照默认格式[元素1，元素2，……]
public static void   sort(数组);     按照默认升序对数组的元素进行排序

备注：
1.如果是数值，sort默认按照升序从小到大；
2.如果是字符串，sort默认按照字母升序；
3.如果是自定义的类型，那么这个自定义类型需要有Comparable或Comparator接口的支持（今后学习）
 */
public class Demo01Arrays {
    public static void main(String[] args) {
        int[] array={2,56,3};

        //将int数组按照默认格式变成字符串
        String intStr= Arrays.toString(array);
        System.out.println(intStr);

        int[] arr1={12,45,2};
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));

        String[] arr2={"asfd","sdhkjs","hnsdkjfs"};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));  //[asfd, hnsdkjfs, sdhkjs]
    }
}
