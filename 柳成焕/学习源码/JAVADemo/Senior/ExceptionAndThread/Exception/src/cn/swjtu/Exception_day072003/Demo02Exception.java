package cn.swjtu.Exception_day072003;
/*
如果finally中有return语句，永远返回finally中的结果，避免该情况。

 */
public class Demo02Exception {
    public static void main(String[] args) {
        int a=getA();
        System.out.println(a);
    }

    public static int getA() {
        int a = 10;
        try {
            return a;
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            //一定会执行的代码
            a = 100;
            return a;
        }

    }
}
