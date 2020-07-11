public class Demo11Method{
	public static void main(String [] args){
		byte num1=/*(byte)*/30;  //右侧数据没有超过左侧数据范围，编译器自动为我们补上了一个(byte)(short)(char)
		System.out.println(num1);
		
		//byte num2=128;
		//System.out.println(num2); //右侧数据值超过了左侧数据范围，编译器直接报错。
		
		char c1=65;  //没有超过数据范围，编译器自动补上(char0
		System.out.println(c1); 
		
		System.out.println("==========="); 
	}
}