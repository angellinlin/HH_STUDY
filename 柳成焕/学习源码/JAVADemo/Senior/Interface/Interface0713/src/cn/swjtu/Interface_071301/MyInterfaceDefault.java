package cn.swjtu.Interface_071301;
/*
从java8开始，接口里允许有默认方法
格式：
public default 返回值类型 方法名称（参数列表）{
    方法体
}
备注：接口中的默认方法，可以解决接口升级问题。


 */
public interface MyInterfaceDefault {
    public abstract void methodAbs();

    //新添加了一个抽象方法
    //public abstract void methodDefault();

    //新添加的方法，改为默认方法
    public default void methodDefault(){
        System.out.println("这是新添加的默认方法");
    }
}
