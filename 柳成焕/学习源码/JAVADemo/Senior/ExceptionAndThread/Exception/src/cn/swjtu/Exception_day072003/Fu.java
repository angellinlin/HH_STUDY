package cn.swjtu.Exception_day072003;

/*
子父类异常：
1.如果父类抛出了多个异常，子类重写父类方法时，抛出和父类相同的异常或者是父类异常的子类或者不抛出。
2.父类方法没有抛出异常，子类重写父类方法时也不可抛出异常.此时子类产生该异常，只能捕获处理，不能声明抛出。
注意：父类异常是什么样，子类异常就什么样。

 */
public class Fu {
    public void show01() throws NullPointerException, ClassCastException { }
    public void show02() throws IndexOutOfBoundsException{}
    public void show03() throws IndexOutOfBoundsException{}
    public void show04() throws IndexOutOfBoundsException{}
    public void show05(){}
    public void show06(){}

}

class Zi extends Fu {
    //如果父类抛出了多个异常，子类重写父类方法时，抛出和父类相同的异常
    public void show01() throws NullPointerException,ClassCastException{}
    //子类重写父类方法时，抛出和父类相同的异常
    public void show02() throws IndexOutOfBoundsException{}
    //子类重写父类方法时，抛出父类异常的子类
    public void show03()throws ArrayIndexOutOfBoundsException{}
    //子类重写父类方法时，不抛出异常。
    public void show04(){}
    //父类方法没有抛出异常，子类重写父类方法时也不可抛出异常
    public void show05(){}
    //此时子类产生该异常，只能捕获处理，不能声明抛出
    /*public void show06()throws Exception{
        throw new Exception("编译器异常");
    }*/
    public void show06(){
        try{

        }catch (Exception e){}
    }
}
