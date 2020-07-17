package bean;

import JDBC.MySQLConnect;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PersistenceStorageInMySql {

    public void add() {
        System.out.println("进入人员添加界面");
        /**
         * 主 利用FileOutStream类 和 BufferReader类
         */
        try {
            System.out.println("请按照格式依次输入:姓名,ID,学校");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            String[] tempinfos = input.split(",|，");
            String tempName = tempinfos[0];
            int tempID = Integer.parseInt(tempinfos[1]);
            String tempSchool = tempinfos[2];
            People people = new People(tempName, tempID, tempSchool);

            if (!MySQLConnect.getConnection().isClosed()) {
//                Statement statement = MySQLConnect.getConnection().createStatement();
//                String sql = "insert into peoplelist (name,id,school) values (" + "'" + people.getPeopleName() + "'," + "'" + people.getId() + "'," + "'" + people.getSchool() + "'" + ")";

                // 预编译模式
                String sql = "insert into peoplelist(name,id,school) values(?,?,?)";
                PreparedStatement statement = MySQLConnect.getConnection().prepareStatement(sql);
                statement.setString(1, people.getPeopleName());
                statement.setInt(2, people.getId());
                statement.setString(3, people.getSchool());
                int resultSet = statement.executeUpdate();
                if (resultSet > 0) {
                    System.out.println("信息添加成功！");
                    System.out.println("添加信息人员:" + people.getPeopleName() + people.getId() + people.getSchool());
                } else {
                    System.out.println("信息添加失败！");
                    add();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void delete() {
        System.out.println("进入信息删除界面");

        String newInfo = "";
        try {
            System.out.println("请输入删除人员ID");
            Scanner scanner = new Scanner(System.in);
            int deleteID = scanner.nextInt();

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
            delete();
            e.printStackTrace();
        }
    }

    // 待修改
    public void change() {
        System.out.println("进入信息修改界面");

        try {
            System.out.println("请输入修改信息");
            Scanner scanner = new Scanner(System.in);
            String strs = scanner.nextLine();
            String[] tempinfos = strs.split(",|，");
            String tempName = tempinfos[0];
            int tempID = Integer.parseInt(tempinfos[1]);
            String tempSchool = tempinfos[2];
            People people = new People(tempName, tempID, tempSchool);

            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();
                String sql = "update peoplelist set name=" + "'" + people.getPeopleName() + "'," + "id=" + people.getId() + "," + "school=" + "'" + people.getSchool() + "'";
                int resultSet = statement.executeUpdate(sql);
                if (resultSet > 0) {
                    System.out.println("信息修改成功！");
                } else {
                    System.out.println("信息修改失败！");
                }
            }
        } catch (SQLException e) {
            System.out.println("格式输入错误,请重新输入");
            change();
            e.printStackTrace();
        }

    }

    public void search() {
        System.out.println("查询所有人员请输入 Y " + "," + "或直接输入人员 ID");
        Scanner input = new Scanner(System.in);
        String key = input.nextLine();
        if (key.equals("Y")) {
            readInfo();
        } else if (Integer.valueOf(key) > 0) {
            System.out.println("指定人员查询");
            readInfo(Integer.valueOf(key));
        } else {
            System.out.println("查询输入错误,请重新输入");
        }
    }

    // 重载两个不同参数方法,实现两种类型的查询
    // 所有数据遍历
    public void readInfo() {

        try {

            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();

                String sql = "select * from peoplelist";
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String Name = resultSet.getString("name");
                    String ID = resultSet.getString("id");
                    String School = resultSet.getString("school");
                    System.out.println("查询信息为：\t" + Name + "," + ID + "," + School);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    // 指定类型查询
    public void readInfo(int peopleID) {

        try {
            if (!MySQLConnect.getConnection().isClosed()) {
                Statement statement = MySQLConnect.getConnection().createStatement();

                String sql = "select * from peoplelist where id=" + peopleID;
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    String Name = resultSet.getString("name");
                    String ID = resultSet.getString("id");
                    String School = resultSet.getString("school");
                    System.out.println("查询信息为：\t" + Name + "," + ID + "," + School);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
