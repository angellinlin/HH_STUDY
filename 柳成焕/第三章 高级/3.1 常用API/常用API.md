JDK提供的类的集合，是程序员的字典。

 

API使用步骤：

1.打开帮助文档

2.点击显示，找到索引

3.将要寻找的类在输入框中输入，点击回车

4.看包路径。Java.lang下的类不需要导包，其他需要。

5.看类的解释和说明

6.学习构造方法

7.使用成员方法。


### 3.1.1 Scanner类

Scanner类的功能，可以实现键盘输入数据，到程序当中。

 引用类型的一般使用步骤：
 （1）导包：*ipmort* *包路径.**类名称;*
 如果需要使用的目标类与当前类位于统一包下，则可省略导包语句不写。
 只有Java.lang包下的内容不需要导包，其他都需要。
 （2）创建：*类名称* *对象名=new* *类名称();
\* （3）使用: *对象名.**成员方法名();*

 

*例：*

```
//System.in代表从键盘输入
Scanner sc=new Scanner(System.in);
int num=sc.nextInt();  //获取输入int数字
String str=sc.next();  //获取输入的字符串
```

 

```
键盘输入两个int数字，并求出和值。
```

 

```
键盘输入三个int数字，然后求出其中最大值。
int temp = a > b ? a : b;
int max = temp > c ? temp : c;
 
```

### 3.1.2 匿名对象

创建对象的标准格式：*类名称* *对象名=new* *类名称（）;*
 匿名对象就是只有右边的对象，没有左边的名字和赋值运算符: *new* *类名称();*

 注意事项：匿名对象只能使用唯一的一次，下次再用不得不再创建一个对象。
 使用建议：如果确定有一个对象只需要使用唯一的一次，就可以使用匿名对象。

 

匿名对象也可作为方法的参数和返回值。

 

### 3.1.3Random类

Random类用来生成随机数字，使用起来也是三个步骤：
 1.导包 *import java.util.Random;*
 2.创建 *Random r=new Random(); //**小括号留空即可*
 3.使用
 获取随机int数字(范围是int所有范围，有正负两种)：*int num=r.nextInt();*
 获取随机int数字（参数代表范围，左闭右开区间）： *int num=r.nextInt(n);*
 实际上代表的含义是：[0,n)，也就是0,1，……，n-1

 

*题目1**要求：
\* *根据int**变量n**的值，来获取随机数字，范围是[1,n]
\* *思路：
 1.**变量n**，随意赋值
 2.**随机Random**，导包，创建
 3.**若输入为10**，范围为0-9**，想要的是1-10**，因此整体加1**。*

*int num=r.nextInt(n)+1; //**本来范围是[0,n-1],**现在是[1,n]
 4.**打印*

 

*题目2**：用代码模拟猜数字的小游戏。
\* *思路：
 1.**产生一个随机数字，并且一旦产生不再变化。int num=r.nextInt(n);
 2.**键盘输入，用到了Scanner**中的nextInt**方法，获取两个数字
 3.if**判断两个数字：
\*   *如果太小了，提示太小，并且重试；
\*   *如果太大了，提示太大，并且重试；
\*   *如果合适，游戏结束*

 

### 3.1.4 集合类ArrayList

（一）基本介绍

数组的长度不可变，但是ArrayList集合的长度是可变的。
 对于ArrayList来说，有一个<E>，代表泛型。
 泛型，也就是装在集合中的所有元素，全都是统一的什么类型。
 注意：泛型只能是引用类型，不能是基本类型。

 注意事项：
 对于ArrayList来说，直接发音得到的不是地址值，而是内容。
 如果内容是空，得到的是空的中括号：[]

```
//创建了一个ArrayList集合叫list，里面存放的是String类型的字符串数据。
//备注：从JDK 1.7+开始，右侧的尖括号内可不写内容，但本身左边<>还是要写的
ArrayList<String> list = new ArrayList<>();
System.out.println(list);  // []

//向集合中添加一些数据，add
list.add("123");
System.out.println(list);  //[123]

list.add("迪丽热巴");
list.add("古力娜扎");
System.out.println(list);  //[123, 迪丽热巴, 古力娜扎]
//list.add(100);  //报错
```

 

