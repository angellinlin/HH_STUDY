package cn.swjtu.StringBuilder_day0715;
/*
StringBuilder和String可以相互转换
1.String-->StringBuilder :可以使用StringBuilder的构造方法
2.StringBuilder-->String ：可以使用StringBuilder的toString方法

 */
public class Demo03StringBuilder {
    public static void main(String[] args) {
        //1.String-->StringBuilder :可以使用StringBuilder的构造方法
        StringBuilder bu1=new StringBuilder("abc");
        bu1.append("Hello");
        System.out.println(bu1);

        //2.StringBuilder-->String ：可以使用StringBuilder的toString方法
        String str=bu1.toString();
        System.out.println(str);
    }
}
