package cn.com.spdb.testidea08;

public class TestBaozhuang {
    public static void main(String[] args) {
        //装箱
        int i = 10;
        Integer i1 = new Integer(i);
        String src1 = "10";//必须是基本类型的字符串，否则会报错
        Integer i2 = new Integer(src1);
        System.out.println(i1);
        System.out.println(i2);
        //拆箱
        int ii = i1.intValue();
        System.out.println(ii);

        String s3 = "3.14";
        float f1 = Float.parseFloat(s3);
        Float f11 = f1;//将基本数据类型转为包装类
        String f12 = f11.toString();//调用包装类静态方法转化为字符串
        System.out.println(f12+200);//

        String name ="盖伦";
        int kill = 8;
        String title="超神";
        String sentenceFormat ="%s 在进行了连续 %d 次击杀后，获得了 %s 的称号%n";
        System.out.format(sentenceFormat,name,kill,title);

        char bb = 'a'; //不能够直接把一个字符转换成字符串
        String a2 = Character.toString(bb); //转换为字符串
    }
}
