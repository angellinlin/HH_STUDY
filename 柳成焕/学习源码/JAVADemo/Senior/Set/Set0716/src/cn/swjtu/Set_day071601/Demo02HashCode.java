package cn.swjtu.Set_day071601;

/*
哈希值：是一个十进制的整数，由系统随机给定（就是对象的地址值，是一个逻辑地址，是模拟出来的，不是数据实际存储的地址）
int hashCode() 返回该对象的哈希码值。
hashCode方法的源码：
public native int hashCode();native代表该方法调用的是本地操作系统的方法。


 */
public class Demo02HashCode {
    public static void main(String[] args) {
        //Person类继承了Object类，所以可以使用Object类的hashCode方法
        Person p1 = new Person();
        int h1 = p1.hashCode();
        System.out.println(h1);//1967205423  重写后  1

        Person p2 = new Person();
        int h2 = p2.hashCode();
        System.out.println(h2);  //重写后  1

        System.out.println(p1); //cn.swjtu.Set_day071601.Person@75412c2f  重写后  1
        System.out.println(p2);//重写后  1
        System.out.println(p1 == p2);  //false

        //String类的哈希值：String类重写了Object类的HashCode方法
        String str1 = new String("abc");
        String str2 = new String("abc");
        System.out.println(str1.hashCode());//96354
        System.out.println(str2.hashCode());//96354

        System.out.println("通话".hashCode());//1179395
        System.out.println("重地".hashCode());//1179395

    }
}
