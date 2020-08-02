# Spring

## 1.Spring是什么

* Spring是一个开源框架

* Spring为简化企业级应用开发而生。使用Spring可以使简单的JavaBean实现以前只有EJB才能实现的功能

* Spring是一个==IOC(DI)和AOP==容器框架

* 具体描述
  * 轻量级：Spring是非侵入性的，基于Spring开发的应用中的对象可以不依赖于Spring的API
  * 依赖注入(DI---dependency injection, IOC)
  * 面向切面编程(AOP---aspect)
  * 容器：Spring是一个容器，因为它包含并且管理应用对象的生命周期
  * 框架：Spring实现了使用简单的组件配置组合成一个复杂的应用。在spring中可以使用XML和Java注解组合这些对象
  * 一站式：在IOC和AOP的基础上可以整合各种企业应用的开源框架和优秀的的第三方类库(实际上Spring自身也提供了展现层的SpringMVC和持久层的Spring JDBC)
  * ![image-20200713210025047](E:\Code\Git\HH_STUDY\notes\Spring\image-20200713210025047.png)
  * 创建对象和给对象赋值可以使用Spring来完成，反射的方式
  
* ```java
  //1.创建Spring的IOC容器对象
  //在创建容器的时候会调用HelloWorldd的构造方法对对象初始化
  //并会调用setName方法
  ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");
  //2.从IOC容器中获取Bean实例
  //这里getBean中的值是根据配置文件中的id名决定的
  HelloWorld hw = (HelloWorld)ctx.getBean("helloWorld");
  //3.调用方法
  hw.hello()
  ```

* ```xml
  <bean id="helloworld" class="HelloWorld的全路径">
  	<property name="name" value="Spring"></property> // 设置name属性的值为Spring
  </bean>
  ```

## 2.IOC&DI

### 2.1 概述

* IOC：其思想是反转资源获取的方向。**传统的资源查找方式要求组件向容器发起请求查找资源**。作为回应，容器适时的返回资源。而应用了IOC之后，**则是容器主动将资源推送给它所管理的组件，组件所要做的仅是选择一种合适的方法来接收资源。**
* DI：IOC的另一种表述方式：**即组件以一些预定义好的方式(如setter方法)接收来自如容器的资源注入。**
* ![image-20200715164045006](E:\Code\Git\HH_STUDY\notes\Spring\image-20200715164045006.png)
* ![image-20200715164107268](E:\Code\Git\HH_STUDY\notes\Spring\image-20200715164107268.png)
* ![image-20200715164129901](E:\Code\Git\HH_STUDY\notes\Spring\image-20200715164129901.png)



## 3.配置Bean

### 3.1 配置形式

#### 3.1.1 配置形式

* **基于XML文件**的方式

  * 通过bean节点来配置bean

  * ```xml
    <!--通过全类名的方式来配置bean-->
    <bean id="helloworld" class="全类名"></bean>
    ```

  * id是Bean的名称，在IOC容器中必须**是唯一**的；若id没有指定，Spring自动将权限定性类名作为Bean的名字；id可以指定多个名字，名字之间可以用逗号、分号或空格分隔。

  * 通过**反射的方式在IOC容器中创建Bean，所以要求Bean中必须有无参数的构造器**

#### 3.1.2 **基于注解**的方式

* 基于注解配置Bean
* 基于注解来配置Bean的属性

### 3.2 Bean的配置方式

* **通过全类名(反射)**
* 通过工厂方法(静态工厂方法&实例工厂方法)
* FactoryBean

* IOC容器

  * **在SpringIOC容器读取Bean配置创建Bean实例之前，必须对它进行实例化。只有在容器实例化后，才可以从IOC容器里获取Bean实例并使用。**
  * 从IOC容器中获取Bean的实例，可以通过查看**BeanFactory的getBean()方法**，可以通过Id、类型（注意IOC容器中的类型唯一）等方式获取实例。
  * **BeanFactory：**IOC容器的基本实现，面向Spring本身
  * **ApplicationContext**：提供了更多的高级特性，是BeanFactory的子接口
    * ConfigurableApplicationContext扩展于ApplicationContext，新增两个方法refresh()和close()，让ApplicationContext具有启动、刷新和关闭上下文的能力。
    * **ClassPathXmlApplicationContext**：从类路径下加载配置文件
    * **FileSystemXmlApplicationContext**：从文件系统中加载配置文件
    * ApplicationContext在初始化上下文时就实例化所有单例的Bean
  * WebApplicationContext是专门为WEB应用而准备的，它允许从相对于WEB根目录的路径中完成初始化工作。
  * 几乎所有的场合都直接使用ApplicationContext而非底层的BeanFactory

### 3.3 依赖注入

* **属性注入**

  * 即**通过setter方法注意Bean的属性值或依赖的对象**

  * 属性注入**使用<property>元素，使用name属性指定Bean的属性名称，value属性或<value>子节点指定属性值**

  * 属性注入是实际应用中最常用的注入方式

  * ```xml
    <bead id="helloworld" class="全类名">
    	<property name="name" value="tom"></property>
    </bead>
    ```
  
