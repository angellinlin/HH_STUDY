# 快速复习  入职学习基础部分
## 1.基本变量类型 * 8类 
* 整型：byte short int long 
* 浮点：float double 
* 字符：char 
* 布尔：Boolean
**数据类型转换规则：小转大自动，大转小强制转（精度）**
**作用域：成员变量（类变量）、局部变量**
## 2.面向对象/面向过程
* 面向对象：将解决问题的各事物分解为相应的object,用于描述其解决问题的行为和属性。采用封装（private）、继承（extend）、抽象（abstract）等设计实现
* 面向过程：将问题分解为各个步骤，分别构建函数依次解决

## 3.操作符
* 三元操作符：修饰符 变量=变量A **关系操作符** 变量B ？ 变量A：变量B
* 位操作符：二进制操作方式    **#######** 二进制转换方法：变量类型.TobinaryString(i)
* Scanner类：熟悉其操作方法
  **Scanner input = new Scanner(System.in);**
  **input.nextint() //其他数据类型**

## 4.条件判断
* if语句
* switch语句
* while语句
* 关键字：continue  AND break  **注意其外环跳转和外环退出使用方式**
* **PS**: 注意循环语句 for 与foreach的用法

## 5.数组
* 创建方式：
    **(1)** int[] a;    a = new int[5];
    **(2)** int[] b = new int[5];
    **(3)** int[][] array; 多维数组
* 操作方式
  初始化：int[] a={，，，};   int[] a= new int[5]{,,,,};  int[] a= new int[]{,,,,};
  索引：array[index]；
  排序：Arrays类方法掌握;Collections类方法掌握;
  拷贝：System.arraycopy()   **注意：Arraylist 扩容原理**
* String类
  String 字符串常量，长度不可变
  StringBuffer 字符串变量（线程安全），长度可变
  StringBuilder 字符串变量（非线程安全），长度可变
  常见操作方法：append、insert、reverse方法
* Char类与Character包装类
  常见方法：toCharArray()，valueOf()
## 6.哈希
* HashMap（数组+链表结构） 与HashTable
方法：put()添加  putAll(整个hash表)   remove()   containKey()判断key  containValue()判断value  contains(属于hashtable)  get()基于key查询value    values()获取所有value     keyset() 获取所有key

* 都是继承Map接口;
  区别：
  Hashmap：非同步，非线程安全；允许null键值，效率更高。
  Hashtable: 同步，线程安全；不允许null.

  构建方式
```
  ***hashmap    
  HashMap<String, String> map = new HashMap<String, String>();    
  map.put("key1", "value1");    
  map.put("key2", "value2");    
  map.put("key3", "value3"); 

  ***hashtable
  HashTable<String, String> map = new HashTable<String, String>();    
  map.put("key1", "value1");    
  map.put("key2", "value2");    
  map.put("key3", "value3"); 

```
* 遍历方式

   （1）hash通用遍历  
  （hashmap 与hashtable 一样）  二次取值  keyset() 方法 keyset()返回是Map中key值的集合

```
  HashMap<String,String> mp = new　HashMap<String,String>();
  for (String i : mp.keySet()) // foreach的表达方式
  { 
 	  //String 是mp中的键的对应类型 i 是对应的KeySet中的每一个key值 　
   	  System.out.println( mp.get(i));　
  }

```
  （2）entrySet() 方法   
  返回值也是返回一个Set集合，此集合的类型为Map.Entry；再利用 for循环获取
  Set集合中的每一个Entry实例，Map.Entry接口为泛型，定义为Entry<K,V>。它表示Map中的一个实体（一个key-value对）.
```
  HashMap<String,String> mp = new　HashMap<String,String>();
  for (Map.Entry<String, String> entry : map.entrySet()) {    
  System.out.println("key= " + entry.getKey() + " and value= " + entry.getValue()); }
```     
* 哈希冲突 （hashmap,链表法,基本单元Entry（key-value键值对，静态内部类））
  程序执行 map.put(String,Obect)方法 时，系统将调用String的 hashCode() 方法得到其 hashCode 值——每个 Java 对象都有 hashCode() 方法，都可通过该方法获得它的 hashCode 值，从而进一步决定该元素的存储位置
  hash冲突，是指存储过程中，该位置以经存在其他元素此时，首先进行判断，如果key和hashcode都相同，则直接替换valu，并返回旧值。当key不相同时，出现冲突，此时原来存储单元的单个bucket不再是单独的entry,而是形成了一个entry链，用以存储key不相同，但是hashcode相同的输入对象，并且通过便利该entry链来实现查询：

