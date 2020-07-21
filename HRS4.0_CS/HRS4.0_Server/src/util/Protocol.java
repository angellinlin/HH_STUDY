package util;

import model.ActionResult;
import model.Resume;
import model.ResumeList;

public class Protocol {

    /**包装返回给客户端的操作消息
     * 增、删、改包含是否成功，若失败则有失败原因
     * 查则返回包含是否成功+查询到的数据，若失败有失败原因

    /*
     * 把ActionResult的三个属性按ActionResult.isSuccess+":"+failReason或者ActionResult.isSuccess+":"+（ActionResult.resultData
     * 得到的字符串）格式编写
     * 在for循环里得到ActionResult.resultData的字符串
     * */

    //增、删、改信息
    public String processResumeMessage(ActionResult actionResult){
        String str;

        if (actionResult.isSuccess.equals("Success")){
            str = actionResult.isSuccess+ ":";
        }else {
            str = actionResult.isSuccess + ":" + actionResult.failReason;
        }
        return str;
    }

    //查询信息
    public String searchResumeMessage(ActionResult actionResult) {
        StringBuilder str = new StringBuilder();
        if (actionResult.isSuccess.equals("Success")){
            str = new StringBuilder(actionResult.isSuccess + ":");
            Resume resume = (Resume) actionResult.resultData;

            String resumeString = String.format("%s,%s,%s,%s,%s;", resume.getName(), resume.getId(), resume.getSchool(),resume.getStatus(),resume.getDeleteStatus());
            str.append(resumeString);

        }else {
            str.append(actionResult.isSuccess).append(":").append(actionResult.failReason);
        }
        return str.toString();
    }
}
