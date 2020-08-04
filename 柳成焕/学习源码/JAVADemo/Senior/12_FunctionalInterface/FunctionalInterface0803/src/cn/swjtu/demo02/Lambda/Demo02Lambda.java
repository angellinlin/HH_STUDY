package cn.swjtu.demo02.Lambda;
/*
使用lambda优化日志案例
lambda特点：延迟加载
lambda使用前提：必须存在函数式接口。

使用lambda表达式作为参数传递，仅仅是把蚕食传递到showLogger方法中
只有满足条件，日志的等级是1级，才会调用MessageBuilder中的方法builderMessage，才会进行字符串的额拼接。
如果条件不满足，日志的等级不是1级，那么调用MessageBuilder中的方法builderMessage就不会执行，所以拼接字符串的代码也不会执行，所以不会存在性能的浪费。
 */
public class Demo02Lambda {
    //定义一个方法，参数传递日志的等级和MessageBuilder等级
    public static void showLogger(int lever,MessageBuilder mb){
        //对日志的等级进行判断，如果是一集，则调用MessageBuilder中的方法builderMessage
        if(lever==1){
            System.out.println(mb.builderMessage());
        }
    }

    public static void main(String[] args) {
        //定义三个日志信息
        String message1 = "hello";
        String message2 = "world";
        String message3 = "java";
        //调用方法builderMessage，参数是函数是接口，所以可以传递lambda表达式
        showLogger(1,()->{
            System.out.println("不满足条件不执行");
            //返回一个拼接好的字符串
            return message1+message2+message3;
        });
    }
}

