package cn.swjtu.demo03.StaticMethodReference;

@FunctionalInterface
public interface Calcable {
    //定义一个抽象方法，传递一个整数，进行绝对值计算并返回
    public abstract int calAbs(int num);
}
