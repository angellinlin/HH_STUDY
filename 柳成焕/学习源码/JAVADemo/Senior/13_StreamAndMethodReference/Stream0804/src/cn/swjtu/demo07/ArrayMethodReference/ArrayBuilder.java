package cn.swjtu.demo07.ArrayMethodReference;

/*
定义一个创建数组的函数式接口
 */
@FunctionalInterface
public interface ArrayBuilder {
    //定义一个创建int 类型数组的方法，参数传递数组的长度，返回创建好的数组
    int[] arrayBuilder(int length);
}
