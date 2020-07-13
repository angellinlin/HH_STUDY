package com.weihongyu.DAO.impl;

import com.weihongyu.DAO.ResumeDao;
import com.weihongyu.entity.Resume;
import com.weihongyu.util.JdbcUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: weihongyu
 * @Date: 2020/7/13 12:26
 * @Description:
 */
public class ResumeDaoImpl implements ResumeDao {

    private Connection conn = JdbcUtil.getConn();

    public void addResume(Resume resume) throws SQLException {
        String sql = "INSERT INTO resume (name, id, school, process, showStatus)"
                +"values(?,?,?,?,?)";

        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, resume.getName());
        ps.setString(2, resume.getId());
        ps.setString(3, resume.getSchool());
        ps.setInt(4, resume.getProcess());
        ps.setInt(5, resume.getShowStatus());

        ps.execute();

    }

    public void deleResumeByName(String name) throws SQLException {
        String sql = "delete from resume where name=?";

        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);

        ps.execute();
    }

    public void updateResumeByName(String name, Resume resume) throws SQLException {
        String sql = "update resume set name=?, id=?, school=?, process=?, showStatus=?" +
                " where name=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, resume.getName());
        ps.setString(2, resume.getId());
        ps.setString(3, resume.getSchool());
        ps.setInt(4, resume.getProcess());
        ps.setInt(5, resume.getShowStatus());
        ps.setString(6, name);

        ps.execute();
    }

    public Resume searchResumeByName(String name) throws SQLException {
        Resume resume = new Resume();
        String sql = "select * from resume where name=?";
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, name);

        ResultSet resultSet = ps.executeQuery();
        if (resultSet.next()){
            resume.setName(resultSet.getString("name"));
            resume.setId(resultSet.getString("id"));
            resume.setSchool(resultSet.getString("school"));
            resume.setProcess(resultSet.getInt("process"));
            resume.setShowStatus(resultSet.getInt("showStatus"));
        }

        return resume;
    }

    public List<Resume> getAll() throws SQLException {
        List<Resume> list = new ArrayList<>();
        String sql = "select * from resume";
        PreparedStatement ps = conn.prepareStatement(sql);

        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()){
            Resume resume = new Resume();
            resume.setName(resultSet.getString("name"));
            resume.setId(resultSet.getString("id"));
            resume.setSchool(resultSet.getString("school"));
            resume.setProcess(resultSet.getInt("process"));
            resume.setShowStatus(resultSet.getInt("showStatus"));
            list.add(resume);
        }

        return list;
    }
}
