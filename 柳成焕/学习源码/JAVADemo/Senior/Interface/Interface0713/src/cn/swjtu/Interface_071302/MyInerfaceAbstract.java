package cn.swjtu.Interface_071302;

public abstract class MyInerfaceAbstract implements MyInterfaceA,MyInterfaceB{
    @Override
    public void methodAbs() {

    }

    //如果没有覆盖重写所有方法，则本类必须是一个抽象类

    @Override
    public void methodDefault() {

    }
   /* @Override
    public void methodA() {

    }*/

    @Override
    public void methodB(){

    }
}
