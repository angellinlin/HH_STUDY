package cn.swjtu.innner_day071404;
/*
游戏中的英雄角色
 */
public class Hero {
    private String name;  //英雄的名字

    private Weapon weapon; //英雄的武器

    private int age;  //英雄的年龄

    public void attack(){
        System.out.println("年龄为"+age+"的"+name+"用"+weapon.getCode()+"攻击");
    }

    public Hero() {

    }

    public Hero(String name, Weapon weapon, int age) {
        this.name = name;
        this.weapon = weapon;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
