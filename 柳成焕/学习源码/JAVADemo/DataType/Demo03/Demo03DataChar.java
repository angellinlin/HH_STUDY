
/*
数字和字符的对应关系表（编码表）
ASCII码表：Amarican Standard Code for Information Interchange美国信息交换标准代码
Unicode码表：万国码，也是数字和字符的对应关系表，0-127与ASCII码表相同
48--‘0’  65--‘A’   97--'a'
*/

public class Demo03DataChar{
	public static void main(String [] args){
		char c1='1';
		System.out.println(c1+0); //49
		
		char c2='c';
		
		//char-->int 数据范围从小到大，符合自动类型转换
		//发生自动类型转换
		int num=c2;  //99
		System.out.println(num);
		
		char c3='中';
		System.out.println(c3+0); //20013
	}
}