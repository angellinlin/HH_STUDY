package cn.swjtu.day0710_Extends06;

/*
super关键字的用法有三种：
1.在子类的成员方法中，访问父类的成员变量。
2.在子类的成员方法中，访问父类的成员方法。
3.在子类的构造方法中，访问父类的构造方法。
 */

public class Zi extends Fu {
    int num=20;

    public Zi(){
       //super();  //编译器赠送，可不写
        super(20);  //与上面一行只能选其一   //3.在子类的构造方法中，访问父类的构造方法。
        System.out.println("子类无参构造方法！");
    }

    public void method(){
        //super();  //错误写法！只有子类构造方法，才能调用父类构造方法
        System.out.println(super.num);  //父类的num10,1.在子类的成员方法中，访问父类的成员变量

        super.method();  //2.在子类的成员方法中访问父类的成员方法。
    }
}