* **构造器注入**

  * 通过构造方法注入Bean的属性值或依赖的对象，它保证了Bean实例在实例化后就可以使用

  * 构造器注入在<constructor-arg>元素里声明属性，**<constructor-arg>中没有name属性**

  * ```xml
    <bean id="helloworld" class="全类名">
    	<constructor-arg value="test" index=0 type="java.lang.String"></constructor-arg>
    </bean>
    ```

  * **使用<constructor-arg>标签时，可以使用index和type来区分构造器的参数列表进行传值**

* 工厂方法注入

* 泛型依赖注入

  * Spring4.0中可以为子类注入自类对应的泛型类型的成员变量的引用

### 3.4 注入细节

* 字面值

  * 可用字符串表示的值，可以通过<value>元素标签或value属性进行注入。

  * 基本数据类型及其封装类、String等类型都可以采取字面值注入的方式

  * 若字面值中包含特殊字符，可以使用<![CDATA[]]>把子面值包裹起来。

  * ```xml
    <bean id="car" class="全类名">
    	<constructor-arg value="Baoma" type="java.lang.String"></constructor-arg> <!-- name-->
        <constructor-arg type="int">
        	<value>250</value>
        </constructor-arg> <!-- 数量-->
    </bean>
    ```

  * ```xml
    <bean id="car" class="全类名">
    	<constructor-arg value="Baoma" type="java.lang.String"></constructor-arg> <!-- name-->
        <constructor-arg type="java.lang.String">
        	<value><![CDATA[<Shanghai>^]]></value>
        </constructor-arg> <!-- 生产地点 因为有特殊字符< > ^等，所以需要使用CDATA括起来--> 
    </bean>
    ```

* Bean之前的相互引用
  * 外部Bean：**写在<property>属性中，使用ref属性指向要引用的Bean的id，也可以使用<ref>元素进行引用**

  * ```xml
    <bean id="person" class="全类名">
    	<property name="name" value="Tom"></property>
        <property name="car" ref="car"></property> <!--给car属性指向id为car的bean-->
        <property name="car">
        	<ref bean="car"></ref><!--给car属性指向id为car的bean-->
        </property>
    </bean>
    ```

  * 内部Bean：也可以直接在内部写一个Bean

  * ```xml
    <bean id="person" class="全类名">
    	<property name="name" value="Tom"></property>
        <property name="car">
        	<bean class="全类名"> <!-- 内部Bean不能被外部使用，只能在内部使用，可以不加id属性-->
            	<constructor-arg value="Baoma" type="java.lang.String"></constructor-arg>
                ...
            </bean>
        </property>
    </bean>
    ```

* 注入参数详解：null值和级联属性

  * 可以使用**专用的<null/>元素标签为Bean的字符传串或其他对象类型的属性注入null值**

    * ```xml
      <constructor-arg><null/></constructor-arg>
      ```

  * 和Struts、Hiberante等框架一样，Spring支持级联属性的配置。

    * ```xml
      <constructor-arg ref="car"></constructor-arg>
      <property name="car.属性" value="属性值"></property>
      ```

    * 注意：属性需要初始化后才可以为级联属性赋值，否则会有异常，和Struts2不同

* 集合属性

  * 在Spring中可以通过一组内置的xml标签(如，<list>,<Set>或者<map>)来配置集合属性

  * ==配置java.util.list类型的属性，需要指定<list>标签，在标签里包含一些元素，这些标签可以通过<value>指定简单的常量值，通过<ref>指定对其他的Bean的引用。通过<bean>指定内置Bean定义，通过<null/>指定空元素。甚至内嵌其他集合==

  * 数组的定义和List一样，都使用<list>

  * 配置java.util.Set需要使用<set>标签，定义元素的方法与List一样。

  * ```xml
    <bean id="person" class="Person的全类名">
    	<property namne="name" value="Tom"></property><!--Person的name属性-->
        <property name="cars"> <!-- Person的cars属性,为list类型-->
        	<list>
            	<ref bean="car"></ref>
                <ref bean="car2"></ref>
            </list>
        </property>
    </bean>
    ```

  * Java.util.Map通过<map>标签定义，<map>标签里可以使用**多个<entry>**作为子标签，每个条目包含一个键和一个值。

  * 必须在<key>标签里定义键

  * 因为键和值的类型没有限制，所以**可以自由地为它们指定<value>、<ref>、<bean>或<null>**

  * 可以将Map的键和值作为<entry>的属性定义：**简单常量使用key和value来定义；Bean引用通过key-ref和value-ref属性定义**

  * 使用<props>定义java.util.Properties，**该标签使用多个<prop>作为子标签。每个<prop>标签必须定义key属性。**与Mpa的配置类似

  * ```xml
    <bean id="person" class="Person的全类名">
    	<property name="name" value="Rose"></property> <!--Person的name属性-->
        <property name="cars">
        	<map>
            	<entry key="AA" value-ref="car"></entry> <!--Person的car属性，为Map类型-->
                <entry key="BB" value-ref="car2"></entry>
            </map>
        </property>
    </bean>
    ```

  * 使用map节点以及map的entry子节点配置map类型的成员变量

  * ```xml
    <bean id="dataSource" class="DataSource的全类名">
    	<property name="properties"> <!--dataSource的properties属性-->
            <!--使用props和prop子节点来为Properties属性赋值-->
        	<props>
            	<prop key="user">root</prop>
                <prop key="password">1234</prop>
                <prop key="jdbcUrl">...</prop>
                <prop key="driver">...</prop>
            </props>
        </property>
    </bean>
    ```

  * 可以使用<uitl:list>标签配置单例的集合bean，以供多个bean进行引用,需要导入utils命名空间

  * ```xml
    <uitl:list id="cars">
        <ref bean="car"></ref>
        <ref bean="car2"></ref>
    </uitl:list>
    ```

