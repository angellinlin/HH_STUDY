package demo05;

public class Mouse implements USB{
    @Override
    public void open() {
        System.out.println("�����");
    }

    @Override
    public void close() {
        System.out.println("�ر����");
    }

    public void click(){
        System.out.println("������");
    }
}
