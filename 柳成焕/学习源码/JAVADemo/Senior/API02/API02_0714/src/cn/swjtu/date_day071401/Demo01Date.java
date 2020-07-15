package cn.swjtu.date_day071401;

import java.awt.dnd.DropTarget;
import java.sql.SQLOutput;
import java.util.Date;

/*
java.util.Date:表示日期和时间的类。
类Date：表示特定的瞬间，精确到毫秒。
1秒=1000毫秒
毫秒的作用：可以对时间和日期进行计算。
    计算从2020-07-14到2099-01-01之间的天数。
    将日期转换为毫秒计算完毕后，再将毫秒转为日期。


把日期转换为毫秒：
        当前日期：2020-07-14
        时间原点（0毫秒）：1970 年 1 月 1 日 00:00:00（英国格林威治）
        计算一共经历了多少毫秒。
        System.currentTimeMillis() //获取当前系统时间到1970年1月1日00.00共经历了多少毫秒
     注意：中国属于东八区，会把时间增加8小时。
            1970 年 1 月 1 日 08:00:00

把毫秒转为日期：
        1 天 = 24 × 60 × 60 = 86400 秒 = 86400000 毫秒
 */
public class Demo01Date {
    public static void main(String[] args) {
        //获取当前系统时间到1970年1月1日00.00共经历了多少毫秒
        System.out.println(System.currentTimeMillis());

        demo01GetDate(); //Tue Jul 14 17:58:21 CST 2020
        demo02GetDate(); //Thu Jan 01 08:00:00 CST 1970
        demo03GetTime(); //1594721114216
    }


    public static void demo01GetDate() {
        Date date = new Date();
        System.out.println(date);
    }

    public static void demo02GetDate() {
        //带参数的构造方法
        Date date = new Date(0L);
        System.out.println(date);
    }

    //public long getTime() 返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数
    public static void demo03GetTime() {
        Date date = new Date();
        long num = date.getTime();
        System.out.println(num);
    }

}
