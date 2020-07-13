package cn.swjtu.Multi_day071303;

/*
向上转型一定是安全的、正确的。但是也有一个弊端。
对象一旦向上转型为父类，那么久无法调用子类原本特有的内容。

解决方案：对象的向下转型（还原）
 */
public class Demo01Main {
    public static void main(String[] args) {

        //对象的向上转型，父类引用指向子类对象
        Animal animal = new Cat();  //本来是猫，向上转型为“动物”
        animal.eat();   //猫吃鱼！
        //animal.catchMouse(); //报错，向上转型后无法使用子类中特有的内容

        //向下转型  子类名称 对象名 =（子类名称）父类对象;
        Cat cat = (Cat) animal;  //本来是猫，已经被当做动物了，向下还原成为本类的猫
        cat.catchMOouse();       //猫抓老鼠！

        //错误的向下转型
        //本来new的时候是一只猫，现在非要转成狗
        //java.lang.ClassCastException
        //Dog dog = (Dog) animal;  //错误写法！编译不会报错，但运行出现异常

    }
}

