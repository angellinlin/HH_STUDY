package com.weihongyu.DAO;

import com.weihongyu.entity.Resume;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 12:23
 * @Description:
 */
public interface ResumeDao {

    public void addResume(Resume resume) throws SQLException;

    public void deleResumeByName(String name) throws SQLException;

    public void updateResumeByName(String name, Resume resume) throws SQLException;

    public Resume searchResumeByName(String name) throws SQLException;

    public List<Resume> getAll() throws SQLException;
}
