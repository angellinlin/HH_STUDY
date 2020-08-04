package cn.swjtu.demo02.Lambda;

/*
日志案例：根据日志级别，显示日志
发现以下代码。存在一些性能浪费问题。
调用showLogger方法，传递的第二个参数是一个拼接后的字符串
先把字符串拼接好，再调用再调用showLogger方法
showLogger方法如果传递的日志等级不是1级，那么字符串就白拼接了，存在了浪费


 */
public class Demo01Logger {
    //根据日志级别，显示日志
    public static void showLogger(int lever, String message) {
        if (lever == 1) {
            System.out.println(message);
        }
    }
    public static void main(String[] args) {
        //定义三个日志信息
        String message1 = "hello";
        String message2 = "world";
        String message3 = "java";
        showLogger(2, message1 + message2 + message3);
    }
}
