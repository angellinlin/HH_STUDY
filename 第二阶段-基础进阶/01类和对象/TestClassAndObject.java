package cn.com.spdb.testidea06;

//import cn.com.spdb.testidea05.Hero;

public class TestClassAndObject {
    public static void main(String[] args) {
        Person human1 = new Person();
        human1.name = "大头";
        human1.pr();

        Man human2 = new Man();
        human2.name = "小头";
        human2.pr();
        human2.PrintSex();

        Human human3 = new Human();
        human3.name = "中头";
        human3.Friend(human2);//human2和human3都是person，所以可以调用person中的方法
        human3.Friend(human2, human1);
        human3.PrintSex();

        Person human4 = new Person("没头");//构造方法无法继承

        //Hero h = new Hero();//别的包

    }
}
