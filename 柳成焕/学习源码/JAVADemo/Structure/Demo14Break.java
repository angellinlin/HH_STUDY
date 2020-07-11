/*
break关键字的常见用法有两种：
1.可用于switch中，一旦执行，整个switch语句立即结束。
2.用于循环语句中，一旦执行么整个循环语句立刻结束，打断循环。

*/
public class Demo14Break{
	public static void main(String[] args){
		for(int i=1;i<=10;i++){
			//从第四次开始打断循环，后面的循环都不要了，直接退出
			if(i==4){
				break;
			}
			System.out.println("Hello"+i);
		}
	}
	
}