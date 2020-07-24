package cn.swjtu.ThreadSleep;
/*
static void sleep(long millis) 在指定的毫秒数内让当前正在执行的线程休眠（暂停执行）。
毫秒数结束后，线程继续执行。(静态方法，直接用类调用)

 */
public class Demo01Sleep {
    public static void main(String[] args) {
        //模拟秒表
        for(int i=1;i<=60;i++){
            System.out.println(i);

            //使用sleep方法唐程序睡眠1秒
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
