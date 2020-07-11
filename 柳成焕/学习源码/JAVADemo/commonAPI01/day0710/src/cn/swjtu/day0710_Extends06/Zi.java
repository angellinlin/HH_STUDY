package cn.swjtu.day0710_Extends06;

public class Zi extends Fu {
    public Zi(){
       //super();  //编译器赠送，可不写
        super(20);  //与上面一行只能选其一
        System.out.println("子类无参构造方法！");
    }

    public void method(){
        //super();  //错误写法！只有子类构造方法，才能调用父类构造方法
    }
}
