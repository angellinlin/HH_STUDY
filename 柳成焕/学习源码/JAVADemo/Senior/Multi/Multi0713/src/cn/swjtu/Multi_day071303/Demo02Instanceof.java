package cn.swjtu.Multi_day071303;

/*
如何才能知道一个父类引用的对象，本来是什么类？
格式：对象 instanceof 类名称
这将会得到一个boolean结果，也就是判断前面的对象能不能当做后面类型的实例。


 */
public class Demo02Instanceof {
    public static void main(String[] args) {
        Animal animal = new Cat();
        animal.eat();

        //如果想要调用子类特有的方法，需要向下转型
        //判断父类引用是不是Cat类
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMOouse();
        }
        //判断父类引用是不是Dog类
        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }

        giveMeAPet(new Dog());
    }

    public static void giveMeAPet(Animal animal){
        if (animal instanceof Cat) {
            Cat cat = (Cat) animal;
            cat.catchMOouse();
        }

        if (animal instanceof Dog) {
            Dog dog = (Dog) animal;
            dog.watchHouse();
        }
    }
}
