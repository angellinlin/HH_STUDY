package demo01;

import java.util.ArrayList;

/*
public boolean equals(Object obj){
  return (this==obj)
}
ע��
== �Ƚ����㷨�����ǻ����������ͣ��Ƚϵ�ֵ�����������������ͣ��Ƚϵ�����������ĵ�ֵַ
*/
public class Demo02Equals {

    public static void main(String[] args) {
        Person p1=new Person("Dora",12);
        Person p2=new Person("Tom",13);
        boolean out=p1.equals(p2);
        System.out.println(out);//û�н�����дʱ�����Ϊfalse
        p1=p2;
        out=p1.equals(p2);
        System.out.println(out);//û�н�����дʱ�����Ϊture

        //һ�㶼�Ƿ���falseֵ������û�����壬��Ҫ��дEquals����,�Ƚ��������������
        Person p3=new Person("Tom",13);
        out=p1.equals(p3);
        System.out.println(out);//��д�󣬽��Ϊture

        //�����Ż�
        ArrayList<String> list=new ArrayList<>();
        out=p1.equals(list);
        System.out.println(out);
    }
}
