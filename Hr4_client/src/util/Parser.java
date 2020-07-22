package util;

import model.Resume;
import model.ReturnResult;

import java.util.ArrayList;

public class Parser
{
	/**先以“/n”劈开得到是否成功和成功结果或者失败原因
	 * 如果失败 returnResult.isSuccess=false returnResult.failReason为劈开的第二部分
	 * 成功了returnResult.isSuccess=true
	 * 再以“;”劈开各本书
	 * 再以“，”劈开每本书的三个属性分别赋给Book存到BookList
	 * 再把BookList放到returnResult.resultData里
	 * 返回returnResult
	 * */
	public ReturnResult parserAdd(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
		}
		else
		{
			returnResult.setFailReason(amessage[1]);
		}
		return returnResult;
	}
	public ReturnResult parserDelete(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
		}
		else
		{
			returnResult.setFailReason(amessage[1]);
		}
		return returnResult;
	}
	public ReturnResult parserChange(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
		}
		else
		{
			returnResult.setFailReason(amessage[1]);
		}
		return returnResult;
	}
	public ReturnResult parserSearch(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] amessage=message.split("/n");
		if(amessage[0].equals("Success"))
		{
			returnResult.setIsSuccess(true);
			String[] bookinfo=amessage[1].split(";");
			ArrayList<Resume> bookList=new ArrayList<>();
			int bookSize=bookinfo.length;
			for(int i=0;i<bookSize;i++)
			{
				String[] Resume=bookinfo[i].split(",");
				String name=Resume[0];
				String id=Resume[1];
				String school=Resume[2];
				Resume resume=new Resume(name,id,school);
				bookList.add(resume);
			}
			returnResult.setResultData(bookList);
		}
		else
		{
			returnResult.setIsSuccess(false);
			ArrayList<Resume> bookList=new ArrayList<>();
			returnResult.setFailReason(amessage[1]);
			returnResult.setResultData(bookList);
		}
		return returnResult;
	}

}
