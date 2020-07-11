/*
（1）标准格式
while(条件判断) { 循环体 }
（2）扩展格式
初始化语句；
while(条件判断) { 
循环体；
步进语句； }
*/

public class Demo10While{
	public static void main(String [] args){
		int i=0; //初始化语句
		while(i<10) //条件判断
		{
			System.out.println(i+1);  //循环体
			i++;                      //步进语句
		}
	}
}
