package util;

import model.Resume;
import model.ResumeList;
import model.ReturnResult;

public class Parser {
    public ReturnResult Parse(String str){

        /**
         * 接收并处理分解客户端传送过来的信息，主要包括
         * 1.操作命令
         * 2.操作数据
         */
        /*
         * 先按“:”劈开得到想要的操作和操作数据
         * if语句判断操作
         * 把操作数据用相应的parser方法解析得到一个Resume或者ResumeList中
         * 令ReturnResult的head=劈开得到的head
         * 令ReturnResult的resultData等于Resume或者ResumeList
         * */
        //操作数据
        ReturnResult returnResult = new ReturnResult();

        String[] arrayMessage = str.split(":");  //将从客户端接收到的消息分解为操作指令和操作数据
        String head = arrayMessage[0];  //操作指令
        String resumeInfo = arrayMessage[1];  //操作数据
        returnResult.head = head;

        if (head.equals("add")){
            returnResult.resultData = parseAdd(resumeInfo);
        }else if (head.equals("delete") || head.equals("search")){
            returnResult.resultData = parseDeleteAndSelect(resumeInfo);
        }else if (head.equals("update")){
            returnResult.resultData = parseUpdate(resumeInfo);
        }
        return returnResult;
    }

    //增加简历
    // message: name, id, school, status, deleteStatus
    public Resume parseAdd(String message){
        String[] resumeInfo = message.split(",");
        return new Resume(resumeInfo[0],resumeInfo[1],resumeInfo[2],resumeInfo[3],resumeInfo[4]);
    }

    //通过id删除、查找简历
    // message: id
    public Resume parseDeleteAndSelect(String message){
        return new Resume(null,message,null,null,null);
    }

    //通过id修改简历信息
    // message: old id, new name, new id, new school, new status
    public ResumeList parseUpdate(String message) {
        String[] resumeInfo = message.split(",");
        ResumeList resumeList = new ResumeList();

        Resume oldResume = new Resume(null,resumeInfo[0],null,null,null);
        resumeList.add(oldResume);

        Resume newResume = new Resume(resumeInfo[1],resumeInfo[2],resumeInfo[3],resumeInfo[4],"1");  //默认不修改deletaStatus
        resumeList.add(newResume);

        return resumeList;
    }
}
