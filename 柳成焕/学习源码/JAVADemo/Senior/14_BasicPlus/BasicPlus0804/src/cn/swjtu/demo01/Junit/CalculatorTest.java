package cn.swjtu.demo01.Junit;
/*
单元测试使用步骤
1、定义一个测试类（测试用例）
建议：
（1）测试类名：被测试的雷鸣Test  CalculatorTest
(2)包名：XXX.XXX.XX.test cn.swjtu.test
2、定义测试方法：可以独立运行
建议：
（1）方法名：test测试的方法名 testAdd
（2）返回值：void
（3）参数列表：空参
3、给方法加注解@Test
4、导入Junit依赖环境

判定结果：
绿色：成功
红色：失败
一般我们会使用断言操作来处理结果。 Assert.assertEquals(期望的结果,运算的结果);
 */
public class CalculatorTest {
    public static void main(String[] args) {
        Calculator ca = new Calculator();
        //int result = ca.add(1, 2);
        int result = ca.sub(1, 2);
        System.out.println(result);
    }
}
