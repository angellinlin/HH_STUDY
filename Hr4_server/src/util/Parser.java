package util;

import model.Resume;
import model.ReturnResult;

import java.util.ArrayList;

public class Parser
{
	public Parser()
	{

	}
	static String[] amessage;
	static String head;
	static ReturnResult ss;
	static String message;
	public ReturnResult parser(String str)
	{
		/*
		 * 先按“/n”劈开得到想要的操作和操作数据
		 * if语句判断操作
		 * 把操作数据用相应的parser方法解析存到resumeList中
		 * 令ReturnResult的head=劈开得到的head
		 * 令ReturnResult的resultData等于resumeList
		 * */
		amessage=str.split("/n");
		head=amessage[0];
		message=amessage[1];
		ss=new ReturnResult();
		ss.setHead(head);
		if(head.equals("add"))
		{
			ArrayList<Resume> resumeList=parserAdd(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("deletebyname"))
		{
			ArrayList<Resume> resumeList=parserDeleteByName(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("deletebyid"))
		{
			ArrayList<Resume> resumeList=parserDeleteByid(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("change"))
		{
			ArrayList<Resume> resumeList=parserChangeresume(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("searchbyname"))
		{
			ArrayList<Resume> resumeList=parserSearchByName(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("searchbyid"))
		{
			ArrayList<Resume> resumeList=parserSearchByid(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("searchbyschool"))
		{
			ArrayList<Resume> resumeList=parserSearchByschool(message);
			ss.setResultData(resumeList);
		}
		else if(head.equals("searchbykeyword"))
		{
			ArrayList<Resume> resumeList=parserSearchByKeyWord(message);
			ss.setResultData(resumeList);
		}
		return ss;

	}
	/*
	 * “;”劈开得到resume的三个属性
	 * 	","劈开resume的三个属性存在resume中
	 * 最后都存在resumeList中返回
	 * * */
	public ArrayList<Resume> parserAdd(String message) {
		String[] str=message.split(",");
		String resumeName=str[0];
		String resumeid=str[1];
		String resumeschool=str[2];
		Resume resume=new Resume(resumeName,resumeid,resumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;

	}
	public ArrayList<Resume> parserDeleteByName(String message) {
		String resumeName=message;
		String resumeid=null;
		String resumeschool=null;
		Resume resume=new Resume(resumeName,resumeid,resumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;

	}
	public ArrayList<Resume> parserDeleteByid(String message) {
		String resumeName=null;
		String resumeid=message;
		String resumeschool=null;
		Resume resume=new Resume(resumeName,resumeid,resumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;

	}
	public ArrayList<Resume> parserChangeresume(String message) {
		String[] str=message.split(";");
		String[] oldresumemessage=str[0].split(",");
		String oldresumeName=oldresumemessage[0];
		String oldresumeid=oldresumemessage[1];
		String oldresumeschool=oldresumemessage[2];
		String[] resumemessage=str[1].split(",");
		String resumeName=resumemessage[0];
		String resumeid=resumemessage[1];
		String resumeschool=resumemessage[2];
		Resume oldresume=new Resume(oldresumeName,oldresumeid,oldresumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(oldresume);
		Resume resume=new Resume(resumeName,resumeid,resumeschool);
		resumeList.add(resume);
		return resumeList;
	}
	public ArrayList<Resume> parserSearchByName(String message) {
		String resumeName=message;
		String resumeid=null;
		String resumeschool=null;
		Resume resume=new Resume(resumeName,resumeid,resumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;

	}
	public ArrayList<Resume> parserSearchByid(String message) {
		String resumeid=message;
		Resume resume=new Resume(null,resumeid,null);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;

	}
	public ArrayList<Resume> parserSearchByschool(String message) {
		String resumeschool=message;
		Resume resume=new Resume(null,null,resumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;
	}
	public ArrayList<Resume> parserSearchByKeyWord(String message) {
		String resumeName=message;
		String resumeid=null;
		String resumeschool=null;
		Resume resume=new Resume(resumeName,resumeid,resumeschool);
		ArrayList<Resume> resumeList =new ArrayList<>();
		resumeList.add(resume);
		return resumeList;
	}

}
