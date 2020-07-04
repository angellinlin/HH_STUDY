#HR系统 服务端
相关技术：SpringBoot、Gradle、MyBatis、MySQL、Redis等
##第一阶段
   - 搭建系统整体框架，SpringBoot+Gradle
   - 集成相关技术模块，比如集成MyBatis
###一些问题
- （1）如果执行两次Generator生成代码时，xml并不会覆盖原来的内容，而是会在原来的基础上再生成一份------>未解决
- （1）解决方案：(暂时不明确原因)在生成代码配置xml中table标签指明库名称:catalog="root"
##第二阶段（暂定）