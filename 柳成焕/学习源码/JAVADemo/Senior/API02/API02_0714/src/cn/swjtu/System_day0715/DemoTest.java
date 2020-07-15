package cn.swjtu.System_day0715;

import java.util.Arrays;

/*
1.计算打印1-9999所需要的时间（毫秒值）
思路：
1.程序执行前，计算一次毫秒值System.currentTimeMillis()
2.打印程序
3.程序执行后，计算一次毫秒值
4.相减，输出

2.将src数组中的前3个元素，复制到dest数组的前3个位置上。
复制元素前：src[1,2,3,4,5] dest[6,7,8,9,10]
复制元素后：src[1,2,3,4,5] dest[1,2,3,9,10]
思路：System.arraycopy(src,0,dest,0,3);
 */
public class DemoTest {

    public static void main(String[] args) {
        demo01();
        demo02();
    }

    private static void demo02() {
        int[] src = {1, 2, 3, 4, 5};
        int[] dest = {6, 7, 8, 9, 10};
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(src));
        System.out.println(Arrays.toString(dest));
    }

    private static void demo01() {
        long num1 = System.currentTimeMillis();
        for (int i = 1; i < 10000; i++) {
            if (i % 10 == 0) {
                System.out.println();
            }
            System.out.print(i + " ");

        }
        long num2 = System.currentTimeMillis();

        System.out.println("所需时间：" + (num2 - num1) + "毫秒");
    }


}
