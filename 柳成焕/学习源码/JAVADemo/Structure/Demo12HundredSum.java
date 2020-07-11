
/*
求1-100所有偶数和
*/
public class Demo12HundredSum{
	public static void main(String [] args){
		int sum=0;
		
		//for循环
		for(int i=1;i<=100;i++){
			if(i%2==0){
				sum+=i;
			}
		}
		System.out.println("for循环1-100所有偶数之和为："+sum);
		System.out.println("===================");
		
		//while循环
		int j=1;
		sum=0;
		while(j<=100){
			if(j % 2==0){
				sum+=j;
			}
			j++;
		}
		System.out.println("while循环1-100所有偶数之和为："+sum);
		
		System.out.println("===================");
		//do-while循环
		sum=0;
		int k=1;
		do{
			if(k%2==0){
				sum+=k;
			}
			k++;
		}while(k<=100);
		System.out.println("do-while循环1-100所有偶数之和为："+sum);
	}
}