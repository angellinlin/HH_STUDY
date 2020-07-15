package cn.swjtu.Integer_day0715;

/*
基本类型与字符串类型之间的相互转换
基本类型-->字符串（String）
1.基本类型的值+""  最简单的方法（工作中常用）
2.包装类的静态方法toString(参数)，不是Object类中的toString()重载。
3.String类中的valueOf(参数)方法  返回int参数的字符串表示

字符串 --> 基本类型
使用包装类的静态方法parseXXX("数值类型的字符串")
    Integer类：static int parseInt(String s)
    Double类： static double parseDouble(String s)
 */
public class Demo04 {
    public static void main(String[] args) {
        //基本类型-->字符串（String）
        int num1 = 100;
        String str1 = num1 + ""; //"100"
        System.out.println(str1 + 200);  //100200

        String str2 = Integer.toString(300);
        System.out.println(str2 + 200); //300200

        String str3=String.valueOf(400);
        System.out.println(str3+200);//400200

        int num=Integer.parseInt(str1);
        System.out.println(num);  //100
    }
}
