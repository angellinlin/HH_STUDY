public class Demo12Notice{
	public static void main(String [] args){
		short num1=30;  //正确写法，右侧数据没有超过左侧数据范围
		System.out.println(num1);
		
		short num2=20;
		//short result=num1+num2;  //错误语句！左侧需是Int型
		//System.out.println(result);
		
		short result=30+20;
		System.out.println(result);  //正确！编译器的常量优化，在编译时就将常量计算得到结果
	}
}