（二）*ArrayList*中的常用方法：
 *public boolean add(E e);*  //向集合中添加元素，参数类型与泛型一致，返回值代表添加是否成功。
 备注：对于ArrayList集合来说，add添加动作一定是成功的，所以返回值可用可不用。
 但是对于其他集合来说，add添加动作不一定成功。

 public E get(int index); //从集合中获取元素，参数是索引编号，返回值就是对应位置的元素

 public E remove(int index);//从集合中删除元素，参数是索引编号，返回值是被删除掉的元素

 public int size();     //获取集合的尺寸长度，返回值是集合中包含的元素个数。

 

（三）遍历集合*
\* for (int i = 0; i < list.size(); i++) {
   System.*out*.println(list.get(i));
 }

 

（四）存储基本数据类型

*//**错误写法！泛型只能是引用类型，不能是基本类型
 //ArrayList<int>list=new ArrayList<int>();

\* 如果希望向集合ArrayList集合中存储基本数据类型，必须使用基本类型对应的包装类。*
\* *基本类型*   *包装类（引用类型，包装类都位于java.lang**包下）
 byte    Byte
 short    Short
 int     Integer**【特殊】
 long    Long
 float    Float
 double   Double
 char    Character**【特殊】
 boolean   Boolean*

 

从JDK 1.5+开始，支持自动装箱，自动拆箱。*
\* 自动装箱：基本类型 --> 包装类型
 自动拆箱：包装类型 --> 基本类型

 

（五）练习

*题目1**：生成6**个1-33**之间的随机整数，添加到集合，并遍历集合。
\* *思路：
 1.**随机数生成Random**类，创建，使用
 2.**创建ArrayList**集合存Integer**随机数，.add r.nexrInt(33)+1
 3.**遍历集合 .size() .get()*

```
Random r = new Random();
ArrayList<Integer> list=new ArrayList<>();
for (int i = 0; i < 6; i++) {
    list.add(r.nextInt(33)+1);
}
//遍历集合
for (int i = 0; i < list.size(); i++) {
    System.out.println(list.get(i));
}
```

 

*题目2**：自定义4**个学生对象，添加到集合，并遍历。
\* *思路：
 1.**定义学生类Student,**标准类
 2.**定义ArrayList**集合，创建对象.add
 3.**遍历for**循环，list.get**（）*

```
ArrayList<Student> list = new ArrayList<>();
Student stu1 = new Student("柳成焕", 24);
Student stu2 = new Student("李姝欣", 23);
Student stu3 = new Student("董曲江", 25);
Student stu4 = new Student("郭彦宏", 26);
//添加对象
list.add(stu1);
list.add(stu2);
list.add(stu3);
list.add(stu4);
//遍历集合
for (int i = 0; i < list.size(); i++) {
    System.out.println("姓名："+list.get(i).getName()+",年龄："+list.get(i).getAge());
}
```

 

*题目3**：
\* *用一个大集合存入20**个随机数字，然后筛选其中的偶数元素，放到小集合中。
\* *要求使用自定义的方法实现筛选。

\* *思路：
 1.**定义一个大集合和一个小集合
 2.**定义一个随机类Random r**，大集合中存入20**个随机数字listA.add r.nextInt()
 3.**定义方法实现筛选,**参数为ArrayList,**返回值也为ArrayList
 4.**方法中实现奇偶判断
 5.**偶数存入集合中
 6.**返回小集合，遍历输出*

 

### 3.1.5 字符串类String

（一）概述和特点

java.lang.String类代表字符串
 API中说，Java程序中的所有字符串字面值（如 "abc" ）都作为此类的实例实现。
 其实就是说，程序中所有的双引号字符串，都是String类的对象（就算没有new，也照样是）

 字符串的特点：
 1.字符串的内容永不可变【重点】 ---字符串是常量；它们的值在创建之后不能更改。
 2.正是因为字符串不可改变，所以字符串是可共享使用的。
 3.字符串效果上相当于是char[]字符数组。但是底层原理是byte[]字节数组*。*

 

（二）创建字符串的常见3+1方式：
 1、三种构造方法:
 *public String(); //**创建一个空白字符串，没有任何内容
 public String(char[] array); //**根据字符数组的内容，来创建对应的字符串
 public String(byte[] array); //**根据字节数组的内容，来创建对应的字符串*

2、一种直接创建:
 *String str="Hello";*
 注意：直接写上双引号，就是字符串对象！

 

（三）字符串的常量池

