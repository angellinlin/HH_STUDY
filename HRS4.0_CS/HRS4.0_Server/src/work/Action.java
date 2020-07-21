package work;

import database.DBConnection;
import model.ActionResult;
import model.Resume;
import model.ResumeList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Action {

    public Connection connection = null;

    public void closeStatement(Statement statement){
        DBConnection.closeConnection(null,statement,null);
    }

    public void closeStatementAndResultSet(Statement statement, ResultSet resultSet){
        DBConnection.closeConnection(null,statement,resultSet);
    }

    public void closeConnection(){
        DBConnection.closeConnection(connection,null,null);
    }

    public Action(){
        connection = DBConnection.getConnection();
        assert connection != null;  //断言，判断数据库连接上
        System.out.println("服务器已连接数据库！");
    }

    //查询所有简历
    public ActionResult selectAll(){
        ResumeList resumeList = new ResumeList();
        ActionResult actionResult = new ActionResult();

        String sqlExpr = String.format("select * from resume where deleteStatus='1'");
        Statement statement = null;
        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlExpr);
            while (resultSet.next()){
                Resume resume = new Resume(resultSet.getString("name"),resultSet.getString("id"),resultSet.getString("school"),
                        resultSet.getString("status"),resultSet.getString("deleteStatus"));
                resumeList.add(resume);
            }
            closeStatementAndResultSet(statement,resultSet);
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }

        if (resumeList.size() > 0){
            actionResult.isSuccess = "Success";
            actionResult.resultData = resumeList;
        }else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "简历库尚未收录简历";
        }
        return actionResult;
    }

    //通过id查询简历
    public ActionResult selectById(String id){
        ActionResult actionResult = new ActionResult();
        Resume resume = null;
        String sqlExpr = String.format("select * from resume where id=\"%s\" and deleteStatus='1'", id);
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlExpr);
            while (resultSet.next()){
                resume = new Resume(resultSet.getString("name"),resultSet.getString("id"),resultSet.getString("school"),
                        resultSet.getString("status"),resultSet.getString("deleteStatus"));
            }
        } catch (SQLException e) {
            System.out.println("SQL Exception: " + e.toString());
        }
        if (resume != null){
            actionResult.isSuccess = "Success";
            actionResult.resultData = resume;
        }else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "没有找到该简历";
        }
        return actionResult;
    }

    //增加简历
    public ActionResult addResume(Resume resume){
        int line = 0;
        ActionResult actionResult = new ActionResult();

        ActionResult actionResult1 = selectById(resume.getId());
        if (!actionResult1.isSuccess.equals("Success")){
            String sqlExpr = String.format("insert into resume (name, id, school, status, deleteStatus) values (\"%s\", \"%s\", \"%s\", \"%s\", \"%s\")",
                    resume.getName(), resume.getId(), resume.getSchool(), resume.getStatus(), resume.getDeleteStatus());
            try {
                Statement statement = connection.createStatement();
                line = statement.executeUpdate(sqlExpr);
                closeStatement(statement);
            } catch (SQLException e) {
                System.out.println("SQL Exception: "+e.toString());
            }

            if (line > 0){
                actionResult.isSuccess = "Success";
            }else {
                actionResult.isSuccess = "Failed";
                actionResult.failReason = "unknown error";
            }
        }else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "简历id已存在";
        }
        return actionResult;
    }

    //通过id删除简历
    public ActionResult deleteResume(String id){
        int line = 0;
        ActionResult actionResult = new ActionResult();

        String sqlExpr = String.format("update resume set deleteStatus = '0' where id =\"%s\" and deleteStatus = '1'",id);
        try {
            Statement statement = connection.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (line > 0) {
            actionResult.isSuccess = "Success";
        }
        else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "没有找到该简历,删除失败";
        }
        return actionResult;
    }

    //通过id修改简历
    public ActionResult updateResumeById(ResumeList resumeList){
        int line = 0;
        ActionResult actionResult = new ActionResult();
        String sqlExpr = String.format("update resume set name=\"%s\", id=\"%s\", school=\"%s\", status=\"%s\" where id=\"%s\" and deleteStatus = '1'",
                resumeList.get(1).getName(), resumeList.get(1).getId(), resumeList.get(1).getSchool(),resumeList.get(1).getStatus(),
                resumeList.get(0).getId());
        try {
            Statement statement = connection.createStatement();
            line = statement.executeUpdate(sqlExpr);
            closeStatement(statement);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (line > 0) {
            actionResult.isSuccess = "Success";
        }
        else {
            actionResult.isSuccess = "Failed";
            actionResult.failReason = "没有找到该简历，修改失败";
        }
        return actionResult;
    }
}
