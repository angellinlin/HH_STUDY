package dao;

import bean.Employee;
import util.DBConnection;

import java.awt.print.Book;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * @Author LeiPeng
 * @Date 2020/7/13 - 12:46
 */
public class EmployeeDao {
    //添加员工方法。
    public int addEmp(Employee employee) {
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql =
                    "insert into tb_employee(name, gender, phone, email, edu_background, stage, status) values('" + employee.getName() +
                            "','" + employee.getGender() + "'," + "'" + employee.getPhone() + "','" + employee.getEmail() + "', '" + employee.getEduBackGround() +
                            "', '" + employee.getStage() + "')";
            line = statement.executeUpdate(sql);
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return line;
    }

    //删除员工方法
    public int deleteEmpByName(String name) {
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String stringSql = "delete from tb_employee where name = '" + name + "'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return line;
    }

    public int updateEmp(Employee employee) {
        int line = 0;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String stringSql =
                    "UPDATE tb_employee SET gender = '" + employee.getGender() + "', phone='" + employee.getPhone() +
                            "',email='" + employee.getEmail() + "',edu_background='" + employee.getEduBackGround() +
                            "',stage='" + employee.getStage() + "'WHERE  name= '" + employee.getName() + "'";
            line = statement.executeUpdate(stringSql);
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return line;
    }

    public Employee searchEmpByName(String name) {
        Employee employee = null;
        try {
            Connection conn = DBConnection.getConnection();
            Statement statement = conn.createStatement();
            String sql = "select * from tb_employee where name='" + name + "'";
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                employee = new Employee(rs.getString("name"), rs.getString("gender"),
                        rs.getString("phone"), rs.getString("email"), rs.getInt("edu_backGround"),
                        rs.getInt("stage"));
            }
            DBConnection.closeConnection(null, statement, conn);
        } catch (SQLException e) {
            System.out.println("SQL Exception:" + e.toString());
        }
        return employee;
    }
}
