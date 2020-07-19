package cn.com.spdb.testidea07;

public class TestInnerClass {
    public static void main(String[] args) {
        //使用匿名内部类
        USB usb = new USB() {
            @Override
            public void open() {
                System.out.println("匿名内部类开");
            }

            @Override
            public void close() {
                System.out.println("匿名内部类关");
            }
        };
        usb.open();
        usb.close();
        System.out.println("------");

        //使用匿名内部类，且省略对象名称
        new USB() {
            @Override
            public void open() {
                System.out.println("匿名内部类加匿名对象开");
            }

            @Override
            public void close() {
                System.out.println("匿名内部类加匿名对象关");
            }
        }.open();
    }
}
