/*
死循环：永远停不下来的循环(按ctrl+c强制结束)
死循环的标准格式：
while(true){
	循环体；
}

*/
public class Demo16DeadLoop{
	public static void main(String[] args){
	//	for(int i=1;i<=10;){
	//		System.out.println("Hello"+i);
	//	}
	
	
		while(true){
			System.out.println("I Love JAVA!");
		}
		
		//System.out.println("Hello!");  //报错，无法访问，因为上面是死循环，永远结束不了
	}
}