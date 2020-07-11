public class Demo04Choose{
	public static void main(String[] args){
		int grade=100;
		if(90<=grade && grade<=100){
			System.out.println("优秀");
		}
		else if(80<=grade && grade<=89){
			System.out.println("好");
		}else if(70<=grade && grade<=79){
			System.out.println("良");
		}else if(60<=grade && grade<=69){
			System.out.println("及格");
		}else if(0<grade && grade<60){
			System.out.println("不及格");
		}else{
			System.out.println("错误");
		}
	}
}
