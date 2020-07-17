package cn.swjtu.Collections_day0717;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
 public static <T> void sort(List<T> list,Comparator<? super T>)：定义默认规则
区别：Comparable：自己(this)和别人（参数）比较，自己需要实现Comparable接口，重写比较规则compareTo方法
      Comparator：相当于找一个第三方的裁判，比较两个o1,o2
 */
public class Demo03CollectionsSort {
    public static void main(String[] args) {
        ArrayList<Integer> list01 = new ArrayList<>();
        Collections.addAll(list01, 1, 6, 3, 2);
        System.out.println(list01);  //[1, 6, 3, 2]

        //使用Comparator进行排序定义
        Collections.sort(list01, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                //重写比较规则
                return o1 - o2;  //升序排列
            }
        });
        System.out.println(list01);  //[1, 2, 3, 6]

        //定义学生集合
        ArrayList<Student> list02 = new ArrayList<>();
        list02.add(new Student("b啊柳啊", 18));
        list02.add(new Student("a孙尚香", 18));
        list02.add(new Student("孙尚香", 19));
        System.out.println(list02);//[Student{name='b啊柳啊', age=18}, Student{name='a孙尚香', age=18}, Student{name='孙尚香', age=19}]

        Collections.sort(list02, new Comparator<Student>() { //定义Comparator匿名内部类
            @Override
            public int compare(Student o1, Student o2) {
                //年龄升序
                int result = o1.getAge() - o2.getAge();
                if (result == 0) {//年龄相同
                    //姓名首个字升序
                    result = o1.getName().charAt(0) - o2.getName().charAt(0);
                }
                return result;
            }
        });
        System.out.println(list02); //[Student{name='a孙尚香', age=18}, Student{name='b啊柳啊', age=18}, Student{name='孙尚香', age=19}]
    }
}
