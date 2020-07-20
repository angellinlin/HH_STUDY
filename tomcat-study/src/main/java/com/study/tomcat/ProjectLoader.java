package main.java.com.study.tomcat;

import java.net.URLClassLoader;

/**
 * @Author: A wei
 * @Date: 2020/7/18 15:40
 * @Last Modified by:
 * @last Modified date:
 * @Description: 类加载工具
 */
public class ProjectLoader {

    private String project;

    URLClassLoader loader = null;

    public ProjectLoader(String project){
        //得有一个工具 ---类加载器
        this.loader = new URLClassLoader();
    }
}
