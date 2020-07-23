# Java学习

## 基础

### 类和对象

1. this可以在一个构造方法中调用另一个构造方法

```java
public Hero(String name){
        this.name = name;
    }
public Hero(String name,float hp){
        this(name);
        this.hp = hp;
    }
```

2. 传参：基本类型传参、类类型传参

   - 基本类型传参：在函数内，无法修改函数外的基本类型参数

   - =对于基本类型是赋值，=对于类类型是引用

3. 包

4. 访问修饰符

   public、protected、默认（package、friendly、default）、private

   ![总结](https://stepimagewm.how2j.cn/612.png)

   作用范围最小原则

   - 属性通常使用private封装起来
   - 方法一般使用public用于被调用
   - 会被子类继承的方法，通常使用protected

5. 类属性

   static修饰的属性为类属性（静态属性），所有对象共享一个值。

   static String propertyName;

6. 类方法

   **类方法：** 又叫做静态方法

   **对象方法：** 又叫实例方法，非静态方法

   - 访问一个对象方法，必须**建立在有一个对象**的前提的基础上
   - 访问类方法，**不需要对象**的存在，直接就访问  

7. 属性初始化

   - 对象属性初始化

     - 声明对象时初始化
     - 构造方法中初始化
     - 初始化块

   - 类属性初始化

     - 声明类时初始化

       ```
       public static int itemCapacity=8;
       ```

       

     - 静态初始化块

       ```
       public static int itemCapacity;
       static{
               itemCapacity = 6;
           }
       ```

类中对象属性初始化方法执行先后顺序：声明初始化、初始化块初始化、构造函数初始化

8. 枚举，也是类

```java
public enum HeroType{
    TANK,WARRIOR,ASSASSIN,RANGED,ABLITYPOWER,SUPPORT
}
```

### 接口和继承

1. 接口、实现

   关键字 implements 

   接口定义了规范，而接口的实现类按照这样的规范去实现。
   一个接口可以有多个实现类，这样就体现了java的多态。

   ```java
   public class ADHero extends Hero implements AD { //AD是ADHero的接口
       @Override
       public void physicalAttack(){
           System.out.println("进行物理攻击");
       }
   }
   ```

2. 对象类型转换

   引用类型与对象类型不一致时，进行转换

   - 子类转父类（向上转型）

     ```
     Hero h = new Hero();
     ADHero ad = new ADHero();
     h = ad;
     ```

   - 父类转子类（向下转型）

     父类转子类需要强制类型转换，能不能转换成功，要看父类具体引用指向的是哪种对象。

     ```java
     Hero h = new Hero();
     ADHero ad = new ADHero();
     h = ad;
     ad= (ADHero)h;//强制类型转换，成功
     
     Supprot s=new Support();
     h=s;
     ad=(ADHero)h;//失败
     ```

   - 无继承关系的两个类，相互转换会失败

   - 实现类转换为接口（向上转型）

     ```java
     ADHero ad = new ADHero();
     AD adi = ad;//AD是ADHero的接口，成功
     ```

   - 接口转实现类（向下转型）

     要看接口具体指向的是哪种对象

   - instanceof 判断一个引用的对象是否是该类型、或该类型的子类类型

     ```java
     ADHero ad = new ADHero();
     Hero h1 = ad;
     System.out.println(h1 instanceof ADHero);
     ```

3. 重写

   子类继承父类的对象方法，继承后重复提供该方法，又称为覆盖（override）。重写提高了代码复用性，增强可扩展性。

   - @Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处:
     - 可以当注释用,方便阅读；
     - 编译器可以验证@Override下面的方法名是否是父类所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错了，这时你的编译器是可以编译通过的，因为编译器会认为这个方法是子类中自己增加的方法。

   ### 异常处理
   
   1. try catch finally throws
   
      可能出现异常的代码放在try中，如果没有异常就顺序往下执行，不执行catch中代码，否则会运行到catch中
   
      - FileNotFoundException是Exception子类
   
      - 一段代码可能抛出多种异常，就需要分别进行catch
   
        ```java
        catch (FileNotFoundException e) {
        
        	System.out.println("文件不存在");
        
        	e.printStackTrace();
        
        } catch (ParseException e) {
        
        	System.out.println("日期格式解析错误");
        	e.printStackTrace();
        
        }
        ```
   
      - 或者，放在同一个catch中
   
        ```
        catch (FileNotFoundException | ParseException e) {}
        ```
   
        不确定是哪种异常使用instanceof判断
   
      - 无论是否出现异常，finally一定会执行
   
      - throws抛出异常给上级函数
   
        ```java
        private static void method2() throws FileNotFoundException {
                File f = new File("d:/LOL.exe");
                System.out.println("试图打开 d:/LOL.exe");
                new FileInputStream(f);
                System.out.println("成功打开");
        }
        ```
   
        
   
      - throws与throw这两个关键字接近，不过意义不一样，有如下区别：
   
        - throws 出现在方法声明上，而throw通常都出现在方法体内。
   
        - throws 表示出现异常的一种可能性，并不一定会发生这些异常；throw则是抛出了异常，执行throw则一定抛出了某个异常对象。
   
   
   ### JDBC
   
   **JDBC** (Java DataBase Connection) 是JAVA访问数据库的API
   
   1. JDBC基础
   
      - 初始化驱动
   
        ```
        Class.forName(("com.mysql.jc.database.Driver");//初始化驱动类
        ```
   
      - 建立与数据库的连接
   
        ```
        Connection c = DriverManager.getConnection(
        "database:mysql://127.0.0.1:3306/tables_name?characterEncoding=UTF-8",
         "root", "admin");
        ```
   
      - 创建Statement
   
        ```
        Statement s = c.createStatement();
        ```
   
      - 执行SQL
   
        ```
        s.execute(sql);
        ```
   
      - 关闭连接
   
        - 先关闭Statement，后关闭Connection
        - 可以使用try-with-resource
   
   2. JDBC查询
   
      - executeQuery 执行SQL查询语句，在取第二列的数据的时候，用的是get(2) ，而不是get(1)。这个是整个Java自带的api里**唯二**的地方，使用**基1**的，即2就代表第二个。