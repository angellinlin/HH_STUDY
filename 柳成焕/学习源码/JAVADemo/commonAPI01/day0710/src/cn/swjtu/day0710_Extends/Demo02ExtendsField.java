package cn.swjtu.day0710_Extends;
/*
在父子类的继承关系中，如果成员变量重名，则创建子类对象时，访问有两种方式。
（1）直接通过子类对象访问成员变量
        等号左边是谁，则优先用谁，没有则向上找。
（2）间接通过成员方法访问成员变量
        该方法属于谁，就优先用谁，没有则向上找。
 */
public class Demo02ExtendsField {
    public static void main(String[] args) {
        Fu fu = new Fu();   //创建父类对象
        System.out.println(fu.numFu);  //只能使用父类的东西，不能使用任何子类的内容

        Zi zi = new Zi();
        System.out.println(zi.numFu);  //10
        System.out.println(zi.numZi);  //20
        System.out.println("==============");

        //Zi zi = new Zi();  等号左边是Zi，则优先用子类，200
        System.out.println(zi.num);

        //这个方法是子类的，优先用子类的，没有再向上找
        zi.methodZi();  //200
        //这个方法是在父类中定义的，所以用的是父类的方法
        zi.methodFu();  //100

        System.out.println("=================");

        zi.method();
    }


}
