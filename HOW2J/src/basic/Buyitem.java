package basic;

public class Buyitem extends Item{
    @Override
    public void buy() {
        System.out.println("ÂòÂòÂò£¡");
    }

    public static void main(String[] args){
        Buyitem  b = new Buyitem();
        b.buy();

        int i = 5;
        int j = 6;
        int k = i+j;
        System.out.println(k);

        int a1 = 5;
        String a2 = "5";
        String c = a1 + a2;
        System.out.println(c);
    }
}
