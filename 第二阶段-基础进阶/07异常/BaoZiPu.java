package cn.com.spdb.testidea10;
//这个线程和包子线程是通信关系，必须使用同步技术，需要把包子对象作为参数传递
public class BaoZiPu extends Thread {
    Baozi baozi = new Baozi();

    public BaoZiPu(Baozi baozi) {
        this.baozi = baozi;
    }

    @Override
    public void run() {
        int count = 0;
        while(true){
            synchronized (baozi){
                //生产一个吃一个
                if(baozi.flag == true){
                    //有包子，唤醒吃货线程
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    //没有包子，被唤醒，交替做两种包子
                    if(count%2 == 0){
                        //生产薄皮三鲜包子
                        baozi.pi = "薄皮";
                        baozi.xian = "三鲜";
                    }else {
                        //生产厚皮猪肉包子
                        baozi.pi = "厚皮";
                        baozi.xian = "猪肉";
                    }
                    count++;
                    System.out.println("包子铺正在生产第"+count+"个包子"+",类型是:"+baozi.pi+baozi.xian);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //到这里值生产完一个，所以后续while判断的时候就不会进入生产过程，直接唤醒吃货。所以是生产一个吃一个
                    baozi.flag=true;
                    baozi.notify();
                    System.out.println("包子铺已经生产好了");
                }
            }
        }

    }
}
