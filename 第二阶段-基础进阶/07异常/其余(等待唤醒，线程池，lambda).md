#### 等待唤醒，线程池，lambda

1. 等待唤醒机制：多个线程在处理同一个资源，但是处理的线程任务却不同

   - 线程状态概述
   
     ![线程状态](D:\HH_STUDY-test\基础知识加强版\07异常\其余(等待唤醒，线程池，lambda).assets\线程状态.PNG)
   
   - **等待唤醒（只有同步对象才能调用），注意用wait唤醒之后会继续指向wait方法之后的代码**
   
   - **wait(可以传等待的时间)如果时间结束还没有被唤醒就自动醒来；notifyall（叫醒所有等待的线程）**；notify只能随机唤醒一个人
   
   - 等待唤醒机制（线程之间的通信）：见生产消费者程序
   
2. throw关键字

   - 可以在指定的方法中抛出指定的异常

   - 格式：throw new xxxException（"异常产生的原因"）

   - 注意：必须写在方法的内部，对线必须是异常或者异常的子类；如果是运行时异常可以交给虚拟机处理；如果是编译期异常，必须处理，要么throws，要么try...catch

   - ##### **工作中首先必须对方法传递过来的参数进行合法校验，如果不符合要求，必须进行异常处理！！！**

3. Objects类有一些静态方法，比如**查看指定引用对象是不是null**

   ```java
   public static void main(String[] args) {
           method(null);
       }
   
       public static void method(Object obj) {
   //        if (obj == null) {
   //          throw new NullPointerException("传递的对象是null");
   //      }
             Objects.requireNonNull(obj,"空");
       }
   ```

4. 声明异常Throws

   - 异常处理的第一种方式：会抛出给方法的调用者，自己不处理，最终给JVM中断处理，在方法声明时使用；

   - **如果调用了一个声明抛出异常的方法，就必须处理声明的异常，要么继续throws，要么try...catch自己处理**

     ```java
     public static void main(String[] args) throws FileNotFoundException {
             method("xxx");
         }
     
         public static void method(String Filename) throws FileNotFoundException {
             //编译期异常必须处理
             if(!Filename.equals("c:/a.txt"))
             throw new FileNotFoundException("传递的文件路径不正确");
     //        Objects.requireNonNull(obj,"空");
         }
     ```

5. try...catch捕获异常

   - 异常处理的第二种方式：自己处理异常；一个try后面可以有多个catch(多个异常)；执行完catch后可以继续执行（与throws不同）

   - 一个try后面可以有多个catch，catch里面定义的异常变量，如果有子父类关系，子类必须写在上面

     ```java
      public static void main(String[] args)  {
             try {
                 method("xxx");
             } catch (FileNotFoundException e) {
                 System.out.println("传递的文件后缀名不是.txt");
             }
             System.out.println("后续代码");
         }
     
         public static void method(String Filename) throws FileNotFoundException {
             if(!Filename.equals("c:/a.txt")) {
                 throw new FileNotFoundException("传递的文件路径不正确");
             }
     ```

6. throwable类定义的三个异常处理方法

   - getMessage() 返回此throwable的简短描述

     ```java
      try {
                 method("xxx");
             } catch (FileNotFoundException e) {
     			String message = e.getMessage();
                 System.out.println(message);
             }
     ```

   - toString() 返回此throwable的详细消息字符串

     ```java
             try {
                 method("xxx");
             } catch (FileNotFoundException e) {
                 String s = e.toString();
                 System.out.println(s);
             }
     ```

   - printStackTrace() JVM打印异常，信息最全面

7. Finally代码块

   - 必须和try代码块一起使用，无论是否出现异常都会实现，一般用于资源释放（IO流就需要）

8. 异常注意事项：

   - 如果finally有return语句，永远会返回这个结果，应该避免这种情况
   - 如果父类抛出多个异常，子类重写父类该方法时（父类异常什么样，子类就什么样）
   - 如果父类方法没有抛出异常，子类也不可以抛出，此时子类产生异常只能捕获处理不可以抛出

9. 自定义异常类：自己定义一个类继承Exception或者RuntimeException

10. 线程池

    - 一个容器，容纳很多线程，可以复用，降低创建新对象的次数，队列

    - 创建线程池，创建runnable接口，用submit调用

      ```java
      ExecutorService executorService =Executors.newFixedThreadPool(3); 		
      //创建三个接口实现Runnable接口，同时创建他们的实例
      PolsR1 ru1 = new PolsR1();
      PolsR2 ru2 = new PolsR2();
      plssR3 ru3 = new plssR3();
      //调用线程池实现三个run
      executorService.submit(ru1);
      executorService.submit(ru2);
      executorService.submit(ru3);//pool-1-thread-1线程1pool-1-thread-3线程pool-1-thread-3线程3pool-1-thread-3线程3pool-1-thread-2线程2
      ```

11. Lambda表达式

    - 创建线程

      ```java
              new Thread(()-> {
                  System.out.println("新创建了一个线程");
              }).start();
      ```

    - 标准格式（可推导可省略）:

      - (参数类型 参数名称) -> {代码语句}
      - 重写的那个方法的参数列表，比如上面那个没有参数就是空格
      - 重写接口的方法体

    - 省略：

      - 可以省略的内容：参数列表的数据类型，参数列表括号中的参数如果只有一个，那类型和括号都可以省略；代码如果只有一行，省略大括号和return；
      - 注意事项：要省略的话上述的东西必须一起省略。