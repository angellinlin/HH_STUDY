package cn.swjtu.day01.demo02;

//打印一个*矩形，每行20个，共5行
public class Demo02Mathod {
    public static void main(String[] args) {
        PrintRec();
    }

    public static void PrintRec()
    {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
