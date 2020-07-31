package demo03;

import java.util.Calendar;
import java.util.Date;

/*
* Calendar��ĳ�����Ա������
* 1.public int get(int field):���ظ��������ֶε�ֵ
* 2.pubic void set (int field,int value):�������������ֶ�����Ϊ����ֵ
* 3.public abstract void add(int field,int amount):������������Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
* 4.public Date getTime():����һ����ʾ��Calendarʱ��ֵ������Ԫ�����ڵĺ���ƫ��ֵ����Date����
* ��Ա����������
* int field����������ֶΣ�����ʹ��Calander��ľ�̬��Ա������ȡ
* public static final int YEAR=1; ��
* public static final int MONTH=2; ��
* public static final int DATE=5; ���е�ĳһ��
* public static final int DAY_OF_MONTH=5; ���е�ĳһ��
* public static final int HOUR=10; ʱ
* public static final int MINUTE=12; ��
* public static final int SECOND=13; ��
*
* */
public class Demo02Calendar {
    public static void main(String[] args) {
        demo01();
        demo02();
        demo03();
        demo04();
    }

    private static void demo04() {
        /*public Date getTime():����һ����ʾ��Calendarʱ��ֵ������Ԫ�����ڵĺ���ƫ��������Date����
        * ʵ�ʾ��ǰ���������ת��Ϊ���ڶ���
        * */
        //��ȡCalendar����
        Calendar calendar=Calendar.getInstance();
        Date time=calendar.getTime();
        System.out.println(time);
    }

    private static void demo03() {
        /*
        * public abstract void add(int field,int amount)��
        * ���������Ĺ���Ϊ�����������ֶ���ӻ��ȥָ����ʱ����
        * ������
        * int field������ָ���������ֶ�
        * int amount�����Ӽ���ָ����ֵ
        * ����������
        * ����������
        * */
        //��ȡCalendar����
        Calendar calendar=Calendar.getInstance();
        //int year= calendar.get(1);
        //��������2��,���¼���2��
        calendar.add(Calendar.YEAR,2);
        calendar.add(Calendar.MONTH,-2);
        int year= calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH)+1);//�����·�0-11�������·�1-12

    }

    private static void demo02() {
        /*
        * public void set(int field ,int value):�������������ֶ�����Ϊ����ֵ
        * ������
        * int field������ָ���������ֶ�
        * int value����ָ���ֶ�����ֵ
        * */
        //��ȡCalendar����
        Calendar calendar=Calendar.getInstance();
        //һ��������Ϊ9999��9��9��
        calendar.set(Calendar.YEAR,9999);
        calendar.set(Calendar.MONTH,9);
        calendar.set(Calendar.DATE,9);
        //����Ҳ����ͬʱ����������,����������
        calendar.set(9999,9,9);
        int year= calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.get(Calendar.DATE));
    }

    private static void demo01() {
        //��ȡCalendar����
        Calendar calendar=Calendar.getInstance();
        //int year= calendar.get(1);
        int year= calendar.get(Calendar.YEAR);
        System.out.println(year);
        System.out.println(calendar.get(Calendar.MONTH)+1);//�����·�0-11�������·�1-12
        System.out.println(calendar.get(Calendar.DATE));
    }
}
