package operate;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.DBConnection;

public class ResumeOperate {

	// չʾ���м���
    public static void showResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		String sql = "select * from resume";
    		ResultSet rs = s.executeQuery(sql);
    		System.out.println("����"+'\t'+"���֤��"+'\t'+"ѧ��"+'\t'+"�绰��"+'\t'+"����״̬");
    		while (rs.next()) {
    			String name = rs.getString(1);
                String id = rs.getString("id");
                String eduction = rs.getString(3);
                String telephone = rs.getString(4);
                int process = rs.getInt(5);
                System.out.printf("%s\t%s\t%s\t%s\t%d%n", name, id, eduction, telephone, process);
            }
    		DBConnection.closeConnection(rs, s, c);
    	} catch(SQLException e){
    		e.printStackTrace();
    	}
    }
    
    //�鿴ָ������״̬�ļ���
    public static void showAppointResume() {
    	try {
    		ArrayList<Integer> datas = new ArrayList<>();
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		
    		Scanner sc=new Scanner(System.in);
        	boolean keepon=false;
        	ResultSet rs;
        	do {
        		System.out.println("*****������Ҫ��ѯ�ļ���״̬*****");
            	System.out.println("-1�������˲ſ�");
            	System.out.println("0��������");
            	System.out.println("1������ͨ��");
            	System.out.println("2������ͨ��");
            	System.out.println("3������ͨ��");
            	System.out.println("4�����ͨ��");
            	System.out.println("5������ͨ��");
            	System.out.println("6����ǩԼ");
            	System.out.println("7������ְ");
            	int k = sc.nextInt();
            	sc.nextLine();
            	boolean notexist=true;
            	String sql = "select * from resume";
        		rs = s.executeQuery(sql);
            	while (rs.next()) {
            		String name = rs.getString(1);
                    String id = rs.getString("id");
                    String eduction = rs.getString(3);
                    String telephone = rs.getString(4);
                    int process = rs.getInt(5);
                    if(k == process) {
            			notexist=false;
            			System.out.println("����"+'\t'+"���֤��"+'\t'+"ѧ��"+'\t'+"�绰��"+'\t'+"����״̬");
            			System.out.printf("%s\t%s\t%s\t%s\t%d%n", name, id, eduction, telephone, process);
            		}
                }
            	if(notexist)
            		System.out.println("�����ڸ�״̬�ļ���");
            	System.out.println("*****�Ƿ������ѯ����/��*****");
                if(sc.nextLine().equals("��"))
                	keepon=true;
                else
                	keepon=false;
        	}while(keepon);
        	DBConnection.closeConnection(rs, s, c);
    	} catch(SQLException e){
    		 e.printStackTrace();
    	}
    	
    }
	
	// ���ָ������
    public static void addResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****�������������������֤�š�ѧ�����绰�š�����״̬�����и�����*****");
                String name = sc.nextLine();
                String id = sc.nextLine();
                String education = sc.nextLine();
                String telephone = sc.nextLine();
                int process = sc.nextInt();
                sc.nextLine();
                String sql="insert into resume values('"+name+"','"+id+"','"+education+"','"+telephone+"',"+process+")";
                s.execute(sql);
                
                System.out.println("*****�Ƿ������ӣ���/��*****");
                if(sc.nextLine().equals("��"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
            DBConnection.closeConnection(s, c);
    	} catch(SQLException e){
   		 e.printStackTrace();
    	}
        System.out.println("��ӳɹ�");
    }

    //ɾ��ָ������
    public static void deleteResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****������Ҫɾ���ļ�����Ӧ�����֤��*****");
                String id = sc.nextLine();
                int count;
                String sql = "delete from resume where id = '" + id +"'";
                count = s.executeUpdate(sql);
                if(count == 0)
                	System.out.println("û���ҵ�����Ҫɾ���ļ���");
                
                System.out.println("*****�Ƿ����ɾ������/��*****");
                if(sc.nextLine().equals("��"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
            DBConnection.closeConnection(s, c);
    	} catch(SQLException e){
      		 e.printStackTrace();
       	}
        System.out.println("�������");
    }

    //�޸�ָ������
    public static void updateResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		ResultSet rs;
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****������Ҫ�޸ĵļ�����Ӧ�����֤��*****");
                String id = sc.nextLine();
                String sql = "select * from resume where id = '" + id +"'";
                rs = s.executeQuery(sql);
                System.out.println("*****���ҵ�Ҫ�޸ĵļ���*****");
        		System.out.println("****����ԭʼ״̬****");
        		System.out.println("����"+'\t'+"���֤��"+'\t'+"ѧ��"+'\t'+"�绰��"+'\t'+"����״̬");
        		rs.next();
        		System.out.printf("%s\t%s\t%s\t%s\t%d%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
            	boolean iscompleted=false;
            	do {
            		System.out.println("*************************");
                	System.out.println("�޸���������1");
                	System.out.println("�޸����֤�š���2");
                	System.out.println("�޸�ѧ������3");
                	System.out.println("�޸ĵ绰�š���4");
                	System.out.println("�޸ļ���״̬����5");
                	int choice=sc.nextInt();
                	sc.nextLine();
                	switch(choice) {
                	case 1:
                		{System.out.println("�������µ�����");
                		String sql1 = "update resume set name = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql1);}
                        break;
                    case 2:
                    	{System.out.println("�������µ����֤��");
                    	String sql2 = "update resume set id = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql2);}
                        break;
                    case 3:
                    	{System.out.println("�������µ�ѧ��");
                    	String sql3 = "update resume set education = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql3);}
                        break;
                    case 4:
                    	{System.out.println("�������µĵ绰����");
                    	String sql4 = "update resume set telephone = '" + sc.nextLine() + "' where id = '" + id +"'";
                		s.executeUpdate(sql4);}
                        break;
                    case 5:
                    	{System.out.println("�������µļ���״̬");
                    	String sql5 = "update resume set process = " + sc.nextInt() + " where id = '" + id +"'";
                		s.executeUpdate(sql5);
                    	sc.nextLine();}
                        break;
                    default:
                        System.out.println("������������������");
                	}
                	
                	System.out.println("*****�Ƿ�����޸ı���������/��*****");
                    if(sc.nextLine().equals("��"))
                    	iscompleted=true;
                    else
                    	iscompleted=false;
            	}while(iscompleted);
                System.out.println("�޸ĳɹ�");
                
                System.out.println("*****�Ƿ�����޸���һ����������/��*****");
                if(sc.nextLine().equals("��"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
            DBConnection.closeConnection(rs, s, c);
    	} catch(SQLException e){
     		 e.printStackTrace();
      	}
        System.out.println("�������");
    }

    // ��ѯָ������
    public static void searchResume() {
    	try {
    		Connection c = DBConnection.getConnection();
    		Statement s = c.createStatement();
    		ResultSet rs;
    		Scanner sc = new Scanner(System.in);
            boolean keepon=false;
            do {
            	System.out.println("*****������Ҫ��ѯ�ļ�����Ӧ�����֤��*****");
                String id = sc.nextLine();
                String sql = "select * from resume where id = '" + id + "'";
                rs = s.executeQuery(sql);
                rs = s.executeQuery(sql);
            	System.out.println("�ҵ�������ѯ�ļ���");
            	System.out.println("����"+'\t'+"���֤��"+'\t'+"ѧ��"+'\t'+"�绰��"+'\t'+"����״̬");
        		rs.next();
        		System.out.printf("%s\t%s\t%s\t%s\t%d%n", rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5));
                
                System.out.println("*****�Ƿ������ѯ����/��*****");
                if(sc.nextLine().equals("��"))
                	keepon=true;
                else
                	keepon=false;
            }while(keepon);
    	} catch(SQLException e){
    		 e.printStackTrace();
     	}
        System.out.println("��ѯ���");
    }

}
