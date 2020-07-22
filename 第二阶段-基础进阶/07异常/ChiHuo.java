package cn.com.spdb.testidea10;

public class ChiHuo extends Thread{
    Baozi baozi = new Baozi();

    public ChiHuo(Baozi baozi) {
        this.baozi = baozi;
    }
    @Override
    public void run() {
        while(true){
            synchronized (baozi){
                if(baozi.flag == false){
                    //有包子，唤醒吃货线程
                    try {
                        baozi.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    System.out.println("吃货正在吃"+baozi.pi+baozi.xian+"包子");
                    baozi.flag=false;
                    baozi.notify();
                    System.out.println("吃货已经吃完了");
                }
            }
        }

    }
}
