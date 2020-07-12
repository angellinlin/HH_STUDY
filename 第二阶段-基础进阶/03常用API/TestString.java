package cn.com.spdb.testidea05;

/*
==是进行对像的地址值比较

equals(Object obj）:参数可以是任何对象，只有参数是一个字符串并且内容相同才会给true
* */
public class TestString {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "hello";
        char[] array = {'h', 'e', 'l', 'l', 'o'};
        String str3 = new String(array);

        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str3));//对象时字符串并且内容相同，但是注意他们的地址并不相同

        System.out.println(str1.length());
        System.out.println(str1.concat(str2));
        System.out.println(str1.charAt(1));
        System.out.println(str1.indexOf("llo"));
        System.out.println(str1.indexOf('e'));
        System.out.println(str1.substring(3));

        System.out.println(str1.toCharArray()[1]);
        System.out.println(str1.getBytes().length);
        System.out.println(str1.replace("el","ol"));

        String str4 ="aa,bb,cc,dd";
        String[] aa = str4.split(",");
        System.out.println(aa[1]);
    }
}
