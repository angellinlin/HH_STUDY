package demo05;
/*jva.lang.StringBuilder��
* �ַ����ǳ��������ǵ�ֵ�ڴ���֮���ܸ���
* �ײ���һ�����飬��final����
* private final byte[] value;
* �����ַ�������ӣ��ڴ��оͻ��ж���ַ�����Ч�ʵ���
* String s= "a"+"b"+"c"="abc"
* "a" "b" "c"�ֱ�ռ�������ַ���
* "a"+"b"="ab"ռ��һ���ַ���
* "ab"+"c"="abc"ռ��һ���ַ���
* ��ռ��5���ַ���
* StringBuilder�ࣺ
* �ַ�������������������ַ����Ĳ���Ч�ʣ�����һ�����ȿɱ���ַ�����
* �ײ�Ҳ��һ�����飬��û�б�final���Σ��ɸı䳤��
* byte [] value=new byte[16];
* ���ڴ���ʼ����һ�����飬ռ�õĿռ��٣�Ч�ʸ�
* ���������ʼ����16�����Զ�����
*
* һ�����췽��
* StringBuilder():����һ�������κ��ַ��������������ʼ����Ϊ16���ַ�
* StringBuilder(String str):����һ���ַ���������������ʼ��ָ�����ַ�������
*
* ������Ա����
* public StringBuilder append(.....):��������������ݵ��ַ�����ʽ�������ص�ǰ��������
* public String toString()������ǰStringBuilder����ת��ΪString����
* ע���÷������ص���this
* StringBuilder��String�����໥ת��
* String->StringBuilder:ʹ�ù��췽��StringBuilder(String str)
* StringBuilder->String������ʹ��StringBulder�е�toString����public String toString()
*
* */
public class Demo01StringBuilder {
    public static void main(String[] args) {
        //�ղ������췽��
        StringBuilder bu1=new StringBuilder();
        //���ַ����Ĺ��췽��
        StringBuilder bu2=new StringBuilder("abc");
        System.out.println("bu1:"+bu1);
        System.out.println("bu2:"+bu2);
        System.out.println("========================");

        StringBuilder bu3=new StringBuilder();
        StringBuilder bu4= bu3.append("abc");//��bu3�ĵ�ַ���Ƹ�bu4
        System.out.println(bu3);
        System.out.println(bu4);
        System.out.println(bu4==bu3);//�������ͱȽϵ�ַ��true�����Բ��ý��ܷ���ֵ
        System.out.println("========================");
        /*��ʽ��̣���������ֵ��һ�����󣬿��Լ�������*/
        bu3.append("abccc").append(true).append(8.8).append('��');
        System.out.println(bu3);
        System.out.println("========================");

        String str="hello";
        System.out.println("str:"+str);
        StringBuilder bu=new StringBuilder(str);
        bu.append("world");

        String s=bu.toString();
        System.out.println("s:"+s);





    }
}
