package service;

import DBConnection.DBConnection;
import model.Resume;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/*mysql.hrsys.resume:
 * create table resume(
 * id varchar(255) not null,
 * name varchar(255) default null,
 * school varchar(255) default null,
 * process int(11) default null,
 * primary key(id)
 * )engine=innodb default charset=utf8;
 * */
public class DBCRUDImpl implements DBCRUDService {
    String sqlAdd = "insert into resume value(?,?,?,?)";
    String sqlDelete = "delete from resume where id= ?";
    String sqlUpdate = "update resume set id=?,name=?,school=?,process=? where id=?";
    String sqlGet = "select * from resume where %s=?";/*placeholder can only replace value-type*/
    String sqlFuzzyByName="select * from resume where name like ?";
    String sqlQuery = "select * from resume";
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public DBCRUDImpl() {
        conn = DBConnection.getConnection();
    }

    public boolean addEntity(Resume resume) {
        try {
            ps = conn.prepareStatement(sqlAdd);
            ps.setString(1, resume.getId()); /*Resume Id,String - varchar(255),Primary Key,not null*/
            ps.setString(2, resume.getName());/*Resume Name,String - varchar(255),default null*/
            ps.setString(3, resume.getSchool());/*Resume Id,String - varchar(255),default null*/
            ps.setInt(4, resume.getProcess());/*Resume Id,String - varchar(255),default null*/
            ps.executeUpdate();
            System.out.println("Server：添加简历成功");
        } catch (SQLException e) {
            System.out.println("Server：添加简历异常：" + e.toString());
            return false;
        }
        return true;
    }

    public boolean deleteEntity(String deleteId) {
        try {
            ps = conn.prepareStatement(sqlDelete);
            ps.setString(1, deleteId);
            int line=ps.executeUpdate();
            System.out.println(line>0?"Server：删除简历成功":"Server：删除失败：未找到该简历");
            return line>0?true:false;
        } catch (SQLException e) {
            System.out.println("Server：删除简历异常：" + e.toString());
            return false;
        }
    }

    public boolean updateEntity(Resume resume) {
        try {
            ps = conn.prepareStatement(sqlUpdate);
            ps.setString(1, resume.getId());
//            System.out.println("请依次修改【简历】的姓名，身份证号学校，简历状态");
//            Scanner input = new Scanner(System.in);
            ps.setString(2, resume.getName());
            ps.setString(3, resume.getSchool());
            ps.setInt(4, resume.getProcess());
            ps.setString(5, resume.getId());
            ps.executeUpdate();
            System.out.println("Server：修改简历成功");
        } catch (SQLException e) {
            System.out.println("Server：修改简历异常：" + e.toString());
            return false;
        }
        return true;
    }

    public ArrayList<Resume> getEntityListByKey(int cond,String key) {
        if (cond == 0) return getEntityList();/*cond==0:query all*/

        if(cond==5) return getEntityListFuzzy(key);
        ArrayList<Resume> rlist = new ArrayList<Resume>();
        String matchStr = cond == 1 ? "id" : cond == 2 ? "name" : cond == 3 ? "school" : cond == 4 ? "process" : "id";
        try {
            ps = conn.prepareStatement(String.format(sqlGet, matchStr));
            ps.setString(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resume r = new Resume(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                rlist.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Server：查找简历异常：" + e.toString());
        }
        return rlist;
    }

    public ArrayList<Resume> getEntityList() {
        ArrayList<Resume> rlist = new ArrayList<Resume>();
        try {
            ps = conn.prepareStatement(sqlQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                Resume r = new Resume(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                rlist.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Server：查找简历异常：" + e.toString());
        }
        return rlist;
    }

    public ArrayList<Resume> getEntityListFuzzy(String matchStr) {
        ArrayList<Resume> rlist = new ArrayList<Resume>();
        try {
            ps = conn.prepareStatement(sqlFuzzyByName);
            ps.setString(1, "%"+matchStr+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                Resume r = new Resume(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4));
                rlist.add(r);
            }
        } catch (SQLException e) {
            System.out.println("Server：查找简历异常：" + e.toString());
        }
        return rlist;
    }
    public void close() {
        DBConnection.closeConnection(rs, ps, conn);
    }
}
