package demo01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/*
java.long��Object ��toString����
Object�����νṹ�ĸ��������ࣩ��ÿ���඼ʹ��Object��Ϊ����
���ж��󣨰������飩��ʵ�������ķ���

ע�⣺��һ�����Ƿ���д��toString������ֱ�Ӵ�ӡ������Ӧ��������ּ��ɣ�
���û����д������������ӡ�ľ��Ƕ���ĵ�ֵַ��
*/
public class Demo01ToString {
    public static void main(String[] args) {
        Person person=new Person("����",15);
        String s= person.toString();
        System.out.println(s);//û�н�����дʱ�����Ϊdemo01.Person@723279cf

        //ֱ�Ӵ�ӡ��������֣���ʵ���ǵ��ö����toString����
        System.out.println(person);//û�н�����дʱ��demo01.Person@723279cf
        Random r=new Random();//û����дtoString����
        System.out.println(r);

        Scanner sc=new Scanner(System.in);//��дtoString����
        System.out.println(sc);

        ArrayList<Integer> list=new ArrayList<>();//��дtoString����
        list.add(1);
        list.add(2);
        System.out.println(list);

    }
}
