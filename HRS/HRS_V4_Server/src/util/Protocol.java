package util;

import Resume.Resume;

import java.util.ArrayList;
import java.util.List;

//服务器执行操作后，向客户端返回信息。
public class Protocol {
    //添加简历操作
    public String addResumeMessage(ReturnResult rr) {
        String str;
        String isSuccess = rr.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + rr.failReason;
        }
        return str;
    }

    //删除简历操作
    public String deleteResumeMessage(ReturnResult rr) {
        String str;
        String isSuccess = rr.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + rr.failReason;
        }
        return str;
    }

    //修改简历操作
    public String modifyResumeMessage(ReturnResult rr) {
        String str;
        String isSuccess = rr.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
        } else {
            str = isSuccess + "/n" + rr.failReason;
        }
        return str;
    }

    //查询单个简历操作
    public String searchResumeMessage(ReturnResult rr) {
        String str;
        String isSuccess = rr.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
            Resume applicant = (Resume) rr.resultData;
            String temp = applicant.getName() + "," + applicant.getSchool() + ","
                    + applicant.getId() + "," + applicant.getEmail();
            str=str+temp;
        } else {
            str = isSuccess + "/n" + rr.failReason;
        }
        return str;
    }

    //查询全部简历操作
    public String searchAllResumeMessage(ReturnResult rr) {
        String str;
        String isSuccess = rr.isSuccess;
        if (isSuccess.equals("Success")) {
            str = isSuccess + "/n";
            List<Resume> applicants = (List<Resume>) rr.resultData;
            for (Resume applicant : applicants) {
                String temp = applicant.getName() + "," + applicant.getSchool() + ","
                        + applicant.getId() + "," + applicant.getEmail() + ";";
                str = str + temp;
            }

        } else {
            str = isSuccess + "/n" + rr.failReason;

        }
        return str;
    }
}
