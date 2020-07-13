package com.weihongyu.service;

import com.weihongyu.entity.Resume;

import java.sql.SQLException;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 14:31
 * @Description:
 */
public interface ResumeService {
    public void addResume(String resume) throws SQLException;

    public void delResumeByName(String name) throws SQLException;

    public void updateResumeByName(String name, String resume) throws SQLException;

    public void searchResumeByName(String name) throws SQLException;

    public void getAll() throws SQLException;
}
