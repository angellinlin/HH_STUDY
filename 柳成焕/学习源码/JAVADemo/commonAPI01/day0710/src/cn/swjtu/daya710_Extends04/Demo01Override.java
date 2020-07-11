package cn.swjtu.daya710_Extends04;

/*
方法覆盖重写的注意事项：
1.必须保证父类与子类之间方法名称相同，参数列表也相同。
@Override，写在方法前面，用于检测是不是有效的正确覆盖重写。
这个注解就算不写，只要满足要求，也是正确的方法覆盖重写。

2.子类方法的【返回值】必须【小于等于】父类方法的返回值范围。
提示：java.lang.Object类是所有类的公共最高父类（祖宗类），java.lang.String就是Object类的子类。

3.子类方法的【权限】必须【大于等于】父类方法的权限修饰符。
提示：public > protected > (defalut) >  private
备注：(default)不是关键字default，而是什么都不写，留空。
 */
public class Demo01Override {

}
