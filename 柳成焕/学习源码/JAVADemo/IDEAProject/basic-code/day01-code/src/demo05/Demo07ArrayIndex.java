package demo05;
/*
如果访问数组元素时，索引编号并不存在，将会发生数组索引越界异常ArrayIndexOutOfBoundsException
原因：索引编号写错了
解决办法：修改使其成为存在的正确索引值。

 */
public class Demo07ArrayIndex {
    public static void main(String[] args) {
        int[] array=new int[]{11,12,13};

        System.out.println(array[0]); //11
        System.out.println(array[1]); //12
        System.out.println(array[2]);//13

        System.out.println(array[3]); //ArrayIndexOutOfBoundsException
    }
}
