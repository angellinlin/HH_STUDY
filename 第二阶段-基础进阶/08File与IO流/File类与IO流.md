#### File类与IO流

1. File类

   - 用于文件和目录的创建、删除和查找等操作
   
   - 绝对路径：以盘符开始的路径
   
   - 相对路径：如果使用当前项目的根目录，路径可以简化，项目的根目录可以省略
   
   - 注意：路径是不区分大小写的，名称分隔符使用两个反斜杠
   
   - 构造方法
   
     ```java
     File file = new File("C:"+File.separator+"Users"+File.separator+"BBJ"+File.separator+"Desktop");
         }//路径可以是存在的也可以是不存在的
     //父子路径的方法
     new File(String parent,String child);
     //第三种
     new File(File parent,String child);
     new file2(file,"aa.txt");
     
     ```
   
   - 获取功能的方法
   
     ```java
     System.out.println(file);//C:\Users\BBJ\Desktop\jiujiu.txt
     System.out.println(file.getName());//jiujiu.txt
     System.out.println(file.length());//0，路径不存在，返回0 
     System.out.println(file.getAbsolutePath());//C:\Users\BBJ\Desktop\jiujiu.txt.绝对路径
     System.out.println(file.getPath());//C:\Users\BBJ\Desktop\jiujiu.txt
     
     ```
   
   - 判断功能的方法
   
     ```java
     System.out.println(file.exists());//判断这个目录存不存在
     System.out.println(file.isDirectory());//判断这是不是目录,路径必须存在，不然就是false
     System.out.println(file.isFile());//判断这是不是文件，路径必须存在，不然就是false
     ```
   
   - 创建和删除文件的方法
   
     ```java
     //创建文件：
             File file1 = new File("C:"+File.separator+"Users"+
                     File.separator+"BBJ"+File.separator+"Desktop"+
                     File.separator+"嘿嘿.txt");
             //只能创建文件不能创建文件夹，路径必须存在否则会抛出异常
             boolean b = file1.createNewFile();//处理异常,抛出IO异常
             System.out.println(b);
     //删除：
             boolean delete = file1.delete();//删除
             System.out.println(delete);
     //创建单级文件夹
             boolean aaa = new File("aaa").mkdir();
             System.out.println(aaa);
     //创建单级或多级文件夹
             File file2 = new File("C:"+File.separator+"Users"+
                     File.separator+"BBJ"+File.separator+"Desktop"+
                     File.separator+"aaa");
             file2.mkdirs();
     
     ```
   
   - 目录的遍历功能
   
     list():返回一个string数组
   
     listFiles()：返回一个File数组
   
2. 递归

   - 一定要有条件限定使其能够停下来，次数也必须做限制，否则会栈溢出
- 构造方法禁止递归
   - filefilter文件过滤器，创建实现类，重写accept方法定义过滤规则

3. **IO流**

   - input 读取；output 写入

     ![io流内存图](D:\HH_STUDY-test\基础知识加强版\08File与IO流\File类与IO流.assets\io流内存图.PNG)

   - 字节流（InputStream；OutputStream(所有**输出字节流的父类，是一个抽象类**））

     - FileOutputStream（文件字节输出流）：把内存的数据写入文件中。其中的构造方法能够创建一个流对象，根据文件路径创建一个空的文件，同时将流对象指向创建好的文件

     - **字节输出流**的使用步骤：

       **1）创建一个输出流对象，构造方法中传递写入数据的目的地**

       **2）调用对象方法中的write方法，把数据写入到文件中**

       **3）释放资源**（使用流的时候会占内存）

       ```java
       FileOutputStream fos = new FileOutputStream("baobaojiu.txt");//在项目下创建的
       fos.write(97);//写在文本编辑器中时，会转换为字符表示，0-127会查询ASCII码表
       fos.close();
       ```

     - 一次写多个字节(可以写一个字节数组，也可以写字节数组的一部分)

       ```java
       FileOutputStream fos = new FileOutputStream("baobaojiu.txt");//在项目下创建的
       byte[] bytes = new byte[]{65,67,68,69,70};
       fos.write(bytes);
       fos.close();
       ```

     - **写入字符串的方法（把字符串转化为字节数组，再调用这个方法写）**

       ```java
       String name = "goudan";
       byte[] bytes1 = name.getBytes();//转化为字节数组
       fos.write(bytes1);//utf-8三个字节一个中文，gdk中两个字节是一个中文
       ```

     - 续写（前面的是直接覆盖）：使用两个参数的构造方法

       ```java
       FileOutputStream fos = new FileOutputStream("baobaojiu.txt",true);//在项目下创建的
       ```

     - 换行：windows(\r\n)  linux(/n)  mac(/r)

       ```java
       String name = "goudan";
       byte[] bytes1 = name.getBytes();
       fos.write(bytes1);
       fos.write("\r\n".getBytes());
       ```

     - **字节输入流（inputstream->FileInputStream)**

     - **read()方法：**从输入流中读取数据的下一个字节

     - **read（byte[] b）从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中**

     - 输入流的使用步骤

       **1）创建一个输入流对象，构造方法中传递读取的数据源**

       **2）调用对象方法中的read方法，把数据读取到内存中**

       **3）释放资源**（使用流的时候会占内存）

       ```java
       int le = 0;//记录读取的字节
       while ((le = fis.read())!=-1){
       	System.out.println(le);
         }
       ```

     - 一次读取多个字节

       ```java
       byte[] b = new byte[2];
       int read = fis.read(b);
       System.out.println(Arrays.toString(b));
       System.out.println(new String(b));
       //使用while进行优化
       byte[] bytes = new byte[1024];
       int len = 0;
       while ((len = (fis.read(bytes)))!=-1){
            System.out.println(new String(bytes,0,len));//只转有效的
         }
       ```

     - 复制文件

       ```java
       public class TestCopy {
           public static void main(String[] args) throws IOException {
               //读
               FileInputStream fis = new FileInputStream("baobaojiu.txt");
               FileOutputStream fos = new FileOutputStream("ningning.txt");
               byte[] bytes = new byte[1024];
               int len = 0;
               while ((len=fis.read(bytes))!=-1){
                   fos.write(bytes,0,len);//边读边写
               }
               fos.close();
               fis.close();
           }
       }
       ```

   - 字符流

     - 字节流读中文的时候，中文显示乱码（一次只能读取三分之一个字）所以要采用字符流

     - **字符输入流Reader**(字符输入流的顶尖父类，从文件中读取，同样是抽象类)

       ```java
       public class TestReader {
           public static void main(String[] args) throws IOException {
               FileReader fr = new FileReader("baobaojiu.txt");
               char[] chars = new char[1024];
               int len = 0;//放读取的有效个数
               while ((len=fr.read(chars))!=-1){
                   System.out.println(new String(chars,0,len));
               }
               fr.close();
           }
       }
       ```

     - 字符输出流(**需要用flush从缓冲区刷新到文件中**)

       ```java
       String name = "ergouzi";
       char[] chars1 = name.toCharArray();
       FileWriter fw = new FileWriter("baobaojiu.txt");//写字符
       fw.write(chars1);
       
       String nihaoma = "nihaoma";
       fw.write(nihaoma);//写字符串
       fw.flush();//flush和close的区别是，close刷新并关闭流无法使用了；前者还可以继续使用
       ```

     - 续写

       ```java
       FileWriter fw = new FileWriter("baobaojiu.txt",true);
       ```

     - 换行，和前面字节流一样

   - **异常处理用try...catch（把关闭资源的代码放在finally中，无论如何都需要释放）可以在try后面的括号里面定义流对象，就可以自动释放，不用写finally了**

