package demo06;
/*
�����������ַ�������֮����໥ת��
��������->�ַ�����String��
1.�������͵�ֵ+""
2.��װ��ľ�̬����toString(����)������Object���toString()�������صĹ�ϵ��
static Sting toString(int i)����һ����ʾָ��������String����
3.String��ľ�̬����valueOf(int i) ����int�������ַ�����ʾ��ʽ
�ַ�����String��->��������
ʹ�ð�װ��ľ�̬����parseXXX("�ַ���");
Integer �ࣺstatic int parseInt(String s);
Double �ࣺstatic double parseDouble(String s);
*
* */
public class Demo3Integer {
    public static void main(String[] args) {
        //��������->�ַ���
        int i1=100;
        String s1=i1+"";
        System.out.println(s1+200);//100200

       String s2= Integer.toString(100);
       System.out.println(s2+200);//100200

       String s3=String.valueOf(100);
       System.out.println(s3+200);//100200

        //�ַ���->��������
        int i=Integer.parseInt(s1);
        double d=Double.parseDouble("1.36");
        System.out.println(i-10);
        System.out.println(d+1.33);
    }
}
