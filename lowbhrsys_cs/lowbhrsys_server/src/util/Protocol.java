package util;

import medol.ActionResult;
import medol.ResumeList;

public class Protocol {
	public Protocol()
	{
		
	}
	/*
	 * ��ActionResult���������԰�ActionResult.isSuccess+"/n"+failReason����ActionResult.isSuccess+"/n"+��ActionResult.resultData
	 * �õ����ַ�������ʽ��д
	 * ��forѭ����õ�ActionResult.resultData���ַ���
	 * */
	public String CRUDResumeMessage(ActionResult ar)
	{	
		String str;
		String isSuccess = ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			str = isSuccess+"/n";
		}
		else
		{
			str = isSuccess+"/n"+ar.failReason;
		}
		return str;
	}

	public String searchResumeMessage(ActionResult ar)
	{
		String str;
		String isSuccess = ar.isSuccess;
		if(isSuccess.equals("Success"))
		{
			ResumeList resumeList = (ResumeList)ar.resultData;
			str = isSuccess+"/n";
			//forѭ���õ�ActionResult.resultData�ַ���Ӧ���ַ���
			int resumeSize = resumeList.size();
			for(int i=0;i<resumeSize;i++)
			{
				String resumeString = resumeList.get(i).getName()+","+resumeList.get(i).getId()+","+
						resumeList.get(i).getSchool()+","+resumeList.get(i).getProcess()+";";
				str = str + resumeString;
			}
		}
		else
		{
			str = isSuccess+"/n"+ar.failReason;
		}
		return str;
	}
}
