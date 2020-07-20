package com.weihongyu.service.impl;

import com.weihongyu.DAO.ResumeDao;
import com.weihongyu.DAO.impl.ResumeDaoImpl;
import com.weihongyu.entity.Resume;
import com.weihongyu.service.ResumeService;

import java.sql.SQLException;
import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 14:34
 * @Description:
 */
public class ResumeServiceImpl implements ResumeService {

    private ResumeDao resumeDao = new ResumeDaoImpl();


    @Override
    public void addResume(String str) throws SQLException {
        Resume resume = strToResume(str);
        resume.setProcess(0);
        resume.setShowStatus(1);

        resumeDao.addResume(resume);
    }

    //只更改显示状态，数据库仍保存
    @Override
    public void delResumeByName(String name) throws SQLException {
        Resume resume = resumeDao.searchResumeByName(name);
        resume.setShowStatus(0);

        resumeDao.updateResumeByName(resume.getName(), resume);
    }

    @Override
    public void updateResumeByName(String name, String str) throws SQLException {
        Resume resume = strToResume(str);
        resumeDao.updateResumeByName(name, resume);

    }

    @Override
    public void searchResumeByName(String name) throws SQLException {
        Resume resume = resumeDao.searchResumeByName(name);
        System.out.println(resume);
    }

    @Override
    public void getAll() throws SQLException {
        List<Resume> list = resumeDao.getAll();
        for (Resume resume : list) {
            System.out.println(resume);
        }
    }

    private Resume strToResume(String str){
        Resume resume = new Resume();
        String[] values = str.split("#");

        resume.setName(values[0]);
        resume.setId(values[1]);
        resume.setSchool(values[2]);

        return resume;
    }
}
