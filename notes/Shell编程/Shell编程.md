# Shell编程

## 1.入门

* shell是一个命名行解释器，它为用户提供了一个向Linux内核发送请求以便运行程序的界面系统级程序，用户可以用Shell来启动、挂起、停止甚至是编写一些程序。

* 脚本格式要求
  * 脚本以#!/bin/bash开头
  * 脚本需要有可执行权限
* 编写第一个Shell脚本
  * 需求一个shell脚本，输出hello world
  * ![image-20200711094458206](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711094458206.png)
* 脚本的常用执行方式
  * 方式1(输入脚本的绝对路径或相对路径)
    * 首先要赋予脚本的+x权限
    * 执行脚本
    * ![image-20200711105359164](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711105359164.png)
  * 方式2
    * (sh + 脚本)
    * 不需要赋予脚本+x权限，直接执行即可
    * ![image-20200711105743015](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711105743015.png)

## 2.变量

### 2.1 变量的介绍

* shell中的变量分为系统变量和用户自定义变量
* 系统变量：$HOME、$PWD、$SHELL、$USER等
* ![image-20200711105847066](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711105847066.png)
* 显示当前shell中的所有变量:set

### 2.2 变量的定义

* 基本语法
  * 定义变量：变量=值
  * 撤销变量：unset 变量
  * 声明静态变量：readonly 变量，注意不能unset

### 2.3 变量定义的规则

* 规则
  * 变量名称可以由字母、数字和下划线组成，但是不能以数字开头
  * 等号两侧不能有空格
  * 变量名称一般习惯为大写
* 将命令的返回值赋给变量
  * A=`ls - la`,反引号，运行里的命令，并把结果返回给变量A``
  * A=$(ls - la)等价于反引号

## 3.环境变量

* 基本语法
  * export 变量名=变量值 （功能描述：将shell变量输出为环境变量）
  * source 配置文件      （功能描述：让修改后的配置信息立即生效）
  * echo $变量名         （功能描述：查询环境变量的值）
* 多行注释
  * :<<! 
  * !

## 4.位置参数

* 介绍
  * 当我们执行一个shell脚本时，如果希望获取到命令行的参数信息，就可以使用到位置参数变量
  * 比如：./myshell.sh 100 200,这个就是一个执行shell的命令行，可以在myshell脚本中获取到参数信息
* 基本语法
  * $n(功能描述：n为数字,$0代表命令本身，$1-$9代表第一到第九个参数，十以上的参数需要用大括号包含，如${10})
  * $* (功能描述：这个变量代表命令行中所有的参数，$* 把所有的参数看成一个整体)
  * $@ (功能描述：这个变量也代表命令行中所有参数，不过$@把每个参数区分对待)
  * $# (功能描述：这个变量代表命令行所有参数的个数)
* 应用案例
  * 编写一个shell脚本positionPara.sh，在脚本中获取到命令行的各个参数信息
  * ![image-20200711201600939](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711201600939.png)
  * ![image-20200711201638488](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711201638488.png)

## 5.预定义变量

* 介绍
  * shell设计者已经定义好的变量，可以直接在shell脚本中使用
* 基本语法
  * $$ 功能描述：当前进程的进程号(PID)
  * $! 功能描述：后台运行的最后一个进程的进程号(PID)
  * $? 功能描述：最后一次执行的命令的返回状态。如果这个变量的值为0，证明上一个命令正确执行，如果这个变量的值为非0(具体是哪个数，由命令自己决定)，则证明上一个命令执行不正确)

## 6.运算符

* 基本语法
  * "$((运算式))" 或 "$[运算式]"
  * expr m + n 注意：expr运算符间要有空格
  * expr m - n
  * expr \ *(乘),/(除), %(取余)
* 案例
  * ![image-20200711205202143](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711205202143.png)

## 7.判断语句

* 基本语法
  * [ condition ] (注意conditiion前后有空格)
  * #非空返回true，可以使用$?验证(0为true, >1为false)

