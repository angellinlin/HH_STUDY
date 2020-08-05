# File类与IO流

## File类

- `java.io.File`类：文件和目录路径名的抽象表示形式。Java把电脑中的文件和文件夹（目录）封装为了一个File类，可以使用File类对文件和文件夹进行操作。

  File类是一个**与系统无关的类**，任何的操作系统都可以使用这个类中的方法。

  File类中的一些方法：

  - 创建一个文件/文件夹
  - 删除文件/文件夹
  - 获取文件/文件夹
  - 判断文件/文件夹是否存在
  - 对文件夹进行遍历
  - 获取文件的大小

  `file`：文件

  `directory`：文件夹/目录

  `path`：路径

- File类的静态成员变量

  1. `static String pathSeparator`：与系统有关的路径分隔符
  2. `static char pathSeparatorChar`：与系统有关的路径分隔符
  3. `static String separator`：与系统有关的默认名称分割符
  4. `static char separatorChar`：与系统有关的默认名称分割符

  - 路径分隔符 Windows ：分号； Linux：冒号：

    文件名称分隔符 Windows：反斜杠\	Linux：正斜杠/

- 绝对路径和相对路径

  1. 绝对路径：是一个完整的路径。

     以盘符开始的路径

  2. 相对路径：是一个简化的路径。

     相对指的是相对于当前项目的根目录。

     如果使用当前项目的根目录，路径可以简化书写。

  【注意】

  1. 路径是不区分大小写
  2. 路径中的文件名称分隔符Windows使用的反斜杠，反斜杠是转义字符，两个反斜杠代表一个普通的反斜杠。

- File类的【构造方法】

  1. `File(String pathname)`通过将给定路径名字符串转换为抽象路径来创建一个新的File实例。

     参数：

     ​		`String pathname`：字符串的路径名称

     ​		路径可以是以文件结尾，也可以是以文件夹结尾

     ​		路径可以是相对路径，也可以是绝对路径

     ​		路径可以存在，也可以是不存在

     ​		创建`File`对象，只是把字符串路径封装为`File`对象，不考虑路径的真假情况。

  2. `File(String parent,String child)`根据`parent`路径名字符串和`child`路径名字符串创建一个新的`File`实例。

     参数：把路径分成了两部分

     ​		`String parent`：父路径

     ​		`String child`：子路径

     优点：

     ​		父路径和子路径，可以单独书写，使用起来非常灵活。

  3. `File(File parent,String child)`：根据`parent`抽象路径和`child`路径名字符串创建一个新的`File`实例。

     参数：把路径分为两部分

     ​		`File parent`：父路径

     ​		`String child`：子路径

     优点：

     ​		父路径和子路径，可以单独书写，使用起来非常灵活；

     ​		父路径是`File`类型，可以使用`File`的方法对路径进行一些操作，再使用路径创建对象。

- File类【获取功能】的方法

  1. `public String getAbsolutePath()`：返回此File的绝对路径名字符串。

     获取构造方法中传递的路径，无论路径是绝对还是相对，该方法最终返回的都是据对路径。

  2. `public String getPath()`：将此File转换为路径名字符串。

     获取构造方法中传递的路径。

  3. `public String getName()`：返回由此File表示的文件或目录的名称。

     获取的就是构造方法传递路径的结尾部分（文件/文件夹）。

  4. `public long length()`：返回由此File表示的文件的长度。

     获取的是构造方法指向的文件的大小，以字节为单位。

     【注意】：

     1. 文件夹是没有大小概念的，不能获取文件夹的大小。
     2. 如果构造方法中给出的路径不存在，那么length方法返回0。

- File类【判断功能】的方法

  1. `public boolean exists()`：此File表示的文件或目录是否实际存在。

  2. `public boolean isDirectory`：此File表示的是否为目录。

  3. `public boolean isFile`：此File表示的是否是文件。

     方法2和方法3【注意】

     1. 电脑的硬盘中只有文件/文件夹，两个方法是互斥的。
     2. 这两个方法使用前提，路径必须是存在的，否则都返回false。

