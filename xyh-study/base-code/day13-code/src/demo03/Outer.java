package demo03;

/*
 * �ֲ��ڲ���
 * ���壺���һ�����Ƕ�����һ�������ڲ��ģ���ô�������Ǿֲ��ڲ���
 * ���ֲ�����ֻ�е�ǰ������������ʹ������
 * �����ʽ��
 * ���η� class �ⲿ������{
 *    ���η� ����ֵ���� �ⲿ��������(�����б�){
 *       class �ֲ��ڲ�������{
 *           //.....
 *       }
 *     }
 * }
 * С��һ�£�
 * Ȩ�����η�
 * public>protected>(dafault)>private
 * 1.�ⲿ�ࣺ������public/defaultȨ�����η�
 * 2.��Ա�ڲ��ࣺ������ public��protected��(dafault)��privateȨ�����η�
 * 3.�ֲ��ڲ��ࣺû��Ȩ�����η�
 * */
public class Outer {
    public void methodOuter() {
        class Inner {
            int num = 10;
            public void methodInner() {
                System.out.println(num);
            }

        }
        Inner inner=new Inner();
        inner.methodInner();

    }

}


