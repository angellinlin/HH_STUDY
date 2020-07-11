/*
1.多个case语句后面的数值不可以重复；
2.switch后面小括号当中只能是以下数据类型：
（1）4个基本数据类型：byte/short/int/char
（2）2个引用数据类型：String字符串/enum枚举
3.switch语句可以很灵活：前后顺序可以颠倒，而且break语句还可省略。
“匹配到哪一个case就从哪一个位置向下执行，直到遇到break或整体结束为止”

*/
public class Demo08SwitchNotice{
	public static void main(String[] args){
		char c='f';
		switch(c){
			case 'a':
				System.out.println("aaa");
				//break;
			default:
				System.out.println("ccc");
				
				//break;
			case 'b':
				System.out.println("bbb");
				break;
			
		}
	}
}