* 可以通过p命名空间为bean的属性赋值，需要先导入p命名空间

  * ```xml
    <bean id="person" class="Person的全类名" p:age="20" p:name="Tom" p:cars-ref="cars"></bean>
    ```

### 3.5 自动装配

* Spring IOC容器可以自动装配Bean。需要做的仅仅是在<bean>的autowire属性里指定自动装配的模式

* **byType**(根据类型自动装配):若IOC容器中有多个与目标Bean类型一致的Bean。在这种情况下，Spring将无法判定哪个Bean最合适该属性，所以不能执行自动装配

* **byName**(根据名称自动装配)：必须将目标Bean的名称和属性名设置的完全相同

* constructor(通过构造器自动装配):当Bean中存在多个构造器时，此种自动装配方式将会很复杂。

* ```xml
  <bean id="address" class="Address的全类名" p:city="Beijing" p:street="Huilang"></bean>
  
  <bean id="car" class="Car的全类名" p:brand="Audi" p:price="30000"></bean>
  
  <!-- 通过autowire的方式自动注入，因为id为address和car的bean与Person中的属性address、car名称一致，所以可以自动注入-->
  <!--byName根据bean的名字和当前bean的setter风格的属性名进行自动装配,若有匹配的，则进行自动装配，若没有匹配，则不装配-->
  <!--byType根据bean的类型和当前bean的属性的类型进行自动装配，若IOC容器中有一个以上的类型匹配Bean，则会抛出异常-->
  <bean id="person" class="Person的全类名" p:name="Tom" autowire="byName"></bean>
  ```

* 缺点：

  * 在配置文件里设置autowire属性进行**自动装配将会配置Bean的所有属性**。然而，若只希望装配个别属性时不够灵活
  * **autowire属性要么根据类型自动装配，要么根据名称自动装配，不能两者同时使用**

### 3.6 Bean之间的关系

* 继承（配置上继承）
  * ==使用<bean>标签的parent属性指定继承哪个bean的配置==
  * Spring允许集成bean的配置，被继承的bean称为父bean。继承这个父Bean的Bean成称为子Bean
  * 子Bean从父Bean中继承配置，包括Bean的属性配置
  * 子Bean也可以**覆盖**从父Bean继承过来的配置
  * **父Bean可以作为配置模板，也可以作为Bean实例**。若只想把父Bean作为模板，可以设置<bean>的**absstract属性为true**，这样Spring将不会实例化这个Bean，如果去实例化江汇报错
  * 并不是<bean>元素里的所有属性都会被继承，比如autowire，abstract等
  * 也可以忽略父Bean的class属性，让子Bean指定自己的类，而共享相同的属性配置。但此时的abstract必须设置为true。
* 依赖（Bean配置）
  * Spring允许用户通过**depends-on**属性设定Bean前置依赖的Bean，前置依赖的Bean会在本Bean实例化之前创建好
  * 如果前置依赖于**多个Bean，则可以通过逗号，空格的方式配置Bean的名称**

### 3.7 Bean的作用域

* 默认的IOC容器中的bean是单例的，每次调用都会返回同一个bean
* 使用bean的scope属性来配置bean的作用域
  * singleton:默认值，容器初始时创建bean实例。在整个容器的声明周期内只创建这一个bean。在执行```ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml")```时，就会执行构造方法，初始化Bean，所以每次都是获取的同一个。
  * prototype:原型的，容器初始化时不创建bean的实例，而在每次请求时都创建一个新的Bean实例，并返回。也就是说在执行```ApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml")```时，并不会进行初始化构造。
  * session：会话
  * request：请求

### 3.8 外部属性文件

* 在配置文件里配置Bean时，有时需要在Bean的配置里混入**系统部署的细节信息**(例如：===文件路径，数据源配置信息===等)。而这些部署细节实际上需要和Bean配置相分离。
* Spring提供了一个**PropertyPlaceholderConfigurer**的**BeanFactory后置处理器**，这个处理器允许用户将Bean配置的部分内容**外移到属性文件中**。可以在Bean配置文件里使用形式为**${var}**的变量，PropertyPlacehholderConfigurer从属性里加载属性，并使用这些属性来替换变量。
* Spring还允许在属性文件中使用**${propName}**，以实现属性之前的相互引用。
* 首先要导入context的命名空间
* 然后导入属性文件```<context:property-placeholder location="classpath:配置文件(如db.properties)"/>```
* 再然后在bean标签中使用外部化属性文件的属性```<property name="user" value="${user}"></property>```,${user}的值是在配置文件中配置了的，使用${var}的方式进行使用