- File类【创建删除功能】的方法

  1. `public boolean createNewFile()`：当且仅当具有该名称的文件尚不存在时，创建一个新的空文件。

     创建文件的路径和名称在构造方法中给出（构造方法的参数）。

     返回值：布尔值

     ​	true：文件不存在，创建文件，返回true

     ​	false：文件存在，不会创建，返回false

     【注意】：

     1. 此方法只能创建文件，不能创建文件夹。
     2. 创建文件的路径必须存在，否则会抛出异常。

  2. `public boolean delete()`：删除由此File表示的文件或者目录。

     此方法，可以删除构造方法路径中给出的文件/文件夹。

     返回值：布尔值

     ​	true：文件/文件夹删除成功，返回true

     ​	false：文件夹中有内容，不会删除，返回false；构造方法中给出的路径不存在，返回false。

     【注意】：

     ​	delete方法是直接在硬盘删除文件/文件夹，不走回收站，删除需谨慎！！!

  3. `public boolean mkdir()`：创建由此File表示的目录。

     创建单级文件夹。

  4. `public boolean mkdirs()`：创建由此File表示的目录，包括任何必须但不存在的父目录。

     既可以创建单级文件夹，也可以创建多级文件夹。

     创建文件夹的路径和名称在构造方法中给出（构造方法的参数）。

     返回值：布尔值

     ​	true：文件夹不存在，创建文件，返回true

     ​	false：文件夹存在，不会创建，返回false；构造方法中给出的路径不存在，返回false。

- File类【遍历目录功能】

  1. `public String[] list()`：返回一个String数组，表示该File目录中所有子文件或目录。

     遍历构造方法中给出的目录，会获取目录中所有文件/文件夹的名称，把获取到的多个名称存储到一个String类型的数组中。

     隐藏文件/文件夹也能获取到。

  2. `public File[] listFiles()`：返回一个File数组，表示该File目录中的所有的子文件或目录。

     遍历构造方法中给出的目录，会获取目录中所有文件/文件夹，把文件/文件夹封装为File对象，多个File对象存储到File数组中。

     【注意】：

     1. `list`方法和`listFiles`方法遍历的是构造方法中给出的目录。
     2. 如果构造方法中给出的目录的路径不存在，会抛出空指针异常。
     3. 如果构造方法中给出的路径不是一个目录，也会抛出空指针异常。

## 递归

- 相关基础

  - 递归：指在当前方法内调用自己的这种现象。

  - 分类：

    - 直接递归

      直接递归称为方法自身调用自己。

    - 间接递归

      间接递归可以A方法调用B方法，B方法调用C方法，C方法调用A方法。

  - 【注意事项】

    1. 递归一定要有条件限定，保证递归能够停下来，否咋会发生栈内存溢出。
    2. 在递归中虽然有限定条件，但是递归次数也不能太多，否咋也会发生栈内存溢出。
    3. **构造方法，禁止递归。**

  - 递归的【使用前提】：

    当调用方法的时候，方法的主体不变，每次调用方法的参数不同，可以使用递归。

## 过滤

在`File`类中，有两个`ListFiles`重载的方法，方法的参数传递的就是过滤器。

1. `File[] listFiles(FileFilter filter)`

   `java.io.FileFilter`接口：用于抽象路径名（`File`对象）的过滤器。

   【作用】:
   	用来过滤文件（`File`对象）。

   【抽象方法】：用来过滤文件的方法。

   ​	`boolean accept(File pathname)`测试指定抽象路径名是否应该包含在某个路径列表中。

   ​	参数：

   ​			`File pathname`：使用`ListFiles`方法遍历目录，得到的每一个文件对象。

2. `File[] listFiles(FilenameFilter filter)`

   `java.io.FilenameFilter`接口：实现此接口的类实例可用于过滤文件名。

   【作用】：

   ​	用于过滤文件名称。

   【抽象方法】：

   ​	`boolean accept(File dir,String name)`测试指定文件是否包含在某一文件列表中。

   ​	参数：

   ​		`File dir`：构造方法中传递的被遍历的目录。

   ​		`String name`：使用`ListFiles`方法遍历目录，获取的每一个文件/文件夹的名称。

3. 【注意】：
   两个过滤器接口是没有实现类的，需要自己写实现类，重写过滤的方法`accept`，在方法中自己定义过滤的规则。

## IO字节流

**顶级父类**

|        |             输入流             |             输出流              |
| :----: | :----------------------------: | :-----------------------------: |
| 字节流 | 字节输入流<br/>**InputStream** | 字节输出流<br/>**OutputStream** |
| 字符流 |   字符输入流<br/>**Reader**    |    字符输出流<br/>**Writer**    |

