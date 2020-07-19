package cn.com.spdb.testidea08;

import javax.management.StandardEmitterMBean;
import java.security.PublicKey;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TestDate {
    public static void main(String[] args) throws ParseException {
        Date d1 = new Date();
        System.out.println("当前时间:");
        System.out.println(d1);
        System.out.println();
        // 从1970年1月1日 早上8点0分0秒 开始经历的毫秒数
        Date d2 = new Date(5000);
        System.out.println("从1970年1月1日 早上8点0分0秒 开始经历了5秒的时间");
        System.out.println(d2);

        Date now= new Date();
        //打印当前时间
        System.out.println("当前时间:"+now.toString());
        //getTime() 得到一个long型的整数
        //这个整数代表 1970.1.1 08:00:00:000，每经历一毫秒，增加1
        System.out.println("当前时间getTime()返回的值是："+now.getTime());

        Date zero = new Date(0);
        System.out.println("用0作为构造方法，得到的日期是:"+zero);


        SimpleDateFormat s1 = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String ss = s1.format(now);
        System.out.println(ss);

        Date dd1 = s1.parse("2020年07月18日 15时23分20秒");
        System.out.println(dd1);

       SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //采用单例模式获取日历对象Calendar.getInstance();
        Calendar c = Calendar.getInstance();

        //通过日历对象得到日期对象
        Date d = c.getTime();
        System.out.println(d);
        c.add(Calendar.YEAR,-1);//翻到去年
        System.out.println(sdf.format(c.getTime()));
        c.set(Calendar.YEAR,1999);
        System.out.println(sdf.format(c.getTime()));

        System.out.println(System.currentTimeMillis());//相较于时间原来的毫秒值
        Date zero1 = new Date(System.currentTimeMillis());
        System.out.println("现在的日期是:"+sdf.format(zero1));

//        Date dd2 = new Date(0);
//        c.setTime(dd2); //把这个日历，调成日期 : 1970.1.1 08:00:00

    }

}
