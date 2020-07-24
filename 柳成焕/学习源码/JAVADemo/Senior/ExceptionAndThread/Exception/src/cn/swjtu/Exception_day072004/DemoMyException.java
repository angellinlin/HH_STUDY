package cn.swjtu.Exception_day072004;

import java.util.Scanner;

/*
要求：模拟注册操作，如果用户名已经存在，则抛出异常并提示：亲，该用户名已经被注册！
分析：
1、使用数组保存已经注册过的用户名（数据库）
2、使用Scanner获取用户的注册名（前端、页面）
3、定义一个方法，对输入的用户名进行判断
    遍历数组，获取每一个用户名
    判断比较
        true：抛出RegisterException异常，告知用户“亲，该用户名已经被注册！”
        false：继续遍历比较
     遍历结束，依然没有重复则，提示用户“注册成功！”
 */
public class DemoMyException {
    //1、使用数组保存已经注册过的用户名（数据库）
    public static String[] userNames = {"孙尚香", "王昭君", "芈月"};

    public static void main(String[] args) /*throws RegisterException*/ {
        //2、使用Scanner获取用户的注册名（前端、页面）
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入要注册的用户名：");
        String username = sc.next();
        checkUsername(userNames,username);
    }
    //3、定义一个方法，对输入的用户名进行判断
    public static void checkUsername(String[] userNames,String username) /*throws RegisterException*/ {
        for (String name : userNames) {
            if(name.equals(username)){
                try {
                    throw new RegisterException("亲，该用户名已经被注册！");
                } catch (RegisterException e) {
                    e.printStackTrace();
                    return;  //结束循环
                }


            }
        }
        System.out.println("注册成功！");
    }

}
