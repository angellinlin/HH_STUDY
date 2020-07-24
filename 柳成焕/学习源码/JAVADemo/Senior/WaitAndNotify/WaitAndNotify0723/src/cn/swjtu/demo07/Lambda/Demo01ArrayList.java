package cn.swjtu.demo07.Lambda;

import com.sun.jdi.ArrayReference;

import java.util.ArrayList;

/*
Lambda表达式：可推导，可省略
凡是根据上下文推导出来的内容，都可以省略书写。
可以省略的内容：
    1、(参数列表)：括号中参数列表的数据类型可以省略不写
    2、(参数列表)：括号中的参数如果只有一个，那么类型和括号都可以省略
    3、{一些代码}：如果{}中的代码只有一行，无论是否有返回值，那么都可以省略({},return,分号)
        注意：{},return,分号必须一起省略

 */
public class Demo01ArrayList {
    public static void main(String[] args) {
        //JDK1.7之前，创建集合必须把前后的泛型都写上
        ArrayList<String> list01 = new ArrayList<String>();

        //JDK1.8版本之后等号后的泛型可以省略，后边的泛型是可以根据前边推导出来的
        ArrayList<String> list02 = new ArrayList<>();
    }
}
