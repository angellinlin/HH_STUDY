package work;

import database.DBConnection;

import model.ActionResult;
import model.Resume;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Action
{
	/*
	 * 根据相应的操作向数据库传送SQL语句
	 * 通过数据库返回的受影响行数（line）和（boolean）判断操作是否成功
	 * line>0或者boolean=true为成功 令ar.isSuccess="Success
	 * 查询图书的话令ActionResult.resultData=resumeList;
	 *  反之false 并设置ActionResult.failReason
	 *
	 * */
	//添加图书方法。
	public ActionResult addresume(Resume resume)
	{
		int line = 0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql = "insert into resume1 values('"+resume.getName()+"','"+resume.getId()+"','"+resume.getSchool()+"')";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("unknow error");
		}
		return ar;
	}
	//删除图书方法。
	public ActionResult deleteresumeByName(Resume resume)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from resume1 where name = '"+resume.getName()+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}

		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("没有找到该学生");
		}


		return ar;
	}
	public ActionResult deleteresumeByid(Resume resume)
	{
		int line=0;
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn = DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String stringSql ="delete from resume1 where id = '"+resume.getId()+"'";
			line=statement.executeUpdate(stringSql);
			DBConnection.closeConnection(null,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("没有找到该学生");
		}


		return ar;
	}
	//修改图书方法。
	public ActionResult changeresume(Resume resume,Resume oldresume)
	{
			int line=0;
			ActionResult ar=new ActionResult();
		try
			{
				Connection conn = DBConnection.getConnection();
				Statement statement =conn.createStatement();
				String stringSql ="UPDATE resume1 SET name = '"+resume.getName()+"', id='"+resume.getId()+"',school='"+resume.getSchool()+"' WHERE  name= '"+oldresume.getName()+"'";
				line=statement.executeUpdate(stringSql);
				DBConnection.closeConnection(null,statement,conn);
			}
		catch(SQLException e)
			{
				System.out.println("SQL Exception:"+e.toString());
			}
		if(line>0)
		{
			ar.setIsSuccess("Success");
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("没有找到该学生");
		}

		return ar;
	}
	//查询图书方法。
	public  ActionResult searchresumeByName(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where name='"+resume.getName()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到resumeList的操作
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int resumesize=resumeList.size();

		if(resumesize>0)
		{
			ar.setIsSuccess("Success");
			ar.setResultData(resumeList);
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("没有找到该学生");
		}


		return ar;

	}
	public  ActionResult searchresumeByid(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
		ActionResult ar=new ActionResult();
		try
		{

			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where id='"+resume.getId()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到resumeList的操作
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		int resumesize=resumeList.size();
		if(resumesize>0)
		{
			ar.setIsSuccess("Success");
			ar.setResultData(resumeList);
		}
		else
		{
			ar.setIsSuccess("false");
			ar.setFailReason("没有找到该学生");
		}
		return ar;
	}
	public  ActionResult searchresumeByschool(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
			ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where school='"+resume.getSchool()+"'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到resumeList的操作
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumesize=resumeList.size();
			if(resumesize>0)
			{
				ar.setIsSuccess("Success");
				ar.setResultData(resumeList);
			}
			else
			{
				ar.setIsSuccess("false");
				ar.setFailReason("没有找到该学生");
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
	public  ActionResult searchresumeByPointword(Resume resume)
	{
		ArrayList<Resume> resumeList =new ArrayList<>();
		ActionResult ar=new ActionResult();
		try
		{
			Connection conn =  DBConnection.getConnection();
			Statement statement =conn.createStatement();
			String sql = "select * from resume1 where name like '%"+resume.getName()+"%'";
			ResultSet rs = statement.executeQuery(sql);
			//把查询结果放到resumeList的操作
			while(rs.next())
			{
				Resume aresume=new Resume(rs.getString(1),rs.getString(2),rs.getString(3));
				resumeList.add(aresume);
			}
			DBConnection.closeConnection(rs,statement,conn);
			int resumesize=resumeList.size();
			if(resumesize>0)
			{
				ar.setIsSuccess("Success");
				ar.setResultData(resumeList);
			}
			else
			{
				ar.setIsSuccess("false");
				ar.setFailReason("没有找到该学生");
			}
		}
		catch(SQLException e)
		{
			System.out.println("SQL Exception:"+e.toString());
		}
		return ar;
	}
}
