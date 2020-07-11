/*
当数据类型不一样时，将会发生数据类型转换
1.自动类型转换（隐式）
  特点：代码不需要特殊处理，自动完成
  规则：数据范围从小到大（与字节数不一定相关，如float→long类型，数据范围从小到大，发生自动类型转换）
2.强制类型转换（显式）
  
*/
public class Demo01DataType{
	public static void main(String[] args){
		System.out.println(1024);  //这就是一个整数，默认int型
		System.out.println(3.14);  //这是一个浮点型，默认double型
		
		//左边是long类型，右边默认的是int类型，左右不一样
		//一个=代表赋值操作，将右侧的int常量，赋值给左侧的long变量进行存储
		//int→long，数据范围从小到大，符合自动类型转换要求
		//这一行发生了自动类型转换
		long num1=100;  			
		System.out.println(num1); 
		
		//左边double类型，右边浮点类型
		//float→long  符合范围从小到大
		double num2=2.5F;
		System.out.println(num2);
		
		//左边float类型，右边long类型
		//float→long，数据范围从小到大，符合自动类型转换要求
		//此处发生了自动类型转换
		float num3=200L;
		System.out.println(num3); //此处应该输出200.0
	}
}