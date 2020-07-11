public class Demo03IfElseIf{
	public static void main(String[] args){
		int x,y;
		x=5;
		if(x >= 3){
			y = 2*x+1;
		}else if(-1<x && x<3){
			y=2*x;
		}else {
			y=2*x-1;
		}
		System.out.println("y="+y);
		
	}
}