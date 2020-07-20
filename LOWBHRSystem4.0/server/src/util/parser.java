package util;

import pojo.*;

public class parser {

    static String[] messages;
    static String head;
    static String context;
    static String[] person;
    static parserResult pr;
    static Resume resume;
    static Resume oldResume;


    public static parserResult parser(String str){
        messages = str.split("\\:");
        head = messages[0];
        context = messages[1];

        person = context.split(",");
        pr = new parserResult();
        pr.head = head;

        if(head.equals("add")){
            resume = new Resume(person[0], person[1], person[2], person[3], person[4]);
            pr.resume = resume;
        }
        else if(head.equals("delete")){
            resume = new Resume(person[0], person[1]);
            pr.resume = resume;
        }
        else if(head.equals("update")){
            oldResume = new Resume(person[0], person[1]);
            resume = new Resume(person[2], person[3], person[4], person[5], person[6]);
            pr.oldResume = oldResume;
            pr.resume = resume;
        }
        else if(head.equals("search")){
            resume = new Resume(person[0], person[1]);
            pr.resume = resume;
        }
        else{
            return null;
        }

        return pr;
    }
}
