package cn.swjtu.DateFormat_day071401;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.text.Format:是日期/时间格式化子类的抽象类
            作用：格式化（日期 -> 文本）、解析（文本-> 日期）
            成员方法：
             String format(Date date)  将一个 Date 格式化为日期/时间字符串。
             Date parse(String source) 从给定字符串的开始解析文本，以生成一个日期。
 DateFormat类是一个抽象类，无法直接创建对象使用，可以使用DateFormat的子类。

 java.text.SimpleDateFormat extends DateFormat
    构造方法：SimpleDateFormat(String pattern) 用给定的模式和默认语言环境的日期格式符号构造 SimpleDateFormat
        参数：String pattern 传递指定的格式
        模式：区分大小写
        y   年
        M   月
        d   日
        H   时
        m   分
        s   秒
写对应的模式，会把模式替换为对应的日期和时间。
“yyyy-MM-dd HH:mm:ss"
注意：模式中的字母不能改变，中间连接的符号可以改变。


 */
public class Demo01DateFormat {

    public static void main(String[] args) throws ParseException {

        demo01(); //2020-07-14 18:35:23格式化
        demo02(); //Tue Jul 14 18:35:23 CST 2020
    }

    /*
    解析
    使用Parse方法，将格式化的字符串解析为Date
    注意：如果字符串和构造方法的模式不一样，那么程序就会抛出异常ParseException
    调用了一个抛出了异常的方法，就必须处理这个异常，要么throws继续抛出这个异常，要么try catch自己处理。
     */
    private static void demo02() throws ParseException {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        date=simFormat.parse("2020-07-14 18:35:23");
        System.out.println(date);
    }

    /*
    使用DateFormat类中的format方法格式化日期。
    步骤：
    1.创建SimpleDateFormat对象，构造方法传递指定格式
    2.调用SimpleDateFormat的format方法，把Date日期转化为符合模式的字符串
    */
    private static void demo01() {
        SimpleDateFormat simFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String str = simFormat.format(new Date());
        System.out.println(str);
    }


}
