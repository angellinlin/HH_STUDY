package cn.swjtu.demo04.Lambda;

/*
需求：
给定一个厨子接口，内含唯一的抽象方法makeFood，且无参数，无返回值。
使用Lambda的标准格式调用invokeCook方法。打印输出“吃饭啦！”
 */
public class Demo01Cook {
    public static void main(String[] args) {
        //调用invokeCook方法，参数：Cook接口，可传递匿名内部类
        invokeCook(new Cook() {
            @Override
            public void mameFook() {
                System.out.println("吃饭啦！");
            }
        });

        //使用Lambda的标准格式简化匿名内部类的书写
        invokeCook(() -> {
            System.out.println("吃饭啦！");
        });

        invokeCook(() ->
            System.out.println("吃饭啦！")
        );
    }

    //定义一个方法invokeCook方，方法内部调用Cook接口中的方法makeFood
    public static void invokeCook(Cook cook) {
        cook.mameFook();
    }
}
