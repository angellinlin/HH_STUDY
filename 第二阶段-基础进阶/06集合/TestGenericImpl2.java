package cn.com.spdb.testidea09;

public class TestGenericImpl2<R> implements TestGe<R> {
    @Override
    public void method1(R i) {
        System.out.println(i);
    }
}
