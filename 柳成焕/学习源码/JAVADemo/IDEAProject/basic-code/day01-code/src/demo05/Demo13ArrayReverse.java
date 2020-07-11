package demo05;

/*
数组元素的反转：(不能使用新数组)
1.数组元素反转，其实就是对称位置元素交换。
2.通常遍历数组用的是一个索引：int i=0;
  现在表示对称位置需要两个索引：int min=0;   int max=array.length-1;
3.如何交换两个变量？借助第三个变量int temp;
4.什么时候应该交换？min<max
 */
public class Demo13ArrayReverse {
    public static void main(String[] args) {
        int[] array = {10, 15, 6, 100, 89,7};
        int temp = 0;
        /*for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }*/

        System.out.println("=============");
        /*
        初始化语句：int min=0,max=array.length-1;
        条件判断：min<max;
        步进表达式：min++,max--;
        循环体：用第三个变量倒手
         */
        for(int min=0,max=array.length-1;min<max;min++,max--){
             temp=array[min];
             array[min]=array[max];
             array[max]=temp;

        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
