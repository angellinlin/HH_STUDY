package net;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import Operator.ServerThread;

public class Server {

	static ServerSocket ss;
	Socket tcpConnection ;
	public Server()
	{
		try {
			ss = new ServerSocket(1235);
			System.out.println("�����������ˣ��ȴ��ͻ�������...");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{
			
			try {
				tcpConnection = ss.accept();//���µ�Client����
				System.out.println("�пͷ�����������");
				ServerThread r = new ServerThread(tcpConnection);//�����µ��߳�
				//ÿ��һ��Ů���֣��Ҷ�Ҫ�½�һ������գ���ʵ�ǳ�����Դ�ģ�����ս����Ů���ֹ������� �ֶ��������ɱ��
				//�̳߳�=���
				r.start();//�����߳�
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Server();
	}

}