```
  源码：
  public V put(K key, V value) {
   //如果table数组为空数组{}，进行数组填充（为table分配实际内存空间），入参为threshold，
        //此时threshold为initialCapacity 默认是1<<4(24=16)
        if (table == EMPTY_TABLE) {
            inflateTable(threshold);
        }
       //如果key为null，存储位置为table[0]或table[0]的冲突链上
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key);//对key的hashcode进一步计算，确保散列均匀
        int i = indexFor(hash, table.length);//获取在table中的实际位置
        for (Entry<K,V> e = table[i]; e != null; e = e.next) {
        //如果该对应数据已存在，执行覆盖操作。用新value替换旧value，并返回旧value
            Object k;
            if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                V oldValue = e.value;
                e.value = value;
                e.recordAccess(this);
                return oldValue;
            }
        }
        modCount++;//保证并发访问时，若HashMap内部结构发生变化，快速响应失败
        addEntry(hash, key, value, i);//新增一个entry
        return null;
    } 

```



## 7.类与对象
* 引用（类的实例化）：Class obj=new Class();  Fea:多个引用，一个对象;或则一个引用一个对象
* 继承：extend，一个类只能继承一个类；但可以实现多个接口
  public class A extend ClassB; public class A implement interA,interB
* 方法重载：同一个类中的同名方法的不同构建形式
```
  public class tests{
    public void method(){...};
    public void method(...){};
    ...
  }

```  
注意：利用java特性，构建可变量参数函数：
  **返回类型 函数名(参数类型...参数名字)**
* 构造方法：方法名和类名一样（包括大小写）没有返回类型,分为有参合无参（其中JVM会默认构建无参方法，如果显示构建了，则默认方法无）
  public class method{
    public method(){};
  }
  **也可以重载**
* this关键字：用于区别，同名属性和方法参数；第二调用其他构造方法（仅调用一次，放在首行，不可相互调用）
* 传参：类类型（引用），以及基本数据类型（赋值）
* 访问修饰符：
  成员变量有四种修饰符：
  private 私有的
  package/friendly/default 不写
  protected 受保护的
  public 公共的
  **特点**
  重点：private修饰属性
    自身：是可以访问的
    同包子类：不能继承
    不同包子类：不能继承
    同包类：不能访问
    其他包类：不能访问
  **常用方式**
  1. **属性**通常使用**private**封装起来
  2. **方法**一般使用**public**用于被调用
  3. 会被子类继承的方法，通常使用protected
  4. package用的不多，一般新手会用package,因为还不知道有修饰符这个东西
* 包
* 类属性：由static修饰，静态属性，被所有对象obj共享（类实例化对象）,由**类名.属性名** 调用
* 类方法：被static方法修饰，可以直接由**类名.方法**()调用（静态方法）；对象方法称为非静态方法，无法直接调用
* 属性初始化：构建的属性赋值
  (1)对象属性，通常包含以下三个方面：
```
public class Hero {
  public String name = "some hero"; **//声明该属性的时候初始化**
  protected float hp;
  float maxHP;
  {
      maxHP = 200; **//初始化块**
  }  
  public Hero(){
      hp = 100; **//构造方法中初始化** 
  }
}
```
(2) 类属性：声明时，或者static块(自动运行运行)
* 单例模式：整个类中在JVM只有**一个实例化对象obj**；利用priviate构造方法，保证其无法外部实例化，接着利用public方法调用指向该类实例化对象的一个类属性；
  通常分为两种，懒汉式和饿汉式
  懒汉式：只有调用该public方法时，才回构建该唯一对象实例
```
  public class GiantDragon {
  
    **//私有化构造方法使得该类无法在外部通过new 进行实例化**
    private GiantDragon(){       
    }
    **//准备一个类属性，用于指向一个实例化对象，但是暂时指向null**
    private static GiantDragon instance; 
    //public static 方法，返回实例对象
    public static GiantDragon getInstance(){
        **//第一次访问的时候，发现instance没有指向任何对象，这时实例化一个对象**
        if(null==instance){
            instance = new GiantDragon();
        }
        //返回 instance指向的对象
        return instance;
    }   
}

```   
  饿汉式：直接创建指向该对象实例的类变量，每次加载都会调用该唯一的对象实例public方法

