package cn.swjtu.Set_day071601;

/*
可变参数是JDK1.5后出现的新特性。
使用前提：
    当方法的参数列表数据类型已经确定，参数的个数不确定，就可以使用可变参数。
使用格式：定义方法时使用。
    修饰符 返回值类型 方法名（数据类型 ...变量名）{ }
原理：底层是一个数组，根据传递参数个数不同，会创建不同长度的数组来存储这些参数.
     它传递的参数个数可以是0个（不传递），1,2...多个。
注意事项：
    1.一个方法的参数列表，只能有一个可变参数。
    2.如果方法的参数有多个，那么可变参数必须写在参数列表的末尾。
可变参数的特殊写法（终极写法）：
    修饰符 返回值 方法名称(Object ... obj){ }

定义一个方法计算（0-n）个int数据的和。
三要素：
返回值：int
方法名称：add
参数列表：不确定，使用可变参数
add():就会创建一个长度为0的数组，new int[0]
add(10):就会创建一个长度为1的数组，new int[]{10}
add(10,20):就会创建一个长度为2的数组，new int[]{10,20}
 */
public class Demo06VarArgs {
    public static void main(String[] args) {
        int result1 = add();  //[I@50cbc42f  底层是一个数组
        int result2=add(10,3,4,5,6,7);
        System.out.println(result2);
    }

    public static int add(int... arr) {
        /*System.out.println(arr);
        System.out.println(arr.length);*/
        //定义一个初始化变量，记录累加求和
        int sum=0;
        //遍历数组，获取数组元素
        for (int i : arr) {
            sum+=i;
        }
        //返回求和结果
        return sum;
    }

    //public static void method(int ...a,String... str)
    //public static void method(int a,double ...f,String str)
}
