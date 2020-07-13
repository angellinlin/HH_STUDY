package com.weihongyu.service;

import com.weihongyu.entity.Resume;
import com.weihongyu.util.FileUtil;

import java.io.IOException;
import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/10 23:36
 * @Description:
 */
public class ResumeOperateImpl implements ResumeOperate {

    private String path = "E:\\IdeaProjects\\resume.txt";

    public void addResume(String resume) throws IOException, IllegalAccessException {

        FileUtil.addResume(resume, path);
    }

    public void deleResume(String name) throws IOException {
        FileUtil.deleteByname(name, path);
    }

    public void updateResumeByName(String name, Resume resume) throws IOException, IllegalAccessException {
        FileUtil.updateOneLine(name, resume, path);
    }

    public void getByName(String name) throws IllegalAccessException, IOException, InstantiationException {
        Resume resume = FileUtil.getObjectByName(Resume.class, name, path);
        System.out.println(resume);
    }

    public List<String> getAll() throws IOException {
        return FileUtil.getAll(path);
    }
}
