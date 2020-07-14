### AOP编程

---

#### 第一章、静态代理设计模式

##### 1. 为什么需要代理设计模式

###### 1.1 问题

- 在JavaEE分层开发开发中，哪个层次对于我们来讲最重要

  ~~~markdown
  DAO ---> Service --> Controller 
  
  JavaEE分层开发中，最为重要的是Service层
  ~~~

- Service层中包含了哪些代码？

  ~~~markdown
  Service层中 = 核心功能(几十行 上百代码) + 额外功能(附加功能)
  1. 核心功能
     业务运算
     DAO调用
  2. 额外功能 
     1. 不属于业务
     2. 可有可无
     3. 代码量很小 
     
     事务、日志、性能...
     
  ~~~

- 额外功能书写在Service层中好不好？

  ~~~markdown
  Service层的调用者的角度（Controller):需要在Service层书写额外功能。
                           软件设计者：Service层不需要额外功能
                           
  ~~~

- 现实生活中的解决方式

  ![](https://i.loli.net/2020/07/14/GdUhjlfVgLOz4xJ.png)

##### 2. 代理设计模式

###### 1.1 概念

~~~markdown
通过代理类，为原始类（目标）增加额外的功能
好处：利于原始类(目标)的维护
~~~

###### 1.2名词解释

~~~markdown
1. 目标类 原始类 
   指的是 业务类 (核心功能 --> 业务运算 DAO调用)
2. 目标方法，原始方法
   目标类(原始类)中的方法 就是目标方法(原始方法)
3. 额外功能 (附加功能)
   日志，事务，性能
~~~

###### 1.3 代理开发的核心要素

~~~markdown
代理类 = 目标类(原始类) + 额外功能 + 原始类(目标类)实现相同的接口

房东 ---> public interface UserService{
               m1
               m2
          }
          UserServiceImpl implements UserService{
               m1 ---> 业务运算 DAO调用
               m2 
          }
          UserServiceProxy implements UserService
               m1
               m2
~~~

###### 1.4 编码

**静态代理**：为每一个原始类，手工编写一个代理类 (.java .class)

![](https://i.loli.net/2020/07/14/OWItqdR5NHjJelG.png)

###### 1.5 静态代理存在的问题

~~~markdown
1. 静态类文件数量过多，不利于项目管理
   UserServiceImpl  UserServiceProxy
   OrderServiceImpl OrderServiceProxy
2. 额外功能维护性差
   代理类中 额外功能修改复杂(麻烦)
~~~



#### 第二章、Spring的动态代理开发

##### 1. Spring动态代理的概念

~~~markdown
概念：通过代理类为原始类(目标类)增加额外功能
好处：利于原始类(目标类)的维护
~~~

##### 2. 搭建开发环境

~~~xml
<dependency>
  <groupId>org.springframework</groupId>
  <artifactId>spring-aop</artifactId>
  <version>5.1.14.RELEASE</version>
</dependency>

<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjrt</artifactId>
  <version>1.8.8</version>
</dependency>

<dependency>
  <groupId>org.aspectj</groupId>
  <artifactId>aspectjweaver</artifactId>
  <version>1.8.3</version>
</dependency>
~~~

##### 3. Spring动态代理的开发步骤

1. 创建原始对象(目标对象)

   ~~~java
   public class UserServiceImpl implements UserService {
       @Override
       public void register(User user) {
           System.out.println("UserServiceImpl.register 业务运算 + DAO ");
       }
   
       @Override
       public boolean login(String name, String password) {
           System.out.println("UserServiceImpl.login");
           return true;
       }
   }
   
   ~~~

   ~~~xml
   <bean id="userService" class="com.baizhiedu.proxy.UserServiceImpl"/>
   ~~~

2. 额外功能
   **MethodBeforeAdvice接口**

   ~~~xml
   额外的功能书写在接口的实现类中，即运行在原始方法执行之前运行额外功能。
   ~~~

   ~~~java
   public class Before implements MethodBeforeAdvice {
       /*
         作用：需要把运行在原始方法执行之前运行的额外功能，书写在before方法中
        */
       @Override
       public void before(Method method, Object[] args, Object target) throws Throwable {
           System.out.println("-----method before advice log------");
       }
   }
   ~~~

   ~~~xml
   <bean id="before" class="com.baizhiedu.dynamic.Before"/>
   ~~~

3. 定义切入点

   ~~~xml
   切入点：额外功能加入的位置
   
   目的：由程序员根据自己的需要，决定额外功能加入给那个原始方法
   register
   login
   
   简单的测试：所有方法都做为切入点，都加入额外的功能。
   ~~~

   ~~~xml
   <aop:config>
      <aop:pointcut id="pc" expression="execution(* *(..))"/>
   </aop:config>
   ~~~

4. 组装 (2 3整合)

   ~~~xml
   表达的含义：所有的方法 都加入 before的额外功能
   <aop:advisor advice-ref="before" pointcut-ref="pc"/>
   ~~~

5. 调用

   ~~~java
   目的：获得Spring工厂创建的动态代理对象，并进行调用
   ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
   注意：
      1. Spring的工厂通过原始对象的id值获得的是代理对象
      2. 获得代理对象后，可以通过声明接口类型，进行对象的存储
      
   UserService userService=(UserService)ctx.getBean("userService");
   
   userService.login("")
   userService.register()
   ~~~

##### 4. 动态代理细节分析

1. Spring创建的动态代理类在哪里？

   ~~~markdown
   Spring框架在运行时，通过动态字节码技术，在JVM创建的，运行在JVM内部，等程序结束后，会和JVM一起消失
   
   什么叫动态字节码技术:通过第三个动态字节码框架，在JVM中创建对应类的字节码，进而创建对象，当虚拟机结束，动态字节码跟着消失。
   
   结论：动态代理不需要定义类文件，都是JVM运行过程中动态创建的，所以不会造成静态代理，类文件数量过多，影响项目管理的问题。
   ~~~

![](https://kaorou-img.oss-cn-chengdu.aliyuncs.com/img/image-29.png)

 2. 动态代理编程简化代理的开发

      ~~~markdown
      在额外功能不改变的前提下，创建其他目标类（原始类）的代理对象时，只需要指定原始(目标)对象即可。
      ~~~

   3. 动态代理额外功能的维护性大大增强

      ```markdown
      需要修改增强功能时直接修改增强类即可，核心业务功能代码不会修改。
      ```

      