- 字节输出流【**`OutputStream`**】

  `java.io.OutputStream`：此抽象类是表示输出字节流的所有类的超类。

  - 定义了一些子类共性的成员方法：

    |                     名称                      |                           描述                           |
    | :-------------------------------------------: | :------------------------------------------------------: |
    |             `public void close()`             |      关闭此输出流并释放与此流相关联的任何系统资源。      |
    |             `public void flush()`             |       刷新此输出流并强制任何缓冲的输出字节被写出。       |
    |         `public void write(byte[] b)`         |      将`b.length`字节从指定的字节数组写入此输出流。      |
    | `public void write(byte[] b,int off,int len)` | 从指定的字节数组从偏移量off开始的len个字节写入此输出流。 |
    |      `public abstract void write(int b)`      |                将指定的字节写入此输出流。                |

  - 写入数据的原理（内存-->硬盘）

    **Java程序-->JVM（Java虚拟机）-->OS（操作系统）-->OS调用写数据的方法-->把数据写入到文件中。**

- 文件字节输出流【**`FileOutputStream`**】

  - 【作用】：


  ​		把内存中的数据写入到硬盘的文件中。

  - 【构造方法】：


  ​		`FileOutputStram(String name)`：创建一个向具有指定名称的文件中写入数据的文件输出流。

  ​		`FileOutputStream(File file)`：创建一个向指定`File`对象表示的文件中写入数据的文件输出流。

  ​		参数：

  ​				`String name`：目的地是一个文件的路径。

  ​				`File file`：目的地是一个文件。

  ​		构造方法的作用：

  ​				1.创建一个`FileOutputStream`对象。

  ​				2.会根据构造方法中传递的文件/文件路径，创建一个空的文件。

  ​				3.会把`FileOutputStream`对象指向创建号的文件。

  - 【字节输出流的==**使用步骤**==】：

    1. 创建一个`FileOutputStream`对象，构造方法中传递写入数据的目的地。
    2. 调用`FileOutputStream`对象中的方法`Write`，把数据写入到文件中。
    3. 释放资源。

- 一次【写入**多个字节**】

  1. `public void write(byte[] b)`

     【注意】：

     1. 如果写的第一个字节是整数（0-127），那么显示的时候会查询ASCII码表。
     2. 如果写的第一个字节是负数，那么第一个字节会和第二个字节，两个字节组成一个中文显示，查询系统默认码表（GBK）。

  2. `public void write(byte[] b,int off,int len)`

     把字节数组的一部分写入到文件中。

  3. 通过写入字符的方法：可以使用`String`类中的方法把字符串，转换为字节数组。

     `byte[] getBytes()`：把字符串转换为字节数组。

- 字节输出流的【**续写和换行**】

  - 追加写/续写：使用两个参数的构造方法。

    `FileOutputStream(String name,boolean append)`：创建一个向具有指定`name`的文件写入数据的输出文件流。

    `FileOutputStream(File file,boolean append)`：创建一个向指定`File`对象表示的文件中写入数据的文件输出流。

    【参数】：

    ​		`String name,File file`：写入数据的目的地

    ​		`boolean append`：追加写开关。`true`：创建对象不会覆盖原文件，继续在文件的末尾追加写数据；`false`：创建一个新文件，覆盖原文件。

  - 换行：写换行符号。

    1. `Windows`：`\r\n`
    2. `linux`：`/n`
    3. `mac`：`/r`

------

- 字节输入流【**`InputStream`**】

  `java.io.InputStream`：此抽象类是表示字节输入流的所有类的超类。

  |            名称             |                             描述                             |
  | :-------------------------: | :----------------------------------------------------------: |
  |    `public void close()`    |        关闭此输入流并释放与此流相关联的任何系统资源。        |
  |     `public int read()`     | 从输入流中读取数据的下一个字节。（**读取到文件的末尾返回-1**） |
  | `public int read(byte[] b)` | 从输入流中读取一定数量的字节，并将其存储在缓冲区数组`b`中。  |

  - 读取数据的原理（硬盘-->内存）

    **Java程序-->JVM（Java虚拟机）-->OS（操作系统）-->OS调用读取数据的方法-->读取文件。**

- 文件字节输入流【**`FileInputStream`**】

  - 【作用】:

  ​		把硬盘文件中的数据，读取到内存中使用。

  - 【构造方法】：

  ​		`FileInputStream(String name)`

  ​		`FileInputStream(File file)`

  ​		参数：读取文件的数据源。

  ​				`String name`：文件的路径。

  ​				`File file`：文件。

  - 【构造方法的作用】：

  ​		1.会创建一个`FileInputStream`对象。

  ​		2.会把`FileInputStream`对象指向构造方法中要读取的文件。

  - 【字节输入流的**==使用步骤==**】：
    1. 创建`FileInputStream`对象，构造方法中绑定要读取的数据源。
    2. 使用`FileInputStream`对象中的方法`read`，读取文件。
    3. 释放资源。

