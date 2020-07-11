/*
强制类型转换（显式）
	1.特点：代码需要进行特殊处理，不能自动完成
	2.格式：范围小的数据类型 范围小的变量名=（范围大的数据类型）原本范围大的数据;

	注意事项：
	1.强制类型转换一般不推荐使用，整数可能会发生数据溢出，小数会发生精度损失。
	2.byte/short/char这三种类型都可发生数学运算，例如“+”
	3.byte/short/char这三种类型在运算时，都会首先提升为int型，然后再进行计算
	4.boolean类型不能发生数据类型转换。
*/
public class Demo02DataType{
	public static void main(String[] args){
		//左边是int类型，右边是long类型
		//从int→long，数据范围不是从小到大，因此不能发生自动数据类型转换！
		//int num=100L;
		
		//2.格式：范围小的数据类型 范围小的变量名=（范围大的数据类型）原本范围大的数据;
		int num=(int)100L;
		System.out.println(num);
		
		//int num2=6000000000L;  //20亿
		//System.out.println(num2); //报错,不兼容的类型
		
		int num2=(int)6000000000L;
		System.out.println(num2);  //输出了1705032704。发生了数据溢出
	
		int num3=(int)3.99;
		System.out.println(num3); //输出3，这并不是四舍五入，精度丢失，所有小数位都被舍弃
		
		char c1='A';  //字符型变量
		System.out.println(c1);//输出A
		System.out.println(c1+1);//输出66,也就是A当作65来处理
		//计算机中使用一个二进制数来代表字符
		//一旦char进行数学运算，则字符会按照一定规则将其翻译为一个数字
		
		byte b1=40;  //右边数据值不能超过左侧范围  byte范围-128~127
		byte b2=50;
		
		//根据注意事项3，运算时byte首先会转为int型，然后再进行计算
		//byte+byte  →  int +int  两个int相加，结果也是int,因此右边为byte则会报错
		//byte result=b1+b2;  //报错 错误: 不兼容的类型: 从int转换到byte可能会有损失
		
		int result1=b1+b2;
		System.out.println(result1);
		
		short s=60;
		int result2=b1+s;  //byte+short  -->  int +int  -->int 正确
		System.out.println(result2);
		short result3=(short)(b1+s); //将int强制转换为了short型，但要注意的是，必须在逻辑上保证在数据范围内
		System.out.println(result3);
	}
}