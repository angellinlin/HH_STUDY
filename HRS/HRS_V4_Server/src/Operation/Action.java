package Operation;

import Resume.Resume;
import database.DBConnection;
import util.ReturnResult;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Action {
    /*根据相应的操作，向数据库传送对应的sql语句
     * */

    //添加简历操作
    public ReturnResult addResume(Resume resume) {
        ReturnResult rr = new ReturnResult();
        int count = 0;
        try {
            //连接数据库
            Connection conn = DBConnection.getConnection();
            //定义添加语句sql
            String sql = "insert into resume values('" + resume.getName() + "','" + resume.getSchool() + "','" + resume.getId() + "','" + resume.getEmail() + "')";
            //获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //执行sql
            count = stmt.executeUpdate(sql);
            DBConnection.closeConnection(conn, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (count > 0) {
            rr.isSuccess = "Success";
        } else {
            rr.isSuccess = "false";
            rr.failReason = "unknow error";
        }
        return rr;
    }

    //删除简历操作
    public ReturnResult deleteResume(Resume resume) {
        ReturnResult rr = new ReturnResult();
        int count = 0;
        try {
            //连接数据库
            Connection conn = DBConnection.getConnection();
            //定义添加语句sql
            String sql = "delete from resume where id= '" + resume.getId() + "'";
            //获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //执行sql
            count = stmt.executeUpdate(sql);
            DBConnection.closeConnection(conn, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (count > 0) {
            rr.isSuccess = "Success";
        } else {
            rr.isSuccess = "false";
            rr.failReason = "没有找到该人员简历！";
        }
        return rr;
    }

    //修改简历信息
    public ReturnResult modifyResume(Resume preResume, Resume resume) {
        ReturnResult rr = new ReturnResult();
        int count = 0;
        try {
            //连接数据库
            Connection conn = DBConnection.getConnection();
            //定义添加语句sql
            String sql = "update resume set name='" + resume.getName() + "',school='" + resume.getSchool() + "',id='" + resume.getId() + "',email='" + resume.getEmail() + "' where id='" + preResume.getId() + "'";
            //获取执行sql的对象 Statement
            Statement stmt = conn.createStatement();
            //执行sql
            count = stmt.executeUpdate(sql);
            DBConnection.closeConnection(conn, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (count > 0) {
            rr.isSuccess = "Success";
        } else {
            rr.isSuccess = "false";
            rr.failReason = "没有找到该人员简历！";
        }
        return rr;
    }

    //查询简历
    public ReturnResult searchResume(String resumeId) {
        ReturnResult rr = new ReturnResult();
        List<Resume> applicants = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from resume where id= '" + resumeId + "'";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Resume applicant = new Resume(rs.getString("name"), rs.getString("school"),
                        rs.getString("id"), rs.getString("email"));
                applicants.add(applicant);
            }
            DBConnection.closeConnection(rs, conn, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (applicants.size() > 0) {
            rr.isSuccess = "Success";
            rr.resultData = applicants.get(0);
        } else {
            rr.isSuccess = "false";
            rr.failReason = "没有找到该人员简历！";
        }
        return rr;
    }

    //查询全部人员的简历
    public ReturnResult searchAllResume() {
        ReturnResult rr = new ReturnResult();
        List<Resume> applicants = new ArrayList<>();
        try {
            Connection conn = DBConnection.getConnection();
            Statement stmt = conn.createStatement();
            String sql = "select * from resume";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Resume applicant = new Resume(rs.getString("name"), rs.getString("school"),
                        rs.getString("id"), rs.getString("email"));
                applicants.add(applicant);
            }
            DBConnection.closeConnection(rs,conn, stmt);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        if (applicants.size() > 0) {
            rr.isSuccess = "Success";
            rr.resultData = applicants;
        } else {
            rr.isSuccess = "false";
            rr.failReason = "没有找到该人员简历！";
        }
        return rr;
    }
}