- 一次【读取**多个字节**】

  `int read(byte[] b)`

  参数：

  ​		`byte[]`：起到缓冲的作用，存储每次读取到的多个字节；数组的长度一般定义为1024（1kb）或者1024的整数倍。

  ​		方法的返回值`int`：每次读取的有效字节个数。

- **字节流读取文件时，遇到中文字符时，可能不能显示完整的字符，因为一个中文字符可能占用多个字节存储。**

## 字符流

- 字符输入流【**`Reader`**】

  `java.io.Reader`：字符输入流，是字符输入流的最顶层的父类，定义了一些共性的成员方法，是一个**抽象类**。

  - 定义了一些子类共性的成员方法：

    | 方法                    | 描述                                 |
    | :---------------------- | :----------------------------------- |
    | `int read()`            | 读取单个字符并返回。                 |
    | `int read(char[] cbuf)` | 一次读取多个字符，将字符读入数组。   |
    | `void close()`          | 关闭该流并释放与之相关联的所有资源。 |

- 文件字符输入流【**`FileReader`**】

  - 【作用】：

  ​		把硬盘文件中的数据以字符的方式读取到内存中。

  - 【构造方法】：

  ​		`FileReader(String filename)`

  ​		`FileReader(File file)`

  ​		参数：读取文件的数据源

  ​				`String filename`：文件的路径

  ​				`File file`：一个文件

  ​		构造方法的作用：

  ​				1.创建一个`FileReader`对象。

  ​				2.会把`FileReader`对象指向要读取的文件。

  - 字符输入流的【**==使用步骤==**】
    1. 创建`FileReader`对象，构造方法中绑定要读取的数据源。
    2. 使用`FileReader`对象中的方法`read`读取文件。
    3. 释放资源。

------

- ​	字符输出流【**`Writer`**】

  `java.io.Writer`：字符输出流，是所有字符输出流的最顶层的父类，是一个**抽象类**。

- 文件字符输出流【**`FileWriter`**】

  - 【作用】：

  ​		把内存中字符数据写入到文件中。

  - 【构造方法】：

  ​		`FileWriter(File file)`：根据给定的`File`对象构造一个`FileWriter`对象。

  ​		`FileWriter(String filename)`：根据给定的文件名构造一个`FileWriter`对象。

  ​		参数：写入数据的目的地。

  ​				`String filename`：文件的路径。

  ​				`File file`：是一个文件。

  ​		构造方法的作用：

  ​				1.会创建一个`FileWriter`对象。

  ​				2.会根据构造方法中传递的文件/文件的路径，创建文件。

  ​				3.会把`FileWriter`对象指向创建好的文件。

  - 【字符输出流的**==使用步骤==**】
    1. 创建`FileWriter`对象，构造方法中绑定要写入数据的目的地。
    2. 使用`FileWriter`对象中的方法`write`，把数据写入到**内存缓冲区**中（字符转换为字节的过程）。
    3. 使用`FileWriter`中的方法`flush`，把内存缓冲区中的数据，刷新到文件中。
    4. 释放资源（会先把内存缓冲区中的数据刷新到文件中）。

- `flush`方法和`close`方法

  1. `flush`方法：刷新缓冲区，流对象可以继续使用。
  2. `close`方法：先刷新缓冲区，然后通知系统释放资源。流对象不可以再被使用了。

- 字符输出流写数据的【**其他方法**】

  | 方法                                               | 描述                                                         |
  | -------------------------------------------------- | ------------------------------------------------------------ |
  | `void write(char[] cbuf)`                          | 写入字符数组。                                               |
  | `abstract void write(char[] cbuf,int off,int len)` | 写入字符数组的某一部分，off数组的开始索引，len写的字符长度。 |
  | `void write(String str)`                           | 写入字符串。                                                 |
  | `void write(String str,int off,int len)`           | 写入字符串的某一部分。                                       |

- 字符输出流的【**续写和换行**】

  - 续写：使用两个参数的构造方法。

    `FileWriter(String filename,boolean append)`

    `FileWrite(File file,boolean append)`

    参数：

    ​		`String filename,File file`：写入数据的目的地。

    ​		`boolean append`：续写开关。true：不会创建新的文件覆盖源文件，可以续写；false：创建新的文件覆盖源文件。

  - 换行：换行符合。

    `windows`：`\r\n`

    `linux`：`/n`

    `mac`：`/r`

