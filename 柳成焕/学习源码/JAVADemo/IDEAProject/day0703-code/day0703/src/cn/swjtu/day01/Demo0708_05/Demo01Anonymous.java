package cn.swjtu.day01.Demo0708_05;
/*
创建对象的标准格式：类名称 对象名=new 类名称（）;
匿名对象就是只有右边的对象，没有左边的名字和赋值运算符: new 类名称();

注意事项：匿名对象只能使用唯一的一次，下次再用不得不再创建一个对象。
使用建议：如果确定有一个对象只需要使用唯一的一次，就可以使用匿名对象。
 */
public class Demo01Anonymous {
    public static void main(String[] args) {
        Person one=new Person();
        one.name="啊柳";
        one.showName();  //我叫啊柳
        System.out.println("============");

        //匿名对象
        new Person().name="狗子";
        new Person().showName();  //我叫null
    }
}
