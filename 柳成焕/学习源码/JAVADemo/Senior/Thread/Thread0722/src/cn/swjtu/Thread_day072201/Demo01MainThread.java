package cn.swjtu.Thread_day072201;

/*
主线程：执行主方法（main）的线程。

单线程程序：java程序中只有一个线程，执行从main方法开始，从上到下依次执行。

JVM执行main方法，main方法会进入到栈内存，JVM会开辟一条main方法通向CPU的执行路径。
CPU就可以通过这个路径来执行main方法，而这个路径有一个名字，叫做主线程（main线程）。


 */
public class Demo01MainThread {
    public static void main(String[] args) {
        Person person1 = new Person("王昭君");
        person1.run();

        Person person2 = new Person("小乔");
        person2.run();
    }
}
