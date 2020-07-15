package cn.swjtu.innner_day071404;

public class DemoMain {
    public static void main(String[] args) {
        Hero hero=new Hero();
        hero.setName("孙尚香");
        hero.setAge(18);

        //创建一个武器对象
        Weapon weapon=new Weapon("AK47");
        hero.setWeapon(weapon);
        hero.attack();
    }
}
