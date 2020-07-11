package cn.swjtu.day0710_Extends05;
//定义一个新手机，继承老手机
public class NewPhone extends Phone{
    @Override
    public void show() {
       super.show(); //把父类的方法拿过来重复利用
        //自己再添加新的内容
        System.out.println("显示姓名");
        System.out.println("显示头像");
    }
}
