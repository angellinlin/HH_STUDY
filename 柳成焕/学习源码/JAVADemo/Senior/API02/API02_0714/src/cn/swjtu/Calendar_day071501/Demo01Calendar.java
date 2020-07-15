package cn.swjtu.Calendar_day071501;

import java.util.Calendar;

/*
java.util.Calendar类：日历类
1、是一个抽象类，里面提供了很多操作日历字段的方法（YEAR,MONTH,DAY_OF_MONTH,HOUR）
2、无法直接创建对象使用，但其有一个静态方法getInstance(),其返回一个Calendar子类对象。
static Calendar getInstance()使用默认时区和语言环境获得了一个日历
 */
public class Demo01Calendar {
    public static void main(String[] args) {
        Calendar rightNow=Calendar.getInstance();  //多态
        System.out.println(rightNow);
    }
}
