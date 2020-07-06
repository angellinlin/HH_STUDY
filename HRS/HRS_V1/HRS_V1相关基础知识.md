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
- [x] 在`case`语句后用`input.nextLine()`输入结果不正确，但是用`input.next()`输入正确。为什么？

  - 其实是因为在`input.nextInt()`后使用了`input.nextLine()`。
  - `input.nextInt()`：在缓冲区遇到空白字符时，就会将空白字符前的数据读取走，但是空白字符未被处理，因此，随后的`input.nextLine()`读取到留在缓冲区中的回车符了，直接结束。
  - 解决方法:增加一行`input.nextLine()`吸收缓冲区中的空白字符。
- [ ] 

