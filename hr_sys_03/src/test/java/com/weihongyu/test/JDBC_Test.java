package com.weihongyu.test;

import com.weihongyu.DAO.ResumeDao;
import com.weihongyu.DAO.impl.ResumeDaoImpl;
import com.weihongyu.entity.Resume;
import org.junit.Test;

import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 14:04
 * @Description:测试JDBC增删改查
 */
public class JDBC_Test {

    private ResumeDao resumeDao = new ResumeDaoImpl();

    /**
     * @Description添加简历
     */
    @Test
    public void test() throws Exception{
        Resume resume = new Resume();
        resume.setName("小王");
        resume.setId("8899988755");
        resume.setSchool("电子科大222");
        resume.setShowStatus(1);
        resume.setProcess(1);

        resumeDao.addResume(resume);
    }

    /**
     * @Description获得所有简历
     */
    @Test
    public void test2() throws Exception{

        List<Resume> list = resumeDao.getAll();
        for (Resume resume : list) {
            System.out.println(resume);
        }
    }

    /**
     * @Description删除简历
     */
    @Test
    public void test3() throws Exception{
        resumeDao.deleResumeByName("小王");
    }

    /**
     * @Description更新简历
     */
    @Test
    public void test4() throws Exception{
        Resume resume = resumeDao.searchResumeByName("韦虹宇");

        resume.setSchool("郫县高级专科");

        resumeDao.updateResumeByName("韦虹宇", resume);
    }
}
