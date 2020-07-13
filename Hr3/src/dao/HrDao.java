package dao;

import database.DBConnection;
import model.Resume;

import java.sql.*;
import java.util.ArrayList;

public class HrDao {
    public  int addResume(Resume resume){
        int line = 0;

        try
        {
            Connection conn =  DBConnection.getConnection();

            String sql = "insert into Resume values(?,?,?,?,?)";
            PreparedStatement pst =conn.prepareStatement(sql);
            pst.setString(1, resume.getName());
            pst.setString(2, resume.getId());
            pst.setString(3, resume.getSchool());
            pst.setInt(4, resume.getProcess());
            pst.setInt(5, resume.getDeleteStatus());
            line=pst.executeUpdate();
            DBConnection.closeConnection(null,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    public int deleteResumeByName(Resume resume) {
        int line = 0;

        try
        {
            Connection conn =  DBConnection.getConnection();

            String sql = "delete  from Resume where name=?";
            PreparedStatement pst =conn.prepareStatement(sql);
            pst.setString(1, resume.getName());
            line=pst.executeUpdate();
            DBConnection.closeConnection(null,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    public int updateByName(Resume resume1, Resume resume2) {


        int line = 0;

        try
        {
            Connection conn =  DBConnection.getConnection();

            String sql = "update Resume set name=?,id=?,school=? where name=?";
            PreparedStatement pst =conn.prepareStatement(sql);
            pst.setString(1, resume2.getName());
            pst.setString(2, resume2.getId());
            pst.setString(3, resume2.getSchool());
            pst.setString(4, resume1.getName());
            line=pst.executeUpdate();
            DBConnection.closeConnection(null,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return line;
    }

    public ArrayList<Resume> searchBookByName(Resume student) {
        ArrayList<Resume> resumeList=new ArrayList<Resume>();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where name=?";

            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1, student.getName());

            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }

    public ArrayList<Resume> searchBookById(Resume student) {
        ArrayList<Resume> resumeList=new ArrayList<Resume>();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where id=?";

            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1, student.getId());

            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }

    public ArrayList<Resume> searchBookBySchool(Resume student) {
        ArrayList<Resume> resumeList=new ArrayList<Resume>();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where school=?";

            PreparedStatement pst= conn.prepareStatement(sql);
            pst.setString(1, student.getSchool());

            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }

    public ArrayList<Resume> searchBookByKeyword(Resume student) {
        ArrayList<Resume> resumeList=new ArrayList<Resume>();
        try
        {
            Connection conn =  DBConnection.getConnection();
            String sql = "select * from resume where name like '%"+student.getName()+"%'";

            PreparedStatement pst= conn.prepareStatement(sql);

            ResultSet rs = pst.executeQuery();
            while(rs.next())
            {
                Resume resume=new Resume(rs.getString("name"),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getInt(5));
                resumeList.add(resume);
            }
            DBConnection.closeConnection(rs,pst,conn);
        }
        catch(SQLException e)
        {
            System.out.println("SQL Exception:"+e.toString());
        }
        return resumeList;
    }
}
