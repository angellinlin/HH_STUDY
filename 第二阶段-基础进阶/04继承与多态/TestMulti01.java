package cn.com.spdb.testidea07;

/*
*体现多态性
* 父类引用指向子类对象
* 父类名称 名称 = new 子类名称（）；
* 接口名称 名称 = new 实现类名称（）；
* */
public class TestMulti01 {
    public static void main(String[] args) {
        Person one = new Member("DD",12);
        Person two = new qunZhu("ss",180);
        one.method();//优先用子类中的方法
        two.method();

        Computer c1 = new Computer();
        c1.powerOn();

        //鼠标
        USB mouse = new Mouse();//向上转型
        c1.useUSB(mouse);

        Keyboards keyboards = new Keyboards();
        c1.useUSB(keyboards);//自动转型？
        c1.powerOff();
    }
}
