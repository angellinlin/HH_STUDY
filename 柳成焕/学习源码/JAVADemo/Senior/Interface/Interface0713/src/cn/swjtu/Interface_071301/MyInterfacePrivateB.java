package cn.swjtu.Interface_071301;


public interface MyInterfacePrivateB {
    public static void methodStatic1() {
        System.out.println("静态方法1");
    }

    public static void methodStatic2() {
        System.out.println("静态方法2");

    }

    private static void methodPrivate(){
        System.out.println("AAA");
        System.out.println("BBB");
        System.out.println("CCC");
    }
}
