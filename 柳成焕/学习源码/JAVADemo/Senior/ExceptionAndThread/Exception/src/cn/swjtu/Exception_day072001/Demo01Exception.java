package cn.swjtu.Exception_day072001;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.lang.Throwable类：是java语言中所有异常和错误的超类。
    Exception：编译期异常，进行编译（写代码）java程序出现的问题。
          RuntimeException：运行期异常，java程序运行过程中出现的问题。
          异常即相当于程序得了一个小毛病（感冒），把异常处理掉，程序就可以继续执行（吃点药，继续工作）
    Error：错误
          错误就相当于程序得了一个无法治愈的毛病（非典，艾滋），必须修改源代码，程序才能继续执行。


 */
public class Demo01Exception {
    public static void main(String[] args) /*throws ParseException */ {
        //Exception：编译期异常，进行编译（写代码）java程序出现的问题。
      /*  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
             date = sdf.parse("2020-0720");//把字符串格式的日期解析为Date格式
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println(date);
        System.out.println("后续代码");*/


        //异常
        int[] arr = {1, 2, 3};
        System.out.println(arr[0]);
        try {
            //可能会出现异常的代码
            System.out.println(arr[3]);
        }catch (Exception e){
            //异常的处理逻辑
            System.out.println(e);

        }
        System.out.println("=========");
        //Error：错误
        //错误就相当于程序得了一个无法治愈的毛病（非典，艾滋），必须修改源代码，程序才能继续执行。
        //OutOfMemoryErro:必须修改源代码，让数组的大小变小
        //int[] arr1=new int[1024*1024*1204];


        System.out.println("后续代码");
    }
}