- 流中【**异常处理**】

  1. JDK7的新特性

     在try的后边可以增加一个()，在()中定义流对象，那么这个流对象的作用域就在try中有效，try中的代码执行完毕，会自动把流对象释放，不用写finally。

     【格式】：

     ```java
     try(定义流对象;定义流对···){
     	可能会产生异常的代码
     }catch(异常类变量 变量名){
     	异常处理逻辑
     }
     ```

  2. JDK9的新特性

     try的前边可以定义流对象，在try后边的()中可以直接引入流对象的名称（变量名），在try代码执行完毕之后，流对象也可以被是方法掉，不要写finally。

     【格式】：

     ```java
     A a=new A();
     B b=new B();
     try(a,b){
         可能产生异常的代码
     }catch(异常类变量 变量名){
         异常处理逻辑
     }
     ```

## Properties集合

- 相关基础

  - `java.util.Properties集合 extends Hashtable<k,v> implements Map<k,v>`

  - `Properties` 类表示了一个持久的属性集。`Properties` 可保存在流中或从流中加载。

  - `Properties` 集合是一个唯一和`IO`流相结合的集合。

    - 可以使用`Properties` 集合中的方法`store`，把集合中的临时数据，持久化写入到硬盘中。
    - 可以使用`Properties` 集合中的方法`load`，把硬盘中保存的文件（键值对），读取到集合中使用。

  - 属性列表中每个键及其对应值都是一个字符串。 

    - `Properties` 集合是一个双列集合，**key和value默认都是字符串**。		

    - `Properties` 集合有一些操作字符串的特有方法：

      | 方法                                          | 描述                                                         |
      | :-------------------------------------------- | :----------------------------------------------------------- |
      | `Object setProperty(String key,String value)` | 调用`Hashtable`的方法`put`。                                 |
      | `String getProperty(String key)`              | 通过`key`找到`value`值，此方法相当于`Map`集合中的`get(key)`方法。 |
      | `Set<String> stringPropertyNames()`           | 返回此属性列表的键集，其中该键及其对应值是字符串，此方法相当于`Map`集合中的`keySet`方法。 |

- `Properties` 集合中的方法【**`store`方法**】

  可以使用`Properties` 集合中的方法`store`，把集合中的临时数据，持久化写入到硬盘中。

  `void store(OutputStream out,String comments)`

  `void store(Writer writer,String comments)`

  - 【参数】：
    - `OutputStream out`：字节输出流，不能写入中文。
    - `Writer writer`：字符输出流，可以写中文。
    - `String comments`：注释，用来解释说明保存的文件是做什么用的。不能使用中文，会产生乱码，默认是`Unicode`编码，一般使用“ ”空字符串。

  - 【使用步骤】：
    1. 创建`Properties` 集合对象，添加数据。
    2. 创建字节输出流/字符输出流对象，构造方法中绑定要输出的目的地。
    3. 使用`Properties` 集合中的方法`store`，把集合中的临时数据，持久化写入到硬盘中存储。
    4. 释放资源。

- `Properties` 集合中的方法【**`load`方法**】

  可以使用`Properties` 集合中的方法`load`，把硬盘中保存的文件（键值对），读取到集合中使用。

  `void load(InputStream inStream)`

  `void load(Reader reader)`

  - 【参数】：
    - `InputStream inStream`：字节输入流，不能读取含有中文的键值对。
    - `Reader reader`：字符输入流，能读取含有中文的键值对。
  - 【使用步骤】：
    1. 创建`Properties` 集合对象。
    2. 使用`Properties` 集合对象中的方法`load`，读取保存键值对的文件。
    3. 遍历`Properties` 集合。
  - 【注意】：
    1. 存储键值对的文件中，键与值默认的连接符号可以使用=，空格（其他符号）。
    2. 存储键值对的文件中，可以使用#进行注释，被注释的键值对不会再被读取。
    3. 存储键值对的文件中，键与值默认都是字符串，不用再加引号。

## 缓冲流

-  概述

  缓冲流，也叫高效流，是对4个基本的`FileXxx`流的增强。按照数据类型分为：

  - 字节缓冲流：`BufferedInputStream`，`BuffererOutputStream`
  - 字符缓冲流：`BufferedReader`，`BufferedWriter`

  缓冲流的基本原理，是在创建流对象时，会创建一个内置的默认大小的缓冲区数组，通过缓冲区读写，减少系统IO次数，从而提高读写效率。

