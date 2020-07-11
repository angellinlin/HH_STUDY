package demo05;

/*
遍历数组，就是对数组中的每一个元素进行逐一处理，默认的处理方式就是打印输出。


 */
public class Demo10Array {
    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 3, 5, 7, 9};

        //循环
        for (int i = 0; i < arrayA.length; i++) {
            System.out.println(arrayA[i]);
        }

    }
}
