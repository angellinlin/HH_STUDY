package demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
java.test.DateFormat��
���ã���ʽ��������->�ı����ͽ������ı�->���ڣ�
1.��Ա������String format(Date date):����ָ����ģʽ����Date���ں�ʯ��Ϊ����ģʽ���ַ���
2.��Ա������Date parse(String source):�ѷ���ģʽ���ַ���������ΪDate����
DateFormat����һ�������࣬�޷�ֱ�Ӵ������󣬿���ʹ��DateFormat�������
��֪����SimpleDateFormat
���췽����
SimpleDateFormat(String pattern)
�ø�����ģʽ��Ĭ�����Ի��������ڸ�ʽ���Ź���SimpleDateFormat
������String pattern������ָ���ĸ�ʽ
���ִ�Сд
y ��
M ��
d ��
H ʱ
m ��
s ��
д��Ӧ��ģʽ�����ģʽ�滻Ϊ��Ӧ�����ں�ʱ��
ģʽ����ĸ�������滻������ģʽ�ķ��ſ��Ըı�
�磺yyyy-MM-dd:HH:mm:ss
�� yyyy��MM��dd��HHʱmm��ss��
 */
public class Demo03DateFormat {
    public static void main(String[] args) throws ParseException {
      demo01();
      demo02();
    }

    private static void demo02() throws ParseException {
        /*ʹ��DateFormate���еķ���parse�����ı�����Ϊ����
        * ʹ�ò��裺
        * 1.����һ��SimpleDateFormat����
        * 2.����SimpleDateFormat�����еķ���parse���ѷ��Ϸ�����ģʽ���ַ���������ΪDate����
        * ע�⣺
        * public Date parse(String source) throws ParseException
        * parse ����������һ���Ƴ�����ParseException
        * ����ַ����ͺ��ⷽ����ģʽ��һ��������ͻ��׳��쳣
        * ����һ���׳��쳣�ķ������ͱ��봦���쳣��Ҫôthrows�����׳�����쳣��Ҫôtry catch �Լ�����
        *
        */
        //1.����һ��SimpleDateFormat����
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
        Date date=sdf.parse("2020��07��30��21ʱ06��00��");
        System.out.println(date);

    }

    private static void demo01() {
        /*ʹ��DateFormat���еķ���format�������ڸ�ʽ��Ϊ�ı�*/
        //1.����һ��SimpleDateFormat����
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy��MM��dd��HHʱmm��ss��");
        //2.����SimpleDateFormat�����е�format
        Date date=new Date();
        System.out.println(date);
        System.out.println(sdf.format(date));
    }
}
