# API

API(Application Programming Interface)，应用程序编程接口。

## Scanner类

- 功能：可以实现键盘输入数据，到程序中。

- **引用类型的一般使用步骤**：

  1. 导包

     `import 包路径.类名称；`

     如果需要使用的目标类，和当前类位于同一个包下，则可以省略导包语句不写。

     只有**`java.lang`包**下的内容不需要导包，其他的包都需要`import`语句。

  2. 创建

     `类名称 对象名=new 类名称()；`

  3. 使用

     `对象名.成员方法名()；`

- `Scanner input=new Scanner(System.in);   // System.in代表从键盘进行输入`

## 匿名对象

- 创建对象的标准格式：`类名称 对象名=new 类名称()；`

- 匿名对象就是只有右边的对象，没有左边的名字和赋值运算符。

  `new 类名称()；`

- 匿名对象只能使用唯一一次，下次使用需要重新创建一个新对象。
- 使用建议：确定一个对象只需要使用唯一一次，就可以使用匿名对象。

## Random类

| 方法                 | 描述                                                    |
| -------------------- | ------------------------------------------------------- |
| `nextInt()`          | 随机生成一个int类型值，取值范围为int的取值范围          |
| `nextInt(int bound)` | 生成一个0-bound范围类的随机数；**包含0，不包含bound值** |
| `nextLong()`         | 随机生成一个long取值区间内的数                          |
| `nextDouble()`       | 生成一个0-1范围内的doule值                              |
| `nextFloat()`        | 生成一个0-1范围内的浮点型数据                           |

## ArrayList类

- 对象数组：存储对象的数组。缺点是：一旦创建，程序运行期间长度不可以发生改变。

- **ArrayList集合**

  ArrayList长度是可以随时改变的。

  对于ArrayList来说，有一个尖括号**<E>代表泛型**。

  **泛型**：就是装在集合当中的所有元素，全部都是统一的某种类型。

  **泛型只能是引用类型**，不能是基本类型。

- 对于ArrayList集合来说，直接打印得到的**不是地址值，而是内容**。如果内容是空，则输出[]。

- 创建ArrayList：

  `ArrayList<String> list = new ArrayList<>();//创建一个存放String类型的ArrayList集合。`

- ArrayList当中的**常用方法**：

| 方法                         | 描述                                                         |
| ---------------------------- | ------------------------------------------------------------ |
| `public boolean add(E e)`    | 向集合中添加元素，参数的类型和泛型一致，返回值是添加是否成功 |
| `public E get(int index)`    | 从集合中获取元素，参数是索引编号(从0开始)，返回值就是对应位置的元素 |
| `public E remove(int index)` | 从集合当中删除元素，参数是索引编号，返回值就是被删除掉的元素 |
| `public int size()`          | 获取集合的尺寸长度，返回值是集合中包含的元素个数             |

- 向ArrayList集合当中存储基本数据类型，必须使用基本类型对应的"包装类"。

  基本类型			包装类（引用类型，包装类都位于java.lang包下）

  byte					Byte

  short				  Short

  int					   **Integer**

  long					Long

  float					Float

  double			    Double

  char					**Character**

  boolean			  Boolean

  自动装箱：基本类型-->包装类型

  自动拆箱：包装类型-->基本类型