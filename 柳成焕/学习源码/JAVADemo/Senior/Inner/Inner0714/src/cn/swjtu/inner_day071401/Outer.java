package cn.swjtu.inner_day071401;
/*
如果出现了重名现象，那么格式是：外部类名称.this.外部类成员变量

 */
public class Outer {
    int num = 10;

    public class Inner {

        int num = 20;

        public void methodInner() {
            int num = 30;
            System.out.println("局部变量：" + num);  //局部变量
            System.out.println("内部类成员变量：" + this.num);//内部类成员变量
            System.out.println("外部类成员变量：" + Outer.this.num);//外部类成员变量
        }
    }
}
