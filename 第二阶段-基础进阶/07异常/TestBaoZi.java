package cn.com.spdb.testidea10;

public class TestBaoZi {
    public static void main(String[] args) {
        Baozi baozi = new Baozi();
        ChiHuo chihuo  = new ChiHuo(baozi);
        chihuo.start();
        BaoZiPu baozipu = new BaoZiPu(baozi);
        baozipu.start();
    }
}
