package com.weihongyu.service;

import com.weihongyu.entity.Resume;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/10 23:32
 * @Description:简历操作类，文件保存版本
 */
public interface ResumeOperate {
    //增加简历
    public void addResume(String resume) throws IOException, IllegalAccessException;

    //通过名字删除简历
    public void deleResume(String name) throws IOException;

    //通过名字更新简历
    public void updateResumeByName(String name, Resume resume) throws IOException, IllegalAccessException;

    //通过名字查找简历
    public void getByName(String name) throws IllegalAccessException, IOException, InstantiationException;

    //得到所有简历
    public List<String> getAll() throws IOException;
}