* 枚举类型：针对不存在与基本数据类型中的数据而构建的一种**数据集类型**
  public **enum** Season {
    SPRING,SUMMER,AUTUMN,WINTER
}
通常和switch关键字一起使用
## 8.接口与继承（类）
* 一种抽象类型，由interface声明，主要是各类抽象方法的集合。
* 注意：
  1.接口并不是类（不能实例化，没有构造方法），类描述对象的属性和方法，而接口主要包含类要实现的方法，隐式抽象的（abstract修饰）（**全部是抽象方法，没有方法体**）
  2.接口不能被继承，但可以被实现，而实现接口的类必须实现接口中所有abstract方法，否则该类只能被声明为abstract class。
  **3.一个类只能继承一个抽象类（单继承），而一个类却可以实现多个接口（实现），此外接口间可以多重继承（Interface3 extends Interface0, Interface1, interface……），但接口间不能相互实现其中的方法。**
  4.注意接口中的方法和变量都会被隐式的制定为public abstract（不需要特殊声明） 和 public static final 其他修饰符会报错。
* 声明方式：
```
  public interface NameOfInterface
{
   //任何类型 final, static 变量
   //抽象方法，只声明，没有方法体，在实现接口的类中，进一步实现方法
}
```
### 8.1 对象转型
* 引用类型，和对象类型  Class 对象类型=new 引用类型（）； （对象类型与引用类型不一致，就涉及转换问题）
* 通常涉及**向上转型和向下转型**，即子类作为一个普通父类来使用，父类的对象类型由子类的引用类型来声明。以及反向。
  父类 对象A=new 父类();
  子类 对象B=new 子类();

  对象A=对象B；(涉及转换)    **向上转型**（最常见）子类转父类，一定可以成功，此时对象A继承了子类所有方法，但只能调用公共方法，安全性高

  对象B=对象A;              **向下转型**，容易方法丢失，有风险，视情况而定，**注意强制转换使用** 对象B=（B 类）对象A；  通常强转~~~~

### 8.2 方法重写
* 重写又称覆盖（override）：通常是指**子类继承了父类方法后**，对父类中的方法，进行重新定义（声明方式和方法名完全不变，仅改变方法体）
* 注意与方法重载的区别：重载是指在同一个类中，对方法名相同的方法在参数和方法体上的不同实现过程
```
  public void Test(){};
  public void Test(string strs){};
  public void Test(string strs,int ints){};
  注意：修饰和返回类型不同，不是重载的核心。

```
### 8.2 多态
* 多态的体现，主要体现在：方法的覆写，重载等；类的向上转型等（父类引用对象指向子类）。
#### 隐藏
针对子类继承父类的问题中，父类中的类方法，将其覆写一次，然后通过向上转型的方式，实现父类对子类覆写方法的调用
```
public class Hero {
    public String name;
    protected float hp;
  
    //类方法，静态方法
    //通过类就可以直接调用
    public static void battleWin(){
        System.out.println("hero battle win");
    }
      
}
public class ADHero extends Hero implements AD{
  
    @Override
    public void physicAttack() {
        System.out.println("进行物理攻击");
    }
     
    // 父类的battleWin方法的隐藏
    public static void battleWin(){
        System.out.println("ad hero battle win");
    }   
     
    public static void main(String[] args) {
        Hero.battleWin();
        ADHero.battleWin();
    }
  
}

Hero h =new ADHero();
h.battleWin();  // 实现子类覆写方法的调用

```

#### super 关键字
针对父类中的构造方法，子类采用 super(参数) 方式实现显式调用
此外也可以调用父类中的属性，**super.属性名**   this.属性名() 调用当前类属性

#### object类（超类）
* 声明一个类的时候，默认是继承了Object，**所有类都默认继承**，该object类中包含了多种方法，tostring(),finalize()（垃圾回收，由JVM自动调用）,euqals();==,等各种操作方法。

```
**//源码构成**
    public String toString(){
        return name;
    }
     
    public void finalize(){
        System.out.println("这个英雄正在被回收");
    }

    public boolean equals(Object o){
        if(o instanceof Hero){
            Hero h = (Hero) o;
            return this.hp == h.hp;
        }
        return false;
    }

```
此外，还包含线程同步类方法：
wait()
notify()
notifyAll()

#### Final修饰符
* final修饰类
  表示当前类无法被继承（报错:编译错误类型）
```
  public final class Test{}
  public class test1 extend Test{
    //编译错误
  }

```
* final修饰变量
  
* final修饰方法
  当前方法，无法被子类重写

     
        