### 3.9 SpEL：字面量

* #{}

* 整数：```<property name="count" value="#{5}"/>```
* 小数：```<property name="frequency" value="#{89.7}"/>```
* 科学计数法：```>property name="capacity" value="#{1e4}"/>```
* String可以使用单引号或者双引号作为字符串的定界符号：```<property name="name" value="#{'check'}"/>```或者是```<property name='name' value='#{"Check"}'/>``` ,可以直接赋值（value="..."）也可以用value="#{'...'}"
* Boolean:```<property name="enabled" value="#{false}"/>
* **引用其他对象**：```<property name="prefix" value="#{prefixGenerator}"/>```，也可以直接使用ref属性来指定，也可以通过value=#{}的方式应用其他对象 
* **引用其他对象的属性**：```<property name="suffix" value="#{sequenceGenerator2.suffix}"/>```
* 调用其他方法，还可以链式操作：```<property name="suffix" value="#{sequenceGenerator2.toString().toUpperCase()}"/>```,
* 使用运算符：```<property name="info" value="#{car.price > 300000 ? '金领':'白领'}"/>```
* 引用静态属性：```<property name="initValue" value="#{T(java.lang.Math).PI}"/>```

### 3.10 IOC容器中Bean的生命周期

* **SpringIOC容器可以管理Bean的生命周期**，Spring允许在Bean生命周期的特点执行定制的任务。

#### 3.10.1 过程

* SpringIOC容器对Bean的生命周期进行管理的过程：
  * **通过构造器或工厂方法创建Bean实例**
  * **为Bean的属性设置值和对其他的Bean的引用**
  * **调用Bean的初始化方法**
  * Bean可以使用
  * 当容器关闭时，调用Bean的销毁方法
* **当Bean的声明里设置init-method和destory-method属性，为Bean指定初始化和销毁方法**

#### 3.10.2 创建Bean的后置处理器

* Bean的后置处理器允许在调用初始化方法前后对Bean进行额外的处理
* **Bean的后置处理器对IOC容器里的所有Bean实例逐一处理，而非单一实例**。其典型应用是：检查Bean属性的正确性或根据特定的标准更改Bean的属性。
* 对Bean后置处理器而言，**需要实现Interface BeanPostProcesser接口**。在初始化方法被调用前后，**Spring将把每个实例分别传递给BeanPostProcesser接口的postProcessAfterInitialization(init-method之前调用)和postProcessBeforeInitialization(init-method之后调用)方法**。
* bean:bean实例本身
* beanName：IOC容器配置的bean的名字
* 返回值：是实际上返回给用户的bean，可以在以上两个方法中修改返回的bean，甚至返回一个新的bean。

### 3.11 Bean的配置方式

#### 3.11.1 通过全类名(反射)

* ```xml
  <bean id="test" class="全类名">
  ```

#### 3.11.2 通过工厂方法(静态工厂方法&实例工厂方法)

* 调用静态工厂方法创建Bean是将对象创建的过程封装到静态方法中。当客户端需要对象时，只需要简单的调用静态方法，而不同关心创建对象的细节

* 要声明通过静态方法创建的Bean，需要在Bean的class属性里指定用友该工厂方法的类，同时在``factory-method``属性里指定工厂方法的名称，最后使用``<constructor-arg>``元素为该方法传递方法参数。

* **静态工厂方法：直接调用某一个类的静态方法就可以返回Bean的实例**

* ```java
  public class StaticFactory{
      private static Map<String, Car> cars = new HashMap<>();
      static{
          cars.put("audi", new Car("audi", 300000));
        cars.put("baoma", new Car("baoma", 400000));
      }
      public Car getCar(String name) {
          return cars.get(name);
      }
  }
  ```
  
* ```xml
  <!-- 
  	class属性：指向静态工厂方法的全类名 
  	factory-method:指向静态工厂方法的名字
  	constructor-arg:如果工厂方法需要传入参数，则用constructor-arg传入参数
  -->
