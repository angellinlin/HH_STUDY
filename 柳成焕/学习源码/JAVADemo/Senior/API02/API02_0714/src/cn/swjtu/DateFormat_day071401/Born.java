package cn.swjtu.DateFormat_day071401;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Born {
    public static void main(String[] args) throws ParseException {
        //首先给出生日期parse函数
        //计算到目前为止经过了多少毫秒 getTime()
        //将毫秒转为天
        SimpleDateFormat simDate=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date dateBorn=new Date();
        dateBorn=simDate.parse("1995-08-02 08:00:00");  //将出生日期赋值给dateBorn
        //计算一共多少毫秒
        long haoMiao=dateBorn.getTime();
        //将毫秒转为天   1 天  = 86400 000 毫秒
        long dayNum=haoMiao/86400000;
        System.out.println(dayNum);

    }
}
