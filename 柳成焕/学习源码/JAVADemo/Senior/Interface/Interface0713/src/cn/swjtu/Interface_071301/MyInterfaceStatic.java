package cn.swjtu.Interface_071301;
/*
从Java8开始，接口中允许定义静态方法。
格式：
public static 返回值类型 方法名称（参数列表）{
    方法体
}
提示：就是将abstract/default换成static即可，必须写上方法体。

 */
public interface MyInterfaceStatic {
    public static void methodStatic(){
        System.out.println("这是接口的静态方法！");
    }
}
