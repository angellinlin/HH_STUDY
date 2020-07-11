package cn.swjtu.day0710_Extends;

/*
在继承的关系中，“子类就是一个父类”。也就是说，子类可以当做父类看待。
例如：父类是员工，子类是讲师，那么“讲师就是一个员工”。关系is a
定义父类的格式（普通类的定义）
public class 父类名称{
    //...
}
定义子类的格式：
public class 子类名称 extends 父类名称{
    //...
}


 */
public class Demo01Extends {
    public static void main(String[] args) {
        //创建一个子类对象
        Teacher teacher = new Teacher();
        //Teacher类中虽然什么都没写，但也能继承来自父类的method方法
        teacher.method();

        //创建另一个子类对象
        Employee em=new Employee();
        em.method();
    }
}
