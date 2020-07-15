package cn.swjtu.inner_day071405;

import cn.swjtu.innner_day071404.Weapon;

public class Hero {
    private String name;  //英雄的名字

    private Skill skill;  //英雄的技能

    private int age;  //英雄的年龄

    public void attack()
    {
       System.out.println("年龄为"+age+"的"+name+"开始施放技能！");
       skill.use();
        System.out.println("施放技能完成！");
    }

    public Hero() {

    }

    public Hero(String name, Weapon weapon, int age) {
        this.name = name;
        this.skill = skill;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Skill getSkill() {

        return skill;
    }

    public void setSkill(Skill skill) {
        System.out.println("年龄为"+age+"的"+name+"开始施放技能！");
        skill.use();
        System.out.println("施放技能完成！");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

