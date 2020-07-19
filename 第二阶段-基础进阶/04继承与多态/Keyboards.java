package cn.com.spdb.testidea07;

public class Keyboards implements USB{
        @Override
        public void open() {
            System.out.println("打开键盘");
        }

        @Override
        public void close() {
            System.out.println("关闭键盘");
        }
        public void click(){
            System.out.println("键盘特有方法");
        }
    }