- 字节缓冲输出流【**`BufferedOutputStream`**】

  `java.io.BufferedOutputStream extends OutputStream`

  `BufferedOutputStream`：字节缓冲输出流。

  - 继承自父类的共性成员方法：

    |                     名称                      |                           描述                           |
    | :-------------------------------------------: | :------------------------------------------------------: |
    |             `public void close()`             |      关闭此输出流并释放与此流相关联的任何系统资源。      |
    |             `public void flush()`             |       刷新此输出流并强制任何缓冲的输出字节被写出。       |
    |         `public void write(byte[] b)`         |      将`b.length`字节从指定的字节数组写入此输出流。      |
    | `public void write(byte[] b,int off,int len)` | 从指定的字节数组从偏移量off开始的len个字节写入此输出流。 |
    |      `public abstract void write(int b)`      |                将指定的字节写入此输出流。                |

  - 【构造方法】：

    `BufferedOutputStream(OutputStream out)`：创建一个新的缓冲输出流，以将数据写入指定的底层输出流。

    `BufferedOutputStream(OutputStream out,int size)`：创建一个新的缓冲输出流，以将具有指定缓冲区大小的数据写入指定的底层输出流。

    - 参数：

      `OutputStream out`：字节输出流。

      ​		我们可以传递`FileOutputStream`，缓冲流会给`FileOutputStream`增加一个缓冲区，提高`FileOutputStream`的写入效率。

      `int size`：指定缓冲流内部缓冲区的大小，不指定默认。

  - 【==**使用步骤**==】：

    1. 创建`FileOutputStream`对象，构造方法中绑定要输出的目的地。
    2. 创建`BufferedOutputStream`对象，构造方法中传递`FileOutputStream`对象，提高`FileOutputStream`对象效率。
    3. 使用`BufferedOutputStream`对象中的方法`write`，把数据写入内部缓冲区中。
    4. 使用`BufferedOutputStream`对象中的方法`flush`，把内部缓冲区中的数据，刷新到文件中。
    5. 释放资源（会先调用`flush`方法刷新数据，第4步可以省略）。

- 字节缓冲输入流【**`BufferedInputStream`**】

  `java.io.BufferedInputStream extends InputStream`

  `BufferedInputStream`：字节缓冲输入流。

  - 继承自父类的共性成员方法：

    |            名称             |                             描述                             |
    | :-------------------------: | :----------------------------------------------------------: |
    |    `public void close()`    |        关闭此输入流并释放与此流相关联的任何系统资源。        |
    |     `public int read()`     | 从输入流中读取数据的下一个字节。（**读取到文件的末尾返回-1**） |
    | `public int read(byte[] b)` | 从输入流中读取一定数量的字节，并将其存储在缓冲区数组`b`中。  |

  - 【构造方法】：

    `BufferedInputStream(InputStream in)`：创建一个`BufferedInputStream`并保存其参数，即输入流`in`，以便将来使用。

    `BufferedInputStream(InputStream in,int size)`：创建具有指定缓冲区大小的`BufferedInputStream`并保存其参数，即输入流`in`，以便将来使用。

    - 参数：

      `InputStream out`：字节输入流。

      ​		我们可以传递`FileInputStream`，缓冲流会给`FileInputStream`增加一个缓冲区，提高`FileInputStream`的读取效率。

      `int size`：指定缓冲流内部缓冲区的大小，不指定默认。

  - 【==**使用步骤**==】：
    1. 创建`FileInputStream`对象，构造方法中绑定要读取的数据源。
    2. 创建`BufferedInputStream`对象，构造方法中传递`FileInputStream`对象，提高`FileInputStream`对象的读取效率。
    3. 使用`BufferedInputStream`对象中的方法`read`，读取文件。
    4. 释放资源。

