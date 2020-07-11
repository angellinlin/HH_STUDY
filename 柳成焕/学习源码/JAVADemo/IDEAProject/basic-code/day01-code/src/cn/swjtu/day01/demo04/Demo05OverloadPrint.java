package cn.swjtu.day01.demo04;
/*
byte short int long boolean float double char
String
在调用输出语句时，println方法其实就是进行了多种数据类型的重载样式。
 */
public class Demo05OverloadPrint {
    public static void main(String[] args) {
        myPrint("hello");
    }

    //byte
    public static void myPrint(byte a){
        System.out.println("byte型");
        System.out.println(a);
    }

    //short
    public static void myPrint(short a){
        System.out.println("short型");
        System.out.println(a);
    }

    //int
    public static void myPrint(int a){
        System.out.println("int型");
        System.out.println(a);
    }

    //long
    public static void myPrint(long a){
        System.out.println("long型");
        System.out.println(a);
    }

    //float
    public static void myPrint(float a){
        System.out.println("float型");
        System.out.println(a);
    }

    //double
    public static void myPrint(double a){
        System.out.println("double型");
        System.out.println(a);
    }

    //boolean
    public static void myPrint(boolean a){
        System.out.println("boolean型");
        System.out.println(a);
    }

    //char
    public static void myPrint(char c){
        System.out.println("char型");
        System.out.println(c);
    }

    //String
    public static void myPrint(String str){
        System.out.println("String型");
        System.out.println(str);
    }
}
