package demo05;
/*����Ϊ��Ա��������*/
public class DemoMain {
    public static void main(String[] args) {
        //����һ��Ӣ�۽�ɫ
        Hero hero=new Hero();
        hero.setName("����");
        hero.setAge(20);
        Weapon weapon=new Weapon("������");
        hero.setWeapon(weapon);
        hero.attack();
    }
}
