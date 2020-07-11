package demo05;

import com.sun.security.jgss.GSSUtil;

/*
一个方法可以有多个参数；但是只能有0或1个返回值。
如果希望一个方法中产生多个结果进行返回，怎么办？
解决：使用一个数组作为返回值类型即可。

任何数据类型都能作为方法的参数类型和返回值类型。

数组作为方法的参数，传递进去的实际上是数组的地址值。
数组作为方法的返回值，返回的实际上也是数组的地址值。
 */
public class Demo15ArrayReturn {
    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 1};

        int[] arrayB = calulate(array);
        System.out.println("main方法中接收到的数组返回值是："+arrayB); //地址值
        System.out.println("总和：" + arrayB[0]);
        System.out.println("平均数：" + arrayB[1]);
    }

    public static int[] calulate(int[] array) {
        int sum = 0;
        int avg = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        avg = sum / array.length;
        int[] arrayB = {sum, avg};
        System.out.println("calulate方法返回的数组返回值是："+arrayB); //地址值
        return arrayB;
    }
}