-  字符缓冲输出流【**`BufferedWriter`**】

  `java.io.BufferedWriter extends Writer`

  `BufferedWriter`：字符缓冲输出流。

  - 【构造方法】：

    `BufferedWriter(Writer out)`：创建一个使用默认大小输出缓冲区的缓冲字符输出流。

    `BufferedWriter(Writer out,int sz)`：创建一个使用给定大小输出缓冲区的新缓冲字符输出流。

    - 参数：

      `Writer out`：字符输出流。

      ​		我们可以传递`FileWriter`，缓冲流会给`FileWriter`增加一个缓冲区，提高`FileWriter`的写入效率。

      `int sz`：指定缓冲区的大小，不写默认大小。		

  - 【该流**==特有的成员方法==**】：

    `void newLine()`：写入一个行分隔符。会根据不同的操作系统，获取不同的行分隔符。

  - 【**==使用步骤==**】：
    1. 创建字符缓冲输出流对象，构造方法中传递字符输出流。
    2. 调用字符缓冲输出流中的方法`write`，把数据写入到内存缓冲区中。
    3. 调用字符缓冲输出流中的方法`flush`，把内存缓冲区中的数据，刷新到文件中。
    4. 释放资源。

- 字符缓冲输入流【**`BufferedReader`**】

  - 【构造方法】：

    `BufferedReader(Reader in)`：创建一个使用默认大小输入缓冲区的缓冲字符输入流。

    `BufferedReader(Reader in,int sz)`：创建一个使用指定大小输入缓冲区的缓冲字符输入流。

    - 参数：

      `Reader in`：字符输入流。

      ​		我们可以传递`FileReader`，缓冲流会给`FileReader`增加一个缓冲区，提高`FileReader`的读取效率。

  - 【该流**==特有的成员方法==**】：

    `String readLine()`：读取一个文本行。读取一行数据。

    ​		行的终止符号：通过下列字符之一即可认为某行已终止：换行 `('\n')`、回车 `('\r')` 或回车后直接跟着换行。 

    ​		返回值：包含该行内容的字符串，不包含任何行终止符，如果已到达流末尾，则返回 `null`。

  - 【**==使用步骤==**】：
    1. 创建字符缓冲输入流对象，构造方法中传递字符输入流。
    2. 使用字符缓冲输入流对象中的方法`read/readLine`读取文本。
    3. 释放资源。

## 转换流

- 【字符编码】和【字符集】

  1. 字符编码

     就是一套自然语言的字符与二进制数之间的对应规则。

  2. 字符集

     也叫编码表。是一个系统支持的所有字符的集合，包括各个国家文字、标点符号、图形符号、数字等。

     - `ASCII`字符集。
     - `ISO-8859-1`字符集：拉丁码表，使用单字节编码，兼容`ASCII`编码。
     - `GBxxx`字符集：中文码表。（`GB2312`、`GBK`、`GB8030`）
     - `Unicode`字符集：万国码。

- `OutputStreamWriter`

  `java.io.OutputStreamWriter extends Writer`

  `OutputStreamWriter`**是字符流通向字节流的桥梁**：可使用指定的  `charset`将要写入流中的字符**编码**成字节。

  - 【构造方法】：

    `OutputStreamWriter(OutputStream out)`创建使用默认字符编码的 `OutputStreamWriter`。

    `OutputStreamWriter(OutputStream out,String charsetName)`创建使用指定字符集的 `OutputStreamWriter`。

    - 参数：

      `OutputStream out`：字节输出流，可以用来写转换之后的字节到文件中。

      `String charsetName`：指定的编码表名称，不区分大小写，可以是`utf-8/UTF-8,gbk.GBK,···`，不指定默认使用`utf-8`。

  - 【**==使用步骤==**】：
    1. 创建`OutputStreamWriter`对象，构造方法中传递字节输出流和指定的编码表名称。
    2. 使用`OutputStreamWriter`对象中的方法`writer`，把字符转换为字节存储缓冲区中（编码）。
    3. 使用`OutputStreamWriter`对象中的方法`flush`，把内存缓冲区中的字节刷新到文件中（使用字节流写字节的过程）。
    4. 释放资源。

- `InputStreamReader`

  `java.io.InputStreamReader extends Reader`

  `InputStreamReader`**是字节流通向字符流的桥梁**：它使用指定的`charset`读取字节并将其**解码**为字符。

  - 【构造函数】：

    `InputStreamReader(InputStream in)`创建一个使用默认字符集的`InputStreamReader`。

    `InputStreamReader(InputStream in,String charsetName)`创建使用指定字符集的`InputStreamReader`。

    - 参数：

      `InputStream in`：字节输入流，用来读取文件中保存的字节。

      `String charsetName`：指定的编码表名称。

  - 【**==使用步骤==**】：

    1. 创建`InputStreamReader`对象，构造方法中传递字节输入流和指定的编码表名称。
    2. 使用`InputStreamReader`对象中的方法`read`读取文件。
    3. 释放资源。

    【注意事项】：

    ​	构造方法中指定的编码表名称要和文件的编码相同，否则会发生乱码。

