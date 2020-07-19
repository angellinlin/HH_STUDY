package basic;

public abstract class Animal {
    protected int legs;

    public Animal(int l){
        legs = l;
    }

    abstract void eat();

    public void walk(){
        if(legs == 2)
            System.out.println("直立行走");
        else if (legs == 4)
            System.out.println("趴着走");
        else
            System.out.println("飞着走");
    }
}
