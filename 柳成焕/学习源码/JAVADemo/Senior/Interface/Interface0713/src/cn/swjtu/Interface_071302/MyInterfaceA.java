package cn.swjtu.Interface_071302;

public interface MyInterfaceA {
    //错误！接口中没有静态代码块
    /*
    static {

    }
    */

    //错误！接口中没有构造方法
   /* public MyInterface(){

    }*/
    public abstract void methodAbs();

    public abstract void methodA();

    public default void methodDefault(){
        System.out.println("这是接口A的默认方法");
    }

}
