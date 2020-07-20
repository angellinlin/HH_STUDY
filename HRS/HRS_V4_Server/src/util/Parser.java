package util;

import Resume.Resume;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    static String[] tempMessage;
    static String head;
    static ParserResult pr;
    static String message;

    public ParserResult parser(String str) {
        tempMessage = str.split("/n");
        head = tempMessage[0];//获取执行的操作的名称
        if (!head.equals("searchAll")) {
            message = tempMessage[1];//获取数据
        }
        pr = new ParserResult();
        pr.head = head;
        //添加简历操作
        if (head.equals("add")) {
            Resume temp = parserAdd(message);
            pr.resultData = temp;
        } else if (head.equals("delete")) {
            Resume temp = parserDelete(message);
            pr.resultData = temp;
        } else if (head.equals("modify")) {
            List<Resume> temp = parserModify(message);
            pr.resultData = temp;
        } else if (head.equals("search")) {
            String temp = parserSearch(message);
            pr.resultData = temp;
        } else if (head.equals("searchAll")) {
//            List<Resume> temp = parserSearchAll(message);
            pr.resultData = null;
        }
        return pr;
    }

    //添加简历操作
    public Resume parserAdd(String message) {
//        List<Resume> applicants = new ArrayList<>();
        String[] str = message.split(",");
        String resumeName = str[0];
        String resumeSchool = str[1];
        String resumeId = str[2];
        String resumeEmail = str[3];
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
        return resume;
    }

    //删除简历操作
    public Resume parserDelete(String message) {
        String resumeName = null;
        String resumeSchool = null;
        String resumeId = message;
        String resumeEmail = null;
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
        return resume;
    }

    //修改简历操作
    public List<Resume> parserModify(String message) {
        String[] str = message.split(";");
        //pre_resume_information
        String[] preMessage = str[0].split(",");
        String preName = preMessage[0];
        String preSchool = preMessage[1];
        String preId = preMessage[2];
        String preEmail = preMessage[3];
        //new_resume_information
        String[] newMessage = str[1].split(",");
        String resumeName = newMessage[0];
        String resumeSchool = newMessage[1];
        String resumeId = newMessage[2];
        String resumeEmail = newMessage[3];
        //
        Resume pre = new Resume(preName, preSchool, preId, preEmail);
        Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
        List<Resume> applicants = new ArrayList<>();
        applicants.add(pre);
        applicants.add(resume);
        return applicants;
    }

    //查找单个简历
    public String parserSearch(String message) {
        String resumeId = message;
        return resumeId;
    }

    //查找全部简历
    // 不需要写！
//    public List<Resume> parserSearchAll(String message) {
//        List<Resume> applicants = new ArrayList<>();
//        String[] str = message.split(";");
//        int len = str.length;
//
//        return applicants;
//    }
}
