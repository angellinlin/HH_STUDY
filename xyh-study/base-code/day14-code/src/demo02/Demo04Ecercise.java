package demo02;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*��ϰ����ʹ��������ص�API�������һ�����Ѿ�����������
˼·
1.��ȡ��ǰʱ���Ӧ�ĺ���ֵ
2.��ȡ�Լ��������ڶ�Ӧ�ĺ���ֵ
3.����ʱ���������ǰʱ��-�������ڣ�
������
1.ʹ��Scanner���еķ���next����ȡ��������
2.ʹ��DateFormat���еķ���parse�����ַ����ĳ������ڽ�����Date��ʽ
3.��Date��ʽ�ĳ�������ת��Ϊ����ֵ
4.��ȡ��ǰ�����ڣ�ת��Ϊ����ֵ
5.ʹ�õ�ǰ���ڵĺ���ֵ-�������ڵĺ���ֵ
6.�Ѻ���ֵ�Ĳ�ֵת��Ϊ�죨s/1000/60/60/24��
*/
public class Demo04Ecercise {
    public static void main(String[] args) throws ParseException {
        //1.ʹ��Scanner���еķ���next����ȡ��������
        System.out.println("��������������գ���ʽΪyyyy-MM-dd");
        Scanner sc=new Scanner(System.in);
        String birthdayDateString=sc.next();
        //2.ʹ��DateFormat���еķ���parse�����ַ����ĳ������ڽ�����Date��ʽ
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        Date birthdayDate=simpleDateFormat.parse(birthdayDateString);
        //3.��Date��ʽ�ĳ�������ת��Ϊ����ֵ
        long birthdayTime=birthdayDate.getTime();
        //4.��ȡ��ǰ�����ڣ�ת��Ϊ����ֵ
        long todayTime=new Date().getTime();
        //5.ʹ�õ�ǰ���ڵĺ���ֵ-�������ڵĺ���ֵ
        long time=todayTime-birthdayTime;
        //6.�Ѻ���ֵ�Ĳ�ֵת��Ϊ�죨s/1000/60/60/24��
        System.out.println(time/1000/60/60/24);

    }
}
