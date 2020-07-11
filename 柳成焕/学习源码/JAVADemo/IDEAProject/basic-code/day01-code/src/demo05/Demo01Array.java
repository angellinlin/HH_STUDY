package demo05;

/*
特点：
1.数组是一种引用类型；
2.数组中多个数据，类型必须统一；
3.数组长度在程序运行期间不可改变

数组初始化：在内存中创建一个数组，并向其中赋予一些默认值

1.动态初始化（指定长度）
数据类型[] 数组名称=new 数据类型[数组长度]；

2.静态初始化（指定内容）
数据类型[] 数组名称=new 数据类型[]{ 元素1,元素2,...};
 */
public class Demo01Array {
    public static void main(String[] args) {
        //动态初始化
        int[] arrayA = new int[300];
        double[] arratB = new double[10];
        String[] arrayC = new String[10];

        //静态初始化 数据类型[] 数组名称=new 数据类型[]{ 元素1,元素2,...};
        int[] arrayD = new int[]{5, 15, 25};
        String[] arrayS=new String[]{"Hello","World","Java"};
    }
}
