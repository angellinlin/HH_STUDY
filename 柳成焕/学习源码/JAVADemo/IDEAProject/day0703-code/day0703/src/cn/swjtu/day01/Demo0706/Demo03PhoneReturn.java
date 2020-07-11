package cn.swjtu.day01.Demo0706;

public class Demo03PhoneReturn {
    public static void main(String[] args) {
        Phone one=getPhone();
        System.out.println(one.brand);
        System.out.println(one.price);
        System.out.println(one.color);
    }

    public static Phone getPhone(){
        Phone one=new Phone();
        one.brand="苹果";
        one.price=8199;
        one.color="白色";
        return one;
    }
}
