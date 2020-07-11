package cn.swjtu.day01.demo03;
//定义一个方法，用来打印指定次数的HelloWorid
public class Demo03MethodPrint {
    public static void main(String[] args) {
        int num=10;
        printHelloWorld(num);
    }

    public static void printHelloWorld(int num){
        for (int i = 0; i < num; i++) {
            System.out.println("Hello World!");
        }
    }
}
