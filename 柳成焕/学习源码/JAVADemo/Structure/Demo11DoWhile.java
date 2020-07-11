/*
(1)标准格式
do{
	循环体
}while(条件判断);

(2)扩展格式
初始化语句；
do{
	循环体；
	步进语句；
}while(条件判断);
*/

public class Demo11DoWhile{
	public static void main(String [] args){
		for(int i=1;i<=10;i++){
			System.out.println("今天想出去耍鸭！"+i);
		}
		
		System.out.println("------------------");
		int j=1;
		do{
			System.out.println("今天想出去耍鸭！"+j);
			j++;
		}while(j<=10);
		
		System.out.println("------------------");
		int k=1;
		do{
			System.out.println("今天想出去耍鸭！"+k);   //至少执行一次
			j++;
		}while(j<=0);
	}
}