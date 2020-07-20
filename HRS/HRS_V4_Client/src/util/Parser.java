package util;

import Resume.Resume;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    //添加简历操作
    public ReturnResult parserAdd(String message) {
        ReturnResult rr = new ReturnResult();
        String[] temp = message.split("/n");
//        System.out.println(temp[0]);
//        System.out.println(temp[1]);
        if (temp[0].equals("Success")) {
            rr.isSuccess = true;
        } else {
            rr.failReason = temp[1];
        }
        return rr;
    }

    //删除简历操作
    public ReturnResult parserDelete(String message) {
        ReturnResult rr = new ReturnResult();
        String[] temp = message.split("/n");
        if (temp[0].equals("Success")) {
            rr.isSuccess = true;
        } else {
            rr.failReason = temp[1];
        }
        return rr;
    }

    //修改简历操作
    public ReturnResult parserModify(String message) {
        ReturnResult rr = new ReturnResult();
        String[] temp = message.split("/n");
        if (temp[0].equals("Success")) {
            rr.isSuccess = true;
        } else {
            rr.failReason = temp[1];
        }
        return rr;
    }

    //查找简历
    public ReturnResult parserSearch(String message) {
        ReturnResult rr = new ReturnResult();
        String[] temp = message.split("/n");
        if (temp[0].equals("Success")) {
            rr.isSuccess = true;
            String[] resumeinfo=temp[1].split(",");
            String resumeName = resumeinfo[0];
            String resumeSchool = resumeinfo[1];
            String resumeId = resumeinfo[2];
            String resumeEmail = resumeinfo[3];
            Resume resume = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
            rr.resultData=resume;
        } else {
            rr.failReason = temp[1];
        }
        return rr;
    }
    //查找全部简历信息
    public ReturnResult parserSearchAll(String message) {
        ReturnResult rr = new ReturnResult();
        String[] temp = message.split("/n");
        if (temp[0].equals("Success")) {
            rr.isSuccess = true;
            String[] resumeinfo = temp[1].split(";");
            List<Resume> applicants = new ArrayList<>();
            int len = resumeinfo.length;
            for (int i = 0; i < len; i++) {
                String[] resume = resumeinfo[i].split(",");
                String resumeName = resume[0];
                String resumeSchool = resume[1];
                String resumeId = resume[2];
                String resumeEmail = resume[3];
                Resume applicant = new Resume(resumeName, resumeSchool, resumeId, resumeEmail);
                applicants.add(applicant);
            }
            rr.resultData = applicants;
        } else {
            rr.isSuccess=false;
            rr.failReason=temp[1];
        }
        return rr;
    }
}
