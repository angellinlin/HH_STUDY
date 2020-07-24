package cn.swjtu.Exception_day072001;

import java.util.Objects;

/*
Objects类中的静态方法：
    public static <T> requireNonNull(T obj):查看指定引用对象不是null
    源码：public static <T> requireNonNull(T obj){
        if(obj==null)
            throw new NullPointerException();
        return obj;
    }

 */
public class Demo04Exception {
    public static void main(String[] args) {
        method(null);
    }

    public static void method(Object obj) {
        //Objects.requireNonNull(obj);
        Objects.requireNonNull(obj, "传递对象的值是null");
    }
}
