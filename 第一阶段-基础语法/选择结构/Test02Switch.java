public class Test02Switch{
	public static void main(String[] args){
		int num = 6;
		
		switch(num){
		case 1:
			System.out.println("星期一");
			break;
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期天");
			break;
		default:
			System.out.println("发生错误");
			break; //最后一个break可以省略，不建议
		}
																								
	}
}