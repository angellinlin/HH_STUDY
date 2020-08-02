package bean;

import JDBC.MySQLConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PersistenceStorageInMySql {

    public String getRebackMsgToserver() {
        return rebackMsgToserver;
    }

    private String rebackMsgToserver = "";
    public void add(People peoplelist) {
        System.out.println("进入人员添加界面");

        try {
            System.out.println("请按照格式依次输入:姓名,ID,学校");
            if (!MySQLConnect.getConnection().isClosed()) {
//                Statement statement = MySQLConnect.getConnection().createStatement();
//                String sql = "insert into peoplelist (name,id,school) values (" + "'" + people.getPeopleName() + "'," + "'" + people.getId() + "'," + "'" + people.getSchool() + "'" + ")";

                // 预编译模式
                String sql = "insert into peoplelist(name,id,school) values(?,?,?)";
                PreparedStatement statement = MySQLConnect.getConnection().prepareStatement(sql);
                statement.setString(1, peoplelist.getPeopleName());
                statement.setInt(2, peoplelist.getId());
                statement.setString(3, peoplelist.getSchool());
                int resultSet = statement.executeUpdate();
                if (resultSet > 0) {
                    System.out.println("信息添加成功！");
                    System.out.println("添加信息人员:" + peoplelist.getPeopleName() +"," + peoplelist.getId() + "," +peoplelist.getSchool());
                } else {
                    System.out.println("信息添加失败！");
                    add(peoplelist);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete(int deleteID) {
        System.out.println("进入信息删除界面");
        System.out.println("删除人员ID为：" + deleteID);
        try {

            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();
                String sql = "delete from peoplelist where id=" + deleteID;
                boolean resultSet = statement.execute(sql);
                if (resultSet) {
                    System.out.println("信息删除完成");
                }
            }

        } catch (SQLException e) {
            System.out.println("格式输入错误,请重新输入");
            delete(deleteID);
            e.printStackTrace();
        }
    }

    public void change(People changepeoplelist) {
        System.out.println("进入信息修改界面,警告ID不可变！！！");
        System.out.println("修改信息为：" + changepeoplelist.getPeopleName() + "," + changepeoplelist.getId() + "," + changepeoplelist.getSchool());
        try {
            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();
                String sql = "update peoplelist set name= " + "'"+changepeoplelist.getPeopleName()+"'"+",school= "+"'"+changepeoplelist.getSchool()+"'" +" where id= "+changepeoplelist.getId();
                int resultSet = statement.executeUpdate(sql);
                if (resultSet > 0) {
                    System.out.println("信息修改成功！");
                } else {
                    System.out.println("信息修改失败！");
                }
            }
        } catch (SQLException e) {
            System.out.println("格式输入错误,请重新输入");
            change(changepeoplelist);
            e.printStackTrace();
        }
    }

    public void search(String message) {
        try {
            if (message.equals("Y")) {
                readInfo();
            } else if (Integer.valueOf(message) > 0) {
                System.out.println("查询人员ID:" + message);
                readInfo(Integer.valueOf(message));
            } else {
                System.out.println("查询输入错误,请重新输入");
            }
        } catch (Exception e) {
            e.printStackTrace();
            search(message);

        }

    }

    // 重载两个不同参数方法,实现两种类型的查询
    // 所有数据遍历
    public String readInfo() {
        try {

            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();

                String sql = "select * from peoplelist";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String Name = resultSet.getString("name");
                    String ID = resultSet.getString("id");
                    String School = resultSet.getString("school");
                    rebackMsgToserver += "查询信息为：" + Name + "," + ID + "," + School+";\t";
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rebackMsgToserver;
    }

    // 指定类型查询
    public String readInfo(int peopleID) {
        try {
            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();

                String sql = "select * from peoplelist where id=" + peopleID;
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String Name = resultSet.getString("name");
                    String ID = resultSet.getString("id");
                    String School = resultSet.getString("school");
                    rebackMsgToserver="查询信息为：" + Name + "," + ID + "," + School;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rebackMsgToserver;
    }
}
