package cn.swjtu.Exception_day072001;

/*


 */
public class Demo02Exception {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        getElement(arr, 3);
    }

    public static int getElement(int[] arr, int index) {
        int element = arr[index];
        return element;
    }
    /*Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 3
    at cn.swjtu.Exception_day072001.Demo02Exception.getElement(Demo02Exception.java:14)
    at cn.swjtu.Exception_day072001.Demo02Exception.main(Demo02Exception.java:10)*/
}
