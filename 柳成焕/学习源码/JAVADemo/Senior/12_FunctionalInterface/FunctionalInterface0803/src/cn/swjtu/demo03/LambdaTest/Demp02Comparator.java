package cn.swjtu.demo03.LambdaTest;

import java.util.Arrays;
import java.util.Comparator;

/*
如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个lambda表达式。
当需要通过一个方法来获取一个java.util.Comparator接口类型的对象作为排序器时，就可以调用该方法。

 */
public class Demp02Comparator {
    //定义一个方法，返回值类型使用函数式接口Comparator
    public static Comparator<String> getComparator() {
        //方法的返回值类型是一个接口，那我们可以返回这个接口的匿名内部类
        /*return new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //按照字符串的顺序排序
                return o1.length()-o2.length();
            }
        };*/

        //方法的返回值类型是一个接口，那我们可以返回一个lambda表达式
        /*return (String o1,String o2)->{
            return o1.length()-o2.length();
        };*/

        //优化lambda
        return (o1, o2) -> o1.length() - o2.length();
    }

    public static void main(String[] args) {
        String []s = {"12345" ,"123","1234"};
        System.out.println("排序前：");
        System.out.println(Arrays.toString(s));
        //调用arrays的sort方法对字符串数组排序
        Arrays.sort(s,getComparator());
        System.out.println("排序后：");
        System.out.println(Arrays.toString(s));
    }
}
