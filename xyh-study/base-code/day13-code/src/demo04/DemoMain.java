package demo04;
/*
*����ӿڵ�ʵ���࣬�����Ǹ�������ֻ࣬��Ҫʹ��Ψһ��һ�Σ�
* ��ô��������¾Ϳ���ʡ�Ե�����Ķ��壬��ʹ�á������ڲ��ࡿ
* �����ڲ���Ķ����ʽ��
* �ӿ����� ������=new �ӿ�����(){
*   //������д�ӿ������г��󷽷�
* };
*
* �Ը�ʽ���н�����new �ӿ�����(){......}��
* 1.new ����������Ķ���
* 2. �ӿ����ƾ��������ڲ�����Ҫʵ���ĸ��ӿ�
* 3.{......}����������ڲ��������
*
* ע�⣺
* 1.�����ڲ��࣬�ڴ��������ʱ��ֻ��ʹ��Ψһ��һ��,
* �����Ҫ��δ���������ʵ������һ��������Ҫ����������
* 2.���������������ڲ����������������������ڲ��಻��һ���£�
* ���������ڵ��÷�����ʱ��ֻ�ܵ���Ψһ��һ�Σ�
* ���ϣ��ͬһ��������ö�����������������������
* �����ڲ�����ʡ���ˡ�ʵ����/�������ơ�����������������ʡ���ˡ��������ơ�
* */
public class DemoMain {
    public static void main(String[] args) {
        //MyInterface impl=new MyInterfaceImpl();
        //impl.method();

        //ʹ�������ڲ���,������ΪObjA�����������ģ�����û������
        MyInterface objA=new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("ʵ���า����д�˷���");
            }
            public  void  method2(){
                System.out.println("ʵ���า����д�˷���2");
            }
        };
        System.out.println("===============objA===========");
        objA.method();
        objA.method2();
        MyInterface objB=new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("ʵ���า����д�˷���");
            }
            public  void  method2(){
                System.out.println("ʵ���า����д�˷���2");
            }
        };
        System.out.println("================objB=============");
        objB.method();
        objB.method2();
        //ʹ���������ڲ��࣬����ʡ���˶������ƣ�Ҳ����������
        System.out.println("================��������=============");
        new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("ʵ���า����д�˷���");
            }
            public  void  method2(){
                System.out.println("ʵ���า����д�˷���2");
            }
        }.method();
        //��Ϊ���������޷����õڶ��Σ�������Ҫ�ٴ���һ�������ڲ������������
        new MyInterface() {
            @Override
            public  void  method(){
                System.out.println("ʵ���า����д�˷���");
            }
            public  void  method2(){
                System.out.println("ʵ���า����д�˷���2");
            }
        }.method2();
    }
}
