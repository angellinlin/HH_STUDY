package cn.swjtu.demo02.Recursion;

/*
递归：方法自己调用自己。
分类：直接递归和间接递归。
    直接递归是方法自身调用自己。
    间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。
注意事项：
    1、递归一定要有条件限定，保证递归能够停下来，否则会发生栈内存溢出。
    2、在递归中虽然有条件限定，但是递归次数不能太多吗否则会发生栈内存溢出。
    3、构造方法禁止调用递归。
使用前提：
当调用方法的时候，方法的主体不变，每次调用方法的参数不同，可以使用递归。

 */
public class Demo01Recursion {
    public static void main(String[] args) {
        //a();
        b(1);
    }

    /*
     3、构造方法禁止调用递归。
     编译报错：构造方法是创建对象用的，一直递归会导致内存中有无数多个对象，所以直接编译报错。
     */
    public Demo01Recursion(){
        //Demo01Recursion();//编译报错：构造方法是创建对象用的，一直递归会导致内存中有无数多个对象，所以直接编译报错。
    }
    /*
    2、在递归中虽然有条件限定，但是递归次数不能太多吗否则会发生栈内存溢出。
     */
    private static void b(int i) {
        System.out.println(i);
        if (i == 20000) {
            return;
        }
        b(++i);  //10985  Exception in thread "main" java.lang.StackOverflowError
    }

    private static void a() {
        System.out.println("a方法！");
        //a方法会在栈内存中一直调用a方法，就会导致栈内存中有无数多个a方法，
        //方法太多了，超出栈内存的大小，就会导致栈内存溢出的错误。
        //注意：当一个方法调用其他方法的时候，被调用的方法没有执行完毕，当前方法会一直等待调用的方法，执行完毕，才会继续执行。
        a();

    }
}
