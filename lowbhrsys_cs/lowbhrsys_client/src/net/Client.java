package net;

import control.Operator;
import model.Resume;
import model.ResumeList;
import model.ReturnResult;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

import java.io.InputStreamReader;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Client {

    BufferedReader in;
    PrintWriter out;
    Socket tcpConnection;
    Operator op = new Operator(this);
    public Client() {
        try {
            tcpConnection = new Socket("127.0.0.1", 1235);
            System.out.print("�����Ϸ�������\n");
            in = new BufferedReader(new InputStreamReader(tcpConnection.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(tcpConnection.getOutputStream())), true);
        } catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String sendMessageToSever(String message)//�����ַ���ȥ�ͷ���
    {
        String str = "";
        try {
            out.println(message);
			System.out.println("����������ͣ�  "+message);
            str = in.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return str;
    }

    public void closeClient()//�رտͻ��˲��ر�����
    {
        try {
            in.close();
            out.close();
            tcpConnection.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void Start(){
        Scanner input = new Scanner(System.in);
        //*************************��ҳ����ʾ*******************************
        while(true){
            //.openData();
            System.out.println("************��ӭ����HR����ϵͳ************");
            System.out.println("¼��Ա����Ϣ�밴----------1");
            System.out.println("ɾ��Ա����Ϣ�밴----------2");
            System.out.println("�޸�Ա����Ϣ�밴----------3");
            System.out.println("��ѯԱ����Ϣ�밴----------4");
            System.out.println("�г�ȫ��Ա����Ϣ�밴-------5");
            System.out.println("�˳��밴-----------------6");
            //if���ָ���ж�
            int choice =input.nextInt();
            if(choice==1){
                add();
            }
            else if(choice==2){
                deleteResume();
            }
            else if(choice==3){
                changeResume();
            }
            else if(choice==4){
                searchResume();
            }
            else if(choice==5){
                listAllResume();
            }
            else if(choice==6){
                close();
                break;
            }
            else{
                System.out.println("���������ȷ�Ϻ���������");
            }
        }
        System.out.println("�����˳�HR����ϵͳ");
    }

    //*************************�����Ϣ*******************************
    void add(){
        System.out.println("��ӭ����Ա����Ϣ¼�����");
        Scanner input = new Scanner(System.in);
        System.out.println("������������Ҫ¼��Ա�������֣����֤�ţ�ѧУ���������");
        String workerName = input.nextLine();
        String workerId = input.nextLine();
        String workerSchool = input.nextLine();
        int preProcess = input.nextInt();
        while (preProcess > 6 || preProcess <0){
            System.out.println("�������ֻ��Ϊ0-6�����������룺");
            preProcess = input.nextInt();
        }
        int process = preProcess;

        Resume resume = new Resume(workerName, workerId, workerSchool, process);

        ReturnResult rr = op.addResume(resume);
        CRUDResult(rr);
    }
    //*************************ɾ����Ϣ*******************************
    void deleteResume(){
        while(true){
            Scanner input = new Scanner(System.in);
            System.out.println("************��ӭ����Ա����Ϣɾ������************");
            System.out.println("������ɾ���밴----------1");
            System.out.println("��idɾ���밴-----------2");
            System.out.println("�˳��밴---------------3");
            int choice =input.nextInt();
            if(choice==1){
                deleteByName();
            }
            else if(choice==2){
                deleteById();
            }
            else if(choice==3){
                break;
            }
        }

    }

    void deleteByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫɾ����Ա������");
        String workerName = input.nextLine();
        Resume resume = new Resume(workerName,null,null,-1);

        ReturnResult rr = op.deleteResumeByName(resume);
        CRUDResult(rr);
    }

    void deleteById(){
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫɾ����Ա��id");
        String workerId = input.nextLine();
        Resume resume = new Resume(null, workerId,null, -1);

        ReturnResult rr = op.deleteResumeById(resume);
        CRUDResult(rr);
    }
    //*************************�޸���Ϣ*******************************
    void changeResume(){
        System.out.println("��ӭ����Ա����Ϣ�޸Ľ���");
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ�޸�Ա�������֤��");
        String oldWorkerId = input.nextLine();;

        System.out.println("�����������޸ĺ�Ա�������֣����֤�ţ�ѧУ���������");
        String workerName = input.nextLine();
        String workerId = input.nextLine();
        String workerSchool = input.nextLine();
        int preProcess = Integer.parseInt(input.nextLine());
        while (preProcess > 6 || preProcess <0){
            System.out.println("�������ֻ��Ϊ0-6�����������룺");
            preProcess = input.nextInt();
        }
        int process = preProcess;

        Resume oldResume = new Resume(null, oldWorkerId, null, -1);
        Resume resume = new Resume(workerName, workerId, workerSchool, process);

        ReturnResult rr = op.changeResume(resume, oldResume);
        CRUDResult(rr);
    }
    //*************************��ѯ��Ϣ*******************************
    void searchResume(){
        while(true){
            System.out.println("************��ӭ����Ա����ѯ����************");
            System.out.println("�����������밴----------1");
            System.out.println("��id�����밴-----------2");
            System.out.println("��ѧУ�����밴----------3");
            System.out.println("�����Ȳ����밴----------4");
            System.out.println("ģ�������밴------------5");
            System.out.println("�˳��밴---------------6");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if(choice==1){
                searchResumeByName();
            }
            else if(choice==2){
                searchResumeById();
            }
            else if(choice==3){
                searchResumeBySchool();
            }
            else if(choice==4){
                searchResumeByProcess();
            }
            else if(choice==5){
                searchResumeByPointWord();
            }
            else if(choice==6){
                break;
            }
            else{
                System.out.println("����������1-5");
            }
        }
    }
    void searchResumeByName(){
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ��Ա������");
        String workerName = input.nextLine();
        Resume resume = new Resume(workerName,null,null, -1);

        ReturnResult rr = op.searchByName(resume);
        searchResult(rr, "����", workerName);
    }

    void searchResumeById(){
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ��Ա��id");
        String workerId = input.nextLine();
        Resume resume = new Resume(null, workerId,null, -1);

        ReturnResult rr = op.searchById(resume);
        searchResult(rr, "id", workerId);
    }

    void searchResumeBySchool(){
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ��Ա����ѧУ");
        String workerSchool = input.nextLine();
        Resume resume = new Resume(null,null,workerSchool,-1);

        ReturnResult rr = op.searchBySchool(resume);
        searchResult(rr, "ѧУ", workerSchool);
    }
    void searchResumeByProcess(){
        Scanner input = new Scanner(System.in);
        System.out.println("��������Ҫ��ѯ��Ա���Ľ���");
        String workerProcess= input.nextLine();
        Resume resume = new Resume(null,null,null,Integer.parseInt(workerProcess));

        ReturnResult rr = op.searchByProcess(resume);
        searchResult(rr, "����", workerProcess);
    }

    void searchResumeByPointWord(){
        Scanner input = new Scanner(System.in);
        System.out.println("������ؼ���");
        String keyWord = input.nextLine();

        Resume resume = new Resume(keyWord,null,null,-1);
        ReturnResult rr = op.searchByKeyWord(resume);
        searchResult(rr, "�ؼ���", keyWord);
    }
    //*************************�г�������Ϣ*******************************
    void listAllResume(){

        ReturnResult rr = op.listAllResumeInfo();

        ResumeList resumeList = (ResumeList)rr.resultData;
        int resumeCount = resumeList.size();
        if(resumeCount>0){
            for(int i=0;i<resumeCount;i++)
                System.out.println("������"+resumeList.get(i).getName()+"  "
                        +"id:"+"��"+resumeList.get(i).getId()+"  "
                        +"ѧУ"+"��"+resumeList.get(i).getSchool()+"  "
                        +"����"+"��"+resumeList.get(i).getProcess());
        }
        else {
            System.out.println("���ݿ�����Ա����Ϣ");
        }
    }

    void close(){

        op.closeNet("bye");
    }
    //*************************�г�������Ϣ*******************************
    void CRUDResult(ReturnResult result){
        if(result.isSuccess){
            System.out.println("�����ɹ�");
        }
        else{
            System.out.println("����ʧ��"+"/n"+result.failReason);
        }
    }
    void searchResult(ReturnResult result, String kind, String word){
        ResumeList resumeList = (ResumeList)result.resultData;
        int resumeCount = resumeList.size();
        if(resumeCount>0){
            for(int i=0;i<resumeCount;i++)
                System.out.println("������"+resumeList.get(i).getName()+"  "
                        +"id:"+"��"+resumeList.get(i).getId()+"  "
                        +"ѧУ"+"��"+resumeList.get(i).getSchool()+"  "
                        +"����"+"��"+resumeList.get(i).getProcess());
        }
        else {
            System.out.println("û���ҵ�"+kind+"Ϊ"+word+"��Ա��");
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {

        Client c = new Client();
        c.Start();
    }

}
