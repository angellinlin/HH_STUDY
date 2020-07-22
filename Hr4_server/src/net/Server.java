package net;

import Operator.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


	static ServerSocket  ss;
	Socket tcpConnection ;
	public Server()
	{
		try {
			ss = new ServerSocket(1235);
			System.out.println("服务器启动了，等待客户端连接...");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true)
		{

			try {
				tcpConnection = ss.accept();
				System.out.println("有客服端连接上了");
				ServerThread r=new ServerThread(tcpConnection);

				r.start();
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

