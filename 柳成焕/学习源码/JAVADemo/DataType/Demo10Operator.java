//三元运算符
public class Demo10Operator{
	public static void main(String [] args){
		int a=10;
		int b=5;
		
		int max=a>b?a:b; //a 10
		System.out.println("最大值:"+max); //a 10
		
		//int result=3>4?2.5:10;  //错误写法，报错
		
		System.out.println(3>4?2.5:10);  //10.0
		
		//a>b?a:b;  //错误写法
	}
}