package cn.swjtu.day01.demo03;
//定义一个方法，用来求出1-100之间所有数字之和
/*三要素
返回值：有返回值
方法名称：
参数列表：无*/
public class Demo02Sum {
    public static void main(String[] args) {
        System.out.println("1-100的和为："+sum());
    }

    public static int sum(){
        int result=0;
        for (int i = 1; i <= 100; i++) {
            result+=i;
        }
        return result;
    }
}
