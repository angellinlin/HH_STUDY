package demo05;

public class Hero {
    private String name;//Ӣ�۵�����
    private int age;//Ӣ�۵�����
    private  Weapon weapon;//Ӣ�۵�����

    public Hero(String name, int age, Weapon weapon) {
        this.name = name;
        this.age = age;
        this.weapon = weapon;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void attack(){
        System.out.println("����Ϊ"+this.age+"��"+this.name+"��"+this.weapon.getNickname()+"�����з�");
    }

}
