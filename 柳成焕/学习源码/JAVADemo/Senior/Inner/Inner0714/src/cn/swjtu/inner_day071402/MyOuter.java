package cn.swjtu.inner_day071402;
/*
局部内部类如果希望访问所在方法的局部变量，那么这个局部变量必须是【有效final的】
备注：从Java8+开始，只要局部变量事实不变，那么final关键字是可以省略的。

原因：new出来的对象在堆中
2.局部变量是跟着方法走的，在栈内存中红
3.方法执行结束后，立刻出栈，局部变量会立即消失
4.但是new出来的对象会在堆当中持续存在，知道垃圾回收消失。
 */
public class MyOuter {
    public void methodOuter(){
        /*final */int num=10; //所在方法的局部变量【有效final】
        class Inner{
            public void methodInner(){
                System.out.println(num);
            }
        }
    }
}
