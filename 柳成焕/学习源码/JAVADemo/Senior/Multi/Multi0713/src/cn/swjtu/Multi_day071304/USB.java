package cn.swjtu.Multi_day071304;
/*
定义一个USB接口
 */
public interface USB {
    public abstract void open();  //打开设备

    public abstract void close(); //关闭设备
}
