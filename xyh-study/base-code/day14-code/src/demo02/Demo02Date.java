package demo02;

import java.util.Date;

public class Demo02Date {
    public static void main(String[] args) {
        demo();
        demo2();
        demo3();

    }

    public static  void demo(){
        /*Date��Ŀղ������췽����Date()��ȡ��ǰϵͳ�����ں�ʱ��*/
        Date date=new Date();
        System.out.println(date);
    }
    public static  void demo2(){
        /*Date��Ĵ������Ĺ��췽����Date(long date)���ݺ���ֵ���Ѻ���ֵת��ΪDate����*/
        Date date=new Date(0L);
        System.out.println(date);

        Date date1=new Date(3742767540068L);
        System.out.println(date1);
    }

    public static  void demo3(){
        /*long getTime()������ת��Ϊ����ֵ
        ������1970��1��1��00��00��00GMT������Date����ĺ���ֵ��
        �൱��System.currentTimeMillis()
        */
        Date date=new Date();
        long time= date.getTime();
        System.out.println(time);
    }
}
