package cn.swjtu.demo02.MethodAndReference;

/*
通过对象名引用成员方法：
使用前提：对象名是已经存在的，成员方法也是已经存在的，就可以使用对象名来引用成员方法。

 */
public class Demo01ObjectMethodReference {
    //定义一个方法，方法的参数传递Printable接口
    public static void printString(Printable p) {
        p.print("helloWorld!");
    }
    public static void main(String[] args) {
        //调用printString函数，参数传递lambda表达式
        printString((s) -> {
            //创建MethodRefObject对象
            MethodRefObject obj = new MethodRefObject();
            //调用MethodRefObject对象中的成员方法,把字符串按照大写输出
            obj.printUpperCaseString(s);
        });
        //使用方法引用优化lambda
        //对象是已经存在的，成员方法也是已经存在的
        //所以可以使用  对象名引用成员方法
        //创建MethodRefObject对象
        MethodRefObject obj = new MethodRefObject();
        printString(obj::printUpperCaseString);
    }
}
