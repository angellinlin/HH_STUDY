package demo06;
/*
һ����װ�ࣺ
�����������ͣ�ʹ�������ǳ����㣬��û�ж�Ӧ�ķ�����������Щ�������͵����ݣ�
����ʹ��һ���࣬�ѻ������͵�����װ���������ඨ����һЩ����������������װ�࣬
����ʹ�����еķ�����������Щ�������͵����ݡ�
��������    ��Ӧ�İ�װ��
byte       Byte
short      Short
int        Integer
long       Long
float      Float
double     Double
char       Character
boolean    Boolean

����װ�䣺�ѻ������͵����ݣ���װ����װ���У��������͵�����->��װ�ࣩ
���췽����
Integer(int value)����һ���·����Integer��������ʾָ����intֵ
Integer(String s)����һ���·����Integer��������ʾString ������ָʾ��intֵ
���ݵ��ַ����������ǻ������͵��ַ�����������׳��쳣.�磺"100"��ȷ��"A"�׳��쳣
��̬������
static Integer valueOf(int i):����һ����ʾָ����intֵ��Integerʵ��
static Integer valueOf(String s):���ر���ָ����String��ֵ��Integer

�������䣺�ڰ�װ����ȡ���������͵����ݣ���װ��-> �������͵����ݣ�
��Ա������
int intValue() ��int���ͷ��ظ�Integer��ֵ
*/
public class Demo1Main {
    public static void main(String[] args) {
        //װ��
        //���췽��
        Integer in1=new Integer(1);//�������к��ߣ�֤�������ѹ�ʱ
        System.out.println(in1);
        Integer in2=new Integer("1");//�������к��ߣ�֤�������ѹ�ʱ
        System.out.println(in2);
        //��̬����
        Integer in3=Integer.valueOf(1);
        System.out.println(in3);
        Integer in4=Integer.valueOf("1");
        System.out.println(in4);
        //Integer in5=Integer.valueOf("A");//NumberFormatException�쳣

        //����
        int i=in1.intValue();
        System.out.println(i);

    }
}
