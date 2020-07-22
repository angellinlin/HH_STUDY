package cn.com.spdb.testidea10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPols {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        PolsR1 ru1 = new PolsR1();
        PolsR2 ru2 = new PolsR2();
        plssR3 ru3 = new plssR3();
        executorService.submit(ru1);
        executorService.submit(ru2);
        executorService.submit(ru3);
        executorService.submit(ru3);
        executorService.submit(ru3);//线程池可以无限执行，除非你关掉线程池
    }
}
