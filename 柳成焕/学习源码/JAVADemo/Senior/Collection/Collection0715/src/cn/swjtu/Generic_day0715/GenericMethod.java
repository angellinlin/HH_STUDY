package cn.swjtu.Generic_day0715;

public class GenericMethod {
    //含有泛型的非静态方法
    public  <E>void method1(E e){
        System.out.println(e);
    }

    //含有泛型的静态方法（调用时，直接使用类）
    public static <S>void method2(S s){
        System.out.println(s);
    }
}
