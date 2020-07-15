package cn.swjtu.inner_day071402;

import java.net.Inet4Address;

/*
如果一个类是定义在一个方法内部的，那么这就是一个局部内部类。
“局部”：只有当前所属的方法才能使用它，出了这个方法就不能使用了。
    修饰符 class 外部类名称{
        修饰符 返回值类型 方法名称（参数列表）{
            class 局部类名称{
                //...
            }
        }
    }

小结一下类的权限修饰符：
public > protected > (default) > private
定义一个类的时候，权限修饰符规则：
1.外部类：public / (default)
2.成员内部类：public/protected/(default)/private
3.局部内部类：什么都不能写

 */
public class Outer {
    public void methodOuter(){
        class Inner{
            int num=10;

            public void methodInner(){
                System.out.println("这是局部内部类的方法！");
            }
        }

        Inner inner=new Inner();
        System.out.println(inner.num);
        System.out.println("这是外部类的方法！");
    }
}
