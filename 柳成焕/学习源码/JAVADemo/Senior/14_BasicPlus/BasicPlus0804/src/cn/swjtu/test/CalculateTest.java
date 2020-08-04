package cn.swjtu.test;

import cn.swjtu.demo01.Junit.Calculator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
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

补充：
@Before:修饰的方法会在测试方法之前被执行。
@After:修饰的方法会在测试方法执行之后被执行。

 */
public class CalculateTest {
    /*初始化方法：用于资源申请，所有测试方法在执行之前都会执行该方法*/
    @Before
    public void init(){
        System.out.println("init...");
    }
    /*释放资源方法：在所有方法执行完后都会自动执行该方法*/
    @After
    public void close(){
        System.out.println("close...");
    }

    /**
     * 测试add方法
     */
    @Test
    public void testAdd() {
        //System.out.println("我被执行啦！");
        Calculator ca = new Calculator();
        int result = ca.add(1, 2);
        System.out.println("testAdd...");

        //3.断言  我断言这个结果是3
        Assert.assertEquals(3, result);
    }

    @Test
    public void testSub() {
        Calculator ca = new Calculator();
        int res = ca.sub(1, 1);
        System.out.println("testSub...");
        //断言
        Assert.assertEquals(0, res);
    }
}
