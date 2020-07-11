package cn.swjtu.day01.demo03;
/*
1.方法定义应该在类中，但方法间不能相互调用。
2.方法不会自动调用，须手动调用。单独调用、打印调用、赋值调用。
3.方法定义的前后顺序无所谓。
4.若方法有返回值，则必须写“return 返回值;"
5.return后面的返回值数据，要与返回值类型对应。
6.对于void类型没有返回值的方法，不能写return后面的返回值，只能写return自己，结束方法的执行。
7.对于void类型没有返回值的方法中最后一行的return可以省略不写。
8.一个方法中可以有多个return语句，但必须保证同时只有一个会被执行到。两个return不能连写。

 */

public class Demo04MethodNotice {
    public static void main(String[] args) {

    }

    private static void mathod1(){

        return;
    }

    public static int Compare(int a,int b){
        if(a>b)
        {
            return a;
        }else {
            return b;
        }
    }
}
