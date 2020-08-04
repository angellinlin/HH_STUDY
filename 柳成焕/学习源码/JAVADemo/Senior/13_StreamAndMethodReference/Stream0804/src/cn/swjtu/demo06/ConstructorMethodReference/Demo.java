package cn.swjtu.demo06.ConstructorMethodReference;

/*类的构造器（构造方法）引用*/
public class Demo {
    //定义一个方法，参数传递姓名和PersonBuilder接口，通过姓名创建Person对象
    public static void printName(String name, PersonBuilder pb) {
        Person p = pb.personBuilder(name);
        System.out.println(p.getName());
    }
    public static void main(String[] args) {
        //调用printName方法。参数传递lambda表达式
        printName("孙尚香", (name) -> {
            return new Person(name);
        });
        //使用方法引用优化lambda，构造方法new Person(String name)已知
        //创建对象已知，new
        //就可以使用Person引用new创建对象
        printName("王昭君", Person::new);  //使用Person类的带参构造方法，通过传递的姓名传递对象
    }
}
