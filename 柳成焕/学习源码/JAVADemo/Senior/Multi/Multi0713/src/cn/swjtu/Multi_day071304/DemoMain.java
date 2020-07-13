package cn.swjtu.Multi_day071304;

public class DemoMain {
    public static void main(String[] args) {
        Laptop laptop = new Laptop();
        laptop.powerOn();  //开机

        //准备一个鼠标供电脑使用
        //Mouse mouse = new Mouse();

        //首先进行向上转型
        USB usbMouse = new Mouse();
        //方法参数是USB类型，传递进去的正好是USB鼠标
        laptop.useDevice(usbMouse);  //传递USB鼠标

        //创建一个USB键盘
        Keyboard keyboard=new Keyboard();  //没有使用多态
        //方法参数是USB类型，传递进去的是实现类的对象
        laptop.useDevice(keyboard);       //正确写法！也发生了向上转型
        laptop.useDevice(new Keyboard());  //也是正确写法！使用子类对象、匿名对象也可以

        laptop.powerOff();  //关机
        System.out.println("=========");

        method(10.0); //正确写法 double --> double
        method(10);    //正确写法   int   --> double
    }

    public static void method(double num){
        System.out.println(num);
    }
}
