package demo02;
/*
* ��̬��ǰ�᣺extends�̳���implementsʵ��
* ���������ֶ�̬�ԣ���������ָ����������Ҳ���󱻵��������������ʹ��
* ��ʽ��
* ��������  ������ =new ��������();
* ����
* �ӿ����� ������=new ʵ��������();
* */
public class DemoMulti {
    public static void main(String[] args) {
        Fu obj =new Zi();
        obj.method();
        obj.methodFu();
        //�������з����޷�ʹ��
        //obj.methodZi();
    }
}
