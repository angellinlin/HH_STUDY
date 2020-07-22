package cn.com.spdb.testidea10;

public class TestLambda {
    public static void main(String[] args) {
        //使用lambda表达式实现多线程
        new Thread(()-> {
            System.out.println("新创建了一个线程");
        }).start();
    }
}
