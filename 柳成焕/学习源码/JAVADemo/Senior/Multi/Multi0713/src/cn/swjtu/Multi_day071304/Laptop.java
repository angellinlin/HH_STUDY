package cn.swjtu.Multi_day071304;

/*
定义一个笔记本类
 */
public class Laptop {
    public void powerOn() {
        System.out.println("笔记本电脑开机！");
    }

    public void powerOff() {
        System.out.println("笔记本关机！");
    }

    //使用USB设备的方法,使用接口作为方法的参数
    public void useDevice(USB usb) {
        usb.open();  //打开设备

        if(usb instanceof Mouse){  //先判断
            Mouse mouse=(Mouse)usb;  //向下转型
            mouse.click();
        }else if(usb instanceof Keyboard){
            Keyboard keyboard=(Keyboard)usb;
            keyboard.type();
        }

        usb.close(); //关闭设备
    }


}
