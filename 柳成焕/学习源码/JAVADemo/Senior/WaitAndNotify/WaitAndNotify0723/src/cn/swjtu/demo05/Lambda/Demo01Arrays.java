package cn.swjtu.demo05.Lambda;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/*
Lambda表达式有参数有返回值练习
需求：
    使用数组存储多个Person对象
    对数组中的Person对象Arrays的sort方法进行升序排列
 */
public class Demo01Arrays {
    public static <o1> void main(String[] args) {
        Person[] arr = {new Person("孙尚香", 18),
                new Person("芈月", 21),
                new Person("王昭君", 20)};
        //升序排序,前-后
       Arrays.sort(arr, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge()-o2.getAge();
            }
        });

        //使用Lambda表达式简化匿名内部类
        Arrays.sort(arr, (Person o1, Person o2)->{
            return o1.getAge()-o2.getAge();
        });
        //优化省略Lambda
        Arrays.sort(arr, (o1, o2)->
             o1.getAge()-o2.getAge()
        );

        //遍历数组
        for (Person person : arr) {
            System.out.println(person);
        }
    }
}
