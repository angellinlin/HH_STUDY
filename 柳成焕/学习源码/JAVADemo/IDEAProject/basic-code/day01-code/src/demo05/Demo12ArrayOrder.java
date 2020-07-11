package demo05;

/*
排序  从小到大
 */
public class Demo12ArrayOrder {
    public static void main(String[] args) {
        int[] array = {1, 4, 2, 10, 6, 5, 8, 22, 6, 9, 10};
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}