## 序列化流

- 概述

  1. 序列化：

     把对象以流的方式，写入到文件中保存，叫写对象，也叫对象的序列化。

     `ObjectOutputStream`：对象的序列化流。

  2. 反序列化：

     把文件中保存的对象，以流的方式读取出来，叫读对象，也叫对象的反序列化。

     `ObjectInputStream`：对象的反序列化流。

- 对象的序列化流【**`ObjectOutputStream`**】

  `java.io.ObjectOutputStream extends OutputStream`

  `ObjectOutputStream`：对象的序列化流

  作用：把对象以流的方式写入到文件中保存。

  - 【构造方法】：

    `ObjectOutputStream(OutputStream out)`创建写入指定 `OutputStream` 的 `ObjectOutputStream`。

    - 参数：

      `OutputStream out`：字节输出流。

  - 【特有的成员方法】：

    `void writeObject(Object obj)`：将指定的对象写入`ObjectOutputStream`。

  - 【**==使用步骤==**】：

    1. 创建`ObjectOutputStream`对象，构造方法中传递字节输出流。
    2. 使用`ObjectOutputStream`对象中的方法`writeObject`，把对象写入文件中。
    3. 释放资源。

-  `Serializable`

  - 类通过实现 `java.io.Serializable` 接口以启用其序列化功能。未实现此接口的类将无法使其任何状态序列化或反序列化。

  -  `Serializable`接口也叫标记型接口。

    要进行序列化和反序列化的类必须实现 `Serializable`接口，就会给类添加一个标记。

    当我们进行序列化和反序列化的时候，就会检测类上是否有这个标记。

    ​		有：就可以进行序列化和反序列化。

    ​		没有：就会抛出`NotSerializableException`异常。

- 对象的反序列化流【**`ObjectInputStream`**】

  `java.io.ObjectInputStream extends InputStream`

  `ObjecInputStream`：对象的反序列化流

  作用：把文件中保存的对象，以流的方式读取出来使用。

  - 【构造方法】：

    `ObjectInputStream(InputStream in)` 创建从指定 `InputStream` 读取的 `ObjectInputStream`。

    - 参数：

      `InputStream in`：字节输入流。

  - 【特有的成员方法】：

    `Object readObject()`从`ObjectInputStream`读取对象。

  - 【**==使用步骤==**】：
    1. 创建`ObjectInputStream`对象，构造方法中传递字节输入流。
    2. 使用`ObjectInputStream`对象中的方法`readObject`读取保存对象的文件。
    3. 释放资源。
    4. 使用读取出来的对象。

  - 反序列化的【前提】
    1. 类必须实现 `Serializable`。
    2. 必须存在类对应的`class`文件，否则抛出`ClassNotFoundException`异常。

- `transient`关键字（瞬态关键字）

  被`transient`修饰的成员变量，不能够被序列化。

- `InvalidClassException`异常

  序列化运行时使用一个称为 `serialVersionUID`  的版本号与每个可序列化类相关联，该序列号在反序列化过程中用于验证序列化对象的发送者和接收者是否为该对象加载了与序列化兼容的类。如果接收者加载的该对象的类的 serialVersionUID  与对应的发送者的类的版本号不同，则反序列化将会导致`InvalidClassException`。

## 打印流

- `PrintStream`打印流

  `java.io.PrintStrean`

  `PrintStream` 为其他输出流添加了功能，使它们能够方便地打印各种数据值表示形式。

  - 【特点】：

    1. 只负责数据的输出，不负责数据的读取。

    2. 与其他输出流不同，`PrintStream` 永远不会抛出 `IOException`。

    3. 有特有的方法，`print`，`println`。

       `void print(任意类型的值)`

       `void println(任意类型的值并换行)`

  - 【构造方法】：

    `PrintStream(File file)`输出目的地是一个文件。

    `PrintStream(OutputStream out)`输出目的地是一个字节输出流。

    `PrintStream(String fileName)`输出目的地是一个文件路径。

  - 【注意】：
    1. 如果使用继承自父类的`write`方法写数据，那么查看数据的时候会查询编码表。97->a
    2. 如果使用自己特有的方法`print/println`方法写数据，写的数据原样输出。97->97

- 使用`System.setOut`方法可以改变输出语句的目的地，改为参数中传递的打印流的目的地。