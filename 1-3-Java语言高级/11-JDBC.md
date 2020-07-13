# JDBC

- **MySQL**

  - [MySQL的安装与配置]:https://www.cnblogs.com/winton-nfs/p/11524007.html

  - 常用指令：

    - MySQL服务启动
      1. 启动mysql的服务：`net start mysql`
      2. 关闭mysql的服务：`net stop mysql`

    - MySQL登录
      1. `mysql -uroot -p密码`
      2. `mysql -hip -uroot -p连接目标的密码`
      3. `mysql --host=ip --user=root --password=连接目标的密码`

    - MySQL退出
      1. `exit`
      2. `quit`

- 概念：Java DataBase Connectivity ；Java 数据库连接；Java语言操作数据库。
- ==**JDBC本质**==：其实是官方定义的一套操作所有关系型数据库的规则，即**接口**。各个数据库厂商去实现这套接口，提供**数据库驱动`jar`包**。我们可以使用这套接口（JDBC）编程，真正执行的代码是驱动`jar`包中的实现类。
- 步骤：
  1. 导入驱动`jar`包
  2. 注册驱动
  3. 获取数据库连接对象`Connection`
  4. 定义`sql`
  5. 获取执行`sql`语句的对象`Statement`
  6. 执行`sql`，接受返回结果
  7. 处理结果
  8. 释放资源

## JDBC各个类详解

1. `DriverManager`：驱动管理对象

   **功能**：

   1. 注册驱动：告诉程序该使用哪一个数据库驱动jar

      写代码使用：`Class.forname("com.mysql.jdbc.Driver");`

   2. 获取数据库连接

      方法：`static  Connection getConnection(String url, String user , String password)`

      参数：

      - url：指定连接的路径
        - 语法：`jdbc:mysql://ip地址(域名):端口号/数据库名称`
        - 示例：`jdbc:mysql://localhost:3306/db3`
        - 细节：如果连接的是本机mysql服务器，并且mysql服务器默认端口是3306，则url可以简写为：`jdbc:mysql:///数据库名称`

      - user：用户名
      - password:密码

2. `Connction`：数据库连接对象

   **功能**：

   1. 获取执行`sql`的对象
      - `Statement createStatement()`
      - `PreparedStatement prepareStatement(String sql)`
   2. 管理事务
      - 开启事务：`setAutoCommit(boolean autoCommit)`，调用该方法，设置参数为`false`，即开启事务。
      - 提交事务：`commit()`
      - 回滚事务：`rollback()`

3. `Statement`：执行`sql`的对象

   **执行sql**：

   1. `boolean execute(String sql)`：可以执行任意的sql
   2. `int executeUpdate(String sql)`：执行DML（insert、update、delete）与语句、DDL(create、alter、drop)与语句
   3. `ResultSet executeQuery(String sql)`：执行DQL（select）与语句

4. `ResultSer`：结果集对象

5. `PreparedStatement`：执行`sql`的对象

## JDBC增删改查

- `insert`语句



[**MySql可视化工具的安装与使用**]:https://www.cnblogs.com/ll-hb/p/12688940.html
[使用MySQL Workbench进行数据库设计——MySQL Workbench使用方法总结]:https://blog.csdn.net/dongdong9223/article/details/48318877?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.nonecase&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-5.nonecase

