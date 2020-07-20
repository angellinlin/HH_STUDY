/**
 * A program for JAVA-LOWBHRSystem
 * @version 1.0 2020-07-06
 * @author Kan Wang
 */

package service;
import pojo.*;
import operation.dataOperate;
import database.dataBaseConnection;

import java.sql.SQLException;
import java.util.*;
import java.io.*;
import java.sql.*;

public class PersonService {

    public static void createTable(connector con){

        con.ps = null;
        String sql = "CREATE TABLE IF NOT EXISTS person (name VARCHAR(10), sex VARCHAR(2), nation VARCHAR(20), " +
                "phone VARCHAR(20), email VARCHAR(20));";
        try{
            con.ps = con.con.prepareStatement(sql);
            con.ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    public static returnResult addPerson(connector con, Resume resume){

        returnResult rr = new returnResult();
        con.ps = null;
        String sql = "INSERT INTO person VALUES ('"+resume.name+"', '"+resume.sex+"', '"+resume.nation+"', '"+resume.phone+"', '"+resume.email+"');";

        try{
            con.ps = con.con.prepareStatement(sql);
            int num = con.ps.executeUpdate();

            if(num > 0){
                rr.state = "Success";
                rr.failReason = null;
                rr.record = "您已添加" + num + "条人员信息";
            }
            else{
                rr.state = "Failure";
                rr.failReason = "未知的错误!";
                rr.record = null;
            }
        }
        catch(SQLException e){
            rr.state = "Failure";
            rr.failReason = "MySQL语句add添加失败";
            rr.record = null;
            e.printStackTrace();
        }
        return rr;
    }


    public static returnResult deletePerson(connector con, Resume resume){

        boolean flag = lookUpTable(con, resume.name, resume.phone);
        returnResult rr = new returnResult();

        if(flag) {
            String sql = "DELETE FROM person WHERE name = '" + resume.name + "' AND phone = '" + resume.phone + "';";

            try {
                con.ps = con.con.prepareStatement(sql);
                int num = con.ps.executeUpdate();

                if(num > 0){
                    rr.state = "Success";
                    rr.failReason = null;
                    rr.record = "您已删除" + num + "条人员信息";
                }
                else{
                    rr.state = "Failure";
                    rr.failReason = "未知的错误!";
                    rr.record = null;
                }
            } catch (SQLException e) {
                rr.state = "Failure";
                rr.failReason = "MySQL语句delete删除失败";
                rr.record = null;
                e.printStackTrace();
            }
        }
        else{
            rr.state = "Failure";
            rr.failReason = "未找到相关人员信息，请重新输入！";
            rr.record = null;
        }
        return rr;
    }


    public static returnResult updatePerson(connector con, Resume oldResume, Resume resume){

        boolean flag = lookUpTable(con, oldResume.name, oldResume.phone);
        returnResult rr = new returnResult();

        if(flag) {

            String sql = "UPDATE person SET name = '"+resume.name+"', sex = '"+resume.sex+"', nation = '"+resume.nation+"', " +
                    "phone = '"+resume.phone+"', email = '"+resume.email+"' WHERE name = '"+oldResume.name+"' AND " +
                    "phone = '"+oldResume.phone+"';";

            try {
                con.ps = con.con.prepareStatement(sql);
                int num = con.ps.executeUpdate();

                if(num > 0){
                    rr.state = "Success";
                    rr.failReason = null;
                    rr.record = "您已更新" + num + "条人员信息";
                }
                else{
                    rr.state = "Failure";
                    rr.failReason = "未知的错误!";
                    rr.record = null;
                }

            } catch (SQLException e) {
                rr.state = "Failure";
                rr.failReason = "MySQL语句update更新失败";
                rr.record = null;
                e.printStackTrace();
            }
        }
        else{
            rr.state = "Failure";
            rr.failReason = "未找到相关人员信息，请重新输入！";
            rr.record = null;
        }
        return rr;
    }

    public static returnResult showPerson(connector con, Resume resume)  {

        boolean flag = lookUpTable(con, resume.name, resume.phone);
        returnResult rr = new returnResult();

        if(flag) {
            try {
                rr.state = "Success";
                rr.record = con.rs.getString(1) + " " + con.rs.getString(2) + " "
                        + con.rs.getString(3) + " " + con.rs.getString(4) + " " +
                        con.rs.getString(5);
                rr.failReason = null;

            }
            catch (SQLException e) {
                rr.state = "Failure";
                rr.failReason = "MySQL语句select查询失败";
                rr.record = null;
                e.printStackTrace();
            }
        }
        else{
            rr.state = "Failure";
            rr.failReason = "未找到相关人员信息，请重新输入！";
            rr.record = null;
        }
        return rr;
    }

    public static boolean lookUpTable(connector con, String name, String phone){

        String sql = "SELECT * FROM person WHERE name = '"+name+"' AND phone = '"+phone+"';";
        try{
            con.ps = con.con.prepareStatement(sql);
            con.rs = con.ps.executeQuery(sql);

            if(con.rs.next()){
                return true;
            }
            else{
                return false;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
