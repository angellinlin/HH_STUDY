package demo02;
/*
�ڲ������ⲿ�ڵ���������
*/
public class Outer {
    int num=10;
    public class  Inner{
        int num=20;

        public void methodInner(){
            int num=30;
            System.out.println("�ڲ��ڳ�Ա����"+this.num);//�ڲ��ڳ�Ա����,20
            System.out.println("�ֲ�����"+num);//�ֲ������ͽ�ԭ��30
            System.out.println("�ⲿ���Ա����"+Outer.this.num);//�ⲿ���Ա����,10
        }
    }
}