* 常用判断条件
  * 两个整数的比较
    * = 字符串比较
    * -lt 小于
    * -le 小于等于
    * -eq 等于
    * -gt 大于
    * -ge 大于等于
    * =ne 不等于
  * 按照文件权限进行判断
    * -r 有读的权限 [-r 文件]
    * -w 有写的权限
    * -x 有执行的权限
  * 按照文件类型进行判断
    * -f 文件存在并且是一个常规的文件
    * -e 文件存在
    * -d 文件存在并是一个目录
* 案例
  * ![image-20200711210911358](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711210911358.png)
  * ![image-20200711211456215](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711211456215.png)
  * ![image-20200711211722810](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200711211722810.png)

## 8.流程控制

### 8.1 if判断

* 基本语法

  * ```
    if [ 条件判断式 ]； then
    	程序
    fi
    ```

  * ```
    if [ 条件判断式 ]
    then
    	程序
    elif [ 条件判断式 ]
    then
    	程序
    fi
    ```

  * 注意：条件判断式，中括号和条件判断式之间必须有空格

* 案例

  * ![image-20200712100442378](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712100442378.png)

### 8.2 case语句

* 基本语法

  ```
  case $变量名 in
  "值1"）
  	如果变量的值等于值1，则执行程序1
  ;;
  "值2")
  	如果变量的值等于值2，则执行程序2
  ;;
  ....
  *)
  	如果变量的值都不是以上的值，则执行此程序
  ;;
  esac
  ```

* 案例

  * ![image-20200712101425473](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712101425473.png)

### 8.3 for循环

* 基本语法1

  ```
  for 变量 in 值1 值2 值3...
  do
  	程序
  done
  ```

  ![image-20200712103354481](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712103354481.png)

  ![image-20200712103439384](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712103439384.png)

* 基本语法2

  ```
  for((初始值;循环控制条件;变量变化))
  do
  	程序
  done
  ```

  

* ![image-20200712203621533](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712203621533.png)

### 8.4 while循环

* 基本语法

```
while [ 条件判断式 ]
do
	程序
done
```

* 应用实例
  * ![image-20200712204131507](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712204131507.png)

## 9.使用read读取控制台输入

* 基本语法
  * read(选项)(参数)
  * 选项
    * -p 指定读取值时的提示符
    * -t 指定读取值时等待的时间(秒)，如果没有在指定的时间内输入，就不再等待了
  * 参数
    * 变量 指定读取值的变量名
* 案例
  * ![image-20200712205132210](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712205132210.png)

## 10.系统函数简介

* 函数介绍
  * basename基本语法
    * 功能：返回完整路径最后/的部分，常用于获取文件名
    * basename [pathname ][suffix]
    * basename [string][suffix]
    * basename命令会删掉所有的前缀包括最后一个('/')字符，然后将字符串显示出来
    * 选项：suffix为后缀，如果suffix被指定了，basename会将pathname或string中的suffix去掉
  * 案例
    * ![image-20200712205749370](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712205749370.png)
  * dirname基本语法
    * 功能：返回完整路径最后/的前面的部分，常用于返回路径部分
    * dirname 文件绝对路径(功能描述：从给定的包含绝对路径的文件名中去除文件名(非目录部分)，然后返回剩下的路径(目录部分))
  * 案例
    * ![image-20200712210126414](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712210126414.png)

## 11.自定义函数

* 基本语法

```
[ function ] funname[()]
{
	Action;
	[return int;]
}
```

* 调用直接写函数名：funcname [值]
* 案例
  * ![image-20200712210921427](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712210921427.png)

## 12.综合案例

* 需求分析
  * 每天凌晨两点备份数据库testDB到/data/backup/dp
  * 备份开始和备份结束都能够给出相应提示信息
  * 备份后的文件要求以备份时间为文件名，并打包成.tar.gz的形式
  * 在备份的同时，检查是否有10天前备份的数据库文件，如果有就将其删除
* ![image-20200712213916257](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712213916257.png)
* ![image-20200712213937613](E:\Code\Git\HH_STUDY\notes\Shell编程\image-20200712213937613.png)



