package model;

import java.util.ArrayList;
/*客户端和服务器返回的信息对象（通用）*/
public class MessageResult {
    public String type;
    public String status;
    public String str_entity;/*保存字符串状态的简历对象（数组）*/
    public ArrayList<Resume> entityList;/*保存真实的简历对象数组*/
}
