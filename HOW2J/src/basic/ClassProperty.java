package basic;

public class ClassProperty {

    int a;
    static String b = "Property of the class!";

    public static void main(String[] args){
        ClassProperty c1 = new ClassProperty();
        ClassProperty c2 = new ClassProperty();
        c1.a = 1;
        c2.a = 2;
        System.out.println(c1.a);
        System.out.println(c2.a);
        System.out.println(c1.b);
        System.out.println(c2.b);
        c1.b = "Porperty of class c1";
        System.out.println(c1.b);
        System.out.println(c2.b);


    }
}
