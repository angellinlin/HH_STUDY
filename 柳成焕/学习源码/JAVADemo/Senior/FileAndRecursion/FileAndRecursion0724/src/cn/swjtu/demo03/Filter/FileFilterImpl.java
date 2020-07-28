package cn.swjtu.demo03.Filter;

import java.io.File;
import java.io.FileFilter;

/*
创建过滤器FileFilter实现类，重写抽象方法accept
 */
public class FileFilterImpl implements FileFilter {
    @Override
    public boolean accept(File pathname) {
        //过滤规则：判断File对象是否以.java结尾，是返回true，不是返回false
        //如果pathname是一个文件夹也返回true
        return pathname.isDirectory()|| pathname.getName().toLowerCase().endsWith(".java");

    }
}
