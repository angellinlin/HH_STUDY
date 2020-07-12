package cn.com.spdb.testidea05;

public class Hero {//创建类
    private String name;//类的属性
    private  int age;

    void shuai() {
        System.out.println("帅气");
    }//类的方法

    public static void main(String[] args) {
        Hero xu = new Hero();//创建对象
        xu.name = "xuxu";
        xu.shuai();
    }

    public Hero(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Hero() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
