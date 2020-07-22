package cn.com.spdb.testidea10;

public class MyThread extends Thread {
    @Override
    //设置线程任务
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run="+i);
        }
        String name = getName();
        System.out.println(name);
    }
}
