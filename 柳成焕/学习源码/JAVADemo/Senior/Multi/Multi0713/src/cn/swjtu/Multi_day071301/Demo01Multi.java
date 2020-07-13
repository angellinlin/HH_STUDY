package cn.swjtu.Multi_day071301;
/*
代码中体现多态性，其实就是一句话：父类引用指向子类对象。

格式：（左父右子）
父类名称 对象名 = new 子类名称();
接口名称 对象名 = new 实现类名称();

 */
public class Demo01Multi {
    public static void main(String[] args) {
        //多态写法
        //左侧父类引用指向了子类对象
        Fu obj=new Zi();

        //看右边new的是谁，就优先用谁
        obj.method();

        //没有则向上找
        obj.methodFu();
    }
}
