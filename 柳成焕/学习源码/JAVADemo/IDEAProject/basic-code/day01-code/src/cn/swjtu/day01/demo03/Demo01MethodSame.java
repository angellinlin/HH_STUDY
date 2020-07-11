package cn.swjtu.day01.demo03;

//定义一个方法，判断两个数字是否相等。
public class Demo01MethodSame {
    public static void main(String[] args) {
        int num1 = 20;
        int num2 = 30;
        if (getSame(num1, num2)) {
            System.out.println("两数相等");
        } else {
            System.out.println("两数不等");
        }
    }

    public static boolean getSame(int a, int b) {
        //方法一
        /* boolean tag;
        if(a==b){
            tag=true;
        }
        else{
            tag=false;
        }
        return tag;*/

        //方法二
       /* boolean tag=a==b?true:false;
        return tag;*/

        //方法三
        return a==b;
    }
}

