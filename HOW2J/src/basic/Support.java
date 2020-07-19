package basic;

public class Support extends Hero implements Healer{
    @Override
    public void heal() {
        System.out.println("对英雄进行治疗！");
    }
}
