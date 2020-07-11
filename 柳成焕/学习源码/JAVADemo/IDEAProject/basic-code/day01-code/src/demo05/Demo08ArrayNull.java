package demo05;
/*
所有引用类型变量都可赋值为一个null值，但代表其中什么也没有

数组必须进行new初始化才能使用其中的元素。
如果只是赋值了一个null，没有进行new创建，那么将会发生空指针异常NullPointerException
原因：没有new
解决：补上new
 */
public class Demo08ArrayNull {
    public static void main(String[] args) {
//        int[] array;
//        array=new int[3];
//        System.out.println(array[0]); //若上一行未赋值，则报错

        int[] array=null;
        System.out.println(array[0]);  //NullPointerException空指针异常

    }
}
