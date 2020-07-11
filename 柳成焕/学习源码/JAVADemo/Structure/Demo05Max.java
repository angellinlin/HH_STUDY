//分别使用三元运算符和if-else语句实现取两个数中最大值
public class Demo05Max{
	public static void main(String[] args){
		int num1=10;
		int num2=20;
		int max=num1>num2?num1:num2;
		System.out.println("最大值为："+max);
		
		System.out.println("----------------");
		if(num1>num2){
			max=num1;
		}else{
			max=num2;
		}
		System.out.println("最大值为："+max);
	}
}