package cn.swjtu.day0711_04;

public class User {
    private String name;  //姓名
    private int money;    //余额

    public void show() {
        System.out.println("我叫：" + name + "，余额：" + money);
    }

    public User() {

    }

    public User(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
