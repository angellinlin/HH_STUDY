package cn.swjtu.day01.Demo0708;

/*
面向对象的三大特性：封装、继承、多态。

封装性：
1.方法就是一种封装；
2.关键字private也是一种封装。

封装就是将一些细节信息隐藏起来，不让外界可见。
 */
public class Demo02Method {
    public static void main(String[] args) {
        int[] array = {10, 3, 6, 88, 12, 6};
        System.out.println("数组最大值为："+maxMethod(array));
    }

    public static int maxMethod(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }


}
