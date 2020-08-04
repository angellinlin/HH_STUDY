package cn.swjtu.demo04.SuperMethodReferefce;

/*定义子类，继承human，重写父类sayHello方法*/
public class Man extends Human {
    @Override
    public void sayHello() {
        System.out.println("hello,我是man!");
    }
    //定义一个方法，参数传递Greetable接口
    public void method(Greetable g){
        g.greet();
    }
    public void show(){
        //调用method方法，参数是函数式接口，可以传递lambda表达式
        method(()->{
            //创建父类Human对象
            Human h=new Human();
            //调用父类的sayHello方法
            h.sayHello();
        });
        /*因为有子父类关系，所以存在一个关键字super代表父类，所以我们可以直接使用super调用父类成员方法*/
        method(()->{
            super.sayHello();
        });
        /*使用super引用父类的成员方法，super是已经存在的，弗雷德额成员方法sayHello也是存在的，
        我们可以直接使用super引用父类的成员方法。     */
        method(super::sayHello);
    }

    public static void main(String[] args) {
        new Man().show();
    }


}
