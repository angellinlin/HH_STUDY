/*
逻辑运算符 
	&& || ！
	与&&  全部都是true才是true,否则就是false
	或||  至少一个是true就是true，；全都是false，才是false
	非!   取反 
*/
public class Demo09Logic{
	public static void main(String[] args){
		System.out.println(true && false); //false
		
		System.out.println(5>3 && 1<2);  //true
		
		System.out.println(true || false);  //true
		
		System.out.println(!true); //！后必须为boolean值
		
		System.out.println("========");
		int a=10;
		//false && ...   ->false  右边不需要执行
		System.out.println(3>5 && ++a<100); //false
		System.out.println(a);  //10  说明右边代码并未执行
	}
}