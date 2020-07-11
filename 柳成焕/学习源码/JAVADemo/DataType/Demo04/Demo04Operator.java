public class Demo04Operator{
	public static void main(String[] args){
		System.out.println(1+2); //常量可以进行数学运算
		
		int a=10;
		int b=20;
		System.out.println(a-b); //变量之间可进行数学运算
		
		System.out.println(a*10);
		
		int x=20;
		int y=6;
		int result1=x/y;  //3   被除数/除数=商……余数
		System.out.println(result1);
		
		int result2=x%y;  //2    取模/余数
		System.out.println(result2);
		
		//int+double  -->  double +double -->double
		//一旦运算中有不同类型的数据，那么结果将会是数据范围大的那种
		double result3=x+3.14;
		System.out.println(result3);
	}
}