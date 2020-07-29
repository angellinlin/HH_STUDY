package cn.swjtu.demo07.ObjectStream;

import java.io.Serializable;

/*
序列化和反序列化时，会抛出NotSerializableException没有序列化异常
Serializable接口也叫作标记型接口，要进行序列化和反序列化的类，必须实现Serializable接口，给类添加一个标记。
当我们进行序列化和反序列化时，就会检测类上是否有这个标记：
有：可以进行序列化和反序列化
没有：就会抛出NotSerializableException异常

去市场卖肉-->肉上有一个蓝色章（检测合格）-->放心购买-->买回来怎么吃随意

static静态关键字：
1、静态优先于非静态加载到内存中（静态优先于对象进入到内存中）
2、被static修饰的成员变量不能被序列化，序列化的都是对象
private static int age;
oos.writeObject(new Person("芈月",18));
System.out.println(obj);//Person{name='芈月', age=0}

transient关键字：瞬态关键字
被transient关键字修饰的成员变量，不能被序列化
private transient int age;
oos.writeObject(new Person("芈月",18));
System.out.println(obj);//Person{name='芈月', age=0}
 */
public class Person implements Serializable {
    // ANY-ACCESS-MODIFIER static final long serialVersionUID = 42L;
   // private static final long serialVersionUID=42L;

    private String name;
    //private transient int age;
   // private    int age;
    public   int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