4. Propertities

   - 唯一和IO流结合的集合，可以保存在流中或者在流中加载，继承了Hashtable
   - 使用store（）方法把集合中的临时数据，持久化写入到硬盘中储存
   - load方法，把硬盘中保存的文件，读取到集合中使用
   - **注意用store的时候，字节流不能写中文，字符流可以写中文**
   - 存储键值对的文件中，默认键值对连接符号可以使用=。空格
   - 可以使用#对键值对进行注释，注释后不会再被读取
5. **缓冲流**（增强基本流）

   - 字节缓冲流：BufferedOutputStream,BufferedIutputStream，有继承自父类的方法

     - 字节输出缓冲流使用步骤：1）创建FileOutputStream，绑定输出地；2）创建BufferedOutputStream对象，构造方法中传入前面的那个输出流对象，提高效率；3）使用方法写数据到缓冲区；4）使用flush方法刷新到文件中；5）关资源

       ```java
       FileOutputStream fos = new FileOutputStream("baobaojiu.txt");//不续写
       BufferedOutputStream bos = new BufferedOutputStream(fos);
       byte[] bytes = new byte[]{65,66,67,68};
       bos.write(bytes);
       bos.close();
       fos.close();
       ```

     - 字节读取缓冲流

       ```java
       FileInputStream fis = new FileInputStream("baobaojiu.txt");
       BufferedInputStream bis = new BufferedInputStream(fis);
       byte[] b = new byte[1024];
       int len = 0;
       while((len = bis.read(b))!=-1){
          System.out.println(new String(b,0,len));
         }
       ```

   -  字符缓冲输出流BufferedWriter

       ```java
       public class TestBufferedWriter {
           public static void main(String[] args) throws IOException {
               BufferedWriter bw = new BufferedWriter(new FileWriter("baobaojiu.txt"));
               for (int i = 0; i <10 ; i++) {
                   bw.write("heihei");
                   bw.newLine();//分行
               }
       
               bw.close();
           }
       }
       ```

     - 字符缓冲输入流

       ```java
       String line;
       while ((line = br.readLine())!=null){
            System.out.println(line);
         }
       ```

6. 转换流

   - InputStreamReader

   - OutputStreamWriter

     ```java
     OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("baobaojiu.txt"),"utf-8");
     osw.write("你好");
     osw.close();
     ```

7. 序列化

   - 把对象以流的方式写入到文件中保存，叫做对象的序列化；对象中包含的不仅仅是字符，应该使用字节流（ObjectOutputStream对象的序列化流)

     ```java
     Object p1 = new Person("迪丽热巴",18);
             ObjectOutputStream oos;
             oos = new ObjectOutputStream(new FileOutputStream("baobaojiu.txt",true));
             oos.writeObject(p1);
             oos.close();//Person实现了Serializable接口
     ```
     
   - 把文件中保存的对象以流的方式读出来，叫做反序列化（（ObjectInputStream对象的反序列化流)）

     ```java
     ObjectInputStream ois = new ObjectInputStream(new FileInputStream("baobaojiu.txt"));
     Object o = ois.readObject();
     ois.close();
     ```
     
   - **重要：当要对某个类的对象进行序列化的时候，必须实现Serializable接口，启用序列化，否则会抛出异常**

   - 被static关键字修饰的变量是不可以被序列化的

   - 被transient修饰的成员变量也不会被序列化

   - **给类加一个序列化的序号**

8. 打印流 PrintStream
