package demo05;
/*
获取数组长度：
数组名称.length

这样将会得到int数字，代表数组的长度。
☆数组一旦创建，程序运行期间，长度不可改变！
 */
public class Demo09ArrayLength {
    public static void main(String[] args) {
        int[] array=new int[3];

        int[] arrayB={1,1,1,1,1,1,1,1,1,1};
        System.out.println("arrayB的长度为"+arrayB.length);
        System.out.println("=================");

        int[] arrayC=new int[3];
        System.out.println(arrayC.length);  //3
        arrayC=new int[5];
        System.out.println(arrayC.length); //5

    }
}
