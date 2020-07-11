package demo05;

/*
数组作为方法参数
当调用方法时，向方法的小括号进行传参，传递的实际是数组的地址值。
 */
public class Demo14ArrayParam {
    public static void main(String[] args) {
        int[] arrayA = new int[]{1, 4, 6, 7, 3, 6, 6};
        System.out.println(arrayA); //地址值

        printMyArray(arrayA);
        System.out.println("aaa");
        //printMyArray(arrayA);
    }

    //三要素
    /*
    返回值：void
    方法名称：printMyArray
    参数列表：int[] arrayA
     */

    public static void printMyArray(int[] array) {
        System.out.println("方法收到的参数是：");
        System.out.println(array);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
