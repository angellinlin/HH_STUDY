package cn.swjtu.day01.demo02;
//实现两个int型数据相加
/*
定义一个方法的三要素：
返回值类型
方法名称
参数列表

方法调用：
1.单独调用
2.打印调用
3.赋值调用
*/

public class Demo02MathodDefine {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int sum=0;
        //1.单独调用
        addInt(a,b);
        System.out.println("=========");
        //2.打印调用
        System.out.println(addInt(a,b));
        System.out.println("=========");

        //3.赋值调用
        sum=addInt(a,b);
        System.out.println(sum);
    }

    public static  int addInt(int x,int y){
        return x+y;
    }
}
