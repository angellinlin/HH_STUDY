/*
赋值运算符：
	基本赋值运算符：=
	复合赋值运算符：+= -= *= /= %=
	+=:  a+=10; --> a=a+10;
	-=:  b-=20; --> b=b-20;
	*=:  c*=30; --> c=c*30;
	/=:  d/=40; --> d=d/40;
	%=:  e%=50; --> e=e%50;
	
	注意事项：
		1.只有变量才能使用赋值运算符，常量不能进行赋值  
		2.复合赋值运算符隐含了一个强制类型转换。
*/

public class Demo07Operator{
	public static void main(String[] args){
		int a=10;
		a+=5; //a=15
		System.out.println(a);
		
		int b=20;
		b%=6;   //b=b%6  
		System.out.println(b);
		
		byte c=30;
		//c=c+5;
		//byte+int  -->  int + int -->int
		//c=(byte)int  此处有一个强制类型转换
		c+=5;
		System.out.println(c);
		
		byte d=20;
		//d=d+2.5;
		//byte+double  -->int + double
		//int ->double 数据范围从小到大，发生自动类型转换
		//int+double  -->  double + double  ->double 
		//d=(byte)double;
		d+=2.5;
		System.out.println(d); //22
	}
}