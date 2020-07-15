package cn.swjtu.inner_day071401;

/*
如果一个事物的内部包含另一个事物，那么这就是一个类内部包含另一个类。
例如：身体和心脏、汽车和发动机

内部类的分类：
1.成员内部类
2.局部内部类（匿名内部类）

成员内部类的定义格式：
    修饰符 class 外部类名称{
        修饰符 class 内部类名称{
            //...
        }
        //...
    }

注意：内用外，随意访问；外用内，一定需要借助内部类对象。

内部类的使用：
1、间接方式：在外部类的方法当中，使用内部类，然后main只是调用外部类的方法。
2、直接方式：【外部类名称.内部类名称 对象名 = new 外部类名称().new 内部类名称();】

 */
public class Demo01InnerClass {
    public static void main(String[] args) {
        //1.在外部类的方法当中，使用内部类，然后main只是调用外部类的方法。
        //外部类方法
        /*public void methodBody(){
            System.out.println("外部类的方法执行！");
            new Body.Heart().beat();
        }*/
        Body body = new Body();
        body.methodBody();

        //2.直接方式：【外部类名称.内部类名称 对象名 = new 外部类名称.new 内部类名称();】
        Body.Heart obj=new Body().new Heart();
        obj.beat();
    }

}
