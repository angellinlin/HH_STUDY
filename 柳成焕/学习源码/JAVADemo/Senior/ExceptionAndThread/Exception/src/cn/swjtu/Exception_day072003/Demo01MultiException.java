package cn.swjtu.Exception_day072003;

import java.util.List;

/*
多异常的处理：
1、多个异常，分别捕获，分别处理。
2、多个异常，一次捕获，多次处理。
一个try里边多个catch注意事项：
catch中定义的异常变量，如果有父子关系，那么子类的异常变量必须写在上边，否则就会报错。
ArrayIndexOutOfBoundsException extends IndexOutOfBoundsException
try如果出现了异常对象，会把异常对象抛出给catch处理，抛出的异常对象，会从上到下依次赋值给catch中定义的异常变量。
3、多个异常，一次捕获，一次处理
运行时异常被抛出可以不处理，即不捕获也不声明抛出。
默认给虚拟机处理，终止程序，什么时候不抛出运行时异常了，再继续执行程序。
 */
public class Demo01MultiException {
    public static void main(String[] args) {
        //多个异常，多次捕获，多次处理
        /*int[] arr = {1, 2, 3};
        try {
            System.out.println(arr[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e); //java.lang.ArrayIndexOutOfBoundsException: 3
        }

        List<Integer> list = List.of(1, 2, 3);
        try{
            System.out.println(list.get(3));
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);//java.lang.IndexOutOfBoundsException: Index 3 out-of-bounds for length 3
        }*/

        //多个异常，一次捕获，多次处理
        /*try{
            int []arr={1,2,3};
            System.out.println(arr[3]);
            List<Integer> list = List.of(1, 2, 3);
            System.out.println(list.get(4));
        }catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }catch (IndexOutOfBoundsException e){
            System.out.println(e);
        }*/

        //3。多个异常，一次捕获，一次处理
        try{
            int []arr={1,2,3};
            System.out.println(arr[3]);
            List<Integer> list = List.of(1, 2, 3);
            System.out.println(list.get(4));
        }catch (Exception e){
            System.out.println(e);
        }
        System.out.println("后续代码！");
    }
}


