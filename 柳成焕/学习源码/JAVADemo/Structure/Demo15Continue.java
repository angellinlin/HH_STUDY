/*
continue关键字：一旦执行，立刻跳过当前循环剩余内容，马上开始下一次
*/
public class Demo15Continue{
	public static void main(String[] args){
		for(int i=1;i<=10;i++){
			if(i==4){
				continue;  //如果为4层，则直接跳过，执行下一层第五层
			}
			System.out.println(i+"层到了！");
		}
	}
}