package cn.swjtu.demo01;

//与MyClass在同一个包下，没有继承关系
public class MyAnother {
    private void anoterMethod(){
        System.out.println(new MyClass().num);
    }
}
