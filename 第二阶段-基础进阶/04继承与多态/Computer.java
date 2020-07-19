package cn.com.spdb.testidea07;

public class Computer {

    public void powerOn() {
        System.out.println("开机了");
    }

    public void powerOff() {
        System.out.println("关机了");
    }
    //使用USB

    public void useUSB(USB usb) {
        if (usb instanceof Keyboards) {
            Keyboards keyboards = (Keyboards) usb;//向下转型
            keyboards.click();
        } else if(usb instanceof Mouse) {
            usb.open();
            usb.close();
        }
    }
}
