package cn.swjtu.day01.demo02;

//定义一个方法。求出两个数字之和。（你自己算，算完之后结果给我），，有返回值
//顶定义一个方法，打印两个数字之和。（你自己算，算完之后直接输出）--无返回值
public class Demo04MethodReturn {
    public static void main(String[] args) {
        int sum=getSum(10,20);
        System.out.println(sum);
        System.out.println("========");

        printSum(10,10);
    }

    public static int getSum(int a,int b){
        int sum=a+b;
        return  sum;
    }

    public static void printSum(int a,int b){
        System.out.println(a+b);
    }

}
