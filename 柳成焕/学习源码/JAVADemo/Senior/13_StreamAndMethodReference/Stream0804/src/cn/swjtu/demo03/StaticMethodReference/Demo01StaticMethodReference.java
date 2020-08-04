package cn.swjtu.demo03.StaticMethodReference;

/*
通过类名称引用静态成员方法：
使用前提：类已经存在，静态成员方法也已经存在，就可以使用雷鸣层直接引用静态成员方法。
 */
public class Demo01StaticMethodReference {
    //定义一个方法，参数传递要计算绝对值的整数和函数式接口Calcable
    public static int method(int num, Calcable c) {
        return c.calAbs(num);
    }

    public static void main(String[] args) {
        //调用method方法，传递要计算绝对值的整数，和lambda表达式
        int n = method(-10, (int num) -> {
            //计算绝对值并返回
            return Math.abs(num);
        });
        System.out.println(n); //10
        //使用方法引用优化lambda表达式
        //Math类是存在的，abs时候存在的，所以我们可以直接通过类名引用静态方法
        int i = method(-10, Math::abs);
        System.out.println(i); //10
    }
}
