HR系统 服务端
===
相关技术：SpringBoot、Gradle、MyBatis、MySQL、Redis等
#第一阶段
   - 搭建系统整体框架，SpringBoot+Gradle
   - 集成相关技术模块，比如集成MyBatis
 #完成进度
 - 完成整体框架搭建
 - 测试数据库连接
 - 整合MyBatis （连接测试）
 - 整合redis （测试案例：模拟手机验证码）
 - 整合Swagger UI
##一些问题
 * 如果执行两次Generator生成代码时，xml并不会覆盖原来的内容，而是会在原来的基础上再生成一份------>解决
 * 解决方案：(暂时不明确原因)在生成代码配置xml中table标签指明库名称:catalog="root"；更新新的方式，在配置的xml文件中添加插件
  
#第二阶段（暂定）