package demo05;
/*
求数组中的最大值
 */
public class Demo11ArrayMax {
    public static void main(String[] args) {
        int[] array={1,4,2,10,6,5,8,22,6,9,10};
        int max=array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i]>=max){
                max=array[i];
            }
        }
        System.out.println("数组最大值为"+max);
    }
}
