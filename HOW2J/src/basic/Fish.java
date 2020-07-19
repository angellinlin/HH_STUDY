package basic;

import java.util.Scanner;

public class Fish extends Animal implements Pet{
    private String name;

    public Fish(){
        super(0);
    }

    @Override
    public void walk() {
        System.out.println("游啊游！");
    }

    @Override
    void eat() {
        System.out.println(this.name + "正在吃草！");
    }

    @Override
    public void getName() {
        Scanner sc = new Scanner(System.in);
        this.name = sc.nextLine();
        sc.close();
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void play() {
        System.out.println("和" +this.name + "一起玩！");
    }

    public static void main(String[] args){
        Fish f = new Fish();
        f.getName();
        f.walk();
        f.eat();
        f.play();
        f.setName("caicai");
        f.walk();
        f.eat();
        f.play();
    }
}
