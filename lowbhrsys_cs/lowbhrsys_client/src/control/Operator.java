package control;

import model.Resume;
import model.ReturnResult;
import net.Client;
import util.Parser;
import util.Protocol;

public class Operator {
	Client client;
	public Operator(Client client){
		this.client = client;
//		if (client == null)
//			client = new Client();

	} 
	/*
	 * ģʽ
	 * �Ѵ�������book�ŵ�Protocol�б�дЭ��
	 * �ѵõ���Э��ͨ��Client���sendMessageToSever������Э�飨�ַ��������͵�������
	 * �ѷ��������ص�Э�飨Ҳ���ַ�����parser ���� �����󷵻�ReturnResult���ͽ��
	 * �ѽ���ڷ��ظ��������
	 * */

	public ReturnResult addResume(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.AddResumeMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteResumeByName(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteResumeByNameMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult deleteResumeById(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.deleteResumeByIdMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult changeResume(Resume resume, Resume oldResume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.changeResumeMessage(resume,oldResume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserCRUD(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByName(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByNameMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchById(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByIdMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchBySchool(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeBySchoolMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByProcess(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByProcessMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult searchByKeyWord(Resume resume)
	{
		Protocol protocol = new Protocol();
		String message = protocol.searchResumeByKeyWordMessage(resume);
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public ReturnResult listAllResumeInfo()
	{
		Protocol protocol = new Protocol();
		String message = protocol.listAllResumeInfoMessage();
		String returnMessage = client.sendMessageToSever(message);
		Parser parser = new Parser();
		ReturnResult returnResult = parser.parserSearch(returnMessage);
		return returnResult;
	}
	public void closeNet(String str)
	{
		String returnMessage = client.sendMessageToSever(str);
		client.closeClient();
	}

}
