package demo05;

public class Computer {
    public void powerOn(){
        System.out.println("�ʼǱ����Կ���");
    }

    public void powerOff(){
        System.out.println("�ʼǱ����Թػ�");
    }
    //ʹ��USB�豸�ķ�����ʹ�ýӿ���Ϊ�����Ĳ���
    public void useDevice(USB usb){
        usb.open();
        //����ת��
        if(usb instanceof Mouse){
            Mouse mouse=(Mouse) usb;
            mouse.click();
        }else if(usb instanceof KeyBoard){
            KeyBoard keyBoard=(KeyBoard) usb;
            keyBoard.type();
        }
        usb.close();
    }

}
