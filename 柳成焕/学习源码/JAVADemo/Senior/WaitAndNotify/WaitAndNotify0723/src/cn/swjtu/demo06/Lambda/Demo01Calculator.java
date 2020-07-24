package cn.swjtu.demo06.Lambda;

public class Demo01Calculator {
    public static void main(String[] args) {
        int num1=10;
        int num2=20;
        //调用invokeCalculator方法
        invokeCalculator(num1, num2, new Calculator() {
            @Override
            public int calc(int a, int b) {
                return a+b;
            }
        });

        //使用lambda表达式简化匿名内部类的代码
        invokeCalculator(num1,num2,(int a,int b)->{
            return a+b;
        });
        //省略lambda写法
        invokeCalculator(num1,num2,(a,b)-> a+b);
    }

    //定义一个invokeCalculator方法
    public static void invokeCalculator(int a, int b, Calculator c) {
        int result = c.calc(a, b);
        System.out.println(result);
    }
}
