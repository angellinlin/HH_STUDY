package basic;

public class Spider extends Animal{

    public Spider(){
        super(8);
    }

    @Override
    void eat(){
    }

    public static void main(String[] args){
        Spider s = new Spider();
        s.walk();
    }
}