字符串常量池，程序中直接写上的双引号字符串，就在字符串常量池中。

 对于基本类型来说，==是进行数值比较。
 对于引用类型来说，==是进行【地址值】的比较。

```
String str1="abc";
String str2="abc";

char[] charArr={'a','b','c'};
String str3=new String(charArr);

System.out.println(str1==str2);  //true
System.out.println(str1==str3);  //false
System.out.println(str3==str2);  //false
```

 

​                               

 

（四）字符串内容比较

==是进行字符串的地址值比较，如果确实需要字符串内容的比较，可以使用两个方法。
 *public booliean equals(Object obj);**参数可以试试任何对象，只有参数是一个字符串并且内容相同的才会给true**，否则返回false**。*
 注意事项：
 1.任何对象都能用Object进行接收。
 2.equals方法具有对称性，也就是a.equals(b)和b.equals(a)效果一样。
 3.如果比较双方一个常量一个变量，推荐把常量字符串写前面。*
\* *推荐：  "Hello".equals(str);
\* *不推荐： str.equals("Hello");

 public boolean equalsIgnoreCase(String str);* *忽略英文字母大小写，进行内容比较*

 

（五）字符串获取相关的常用方法*
 public int length();*       *获取字符串中含有的字符个数，拿到字符串长度。
 public String concat(String str);* *将当前字符串和参数字符串拼接成为返回值新的字符串。
 public char charAt(int index);*  *获取指定索引为止的单个字符，索引从0**开始
 public int indexOf(String str);*  *查找参数字符串在本字符串中首次出现的索引位置，*

*如果没有返回值则返回-1.*

 

（六）字符串的截取方法

*public String substring(int index);* 截取从参数位置一直到字符串末尾，返回新字符串。
 *public String substring(int begin,int end);*截取从begin开始，一直到end结束，中间的字符串。
                 备注：[begin,end)，左开右闭*。*

 

```
String str1="HelloWorld";
String str2=str1.substring(5);
System.out.println(str1); //HelloWorld,原封不动
System.out.println(str2); //World,新字符
System.out.println("==============");

String str3=str1.substring(4,7);
System.out.println(str3);  //oWo
System.out.println("==============");

//下面这种写法，字符串的内容仍然没有发生改变
//两个字符串："Hello"  "Java"
//strA中保存的是地址值
// 本来保存的是Hello的地址值0x666
//后来地址值变成了Java的地址值0x999
String strA="Hello";
System.out.println(strA); //Hello
strA="Java";
System.out.println(strA);//Java
```

 

（七）字符串的转换相关方法

*public char[] toCharArray();* 将当前字符串拆分成字符数组作为返回值。*
 public byte[] getBytes();*  获得当前字符串底层的字节数组*
 public String replace(CharSequence olsString,CharSequence newString);
\* 将所有出现的老字符串替换成为新的字符串，返回替换之后的结果新字符串。
 备注：CharSequence意思就是说可以接受字符串类型。

 

```
//转换成为字节数组
byte[] bytes = "abc".getBytes();
for (int i = 0; i < bytes.length; i++) {
    System.out.println(bytes[i]); //97 98 99
}

System.out.println("==============");

//字符串的内容替换
String lang1 = "会不会玩儿啊，你大爷的！你大爷的！你大爷的！";
String lang2 = lang1.replace("大爷", "**");
System.out.println(lang1); //会不会玩儿啊，你大爷的！你大爷的！你大爷的!
System.out.println(lang2);//会不会玩儿啊，你**的！你**的！你**的！
```

 

八、字符串的分割方法

*public String[] split(String regex);* *按照参数的规则，将字符串切分成若干部分。
\* 注意事项：
 split方法的参数其实是一个“正则表达式”，今后学习。
 今天要注意的是，如果按照英文句点"."进行切分，必须写"\\."(两个反斜杠)

 

```
String str3 = "XXX.YYY.ZZZ";
String[] array3 = str3.split(".");
System.out.println(array3.length);//0
for (int i = 0; i < array3.length; i++) {
    System.out.println(array3[i]);
}
System.out.println("============");

array3 = str3.split("\\.");
System.out.println(array3.length);//3
for (int i = 0; i < array3.length; i++) {
    System.out.println(array3[i]);  //XXX YYY ZZZ
}
```

 

九、练习

