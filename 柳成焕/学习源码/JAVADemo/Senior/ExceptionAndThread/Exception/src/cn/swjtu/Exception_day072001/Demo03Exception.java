package cn.swjtu.Exception_day072001;

/*
throw关键字：
作用：可以使用throw关键字在指定的方法中抛出指定的异常。
使用格式：throw new XXXException("异常产生的原因");
注意：
1.throw关键字必须写在方法的内部；
2.throw关键字后边new的对象必须是Exception或者Exception的子类对象；
3.throw关键字抛出的指定异常对象，我们就必须处理这个异常对象：
（1）throw关键字后边创建的是RuntimeException或者RuntimeException的子类对象，我们可以默认不处理，默认交给JVM处理（打印异常对象，中断程序）
 (2)throw关键字后边创建的是编译异常（写代码时就报错），我们就必须处理这个异常没要么throws，要么try...catch

 */
public class Demo03Exception {
    public static void main(String[] args) {
        //int[] arr = null;
        int[] arr=new int[3];
        int e = getElement(arr, 3);
        System.out.println(e);
    }
    /*
    定义一个方法获取指定索引处的元素
    参数：int[] arr,int index
    工作中，我们必须首先对方法中传递过来的参数进行合法性校验
    如果参数不合法，那么我们就必须使用抛出异常的方式，告知方法的调用者，传递的参数有问题
    注意：NullPointerException和ArrayIndexOutOfBoundsException都是运行期异常，我们不用处理，交给JVM处理。
     */
    public static int getElement(int[] arr, int index) {
        /*
        我们可以对传递过来的数组，进行合法性校验
        如果数组的值是null,那我们就抛出空指针异常，告知方法调用者：传递的数组值是null
         */
        if (arr == null) {
            throw new NullPointerException("传递的数组值是null");
        }
        /*
        我们可以对传递过来的参数index进行合法性校验
        如果index大小不在数组的索引范围内，那我们就抛出数组索引越界异常，告知方法调用者：传递的索引超出了数组的使用范围
         */
        if (index < 0 || index > arr.length - 1) {
            throw new ArrayIndexOutOfBoundsException("传递的索引超出了数组的使用范围");
        }
        int e = arr[index];
        return e;
    }
}