<bean id="car" class="工厂的全类名" factory-method="getCar">
  	<constructor-arg value="audi"></constructor-arg>
  </bean>
  ```
  
* 实例工厂方法：要获取实例，必须先要创建工厂方法对象

* ```java
  /**
  * 实例工厂方法：实例工厂的方法，即先需要创建工厂本身，再调用工厂的实例方法来返回bean的实例
  */
  public class InstanceFactory{
      private Map<String, Car> cars = null;
      
      private InstanceFactory(){
          cars = new HashMap<>();
          cars.put("audi", new Car("audi", 30000));
          cars.put("ford", new Car("ford", 40000));
      }
      public Car getCar(String brand) {
          return cars.get(brand);
      }
  }
  ```

* ```xml
  <!--配置工厂的实例-->
  <bean id="carFactpry" class="工厂的全类名"></bean>
  <!--
  	通过实例工厂方法来配置Bean
  	factory-bean属性:指向实例工厂方法的bean
  	factory-method:指向静态工厂方法的名字
  	constructor-arg:如果工厂方法需要传入参数，则用constructor-arg传入参数
  -->
  <bean id="car2" factory-bean="carFactory" factory-method="getCar">
  	<constructor-arg value="ford"></constructor-arg>
  </bean>
  ```

#### 3.11.3 FactoryBean

* 是Spring提供的，主要有三个方法

* ```java
  // 自定义的FacotryBean 需要实现FactoryBean接口
  public class CarFactoryBean implements FactoryBean<Car> {
      private String brand;
      
      public void setBrand(String brand) {
          this.brand = brand;
      }
      
      // 返回Bean的对象
      public Car getObject() throw Exception{
          return new Car(brand, 400000);
      }
      
      // 返回Bean的类型
      public Class<?> getObject() {
          return Car.class;
      }
      // 返回是否是实例
      public boolean isSingleton(){
          return true;
      }
  }
  ```

* ```xml
  <!--
  	通过FactoryBean来配置Bean的实例
  	class：指向FactoryBean的全类名
  	property:配置FactoryBean的属性
  
  	但是实际返回的实例却是FactoryBean的getObject()方法返回的实例
  -->
  <bean id="car" class="BeanFactory的全类名">
      	// 给BeanFactory的brand属性赋值
      	<property name="brand" value="audi"></property>
  </bean>
  ```

### 3.12 通过组件配置Bean

#### 3.12.1 在classpath中扫描组件

* 组件扫描(component scanning):Spring能够从classpath下自动扫描，侦测和实例化具有特定注解的组件

* 特定组件包括

  * **@Component**：基本注解，标识了一个受Spring管理的组件
  * **@Respository**：标识持久层组件
  * **@Service**：标识服务层(业务层)组件
  * **@Controller**:标识表现层组件

* 对于扫描到的组件，**Spring有默认的命名策略：使用非限定类名，第一个字母小写，也可以在注解中通过value属性值标识组件的名称，可以直接使用value属性标识**

* 当在组件类上使用了特定的注解之后，还需要在Spring的配置文件中声明<context:component-scan>

  * ``base-package``属性指定一个需要扫描的基类包，Spring容器将会扫描这个基类包里及其子包中的所有类

  * 当需要扫描多个包时，可以使用逗号分隔

  * 如果仅希望扫描特定的类而非基包下的所有类，可使用``resource-pattern``属性过滤特定的类，只扫描指定的类

  * ```xml
    // 需要导入命名空间
    <context:compoment-scan
                            base-package="com.spring.beans"
                            resource-pattern="需要过滤的包"></context:compoment-scan>
    ```

  * ``<context:include-filter>``:**子节点表示要包含的目标类**

    * annotation:所有标注了XxxAnnotation的类。该类型采用目标类是否标注了某个注解进行过滤，使用注解过滤
    * assinable：所有继承或扩展XxxService的类，该类型采用目标类是否继承或扩展某个特定类进行过滤,使用类名过滤

  * ``<context:exclude-filter>``:**子节点表示要排除在外的目标类**

  * ``<context:component-scan>``:下可以拥有若干个``<context:include-filter>``和``<context:exclude-filter>``

  * ``use-default-filters``：使用默认的过滤器，如果要使用自定义的过滤器，需要把这个属性设置为false，如果使用``<context:include-filter>``需要把这个设置为false。

#### 3.12.2 组件装配

* ``<context:component-scan>``：元素还会自动注册
* ``AutowireAnnotationBeanPostProcessor``实例，该实例可以自动装配具有**@Autowired和@Resource、@Inject**注解的属性
  * @Autowired注解自动装配**具有兼容类型的单个Bean属性**
    * **构造器，普通字段（即使是非public），一切具有参数的方法都可以应用@Autowired注解**
    * 默认情况下，所有使用@Autowired注解的属性都需要被设置。当Spring找不到匹配的Bean进行装配属性时，会抛出异常。**若某一属性允许不被设置，可以设置@Autowired注解的required属性为false**
    * 默认情况下，**当IOC容器里存在多个类型兼容的Bean时，通过类型的自动装配将无法工作，此时可以在``@Qualifier``注解里提供Bean的名称，Spring允许对方法的入参标注@Qualifier已指定注入Bean的名称**
    * @Autowired注解也可以应用在数组类型的属性上，此时Spring将会把所有匹配的Bean进行自动装配
    * @Autowired注解也可以应用在集合属性上，此时Spring读取集合的类型信息，然后自动装配所有与之兼容的Bean
    * @Autowired注解用在java.util.Map上时，若该Map的键值为String，那么Spring将自动装配与之Map值类型的Bean，此时Bean的名称作为键值。
    * **它是根据类型来匹配，如果有多个类型相同的，则可以使用value来指定。**

## 4.AOP

### 4.1 简介

* 什么是AOP？
  * AOP面向切面编程：是一种新的方法论，是对传统OOP(面向对象编程)的补充
  * AOP的主要编程对象是切面(aspect)，而切面模块化横切关注点
  * 在应用AOP编程的时候，仍然需要定义公共功能，但可以明确的定义这个功能在哪里，以什么方式应用，并且不必修改受影响的类。这样一来横切关注点就被模块化到特殊的对象(切面)里。
  * AOP的好处：
    * 每个事物逻辑位于一个位置，代码不分散，便于维护和升级
    * 业务模块更简洁，只包含核心业务代码
    * ![image-20200725233654883](E:\Code\Git\HH_STUDY\notes\Spring\image-20200725233654883.png)

* 为什么需要AOP？

  * **代码混乱**：越来越多的非业务需求(日志和验证等)加入后，原有的业务方法急剧膨胀。每个方法在处理核心逻辑的同时还必须兼顾其他多个关注点。
  * **代码分散**：以日志需求为例，只是为了满足这个单一需求，就不得不在多个模块(方法)里多次重复相同的日志代码。如果日志需求发生变化，必须修改所有的模块。

* 代理设计模式的原理：

  * **使用一个代理将对象包装起来**，然后用该对象取代原始对象，任何对原始对象的调用都要通过代理。代理对象决定是否以及何时将方法转到原始对象上。

  * ```java
    public class ArithmeticCalculatorLogginProxy{
        // 要代理的对象
        private ArithmeticCalculator target;
        public ArithmeticCalculatorLoggingProxy(ArithmeticCalculator target){
            this.target = target;
        }
        public ArithmeticCalculator getLoggingProxy(){
            ArithmeticCalutor proxy = null;
            
            // 代理对象由哪一个类加载器负责加载
            ClassLoader loader = target.getClass().getClassLoader();
            // 代理对象的类型，即其中有哪些方法
            Class[] interfaces = new class[]{ArithmeticCalculator.class};
            // 当调用代理对象其中的方法时，该执行的代码
            InvocationHandler h  = new InvocationHandler(){
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
    	        	String methodName = method.getName();
                    // 日志
                    System.out.println("begin");
                    Object result = method.invoke(target, args);
                    // 日志
                    System.out.println("end");
                    return result;
                }
            }
            proxy = (ArithmeticCalculator)Proxy.newProxyInstance(loader, interfaces, h);
            return proxy;
        }
    }
    ```

### 4.2 概念

* **切面：横切关注点（跨越应用程序多个模块的功能）被模块化的特殊对象**
* **通知：切面必须要完成的工作**
* **目标：被通知的对象**
* **代理：向目标对象应用通知之后创建的对象**
* **连接点：程序执行的某个特定位置**
* **切点：每个类都拥有很多个连接点。**

### 4.3 AspectJ

* Java社区里最完整最流行的AOP框架，在Spring2.0以上版本中，可以使用基于AspectJ注解或基于XML配置的AOP

#### 4.3.1 步骤

* 要在Spring应用中使用AspectJ注解，必须在classpath下包含AspectJ类库：aopalliance.jar、aspectj.weaver.jar和spring-asppects.jar
* 将aop Schema添加到<beans>根元素中
* 要在Spring IOC容器中启用AspectJ注解支持，只要在Bean配置文件中定义一个空的XML元素<aop:aspectj-autoproxy>
* 当Spring IOC容器侦测到Bean配置文件中的<aop:aspectj-autoproxy>元素时，会自动为与AspectJ切面匹配的Bean创建代理.

#### 4.3.2 实现代码

```java
// 把这个类声明为一个切面 需要把该类放入到IOC容器中，再声明为一个切面
@Aspect
@Componect
public class LogginAspect{
    // 声明该方法是一个前置通知：在目标方法之前开始执行
    @Before("execution(public int 方法所在类的全类名.方法(参数))")
    public void beforeMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        List<Object> args = Arrays.asList(joinPoint.getArgs());
        System.out.println("The method begins");
    }
}
```

```xml
<!-- 配置自动扫描的包-->
<context:component-scan base-package="包名"></context:component-scan>
<!--使得AspectJ注释起作用:自动为匹配的类生成代理对象-->
<aop:aspectj-autoproxy></aop:aspectj-autoproxy>
```

#### 4.3.3 总结

* **加入jar包**
  * com.springsource.org.aopalliance-1.0.0.jar
  * com.springsource.org.aspectj.weaver-1.6.8.RELEASE.jar
  * spring-aop-4.0.0.RELEASE.jar
  * spring-aspects-4.0.0.RELEASE.jar
  * commons-logging-1.1.3.jar
  * spring-beans-4.0.0.RELEASE.jar
  * spring-context-4.0.0.RELEASE.jar
  * spring-core-4.0.0.RELEASE.jar
  * spring-expression-4.0.0.RELEASE.jar

* **在配置文件中加入aop的命名空间**

* **基于注解的方式**
  
  * 在配置文件中加入如下配置 ``<aop:aspectj-autoproxy></aop:aspectj-autoproxy>``
  * 把横切关注点的代码抽象到切面的类中
    * 切面首先是一个IOC中的bean， 即加入@Component注解
    * 切面还需要加入一个@AspectJ注解
  * 在类中声明各种通知
    * @Before 前置通知，在方法执行前执行
    * @After 后置通知，**在方法执行之后执行，后置通知是在连接点完成之后执行的，即连接点返回结果或者抛出异常的时候,下面的后置通知记录了方法的终止，一个切面可以包括一个或者多个通知。**不能访问方法执行的结果，要在返回通知中才能访问
    * @AfterRunning 返回通知，在方法执行返回结果之后执行，方法正常结束执行的代码，返回通知是可以访问到方法的返回值的
    * @AfterThrowing 异常通知，在方法抛出异常之后执行，可以访问到方法出现的异常，且可以指定在出现特定异常时执行通知代码
    * @Around 环绕通知，围绕着方法执行,环绕通知需要携带ProceedingJoinPoint类型的参数，环绕通知需要携带Proceeing JoinPorint类型的参数，环绕通知类似于动态代理的全过程，ProceedingJoinPoint类型参数可以决定是否执行目标方法，环绕通知必须要有返回值，即为目标方法返回值
    * 首先是声明一个方法
    * 然后在方法前加上注解
  * 可以在通知方法中声明一个类型为JoinPoint的参数，然后就能访问到链接细节。如方法名称和参数值
  
* 基于XML配置文件的方式

  * ```xml
    <!-- 配置Bean -->
    <!-- 配置切面的Bean -->
    <bean id="切面id" class="切面类的全类名"></bean>
    <!-- 配置AOP-->
    <aop:config>
    	<!-- 配置切点表达式-->
        <aop:pointcut expression="execution(* 全类名.方法名.(参数列表))"
                      id="ponticut" />
        <!-- 配置切面及通知 -->
        <aop:aspect ref="logginAspect" order="2"> // 这个ref是之前声明的bean的id
        	<aop:before method="beforeMehtod" pointcut-ref="pointcut"></aop:before> // 这个method是之前声明的类中的方法，pointcut-ref指向的是之前声明的切点
            <aop:after></aop:after>
            <aop:after-throwing></aop:after-throwing>
            <aop:after-returning></aop:after-returning>
            <aop:round method="", pointcut-ref="pointcut"></aop:round>
        </aop:aspect>
        // ....
    </aop:config>
    ```

  * 

* 切面的优先级

  * 使用@Order注解指定切面的优先级，值越小优先级越高

  * 可以将连接点写在一个方法上面，然后其他的方法要调用时，就直接使用，不用重复写

  * 同一个包下面的可以使用类名.方法名调用，其他包下面的使用包名.类名.方法名调用

  * 使用@Pointcut声明切入点表达式，后面的其他通知直接使用方法名来引用当前的切入点声明

  * ```java
    @Pointcut("execution(public int 类的全类名.方法名(参数列表))")
    public void declareJoinPointExpression(){}
    
    @Before("declareJoinPointExpression()")
    public void beforeMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("The method " +methodName+ "begins with"+Arrays.asList(args));
    }
    ```

## 5 Spring对JDBC的支持

### 5.1 配置JDBC

* ```xml
  jdbc.user = root
  jdbc.password = 123456
  ....
  ```

* ```xml
  <!-- 导入资源文件-->
  <!-- 要先导入context命名空间-->
  <context:property-placeholder location="classpath:db.properties" />
  <!-- 配置C3P0数据源-->
  <bean id="dataSource"
        class="com.mchange.v2.c3p0.ComboPooledDataSource">
      <property name="user" value="${jdbc.user}"></property>
      <property name="password" value="${jdbc.password}"></property>
      <property name="jdbcUrl" value="${jdbc.jdbcUrl}"></property>
      <property name="driverClass" value="${jdbc.driverCLass}"></property>
      <property name="initialPoolSize" value="${jdbc.initialPoolSize}"></property>
      <property name="maxPoolSize" value="${jdbc.maxPoolSize}"></property>
  </bean>
  <!-- 配置Spring的JdbcTemplate-->
  <bean id="jdbcTemplate"
        class="org.springframework.jdbc.core.JdbcTemplate">
  	<property name="dataSource" ref="dataSource"></property>
  </bean>
  <!-- 配置NamedParameterJdbcTemplate,该对象可以使用具名参数，其没有无参数构造器，所以必须对其构造器指定参数-->
  <bean id="namedParameterJdbcTemplate"
     class="org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate">
      <constructor-arg ref="dataSource"></constructor-arg>
  </bean>
  ```

## 6 Spring中的事务管理

### 6.1 事务简介

* 事务管理是企业级应用程序开发中必不可少的技术，用来确保数据的完整性和一致性。
* 事务就是一系列的动作，它们被当做一个单独的工作单元。这些动作要么全部完成，要么全部不起作用
* 事务的四个关键属性(ACID)
  * **原子性**：事务是一个原子操作，由一系列动作组成。事务的原子性确保动作要么全部完成要么完全不起作用。
  * **一致性**：一旦所有事务动作完成，事务就被提交，数据和资源就处于一种满足业务规则的一致性状态中
  * **隔离性**：可能有许多事务会同时处理相同的数据，因此每个事物都应该与其他事务隔离开来，防止数据损坏。
  * **持久性**：一旦事务完成，无论发生什么系统错误，它的结果都不应该受到影响，通常情况下，事务的结果被写到持久化存储器中。

### 6.2 配置事务

* 在xml文件中配置事务管理器管理

* ```xml
  <!--需要先配置数据源 -->
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
      <!--管理数据源，所以需要将数据源的bean加入-->
  	<property name="dataSource" ref="dataSource"></property>
  </bean>
  <!-- 启用事务注解-->
  <tx:annotation-driven transaction-manager="transactionManager"/>
  ```

* 在需要事务的地方添加事务注解

### 6.3 事务的传播行为

* 事务传播属性：当事务的方法被另一个事务方法调用时，必须指定事务应该如何传播。例如：方法可能继续在现有事务中运行，也可能开启一个新事务，并在自己的事务中运行。

* 事务的传播行为可以由传播属性指定。Spring定义了7种类传播行为。

* | 传播属性                     | 描述                                                         |
  | ---------------------------- | ------------------------------------------------------------ |
  | ==REQUIRED(默认的传播行为)== | 如果有事务在运行，当前的方法就在这个事务内运行，否则，就启动一个新的事务，并在自己的事务内运行 |
  | ==REQUIRED_NEW==             | 当前方法必须启动新事务，并在自己的事务内运行，如果有事务正在运行，应该将它挂起 |
  | SUPPORTS                     | 如果有事务在运行，当前的方法就在这个事务内运行，否则他不可以运行在事务中 |
  | NOT_SUPPORTE                 | 当前的方法不应该运行在事务中，如果有运行的事务，将他挂起     |
  | MANDATORY                    | 当前的方法不应该运行在事务中，如果有运行的事务，需要抛出异常 |
  | NESTED                       | 如果有事务在运行，当前的方法就应该在这个事务的嵌套事务内运行，否则就启动一个新的事务，并在他自己的事务内运行 |

* 添加事务注解
  * **使用propagation指定事务的传播行为，即当前的事务方法被另外一个事务方法调用时**
  * **如何使用事务，默认取值为REQUIRED，即为调用方法的事务**
  * **REQUIRED_NEW：使用自己的事务，调用的事务的方法被挂起**

### 6.5 事务的隔离级别

* 并发事务所导致的问题可以分为下面三种类型
  * **脏读**：对于两个事务T1，T2，T1读取了已经被T2更新但还没有被提交的字段，之后若T2回滚，T1读取的内容就是临时且无效的
  * **不可重复读**：对于两个事务T1、T2，T1读取了一个字段，然后T2更新了该字段，之后T1再次读取同一个字段，值就不同了
  * **幻读**：对于两个事务T1、T2，T1从一个表中读取了一个字段，然后T2向表中插入了一些新的行，如果T1再次读取同一个表，就会多出几行
* 使用**isolation**指定隔离级别，最常用的取值为READ_COMMITTED

* 默认情况下Spring的声明式事务对所有的运行时异常进行回滚，也可以通过对应的属性进行设置，
  * noRollbackFor(控制全类名进行控制)
  * noRollbackForName(通过类名进行控制)

### 6.6 使用readOnly指定事务是否为只读

* 表示这个事务只读取数据，但不更新数据，这样可以帮助数据库引擎优化事务
* 若真的是一个只读取数据库值的方法，应该设置readOnly=true

### 6.7 基于XML配置文件的方式配置事务

* ```xml
  <!--配置bean -->
  <bean id="bookShopDao" class="全类名">
  	<property name="jdbcTemplate" ref="jdbcTemplate"></property>
  </bean>
  <bean id="bookShopService" class="全类名">
  	<property name="bookSShopDao" ref="bookShopDao"></property>
  </bean>
  <bean id="cashier" class="全类名">
  	<property name="bookShopService" ref="bookShopService"></property>
  </bean>
  <!--1.配置事务管理器-->
  <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager"> 
  	<property name="dataSource" ref="dataSource"></property>
  </bean>
  
  <!--2.配置事务隔离属性-->
  <tx:advice id="txAdvice" transaction-manager="transactionManager">
  	<tx:attributes>
          <tx:method name="*"/>
      </tx:attributes>
  </tx:advice>
  
  <!-- 3.配置事务切入点，以及把事务切入点和事务属性关联起来-->
  <aop:config>
  	<aop:pointcut expression="execution(* 全类名.*(..))" id="txPointCut"/>
      <!--将事务与切入点关联起来 -->
      <aop:advisor advice-ref="txAdvice" pointcut-ref="txPointCut" />
  </aop:config>
  ```