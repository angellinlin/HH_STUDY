package util;

import model.ActionResult;
import model.Resume;

import java.util.ArrayList;

public class Protocol {
	public Protocol()
	{

	}
	/*
	 * 把ActionResult的三个属性按ActionResult.isSuccess+"/n"+failReason或者ActionResult.isSuccess+"/n"+（ActionResult.resultData
	 * 得到的字符串）格式编写
	 * 在for循环里得到ActionResult.resultData的字符串
	 * */
	public String AddresumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String deleteresumeByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String deleteresumeByidMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String changeresumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			str=isSuccess+"/n";
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String searchresumeByNameMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String searchresumeByidMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
	public String searchresumeByschoolMessage(ActionResult ar)
	{
		String str;

		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;

	}
	public String searchresumeByKeyWordMessage(ActionResult ar)
	{
		String str;
		String isSuccess=ar.getIsSuccess();
		if(isSuccess.equals("Success"))
		{
			ArrayList<Resume>  resumeArrayList=(ArrayList<Resume> )ar.getResultData();
			str=isSuccess+"/n";
			//for循环得到ActionResult.resultData字符对应的字符串
			int resumesize=resumeArrayList.size();
			for(int i=0;i<resumesize;i++)
			{
				String resumestring=resumeArrayList.get(i).getName()+","+resumeArrayList.get(i).getSchool()+","+resumeArrayList.get(i).getId()+";";
				str=str+resumestring;
			}
		}
		else
		{
			str=isSuccess+"/n"+ar.getFailReason();
		}
		return str;
	}
}
