# Java Scanner类

- `System.out.println()`将输出打印到“标准输出流”中。

- 读取“标准输入流”：首先，构造一个与“标准输入流”`System.in`关联的`Scanner`对象。

  `Scanner in=new Scanner(System.in); `

| 方法                      | 作用                                           |
| ------------------------- | ---------------------------------------------- |
| `String next()`           | 读取一个单词（以空白符作为分隔符）。           |
| `String nextLine()`       | 读取一行输入，包括空格。                       |
| `Int nextInt()`           | 读取一个整数。                                 |
| `Double nextDouble()`     | 读取并转换下一个表示整数或浮点数的字符序列。   |
| `boolean hasNext()`       | 检查输入中是否还有其它单词。                   |
| `boolean hasNextInt()`    |                                                |
| `boolean hasNextDouble()` | 检查是否还有下一个表示整数或浮点数的字符序列。 |

# 待解决问题

- [ ] 还有些逻辑问题
- [ ] 在`case`语句后用`input.nextLine()`输入结果不正确，但是用`input.next()`输入正确。为什么？
- [ ] 

