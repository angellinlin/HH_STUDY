package demo04;

import java.util.Arrays;

/*
java.lang.System�����ṩ�˴����ľ�̬���������Ի�ȡϵͳ��ص���Ϣ�����ϵͳ��������
public static long currentTimeMillis()�������Ժ���Ϊ��λ�ĵ�ǰʱ�䡣
public static void arraycopy(Object src,
                             int srcPos,
                             Object dest,
                             int destPos,
                             int length)����������ָ�������ݿ�������һ��������
src��Դ����
srcPOS��Դ�����е���ʼλ�ã�������
dest��Ŀ������
destPos��Ŀ�������е���ʼλ��
length��Ҫ��ֵ������Ԫ�س���
*/
public class Demo01System {
    public static void main(String[] args) {
        demo01();
        demo02();
    }

    private static void demo02() {
        /*
        *��ϰ��
        * ��src������ǰ��Ԫ�أ����Ƶ�dest���ݵ�ǰ3��λ����
        * ����Ԫ��ǰ��
        * src=[1,2,3,4,5]; dest=[6,7,8,9,10]
        * ����Ԫ�غ�
        * dest=[1,2,3,9,10];
        * */
        int [] src={1,2,3,4,5};
        int [] dest={6,7,8,9,10};
        System.arraycopy(src,0,dest,0,3);
        System.out.println(Arrays.toString(dest));
    }

    private static void demo01() {
        /*�������Գ����Ч�ʣ���֤forѭ����ӡ1-999����Ҫʹ�õ�ʱ�䣨���룩*/
        long start = System.currentTimeMillis();
        for(int i=1;i<=999;i++){
            System.out.println(i);
        }
        long end=System.currentTimeMillis();
        System.out.println("���򹲺�ʱ��"+(end-start)+"ms" );
    }
}
