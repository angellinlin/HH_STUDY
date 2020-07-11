# 第二节 java运行环境

### 一、java概述

### 二、进制转换

### 三、字节、位

位：bit，一个数字0或数字1

字节：Byte，每逢8位是一个字节，是数据存储的最小单位

1Byte = 8bit

1KB = 1024Byte

1MB =1024KB

1GB=1024MB

1TB=1024GB

1PB=1024TB

### 四、命令提示符

启动cmd：    Win+R

切换盘符：    盘符名称+ :   D:

进入文件夹：   cd 文件夹

进入多级文件夹： cd 文件夹1\文件夹2\文件夹3

返回上一级：   cd ..

返回根目录：   cd \

查看当前内容：  dir

清屏：      cls

退出：      exit

 

### 五、java开发环境搭建

1.java虚拟机

JVM—我们编写的代码，都运行在JVM上，是java语言的运行环境。

跨平台：任何软件的运行都必须要在操作系统上，而我们编写的java软件可以运行在任何操作系统上，这个特性称为java语言的跨平台性。该特性是由JVM实现的，我们编写的程序都运行在JVM上，而JVM运行在操作系统上。

![img](file:///C:/Users/guoyh/AppData/Local/Temp/msohtmlclip1/01/clip_image002.jpg)

2.JRE和JDK

JRE：java run enviroment，java运行时的环境，包含JVM和核心类库。

JDK：java Development Kit，java程序开发工具包，包含JRE和开发人员使用的工具。

只想要运行→安装JRE即可

想要开发→安装JDK

关系：JDK包含JRE，JRE包含JVM

![img](file:///C:/Users/guoyh/AppData/Local/Temp/msohtmlclip1/01/clip_image003.png)

oracle.com下载安装JDK，以及环境变量的配置。（安装JDK时不选择JRE，并且安装路径最好不要有空格和中文！！）

**环境配置：**

1.我的电脑—属性—高级系统设置—高级—环境变量—系统变量中新建—变量名（JAVA_HOME）变量值（JDK的安装路径，bin的上一层级）

2.双击path—点击编辑文本—在变量值最前方加入“%JAVA_HOME%\bin;”—确定

3.重启cmd

完成后在cmd中直接输入java即可使用。

 