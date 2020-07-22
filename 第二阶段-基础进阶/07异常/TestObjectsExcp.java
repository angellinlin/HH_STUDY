package cn.com.spdb.testidea10;

import java.io.FileNotFoundException;
import java.util.Objects;

public class TestObjectsExcp {
    public static void main(String[] args) throws FileNotFoundException {
        method("xxx");
    }

    public static void method(String Filename) throws FileNotFoundException {
        if(!Filename.equals("c:/a.txt"))
        throw new FileNotFoundException("传递的文件路径不正确");
//        Objects.requireNonNull(obj,"空");
    }
}
