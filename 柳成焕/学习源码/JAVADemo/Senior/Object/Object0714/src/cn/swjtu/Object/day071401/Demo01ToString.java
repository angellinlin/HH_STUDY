package cn.swjtu.Object.day071401;
/*
public String toString();返回该对象的字符串表示。
该字符串由类名（对象是该类的一个实例）、at 标记符“@”和此对象哈希码的无符号十六进制表示组成
直接打印对象的地址值没有意义，需要重写Object类的toString方法，打印对象的属性
 */
public class Demo01ToString {
    public static void main(String[] args) {
        Person person = new Person("啊柳",18);
        //Object类的 toString 方法返回一个字符串，
        //该字符串由类名（对象是该类的一个实例）、at 标记符“@”和此对象哈希码的无符号十六进制表示组成。
        String str = person.toString();
        System.out.println(str);  //Person{name='啊柳', age=18}
    }
}
