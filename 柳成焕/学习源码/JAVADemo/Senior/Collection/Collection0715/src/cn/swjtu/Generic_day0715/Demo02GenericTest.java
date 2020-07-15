package cn.swjtu.Generic_day0715;

public class Demo02GenericTest {
    public static void main(String[] args) {
        //不写泛型，默认为Object类型
        Generic gc=new Generic();
        gc.setName("孙尚香");
        //String str=gc.getName();
        Object obj=gc.getName();

        //创建对象，泛型使用Integer
        Generic<Integer>gc2=new Generic<>();
        gc2.setName(100);
        Integer name=gc2.getName();
        System.out.println(name);

        //创建对象，泛型使用String
        Generic<String>gc3=new Generic<>();
        gc3.setName("小明");
        String name2=gc3.getName();
        System.out.println(name2);
    }
}
