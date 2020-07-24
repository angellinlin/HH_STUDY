package cn.swjtu.Demo02.WaitAndNotify;

/*
1、资源类：包子类
	设置包子的属性：皮，馅，包子的状态（有true,无false）
 */
public class BaoZi {
    private String pi;  //包子皮
    private String xian;//包子馅
    private boolean state = false; //包子状态,，默认设置为没有


    public BaoZi() {

    }

    public BaoZi(String pi, String xian, boolean state) {
        this.pi = pi;
        this.xian = xian;
        this.state = state;
    }

    public String getPi() {
        return pi;
    }

    public void setPi(String pi) {
        this.pi = pi;
    }

    public String getXian() {
        return xian;
    }

    public void setXian(String xian) {
        this.xian = xian;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "BaoZi{" +
                "pi='" + pi + '\'' +
                ", xian='" + xian + '\'' +
                ", state=" + state +
                '}';
    }
}
