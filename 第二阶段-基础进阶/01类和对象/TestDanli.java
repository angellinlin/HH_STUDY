package cn.com.spdb.testidea06;

public class TestDanli {

        //私有化构造方法使得该类无法在外部通过new 进行实例化
        private TestDanli(){

        }
        //准备一个类属性，指向一个实例化对象。 因为是类属性，所以只有一个

        private static TestDanli instance = new TestDanli();

        //public static 方法，提供给调用者获取11行定义的对象
        public static TestDanli getInstance(){
            return instance;
        }

    }
