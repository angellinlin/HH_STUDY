package demo05;
/*
直接打印数组名称，得到的是数组对应的内存地址哈希值。
访问数组元素的格式：数组名称[索引值]
索引值：就是一个int数组，代表数组元素的编号。
【注意】索引值从0开始，一直到“数组长度-1”为止。

 */
public class Demo03ArrayUse {
    public static void main(String[] args) {
        int[] arrayA = {12, 13, 14};  //静态初始化的省略格式
        //直接打印数组元素值
        System.out.println(arrayA);   //[I@1c53fd30 数组的内存地址哈希值
        System.out.println(arrayA[0]); //12
        System.out.println(arrayA[1]); //13
        System.out.println(arrayA[2]); //14

        //将数组元素值赋值
        int num=arrayA[1]; //13
        System.out.println(num);
    }
}
