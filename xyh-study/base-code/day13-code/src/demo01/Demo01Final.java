package demo01;
/*
* final �ؼ��ִ������գ����ɸı��
* ���������÷���
* 1.����һ����
* 2.����һ������
* 3.����һ���ֲ�����
* ע�����ڻ���������˵�����ɱ�˵���Ǳ������еġ����ݡ����ɸı䣻
*     ��������������˵�����ɱ�˵���Ǳ������еġ���ַ�����ɸı䣻
* 4.����һ����Ա����
* */
public class Demo01Final {
    public static void main(String[] args) {
        int num=10;
        System.out.println(num);
        num=20;
        System.out.println(num);

        System.out.println("================");
        //һ��ʹ��final�������ξֲ���������ô��������Ͳ��ܽ��и���
        final int num1=200;
        System.out.println(num1);
        /*num1=20;//����д��*/

        //ֻҪ��֤��Ψһ��ֵ����
        final int num2;
        num2=30;

        Student stu=new Student("linda");
        System.out.println(stu);//@723279cf
        System.out.println(stu.getName());
        stu=new Student("dora");
        System.out.println(stu);//@10f87f48,��ֵַ�����˸ı�
        System.out.println(stu.getName());

        final Student stu1=new Student("��ԲԲ");
        System.out.println(stu1.getName());
        //��������newһ��������и�ֵ��ʧ�ܡ�
        //stu1=new Student("����͢");

        //�������е����ݿ��Ըı�
        stu1.setName("����͢");
        System.out.println(stu1.getName());

    }
}
