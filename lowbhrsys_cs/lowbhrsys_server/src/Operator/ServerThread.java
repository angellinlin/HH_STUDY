package Operator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

import medol.ActionResult;
import medol.Resume;
import medol.ResumeList;
import medol.ReturnResult;
import util.Parser;
import util.Protocol;
import work.Action;

public class ServerThread extends Thread
{
	Socket connection;
	static BufferedReader in;
	static PrintWriter out;
	static String str;
	public ServerThread(Socket connection)
	{
		this.connection = connection;
	}
	@Override
	public void run()
	{
		while(true)
		{
			/*
			 * ��Server�е�getMessageByClient�����õ�Э�飨�ַ�����
			 * ��Э�飨�ַ������ŵ�parser����� ���صõ�ReturnResult������head�������������ԣ����ͽ��
			 * if����ж�head��Ϣ�õ��û��������ʲô����
			 * ��ReturnResult��dataת��ΪbookList�Ӷ��õ�Book
			 * �ѵõ���Book����Action�����������ݿ������ɾ�Ĳ�Ĳ���������ActionResult�������Ƿ�ɹ� ��ʧ��Ը�� ���ɹ�����������ԣ����ͽ��
			 * ��ActionResult����Protocol�б�дЭ�飨�ַ�����������
			 * ��Server�е�sendMessageToClient������Э�飨�ַ��������͵��ͻ���
			 * �������������ϢΪ"bye"�رշ���������while
			 * */
			try {
				 in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				 out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(connection.getOutputStream())),true);
				 str = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if(str.equals("bye"))
			{
				try {
					out.println("bye");
					in.close();
					out.close();
					connection.close();
					break;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else if(str.equals("listallinfo")){
				Action a = new Action();
				ActionResult ar = new ActionResult();
				ar = a.listAllInfo();
				Protocol protocol = new Protocol();
				String message = protocol.searchResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
				break;
			}
			else
			{
			Parser parser = new Parser();
			ReturnResult ss = parser.parser(str);
			ActionResult ar = new ActionResult();
			if(ss.head.equals("add"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.addResume(resume);
				Protocol protocol = new Protocol();
				String message = protocol.CRUDResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}		
			else if(ss.head.equals("deletebyname"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.deleteResumeByName(resume);
				Protocol protocol = new Protocol();
				String message = protocol.CRUDResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("deletebyid"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.deleteResumeById(resume);
				Protocol protocol = new Protocol();
				String message = protocol.CRUDResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);				
			}
			else if(ss.head.equals("change"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				Resume oldResume = resumeList.get(1);
				ar = a.changeResume(resume, oldResume);
				Protocol protocol = new Protocol();
				String message = protocol.CRUDResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("searchbyname"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.searchResumeByName(resume);
				Protocol protocol = new Protocol();
				String message = protocol.searchResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
				break;
			}
			else if(ss.head.equals("searchbyid"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.searchResumeById(resume);
				Protocol protocol = new Protocol();
				String message = protocol.searchResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("searchbyschool"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.searchResumeBySchool(resume);
				Protocol protocol = new Protocol();
				String message = protocol.searchResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("searchbyprocess"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.searchResumeByProcess(resume);
				Protocol protocol = new Protocol();
				String message = protocol.searchResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			else if(ss.head.equals("searchbykeyword"))
			{
				Action a = new Action();
				ResumeList resumeList = (ResumeList)ss.resultData;
				Resume resume = resumeList.get(0);
				ar = a.searchResumeByPointWord(resume);
				Protocol protocol = new Protocol();
				String message = protocol.searchResumeMessage(ar);
				System.out.println("��ͻ��˷��أ�   "+message);
				out.println(message);
			}
			}

		}
	}

}
