package Operation;

import Resume.Resume;
import TCPClient.TCPClient;
import util.Parser;
import util.Protocol;
import util.ReturnResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//简历的增删改查
public class Service {
    TCPClient client = new TCPClient();

    //添加简历信息
    public void addResume() {
        System.out.println("欢迎进入添加简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        System.out.println("请依次输入姓名，学校，身份ID，email");
        String resumeName = input.nextLine();
        String resumeSchool = input.nextLine();
        String resumeId = input.nextLine();
        String resumeEmail = input.nextLine();
        //get/SET
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
        Protocol protocol = new Protocol();
        //将需要添加的resume转换为预定格式的字符串
        String message = protocol.addResumeMessage(resume);
        //将数据传输给服务器
        String returnMessage = client.sendMessageToServer(message);
        //
        Parser parser = new Parser();
//        System.out.println(returnMessage);      //  false/nunknow error
        ReturnResult rr = parser.parserAdd(returnMessage);
        //
        if (rr.isSuccess) {
            System.out.println("您的信息已成功录入系统！");
            showResume(resume);
        } else {
            System.out.println("简历添加失败！");
        }
    }

    //删除简历
    public void deletResume() {
        System.out.println("欢迎进入删除简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        System.out.println("输入你要删除的简历身份Id:");
        String id = input.nextLine();
        //
        Resume resume = new Resume(null, null, id, null);
        //
        Protocol protocol = new Protocol();
        String message = protocol.deleteResumeMessage(resume);//返回"delete/nresume.id"
        //把字符串传输给服务器，得到服务器返回的字符串returnMessage
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult rr = parser.parserDelete(returnMessage);
        if (rr.isSuccess) {
            System.out.println("删除简历成功！");
        } else {
            System.out.println("操作失败！");
        }
    }

    //显示简历信息
    public static void showResume(Resume resume) {
        System.out.println("姓名：" + resume.getName() + ", 学校：" + resume.getSchool() + ", 身份ID：" + resume.getId()
                + ", email:" + resume.getEmail());
    }

    //修改简历信息
    public void modifyResume() {
        System.out.println("欢迎进入修改简历信息界面！");
        System.out.println("请输入待更新应聘人员的身份ID：");//因为身份证信息是唯一的。
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        String dId = input.nextLine();
        Resume preResume = new Resume(null, null, dId, null);
        System.out.println("开始更新简历信息···");
        System.out.println("请依次输入新的名字，学校，身份ID，Email信息：");
        String resumeName = input.nextLine();
        String resumeSchool = input.nextLine();
        String resumeId = input.nextLine();
        String resumeEmail = input.nextLine();
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);

        Protocol protocol = new Protocol();
        String message = protocol.modifyResumeMessage(preResume, resume);
        String returnMessage = client.sendMessageToServer(message);
        Parser parser = new Parser();
        ReturnResult rr = parser.parserModify(returnMessage);
        if (rr.isSuccess) {
            System.out.println("修改简历成功！");
        } else {
            System.out.println("操作失败！");
        }

    }

    //查看简历
    public void searchResume() {
        System.out.println("欢迎进入查询简历信息界面！");
        Scanner input = new Scanner(System.in);//构建一个Scanner对象
        boolean flag = true;
        while (flag) {
            System.out.println("查询全部---1");
            System.out.println("查询单人---2");
            System.out.println("退出查询---3");
            int choice = input.nextInt();
            switch (choice) {
                case 1: {
                    Protocol protocol = new Protocol();
                    String message = protocol.searchAllResumesMessage();
                    String returnMessage = client.sendMessageToServer(message);
                    Parser parser = new Parser();
                    ReturnResult rr = parser.parserSearchAll(returnMessage);
                    List<Resume> applicants = (ArrayList<Resume>) rr.resultData;
                    for (Resume applicant : applicants) {
                        showResume(applicant);
                    }
                    break;
                }
                case 2: {
                    System.out.println("请输入你要查询的应聘者的身份ID：");
                    String resumeId = input.next();
                    Resume resume = new Resume(null, null, resumeId, null);
                    Protocol protocol = new Protocol();
                    String message = protocol.searchResumeMessage(resume);
                    String returnMessage = client.sendMessageToServer(message);
                    Parser parser = new Parser();
                    ReturnResult rr = parser.parserSearch(returnMessage);
                    Resume applicant = (Resume) rr.resultData;
                    showResume(applicant);
                    break;
                }
                case 3:
                    flag = false;
                    break;
                default: {
                    System.out.println("输入错误！请重新输入：");
                }
            }
        }
    }

    //断开连接
    public void closeNet(String str) {
        String returnMessage=client.sendMessageToServer(str);

        client.closeTCPClient();
    }
}
