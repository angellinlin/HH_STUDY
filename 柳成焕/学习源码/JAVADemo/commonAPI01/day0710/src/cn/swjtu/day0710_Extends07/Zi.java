package cn.swjtu.day0710_Extends07;

/*
super关键字用来访问父类内容，而this关键字用来访问本类内容。用法也有三种：
1.在本类的成员方法中，访问本类的成员白能量。
2.在本类的成员方法中，访问本类的另一个成员方法。
3.在本类的构造方法中，访问本类的另一个构造方法。
注意：在第三种用法中要注意，
（1）this();调用必须也是构造方法的第一个语句。唯一一个。
（2）super和this两种构造调用，不能同时使用。
 */
public class Zi extends Fu {
    int num = 20;

    public Zi(){
        //System.out.println("---");
        //必须都是第一个语句
        this(123);  //本类的无参构造方法调用本类的有参构造
        //this(1,2);
        //super();
    }

    public Zi(int num){
        this(1,2);

    }

    public Zi(int a,int b){
       // this();
        super();
    }

    public void showNum() {
        int num = 30;
        System.out.println(num);    //30
        System.out.println(this.num); //20
        System.out.println(super.num); //10
    }

    public void methodA() {
        System.out.println("aaa");
    }

    public void methodB(){
        this.methodA();
        System.out.println("bbb");

    }
}
