package demo05;
/*
* ��������
* 1.usb�ӿڣ��������豸���ܣ��ر��豸����
* 2.�ʼǱ��࣬�����������ܡ��ػ����ܡ�ʹ��usb�豸����
* 3.����࣬Ҫʵ��usb�ӿڣ����߱�����ķ���
* 4.�����࣬Ҫʵ��usb�ӿڣ��߱��û��ķ���
*
* */
public class Demo1Main {
    public static void main(String[] args) {
        Computer computer=new Computer();
        computer.powerOn();
        //����ת��
        USB  usbMouse=new Mouse();
        computer.useDevice(usbMouse);
        //����һ��USB����
        KeyBoard keyBoard=new KeyBoard();
        computer.useDevice(keyBoard);//��ȷд��������ת���������ڻ������͵���ʽת����
        computer.powerOff();
    }
}
