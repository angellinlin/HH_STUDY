package demo06;

import java.util.ArrayList;

/*
*�Զ�װ�����Զ����䣺�������͵����ݺͰ�װ��֮������Զ��໥ת��
*
* */
public class Demo2Integer {
    public static void main(String[] args) {
        /*�Զ�װ��*/
        Integer in=1;
        /*�Զ����䣬in�ǰ�װ�࣬�޷�����������͵ļ��㣬�������Զ��������㡣
        * in.inValue()+2:�Զ�����
        * in=in.inValue()+2���Զ�װ��
        * */
        in=in+2;
        System.out.println(in);

        ArrayList<Integer> list=new ArrayList<>();
        //�Զ�װ��
        list.add(1);
        System.out.println(list);
        //�Զ�����
        int a=list.get(0);
        System.out.println(list);
    }
}
