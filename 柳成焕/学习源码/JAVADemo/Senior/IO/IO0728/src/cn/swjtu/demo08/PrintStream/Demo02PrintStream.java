package cn.swjtu.demo08.PrintStream;

import java.io.FileNotFoundException;
import java.io.PrintStream;

/*
可以改变输出语句的目的地（打印流的流向）
输出语句默认在控制台输出，可使用System的setOut方法改变输出语句的目的地，
static void setOut(PrintStream out) 重新分配“标准”输出流。参数传递打印流的目的地。
 */
public class Demo02PrintStream {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("默认在控制台输出的流！");
        PrintStream ps=new PrintStream("IO0728\\目的地是打印流.txt");
        System.setOut(ps); //把输出打印流的目的地改为打印流的目的地
        System.out.println("猜猜我被输出到哪里了");  //打印流中
        ps.close();
    }
}
