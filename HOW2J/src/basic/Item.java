package basic;

public class Item {
	
	String name;
	int price;

	public void buy(){
		System.out.println("购买！");
	}

	public String toString(){
		return name + price;
	}

	/*public void finalize(){
		System.out.println("当前对象正在被回收！");
	}*/

	public boolean equals(Object o){
		if( o instanceof Item){
			Item h = (Item) o;
			return h.price == this.price;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Item bottle = new Item();
		bottle.name = "血瓶";
		bottle.price = 50;
		
		Item shoe = new Item();
		shoe.name = "草鞋";
		shoe.price = 350;
		
		Item sword = new Item();
		sword.name = "长剑";
		sword.price = 350;

		System.out.println(sword.toString());
		System.out.println("--------");
		System.out.println(sword);

		System.out.println(shoe.equals(sword));
	}




}
