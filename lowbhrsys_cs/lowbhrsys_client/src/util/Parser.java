package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser 
{
	/**���ԡ�/n�������õ��Ƿ�ɹ��ͳɹ��������ʧ��ԭ��
	 * ���ʧ�� returnResult.isSuccess=false returnResult.failReasonΪ�����ĵڶ�����
	 * �ɹ���returnResult.isSuccess=true
	 * ���ԡ�;������������
	 * ���ԡ���������ÿ������������Էֱ𸳸�Book�浽BookList
	 * �ٰ�BookList�ŵ�returnResult.resultData��
	 * ����returnResult
	 * */
	public ReturnResult parserCRUD(String message)
	{
		ReturnResult returnResult = new ReturnResult();
		String[] aMessage=message.split("/n");
		if(aMessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
		}
		else
		{
			returnResult.failReason=aMessage[1];
		}
		return returnResult;
	}

	public ReturnResult parserSearch(String message)
	{  
		ReturnResult returnResult = new ReturnResult();
		String[] aMessage=message.split("/n");
		if(aMessage[0].equals("Success"))
		{
			returnResult.isSuccess = true;
			String[] resumeInfo=aMessage[1].split(";");
			ResumeList resumeList=new ResumeList();
			int resumeSize=resumeInfo.length;
			for(int i=0;i<resumeSize;i++)
			{
				String[] resumeSte = resumeInfo[i].split(",");
				String resumeName = resumeSte[0];
				String resumeId = resumeSte[1];
				String resumeSchool = resumeSte[2];
				int process = Integer.parseInt(resumeSte[3]);

				Resume resume = new Resume(resumeName,resumeId,resumeSchool,process);
				resumeList.add(resume);
			}
			returnResult.resultData=resumeList;
		}
		else
		{
			returnResult.isSuccess = false;
			ResumeList resumeList = new ResumeList();
			returnResult.failReason = aMessage[1];
			returnResult.resultData = resumeList;
		}
		return returnResult;
	}

}