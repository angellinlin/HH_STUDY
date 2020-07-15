package cn.swjtu.Calendar_day071501;

import java.util.Calendar;

/*
public int get(int field)返回给定日历字段的值。(YEAR,MONTH,DAY_OF_MONTH,HOUR,...)
public final void set(int field,int value)设置日历字段值。
public abstract void add(int field,int amount)根据日历的规则，为给定的日历字段添加或减去指定的时间量。(正数：增加，负数：减少)
public final Date getTime()返回一个表示此 Calendar 时间值（从历元至现在的毫秒偏移量）的 Date 对象。
 */
public class Demo02Calendar {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
    }

    private static void demo03() {
        Calendar c= Calendar.getInstance();

        c.add(Calendar.YEAR,-2);
        int year=c.get(Calendar.YEAR); //年份
        System.out.println(year);

        System.out.println(c.getTime());

    }

    private static void demo02() {
        Calendar c= Calendar.getInstance();
        //设置为2099-09-09
        c.set(Calendar.YEAR,2099);
        c.set(Calendar.MONTH,9);
        c.set(Calendar.DAY_OF_MONTH,9);

        //同时设置年月日
        c.set(2088,8,8);
    }

    private static void demo01() {
        Calendar c= Calendar.getInstance();
        int year=c.get(Calendar.YEAR); //年份
        System.out.println(year);

        int month=c.get(Calendar.MONTH)+1; //西方月份0-11月，+1即可
        System.out.println(month);

        int date=c.get(Calendar.DAY_OF_MONTH);  //日
        System.out.println(date);
    }
}
