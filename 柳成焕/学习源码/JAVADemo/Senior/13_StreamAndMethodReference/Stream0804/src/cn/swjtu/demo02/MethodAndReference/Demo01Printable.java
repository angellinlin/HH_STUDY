package cn.swjtu.demo02.MethodAndReference;
/*
lambda表达式的目的，打印参数传递的字符串，把参数s传递给了 System.out对象，调用out对象的方法println对字符串进行了输出。
注意：
1、 System.out对象是已经存在的
2、方法println也是已经存在的
所以我们可以使用方法引用来优化lambda表达式。
可以使用System.out方法直接引用（调用）println方法。

 */
public class Demo01Printable {
    public static void main(String[] args) {
        //调用printString方法
        printString((s)->{
            System.out.println(s);
        });

        printString(System.out::println);
    }

    /*
    定义一个方法，参数传递Printable接口，对字符串进行打印
     */
    public static void printString(Printable p) {
        System.out.println("hello!");
    }
}
