package cn.swjtu.inner_day071405;

public class DemoGame {
    public static void main(String[] args) {
        //首先创建一个英雄对象
        Hero hero=new Hero();
        hero.setAge(18);
        hero.setName("孙尚香");

        //放入实现类的对象
        SkillImpl skillImlp=new SkillImpl();
        hero.setSkill(skillImlp);
        System.out.println("=============");

        //放入匿名内部类的对象
        Skill skill=new Skill() {
            @Override
            public void use() {
                System.out.println("pia-pia-pia");
            }
        };
        hero.setSkill(skill);
        System.out.println("=============");

        //更简化的，放入匿名内部类的匿名对象
        hero.setSkill(new Skill() {
            @Override
            public void use() {
                System.out.println("biu-pia");
            }
        });
        System.out.println("=============");
    }

}