*题目1**：
\* *定义一个方法，把数组[1,2,3]**按照指定格式拼接成一个字符串，格式参照如下：
 [word1#word2#word3]

\* *思路：
 1.int**数组
 2.**方法，
\* *三要素
\* *返回值String
\* *方法名称fromArrayToString
\* *参数列表int[]
 3.[word1#word2#word3]
\* *用到：for**循环、字符串拼接、每个元素前有一个word**，分隔符用#**，区分是否为最后一个
 4.**调用方法，打印字符串*

 

```
public static String fromArrayToString(int[] array) {
    String str = "[";
    for (int i = 0; i < array.length; i++) {
        if (i == array.length - 1) {  //最后一个元素
            str += "word" + array[i] + "]";
        } else {
            str += "word" + array[i] + "#";
        }
    }
    return str;
}
```

 

*题目2**：键盘输入一个字符串，并且统计其中各种字符出现的次数。
\* *种类有：大写字母、小写字母、数字、其他。

\* *思路：
 1.**键盘输入Scanner
 2.**定义一个字符串存键盘输入sc.next();
 3.**定义四个变量用于统计字符种类数
 3.**将字符串转为字符数字.toCharArray();
 4.**遍历字符数组进行判断，并对四个变量进行++**动作
 5.**打印四个变量*

 

```
Scanner sc = new Scanner(System.in);
System.out.println("请输入一个字符串：");
String str = sc.next();
char[] array = str.toCharArray();
int num1 = 0; //大写字母个数
int num2 = 0; //小写字母个数
int num3 = 0; //数字个数
int num4 = 0; //其他字符个数

for (int i = 0; i < array.length; i++) {
    if (array[i] >= 'A' && array[i] <= 'Z') {
        num1++;
    }else if(array[i] >= 'a' && array[i] <= 'z'){
        num2++;
    }else if(array[i] >= '0' && array[i] <= '9'){
        num3++;
    }else{
        num4++;
    }
}

System.out.println("大写字母个数为："+num1);
System.out.println("小写字母个数为："+num2);
System.out.println("数字个数为："+num3);
System.out.println("其他字符个数为："+num4);
```

 

### 3.1.6 static关键字

（一）static概述

 

 

如果一个成员变量使用了static关键字，那么这个变量不再属于对象自己，而是属于所在的类。即多个对象共享同一份数据。

 

（二）staic关键字修饰成员

一旦使用static修饰成员方法，那么这就成为了静态方法，静态方法不属于对象，而是属于类的。

 如果没有static关键字，那么必须首先创建对象，然后通过对象才能使用它。
 如果有了static关键字，那么必须不需要创建对象，直接通过类名称就能使用它。

 无论是成员变量还是成员方法，如果有了static，都推荐使用类名称进行调用。
 静态变量：*类名称**.**静态变量*
 静态方法：*类名称**.**静态方法()

*

```
//对于静态方法来说，可以通过对象名进行调用，也可通过类名称进行调用。
obj.method();            //正确，不推荐。这种写法在编译之后也会被javac翻译成为“类名称.静态方法名”
MyClass.methodStatic();  //正确，推荐
```

 

```
//对于本来类中的静态方法，可以省略类名称
myMethod();
Demo02StaticMethod.myMethod(); //完全等效
```

 

*
\* 注意事项：
 1.静态不能直接访问非静态.
 原因：因为在内存中【先】有的静态内容，【后】有的非静态内容。
 “先人不知道后人，但是后人知道先人”
 2.静态方法中不能用this。
 原因：this代表当前对象，通过谁调用的方法，谁就是this。

 

```
public static void methodStatic() {
    //System.out.println(num);  //报错！静态不能直接访问非静态
    System.out.println(numStaic);  //静态可以访问静态
    System.out.println("这是一个静态方法！");
    //静态方法中不能使用this关键字！
    //System.out.println(this);

}
```

 

（三）static的内存图

 

静态变量直接在方法区中开辟了一块静态区，用于存放静态变量。

根据类名称访问静态成员变量的时候，全程和对象没有关系，只和类有关系。（如图中红色箭头所示）

 

（四）静态代码块

静态代码块的格式：
 *public class* *类名称{
   static{
     //**静态代码块的内容
   }
 }
\* 特点：当第一次用到本类时，静态代码块执行唯一的一次。
 静态内容总是优先于非讲台，所以静态代码块比构造方法先执行。

 静态代码块的典型用途：
 用来一次性地对静态成员变量进行赋值。

 

### 3.1.7 数组工具类Arrays

*java.util.Arrays*是一个与数组相关的工具类，里面提供了大量静态方法，用来实现数组常见的操作。
 *
 public static String toString(**数组);* 将参数数组变成字符串，按照默认格式[元素1，元素2，……]*
 public static void  sort(**数组);*   按照默认升序对数组的元素进行排序*

\* 备注：
 1.如果是数值，sort默认按照升序从小到大；
 2.如果是字符串，sort默认按照字母升序；
 3.如果是自定义的类型，那么这个自定义类型需要有Comparable或Comparator接口的支持（今后学习）*
\* 

```
String[] arr2={"asfd","sdhkjs","hnsdkjfs"};
Arrays.sort(arr2);
System.out.println(Arrays.toString(arr2));  //[asfd, hnsdkjfs, sdhkjs]
```

 

练习：*请使用**Arrays**相关的API**，将一个随机字符串中的所有字符升序排列，并倒序打印。

\* *思路：
 1.**升序排列 Arrays.sort(**数组)
 2.**将字符串转为字符数组str.toCharArray()*

```
String str = "djhhfdsuguagnvkanvgad";
char[] array = str.toCharArray();  //字符串转为字符数组
Arrays.sort(array);                //升序排列
//倒序遍历 .forr
for (int i = array.length - 1; i >= 0; i--) {
    System.out.print(array[i] + " ");
}
```

 

### 3.1.8 数学工具类Math

*java.util,Math*是数学相关的工具类，里面提供了大量的静态方法，完成与数学相关的操作。
 *
 public static double abs(double num);*  *获取绝对值
 public static double ceil(double num);*  *向上取整12.1 →13
 public static double floor(double num);*  *向下取整12.9 →12
 public static long round(double num);* *四舍五入

 Math.PI* *代表近似的圆周率常量。（double**）*

 

*题目：计算在-10.8**到5.9**之间，绝对值大于6**或者小于2.1**的整数有多少个？

\* *思路：
 1.**既然确定了范围，for**循环
 2.**起点位置-10.8**可用两种方法转为-10
\*  *一是向上取整，而是强制转换
 3.**每一个数字都是整数，所以步进表达式应该是num++
 4.**如何拿到绝对值：Math.abs
 5.**条件判断，计数统计++*

```
int count = 0;
int min = (int) (Math.ceil(-10.8));
int max = (int) (Math.floor(5.9));


for (int i = min; i < max; i++) {
    int abs = Math.abs(i);
    if (abs > 6 || abs < 2.1) {
        System.out.print(i + " ");
        count++;
    }
}
System.out.println("个数为：" + count);  //9
```

###  3.1.9 Object类

\1. *public Str*ing toString(); 返回该对象的字符串表示。该字符串由类名（对象是该类的一个实例）、at 标记符“@”和此对象哈希码的无符号十六进制表示组成。

注：直接打印对象的地址值没有意义，需要重写Object类的toString方法，打印对象的属性。

 

```
String str = person.toString();
System.out.println(str);  //Person{name='啊柳', age=18}
 
```

\2. Person类默认继承了Object类，因此可以用Object类的equals方法。
 *public boolean equals(Object obj);*  指示其他某个对象是否与此对象“相等”。
 equals方法源码：*public boolean equals(Object obj) {
          return (this == obj);
\*         *}*
        *参数：Object obj**可以传递任意对象
        ==**比较运算符，返回的是一个boolean**值，true/false
\*        *基本数据类型：比较的是值
\*        *引用数据类型：比较的是两个对象的地址值
        this**：哪个对象调用的方法，方法中this**就是那个对象。
        obj**：传递过来的参数*

```
3. Objects类中的equals方法，也是对两个对象进行比较，防止空指针异常
源码： public static boolean equals(Object a, Object b) {
          return (a == b) || (a != null && a.equals(b));
      }
String s1=null;
String s2="ABC";
//boolean b=s1.equals(s2);  //NullPointerException 
                     //null是不能调用方法的，否则会出现空指针异常
boolean b2 =Objects.equals(s1,s2);
System.out.println(b2);  //false
 
```

### 3.1.10 日期时间类

#### 一、Date类

（一）毫秒的概念和作用

*java.util.Date:*表示日期和时间的类。
 类Date：表示特定的瞬间，精确到毫秒。
 *1**秒=1000**毫秒*
 毫秒的作用：可以对时间和日期进行计算。
   计算从*2020-07-14**到2099-01-01*之间的天数。
   将日期转换为毫秒计算完毕后，再将毫秒转为日期。
 
 把日期转换为毫秒：
     当前日期：*2020-07-14
\*     时间原点（0毫秒）：*1970* *年 1* *月 1* *日 00:00:00**（英国格林威治）
\*     计算一共经历了多少毫秒。
     *System.currentTimeMillis()* //获取当前系统时间到1970年1月1日00.00共经历了多少毫秒
   注意：中国属于东八区，会把时间增加8小时。
       1*970* *年 1* *月 1* *日 08:00:00*
 
 把毫秒转为日期：*
     1* *天 = 24 × 60 × 60 = 86400* *秒 = 86400000* *毫秒*

 

（二）Date类的构造方法和成员方法

```
Date date = new Date();  //无参构造方法
Date date = new Date(0L); //带参数的构造方法
public long getTime() 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
 
```

#### 二、DateFormat类和SimpleDateFormat类

*java.text.Format:*是日期/时间格式化子类的抽象类
       作用：格式化（日期 -> 文本）、解析（文本-> 日期）
       成员方法：*
       String format(Date date)* 将一个 Date 格式化为日期/时间字符串。*
       Date parse(String source)* 从给定字符串的开始解析文本，以生成一个日期。 *DateFormat*类是一个抽象类，无法直接创建对象使用，可以使用DateFormat的子类。*
 
*

 *java.text.SimpleDateFormat extends DateFormat*

构造方法：*SimpleDateFormat(String pattern)* 用给定的模式和默认语言环境的日期格式符号
     参数：*String pattern* 传递指定的格式*
\*     *模式：区分大小写
\*     y  年
     M  月
     d  日
     H  时
     m  分
     s  秒
 写对应的模式，会把模式替换为对应的日期和时间。*
 “yyyy-MM-dd HH:mm:ss"
\* 注意：模式中的字母不能改变，中间连接的符号可以改变。 

 

使用Parse方法时，将格式化的字符串解析为Date要注意：

如果字符串和构造方法的模式不一样，那么程序就会抛出异常ParseException
 调用了一个抛出了异常的方法，就必须处理这个异常，要么throws继续抛出这个异常（alt+enter选第一个即可），要么try catch自己处理。

```
/*
解析
使用Parse方法，将格式化的字符串解析为Date
注意：如果字符串和构造方法的模式不一样，那么程序就会抛出异常ParseException
调用了一个抛出了异常的方法，就必须处理这个异常，要么throws继续抛出这个异常，要么try catch自己处理。
 */
private static void demo02() throws ParseException {
    SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date date=new Date();
    date=simFormat.parse("2020-07-14 18:35:23");
    System.out.println(date);
}

/*
使用DateFormat类中的format方法格式化日期。
步骤：
1.创建SimpleDateFormat对象，构造方法传递指定格式
2.调用SimpleDateFormat的format方法，把Date日期转化为符合模式的字符串
*/
private static void demo01() {
    SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String str = simFormat.format(new Date());
    System.out.println(str);
}
```

 

三、计算一个人出生了多少天

 

### 3.1.11 Calendar类

一、java.util.Calendar类：日历类
 1、是一个抽象类，里面提供了很多操作日历字段的方法（YEAR,MONTH,DAY_OF_MONTH,HOUR）
 2、无法直接创建对象使用，但其有一个静态方法getInstance(),其返回一个Calendar子类对象。
 *static Calendar getInstance()*使用默认时区和语言环境获得了一个日历

 

二、常用成员方法

*public int get(int field)*返回给定日历字段的值。(YEAR,MONTH,DAY_OF_MONTH,HOUR,...)
 *public final void set(int field,int value)*设置日历字段值。
 *public abstract void add(int field,int amount)*根据日历的规则，为给定的日历字段添加或减去指定的时间量。(正数：增加，负数：减少)
 *public final Date getTime()*返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。

 

### 3.1.12 System类

一、两个常用方法

*public static long currentTimeMillis()*   *返回以毫秒为单位的当前时间
 public static void arraycopy(Object src,*     *源数组
               int srcPos,*  *源数组的起始位置（索引）
               Object dest,*  *目标数组
               int destPos,*  *目标数组起始位置
               int length)*  *要复制的数组元素数量
\*    *从指定源数组中复制一个数组*

 

二、练习

1.计算打印1-9999所需要的时间（毫秒值）
 思路：
 1.程序执行前，计算一次毫秒值System.currentTimeMillis()
 2.打印程序
 3.程序执行后，计算一次毫秒值
 4.相减，输出
 
 2.将src数组中的前3个元素，复制到dest数组的前3个位置上。
 复制元素前：src[1,2,3,4,5] dest[6,7,8,9,10]
 复制元素后：src[1,2,3,4,5] dest[1,2,3,9,10]
 思路：*System.arraycopy(src,0,dest,0,3);*

 

### 3.1.13 StringBuilder类

#### 一、原理

String类

字符串是常量，它们的值在创建之后不能更改。

字符串的底层是一个被final修饰的数组，不能改变，是一个常量。

private final byte[] value;

StringBuilder类

字符串缓冲区，可以提高字符串的操作效率（看成一个长度可变化的字符串）

底层也是一个数组，但是没有final修饰，可以改变长度。

byte[] value=new byte[16];

StringBulider在内存中始终是一个数组，占用空间少，效率高。

如果超出了StringBuilder的容量，会自动扩容。

​                               

#### 二、构造方法和成员方法

**构造方法：**

***public StringBuilder()\****构造一个其中不带字符的字符串生成器，初始容量为 16* *个字符。
 **public StringBuilder(String str)****构造一个字符串生成器，并初始化为指定的字符串内容。*

**成员方法：**

***public StringBuilder append(...)\***  *添加任意数据类型，返回当前对象自身
\* *注意：StringBuilder builder2 = builder1.append("abc");
\* 方法返回的是this，builder1调用的方法，this=builder1
 因此，使用append方法无需接收返回值
 
 链式编程：方法返回值是一个对象，可以继续调用方法。

```
//链式编程
System.out.println("abc".toUpperCase().toLowerCase().toUpperCase());
System.out.println(builder1.append(2).append("hsdj").append(23.1));
```

 

三、StringBuilder和String的相互转换*
 1.String-->StringBuilder :* 可以使用StringBuilder的构造方法*
 2.StringBuilder-->String* *：*可以使用StringBuilder的toString方法

 

### 3.1.14 包装类

#### 一、概述

基本数据类型使用起来非常方便，但是其没有对应的方法来操作这些基本数据类型的数据。

因此可以使用一个类把基本数据类型装起来，在类中定义一些方法，这个类叫**包装类**。

我们可以使用类中的方法来操作这些基本类型的数据。

基本类型       对应的包装类（位于java.lang，无需导包）

byte           Byte

short         Short

int          **Integer**

long          Long

float          Float

double         Double

char          **Character**

boolean        Boolean

 

#### 二、装箱与拆箱

（一）装箱：基本数据类型  à 包装类

1.使用构造方法
 public Integer(int value)
 public Integer(String s)：传递的字符串必须是基本类型的字符串，否则会抛出异常，100-正确，0抛异常
 2.使用静态方法
 public static Integer valueOf(int i)
 public static Integer valueOf(String s)
 
 （二）拆箱：包装类     à 基本数据类型
 public int intValue()

 

（三）自动装箱与自动拆箱

```
//自动装箱
Integer in=1;   //相当于Integer in=new Integer(1);

//自动拆箱
//Integer类无法直接进行运算
//in+2相当于：in.intvalue()+2=3  --> int
//in=3     又是一个自动装箱操作
in=in+2;

ArrayList<Integer>list=new ArrayList<>();
list.add(100);  //隐含了一个自动装箱操作
int num=list.get(0);  //隐含了一个自动拆箱操作
```

 

三、基本类型与字符  串类型之间的相互转换
 （一）基本类型-->字符串（String）
 1.基本类型的值+"" 最简单的方法（工作中常用）
 2.包装类的静态方法toString(参数)，不是Object类中的toString()重载。
 3.String类中的valueOf(参数)方法 返回int参数的字符串表示
 
 （二）字符串 --> 基本类型
 使用包装类的静态方法parseXXX("数值类型的字符串")
   Integer类：static int parseInt(String s)
   Double类： static double parseDouble(String s)

 

 